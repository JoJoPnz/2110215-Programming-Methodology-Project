package Application;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MainMenu extends HBox {
	private Button startGame;

	private Button exitGame;

	public MainMenu() {
		// TODO Auto-generated constructor stub
		startGame = new Button("Start Game");
		exitGame = new Button("Exit Game");
		this.getChildren().addAll(startGame, exitGame);
	}

}
