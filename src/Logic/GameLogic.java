package Logic;

import player.Player;

public class GameLogic {
	private static Player player1;
	private static Player player2;
	public GameLogic() {
		// TODO Auto-generated constructor stub
		Player player1 = new Player("Abab");
		Player player2 = new Player("Abac");
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
