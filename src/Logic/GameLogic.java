package Logic;

import java.io.File;

import board.GameBoard;
import board.GameScene;
import board.Main;
import dice.Dice;
import dice.DicePane;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import player.Player;
import property.Area;
import property.Property;
import property.Upgradable;
import square.PropertySquare;
import square.Square;

public class GameLogic {
	public static Player player1 = new Player("player1.png");
	public static Player player2 = new Player("player2.png");
	public static Player playingPlayer;
	public static Player waitingPlayer;
	
	public GameLogic() {
		// initialize Starting turn
		player1.setTurn(true);
		player2.setTurn(false);
		playingPlayer = player1;
		waitingPlayer = player2;
	}

	public static void rollDice() {
		Dice dice = new Dice();
		dice.roll();
		int faceValue = dice.getFaceValue();
		DicePane.setFaceValue(faceValue);
		DicePane.setDiceImage(faceValue);
		
		GameLogic.updateStatusText("Roll Dice : " + faceValue + "\n");
	}
	public static void move() {
		GameLogic.playingPlayer.move(DicePane.getFaceValue());
	}

	public static void buyArea() {
//		System.out.println("========Before Buy=======");
//		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
//		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
		
		PropertySquare currentSquare = (PropertySquare) GameLogic.playingPlayer.getCurrentSquare();
		String cityName = currentSquare.getAppearName();
		int price = currentSquare.getPrice();
		
		if (GameLogic.player1.isTurn()) {
			currentSquare.setProperty(new Area(true, 0, currentSquare, "blueFlag.png"));
		} else if (GameLogic.player2.isTurn()) {
			currentSquare.setProperty(new Area(true, 0, currentSquare, "redFlag.png"));
		}
		currentSquare.setOwner(playingPlayer);
		GameLogic.playingPlayer.setMoney(GameLogic.playingPlayer.getMoney() - currentSquare.getPrice());
		currentSquare.setOccupy(true);
		GameLogic.playingPlayer.getPropertyHave().add(currentSquare.getProperty());
		
		GameLogic.updateTooltip();
		GameLogic.updateStatusText("Buying " + cityName + " for " + price + "$\n");
		
//		System.out.println("========After Buy=======");
//		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
//		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
	}
	
	public static void payRent(Player payer) {
//		System.out.println("========Before Pay=======");
//		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
//		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
		
		PropertySquare square = (PropertySquare) payer.getCurrentSquare();
		Property property = square.getProperty();
		int payAmount = property.calculateIncome();
		payer.setMoney(payer.getMoney() - payAmount);
		Player propertyOwner = square.getOwner();
		propertyOwner.setMoney(propertyOwner.getMoney() + payAmount);
		
		GameLogic.updateStatusText("Pay rent for " + payAmount + "$\n");
		
		
//		System.out.println("========After Pay=======");
//		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
//		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
	}
	
	public static void upgradeProperty() {
//		System.out.println("========Before Upgrade=======");
//		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
//		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
		
		PropertySquare currentSquare = (PropertySquare) GameLogic.playingPlayer.getCurrentSquare();
		int cost = currentSquare.getUpgradeCost();
		String cityName = currentSquare.getAppearName();
		GameLogic.playingPlayer.setMoney(GameLogic.playingPlayer.getMoney() - cost);
		Property property = currentSquare.getProperty();
		if (property instanceof Upgradable) {
			((Upgradable) property).upgrade();
		}
		
		GameLogic.updateTooltip();
		GameLogic.updateStatusText("Upgrade " + cityName + " for " + cost + "$\n");
		
//		System.out.println("========After Upgrade=======");
//		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
//		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
	}

	public static void endTurn() {
		// check for switch turn with jail condition
		
		// 1. if playing player move to jail while other player has already in jail. --> switch turn
		if (GameLogic.playingPlayer.isInJail() && GameLogic.waitingPlayer.isInJail()) {
			GameLogic.switchTurn();
		}
		// 2. if other player is in jail --> not switch turn and also setInJail of other player to false
		else if (GameLogic.waitingPlayer.isInJail()) {
			GameLogic.waitingPlayer.setInJail(false); // set inJail to false so next turn it can move now.
		// 3. no one in jail --> switch turn normally
		}
		else {
			GameLogic.switchTurn();
		}
	}
	
	public static void switchTurn() {
		GameLogic.playingPlayer.setTurn(false);
		GameLogic.waitingPlayer.setTurn(true);
		if (GameLogic.player1.isTurn()) {
			GameLogic.playingPlayer = GameLogic.player1;
			GameLogic.waitingPlayer = GameLogic.player2;
		}
		else if (GameLogic.player2.isTurn()) {
			GameLogic.playingPlayer = GameLogic.player2;
			GameLogic.waitingPlayer = GameLogic.player1;
		}
	}
	
	public static void updateTooltip() {
		Square currentSquare = GameLogic.playingPlayer.getCurrentSquare();
		if (currentSquare instanceof PropertySquare) {
			((PropertySquare) currentSquare).setUpTooltip();
		}
	}

	public static void updateStatusText(String addText) {
		DicePane.statusText.setText(DicePane.statusText.getText() + addText);
	}
	
	public static void alertBankrupt() {
		 Alert alert = new Alert(AlertType.NONE);
		 alert.setAlertType(AlertType.WARNING);
		 alert.setHeaderText(null);
		 alert.setTitle("BANKRUPT !");
		 alert.setContentText("GAME OVER !\nYou are bankrupt.");
		 alert.showAndWait();
	}
	
	public static void endGame() {
		Main.getStage().setScene(Main.menuScene);
		Main.centerScreen();
		resetGame();
	}
	
	public static void resetGame() {
		GameLogic.player1 = new Player("player1.png");
		GameLogic.player2 = new Player("player2.png");
		GameLogic.player1.setTurn(true);
		GameLogic.player2.setTurn(false);
		GameLogic.playingPlayer = player1;
		GameLogic.waitingPlayer = player2;
	}
	
}
