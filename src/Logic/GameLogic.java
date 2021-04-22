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
	
	
	public static void goToJail(Player player) {
		if (player.getCurrentPosition() == 21) {
			Square goToJailSquare = GameBoard.myArray[21];
			goToJailSquare.getChildren().remove(player.getCharacterImage());

			Square jailSquare = GameBoard.myArray[7];

			player.setCurrentSquare(jailSquare);
			player.setCurrentPosition(7);
			player.setInJail(true);
		}

	}

}
