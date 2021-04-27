package Logic;

import java.io.File;

import board.GameBoard;
import dice.Dice;
import dice.DicePane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import player.Player;
import property.Area;
import property.Property;
import square.PropertySquare;
import square.Square;

public class GameLogic {
	public static Player player1 = new Player("player1.png");
	public static Player player2 = new Player("player2.png");
	public static Player playingPlayer;
	public static Player waitingPlayer;
	
	public GameLogic() {
		// TODO Auto-generated constructor stub
		// initialize Starting turn
		player1.setTurn(true);
		player2.setTurn(false);
		playingPlayer = player1;
		waitingPlayer = player2;
	}

	public static Player getPlayer1() {
		return player1;
	}

	public static Player getPlayer2() {
		return player2;
	}

	public static void rollDice() {
		Dice dice = new Dice();
		dice.roll();
		DicePane.setFaceValue(dice.getFaceValue());
		DicePane.setDiceImage(dice.getFaceValue());
	}
	public static void move() {
		GameLogic.playingPlayer.move(DicePane.getFaceValue());
	}

	public static void buyArea() {
		System.out.println("========Before Buy=======");
		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
		
		PropertySquare currentSquare = (PropertySquare) GameLogic.playingPlayer.getCurrentSquare();
		if (GameLogic.player1.isTurn()) {
			currentSquare.setProperty(new Area(true, 0, currentSquare, "blueFlag.png"));
		} else if (GameLogic.player2.isTurn()) {
			currentSquare.setProperty(new Area(true, 0, currentSquare, "redFlag.png"));
		}
		currentSquare.setOwner(playingPlayer);
		GameLogic.playingPlayer.setMoney(GameLogic.playingPlayer.getMoney() - currentSquare.getPrice());
		currentSquare.setOccupy(true);
		GameLogic.playingPlayer.getPropertyHave().add(currentSquare.getProperty());
		
		
		System.out.println("========After Buy=======");
		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
	}
	
	public static void payRent(Player payer) {
		System.out.println("========Before Pay=======");
		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
		
		PropertySquare square = (PropertySquare) payer.getCurrentSquare();
		Property property = square.getProperty();
		int payAmount = property.calculateIncome();
		payer.setMoney(payer.getMoney() - payAmount);
		Player propertyOwner = square.getOwner();
		propertyOwner.setMoney(propertyOwner.getMoney() + payAmount);
		
		System.out.println("========After Pay=======");
		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
	}
	
	public static void upgradeProperty() {
		System.out.println("========Before Upgrade=======");
		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
		
		PropertySquare currentSq = (PropertySquare) GameLogic.playingPlayer.getCurrentSquare();
		Property property = currentSq.getProperty();
		property.upgrade();
		
		System.out.println("========After Upgrade=======");
		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
	}

	public static boolean haveProperty(PropertySquare currentSq,Player player) {
		Property checkProperty = currentSq.getProperty();
		for (Property eachProperty : player.getPropertyHave()) {
			if (eachProperty.equals(checkProperty)) {
				return true;
			}
		}
		
		return false;
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
	
	
	
	
	
	
}
