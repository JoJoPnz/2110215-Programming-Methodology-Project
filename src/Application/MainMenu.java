package Application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
		
		exitGame.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				// TODO fill in this method }
				//ButtonLogic.topControlPaneOnClick();
				System.exit(0);
			}
		});
		
	}

	public Button getStartGame() {
		return startGame;
	}

	public Button getExitGame() {
		return exitGame;
	}

	public void setStartGame(Button startGame) {
		this.startGame = startGame;
	}

	public void setExitGame(Button exitGame) {
		this.exitGame = exitGame;
	}
	

}
