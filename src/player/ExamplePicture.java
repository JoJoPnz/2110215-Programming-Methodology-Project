package player;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExamplePicture extends Application {

	public ExamplePicture() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Pane pane = new HBox(15);
		Player startPlayer = new Player("dice1.png");
		//Image img = new Image("dice1.png");
		//pane.getChildren().add(new ImageView(img));
		ImageView img2 = startPlayer.getCharacterImage();
		img2.setFitHeight(50);
		img2.setFitWidth(50);
		pane.getChildren().add(img2);
		Scene scene = new Scene(pane, 200, 200);

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
