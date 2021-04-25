package board;

import Logic.GameLogic;
import dice.DicePane;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import property.Area;
import property.Property;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class Board extends Application {
	@Override
	public void start(Stage stage) {
		HBox root = new HBox();
		root.setSpacing(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setPrefHeight(400);
		
		GameLogic newGame = new GameLogic();
		
		System.out.println(GameBoard.myArray); 
		GridPane gameBoard = new GameBoard();
		
		DicePane dicePane = new DicePane();
		
		root.getChildren().addAll(gameBoard, dicePane);
		
		// Creating a scene object
		Scene scene = new Scene(root, 1200, 950);

		// Setting title to the Stage
		stage.setTitle("Drawing a Rectangle");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();

	}

	public static void main(String args[]) {
		launch(args);
	}
}