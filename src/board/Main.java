package board;



import Logic.GameLogic;
import dice.DicePane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

public class Main extends Application {
	private static Stage stage;
	private static Button startGame = new Button("Play");
	private static Button exitGame = new Button("Exit");
	private static AudioClip sound;
	
	public static Stage getStage() {
		return stage;
	}

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		
		// Play Background Song
		try {
			sound = new AudioClip(getClass().getResource("/backgroundSong.mp3").toExternalForm());
			sound.setCycleCount(AudioClip.INDEFINITE);
			sound.play();
			}
		catch(Exception e) {
			System.out.println("Music not found.");
			}
		
		
		
		//====================Main menu scene=========================
		VBox root = new VBox();

		root.setBackground(new Background(new BackgroundImage(new Image("menubg.jpg"), BackgroundRepeat.NO_REPEAT, 
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(900,550,true,true,true,true))));
		ImageView logo = new ImageView(new Image("logo.png"));
		logo.setFitHeight(300);
		logo.setFitWidth(700);
		root.setAlignment(Pos.CENTER);
		
		HBox buttonPane = new HBox();
		
		initButton();
		
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.setSpacing(50);
		buttonPane.getChildren().addAll(startGame, exitGame);
		
		root.getChildren().addAll(logo,buttonPane);
		Scene menuScene = new Scene(root, 900, 550);
		menuScene.getStylesheets().add("stylesheet.css");
		//================================================================
		

		
		// Setting title to the Stage
		stage.setTitle("Monopoly Game");

		// Adding scene to the stage
		stage.setScene(menuScene);

		// Displaying the contents of the stage
		stage.show();
		stage.setResizable(false);
		
		
	}

	public static void main(String args[]) {
		launch(args);
	}
	
	private void initButton() {
		startGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameScene game = new GameScene();
				stage.setScene(GameScene.gameScene);
			}
		});
		
		exitGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});
		
		startGame.setFont(new Font("Ariel",50));
		exitGame.setFont(new Font("Ariel",50));
		startGame.setPrefWidth(300);
		startGame.setPrefHeight(80);
		exitGame.setPrefWidth(300);
		exitGame.setPrefHeight(80);
	}
}