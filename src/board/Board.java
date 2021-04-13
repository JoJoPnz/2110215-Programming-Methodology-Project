package board;

import javafx.application.Application;
import javafx.geometry.HPos;
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
import square.GameBoard;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class Board extends Application {
	@Override
	public void start(Stage stage) {

		System.out.println(GameBoard.myArray);
		GridPane gameBoard = new GameBoard();
		
		// Creating a scene object
		Scene scene = new Scene(gameBoard, 950, 950);

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