package Application;

import board.DashBoard;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import property.Area;
import property.Hotel;
import property.House;
import property.Property;
import square.PropertySquare;
import square.Square;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class CheckMainMenu extends Application {
	@Override
	public void start(Stage stage) {

		// å Property area = new Area(false,);

		// HBox rootTop = new HBox();
		// HBox rootBottom = new HBox();
		VBox vBox = new VBox();
		MainMenu mainMenu = new MainMenu();
		vBox.getChildren().addAll(mainMenu);
		// BorderPane border = new BorderPane();
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
		// Square square8 = new PropertySquare("เรารักในหลวง",area,100,"fourth");
		/*
		 * Square square9 = new PropertySquare("เรารักในหลวง",area,100); Square square10
		 * = new PropertySquare("เรารักในหลวง",area,100); Square square11 = new
		 * PropertySquare("เรารักในหลวง",area,100); Square square12 = new
		 * PropertySquare("เรารักในหลวง",area,100); Square square13 = new
		 * PropertySquare("เรารักในหลวง",area,100); Square square14 = new
		 * PropertySquare("เรารักในหลวง",area,100); Square square15 = new
		 * PropertySquare("เรารักในหลวง7",area,100);
		 */

		/*
		 * Square square21 = new PropertySquare("เรารักในหลวง1",area,100); Square
		 * square20 = new PropertySquare("เรารักในหลวง2",area,100); Square square19 =
		 * new PropertySquare("เรารักในหลวง3",area,100); Square square18 = new
		 * PropertySquare("เรารักในหลวง4",area,100); Square square17 = new
		 * PropertySquare("เรารักในหลวง5",area,100); Square square22 = new
		 * GoToJailSquare();
		 */

		// Rotate rotate = new Rotate();
		// rotate.setAngle(90);

		// square7.getTransforms().addAll(rotate);

		// rootTop.getChildren().addAll(square8,square7,square6,square5,square4,square3,square2,square1,square0);
		// rootLeft.getChildren().addAll(square9,square10,square11,square12,square13,square14,square15);
		// rootLeft.getChildren().add(square14);
		// rootLeft.setRotate(90);
		// rootBottom.getChildren().addAll(square22,square15,square16,square17,square18,square19,square20,square21,square16);

		// root.getChildren().add(square1,squarestartSquare);
		// border.setBottom(rootTop);
		// border.setTop(rootBottom);
		// border.setLeft(rootLeft);

		// rootBottom.setRotate(180);
		// rootBottom.setAlignment(Pos.TOP_RIGHT);

		// Creating a scene object
		Scene scene = new Scene(vBox, 900, 600);
		

		// Setting title to the Stage
		stage.setTitle("Drawing a Rectangle");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();

	}

	public Rectangle createRectangle(float xPos, float yPos, float boxHeight, float boxWidth, Paint color,
			boolean isStroke) {
		Rectangle rectangle = new Rectangle();
		rectangle.setX(xPos);
		rectangle.setY(yPos);
		rectangle.setWidth(boxWidth);
		rectangle.setHeight(boxHeight);
		rectangle.setFill(color);
		if (isStroke) {
			rectangle.setStroke(Color.BLACK);
		}
		return rectangle;

	}

	public static void main(String args[]) {
		launch(args);
	}
}