package board;

import Logic.GameLogic;
import dice.DicePane;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GameScene {
	public static Scene gameScene;
	public static GameLogic newGame;
	
	public GameScene() {
		HBox root = new HBox();
		root.setSpacing(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setPrefHeight(400);
		
		GridPane gameBoard = new GameBoard();
		newGame = new GameLogic();
		DicePane dicePane = new DicePane();
		
		root.getChildren().addAll(gameBoard, dicePane);
		
		gameScene = new Scene(root, 1200, 970);
		gameScene.getStylesheets().add("stylesheet2.css");
	}
	
	
	
}
