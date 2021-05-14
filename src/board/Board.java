package board;



import Logic.GameLogic;
import dice.DicePane;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
		
		//====================Main menu scene=========================
		VBox root = new VBox();
		
		root.setBackground(new Background(new BackgroundImage(new Image("menubg.jpg"), BackgroundRepeat.NO_REPEAT, 
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(900,600,true,true,true,true))));
		
		Scene menuScene = new Scene(root, 900, 600);
		
		//================================================================
		
		HBox root2 = new HBox();
		root2.setSpacing(10);
		root2.setPadding(new Insets(10, 10, 10, 10));
		root2.setPrefHeight(400);
		
		GameLogic newGame = new GameLogic();
		
		System.out.println(GameBoard.myArray); 
		GridPane gameBoard = new GameBoard();
		
		DicePane dicePane = new DicePane();
		
		root2.getChildren().addAll(gameBoard, dicePane);
		
		// Creating a scene object
		Scene gameScene = new Scene(root2, 1200, 950);

		// Setting title to the Stage
		stage.setTitle("Monopoly Game");

		// Adding scene to the stage
		stage.setScene(menuScene);

		// Displaying the contents of the stage
		stage.show();
		stage.setResizable(false);
		// Play Background Song
		try {
			AudioClip sound = new AudioClip(getClass().getResource("/backgroundSong.mp3").toExternalForm());
			sound.setCycleCount(AudioClip.INDEFINITE);
			sound.play();
		}
		catch(Exception e) {
			System.out.println("Music not found.");
		}
	}

	public static void main(String args[]) {
		launch(args);
	}
}