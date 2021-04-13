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

		Property area = new Area();
		GridPane tryGrid = new GridPane();
		//HBox rootTop = new HBox();
		//HBox rootBottom = new HBox();
		//VBox rootLeft = new VBox();
		//VBox rootRight = new VBox();

		//BorderPane border = new BorderPane();
		/*
		 * Square square0 = new StartSquare(); Square square1 = new
		 * PropertySquare("เรารักในหลวง1",area,100); Square square2 = new
		 * PropertySquare("เรารักในหลวง2",area,100); Square square3 = new
		 * PropertySquare("เรารักในหลวง3",area,100); Square square4 = new
		 * PropertySquare("เรารักในหลวง4",area,100); Square square5 = new
		 * PropertySquare("เรารักในหลวง5",area,100); Square square6 = new
		 * PropertySquare("เรารักในหลวง6",area,100); Square square7 = new
		 * PropertySquare("เรารักในหลวง7",area,100);
		 * 
		 * 
		 * Square square8 = new JailSquare(); Square square9 = new
		 * PropertySquare("เรารักในหลวง1",area,100); Square square10 = new
		 * PropertySquare("เรารักในหลวง2",area,100); Square square11 = new
		 * PropertySquare("เรารักในหลวง3",area,100); Square square12 = new
		 * PropertySquare("เรารักในหลวง4",area,100); Square square13 = new
		 * PropertySquare("เรารักในหลวง5",area,100); Square square14 = new
		 * PropertySquare("เรารักในหลวง6",area,100);
		 * 
		 * Square square15 = new PropertySquare("เรารักในหลวง7",area,100); Square
		 * square16 = new CarParkSquare();
		 */
		

		//Square square15 = new PropertySquare("Kyoto", area, 210,"second");

		// Rotate rotate = new Rotate();
		// rotate.setAngle(90);

		// square7.getTransforms().addAll(rotate);

		// rootTop.getChildren().addAll(square8,square7,square6,square5,square4,square3,square2,square1,square0);
		/*rootBottom.getChildren().addAll(square0,square1, square2, square3, square4, square5, square6, square7);
		rootLeft.getChildren().addAll(square14, square13, square12, square11, square10,square9);
		rootTop.getChildren().addAll(square15,square16,square17, square18, square19, square20, square21,square22);
		rootRight.getChildren().addAll(square23, square24, square25, square26, square27,square28);*/
		// rootLeft.setRotate(90);
		// rootBottom.getChildren().addAll(square22,square15,square16,square17,square18,square19,square20,square21,square16);

		// root.getChildren().add(square1,squarestartSquare);
		// border.setBottom(rootTop);
		// border.setTop(rootBottom);
		/*border.setBottom(rootBottom);
		border.setLeft(rootLeft);
		border.setTop(rootTop);
		border.setRight(rootRight);*/

		// rootBottom.setRotate(180);
		// rootBottom.setAlignment(Pos.TOP_RIGHT);
		//tryGrid.add(square2,5,7);
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