package Logic;

import player.Player;

public class GameLogic {
	public static Player player1 = new Player("Abab");;
	public static Player player2 = new Player("Abac");;
	
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
	
	
}
