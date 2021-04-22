package Logic;

import board.GameBoard;
import dice.Dice;
import dice.DicePane;
import player.Player;
import square.Square;

public class GameLogic {
	public static Player player1 = new Player("dice1.png");;
	public static Player player2 = new Player("dice2.png");;

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
	
	public static void endTurn() {
		// change turn with Jail condition.
		if (GameLogic.player1.isTurn()) {	
			System.out.println("player1 isJail = " + GameLogic.player1.isInJail());
			System.out.println("player2 isJail = " + GameLogic.player2.isInJail());
			if (GameLogic.player2.isInJail()) {
				System.out.println("Player2 is in jail");
				GameLogic.player1.setTurn(true);
				GameLogic.player2.setTurn(false);
				GameLogic.player2.setInJail(false); // set inJail to false so next turn it can move now.
			} else {
				GameLogic.player1.setTurn(false);
				GameLogic.player2.setTurn(true);
			}

		} else if (GameLogic.player2.isTurn()) {
			System.out.println("player1 isJail = " + GameLogic.player1.isInJail());
			System.out.println("player2 isJail = " + GameLogic.player2.isInJail());
			if (GameLogic.player1.isInJail()) {
				System.out.println("Player1 is in jail");
				GameLogic.player1.setTurn(false);
				GameLogic.player2.setTurn(true);
				GameLogic.player1.setInJail(false); // set inJail to false so next turn it can move now.
			} else {
				GameLogic.player1.setTurn(true);
				GameLogic.player2.setTurn(false);
			}
		}
	}

	
	
	
	
	
	
	
	
	
}
