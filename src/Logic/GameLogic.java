package Logic;

import player.Player;

public class GameLogic {
	private Player player1;
	private Player player2;
	public GameLogic() {
		// TODO Auto-generated constructor stub
		Player player1 = new Player("Abab");
		Player player2 = new Player("Abac");
		// initialize Starting turn
		player1.setTurn(true);
		
	}

}
