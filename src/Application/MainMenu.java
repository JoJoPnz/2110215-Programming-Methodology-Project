package Application;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class MainMenu extends HBox {
	private Button startGame;
	
	private Button exitGame;

	public MainMenu() {
		// TODO Auto-generated constructor stub
		startGame = new Button("Start Game");
		exitGame = new Button("Exit Game");
		startGame.setFont(new Font("Ariel",30));
		exitGame.setFont(new Font("Ariel",30));
		
		this.getChildren().addAll(startGame, exitGame);
		this.setAlignment(Pos.CENTER);
		this.setSpacing(100);
		startGame.setPrefWidth(200);
		startGame.setPrefHeight(60);
		
		exitGame.setPrefWidth(200);
		exitGame.setPrefHeight(60);
		
	}

}
