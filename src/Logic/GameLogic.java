package Logic;

import board.GameBoard;
import dice.Dice;
import dice.DicePane;
import player.Player;
import property.Area;
import property.Property;
import square.PropertySquare;
import square.Square;

public class GameLogic {
	public static Player player1 = new Player("dice1.png");
	public static Player player2 = new Player("dice2.png");
	public static Player playingPlayer;
	
	public GameLogic() {
		// TODO Auto-generated constructor stub
		// initialize Starting turn
		player1.setTurn(true);
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
		
		// check turn
		if (GameLogic.player1.isTurn()) {
			GameLogic.player1.move(DicePane.getFaceValue());

		} else if (GameLogic.player2.isTurn()) {
			GameLogic.player2.move(DicePane.getFaceValue());
		}
	}

	public static void buyArea() {
		System.out.println("========Before Buy=======");
		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
		if (GameLogic.player1.isTurn()) {
			PropertySquare currentSq = (PropertySquare) GameLogic.player1.getCurrentSquare();
			currentSq.setProperty(new Area(true, 0, currentSq, "blueFlag.png"));
			currentSq.setOwner(player1);
			GameLogic.player1.setMoney(GameLogic.player1.getMoney() - currentSq.getPrice());
			//currentSq.setOccupy(true);
		} else if (GameLogic.player2.isTurn()) {
			PropertySquare currentSq = (PropertySquare) GameLogic.player2.getCurrentSquare();
			currentSq.setProperty(new Area(true, 0, currentSq, "redFlag.png"));
			currentSq.setOwner(player2);
			GameLogic.player2.setMoney(GameLogic.player2.getMoney() - currentSq.getPrice());
		}
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
		PropertySquare currentSq;
		if (GameLogic.player1.isTurn()) {
			currentSq = (PropertySquare) GameLogic.player1.getCurrentSquare();
		} else {
			currentSq = (PropertySquare) GameLogic.player2.getCurrentSquare();
		}
		Property property = currentSq.getProperty();
		property.upgrade();
		System.out.println("========After Upgrade=======");
		System.out.println("Player1 Money:" + GameLogic.player1.getMoney());
		System.out.println("Player2 Money:" + GameLogic.player2.getMoney());
	}

	// public boolean checkOccupy


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
		// change turn with Jail condition.
		
		if (GameLogic.player1.isTurn()) {
			//System.out.println("player1 isJail = " + GameLogic.player1.isInJail());
			//System.out.println("player2 isJail = " + GameLogic.player2.isInJail());
			if (GameLogic.player2.isInJail()) {
				//System.out.println("Player2 is in jail");
				GameLogic.player1.setTurn(true);
				GameLogic.player2.setTurn(false);
				GameLogic.player2.setInJail(false); // set inJail to false so next turn it can move now.
				GameLogic.playingPlayer = GameLogic.player1;
			} else {
				GameLogic.player1.setTurn(false);
				GameLogic.player2.setTurn(true);
				GameLogic.playingPlayer = GameLogic.player2;
			}

		} else if (GameLogic.player2.isTurn()) {
			//System.out.println("player1 isJail = " + GameLogic.player1.isInJail());
			//System.out.println("player2 isJail = " + GameLogic.player2.isInJail());
			if (GameLogic.player1.isInJail()) {
				//System.out.println("Player1 is in jail");
				GameLogic.player1.setTurn(false);
				GameLogic.player2.setTurn(true);
				GameLogic.player1.setInJail(false); // set inJail to false so next turn it can move now.
				GameLogic.playingPlayer = GameLogic.player2;
			} else {
				GameLogic.player1.setTurn(true);
				GameLogic.player2.setTurn(false);
				GameLogic.playingPlayer = GameLogic.player1;
			}
		}
	}
	

}
