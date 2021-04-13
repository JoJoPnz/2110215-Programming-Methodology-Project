package Logic;

import board.GameBoard;
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

	public static void checkInJail() {
		if (player1.isInJail()) {
			System.out.println("Player1 in jail");
			player1.setInJail(false);
			System.out.println("Tired");
			System.out.println(GameLogic.player1.isTurn()+" "+GameLogic.player1.isEverRoll());
			player1.setEverRoll(true);
			System.out.println(player1.isInJail());
			player1.setTurn(false);
			player2.setTurn(true);
		
		} else if (player2.isInJail()) {
			System.out.println("Player2 in jail");
			System.out.println("OK");
			System.out.println(GameLogic.player2.isTurn() +" "+ GameLogic.player2.isEverRoll());
			player2.setInJail(false);
			player2.setEverRoll(true);
			System.out.println(player2.isInJail());
			player1.setTurn(true);
			player2.setTurn(false);
		
		}
	}

	public static void goToJail(Player player) {
		if (player.getCurrentPosition() == 21) {
			player.setInJail(true);
		}
		Square jailSquare = GameBoard.myArray[7];
		jailSquare.add(player.getCharacterImage(), 0, 0);
		player.setCurrentSquare(jailSquare);
		player.setCurrentPosition(7);

	}

}
