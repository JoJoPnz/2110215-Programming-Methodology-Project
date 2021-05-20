package dice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import player.Player;
import square.PropertySquare;

import java.util.ArrayList;

import Logic.GameLogic;

public class DicePane extends VBox {

	public static Button upgradeButton = new Button("Upgrade Area");
	public static Button rollButton = new Button("Roll");
	public static Button endTurnButton = new Button("End Turn");
	public static Button buyButton = new Button("Buy Area");
	public static TextArea statusText = new TextArea();
	public static Button exitButton = new Button("Exit");
	private static Label diceLabel;
	private static ImageView diceImage = new ImageView();
	private static int faceValue = 1;

	public DicePane() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(40);
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		setStatusText();
		setDiceLabelText();
		
		ArrayList<Button> allButton = new ArrayList<>();
		allButton.add(buyButton);
		allButton.add(upgradeButton);
		allButton.add(rollButton);
		allButton.add(endTurnButton);
		allButton.add(exitButton);
		setButtonSize(allButton);
		setStartButtonDisable();
		setButtonAction();
		
		setDiceImage(faceValue); // default dice picture

		VBox buttonPane = new VBox();
		buttonPane.setSpacing(15);
		buttonPane.setAlignment(Pos.CENTER);
		buttonPane.getChildren().addAll(rollButton, buyButton, upgradeButton, endTurnButton);
		this.getChildren().addAll(statusText, diceLabel, this.getDiceImage(), buttonPane, exitButton);
	}

	public void setDiceLabelText() {
		diceLabel = new Label();
		diceLabel.setFont(new Font("Arial", 20));
		diceLabel.textProperty().setValue("DICE (1-6)");
		diceLabel.setPadding(new Insets(60, 0, 0, 0));
	}

	public static void setDiceImage(int faceValue) {
		DiceImages image = new DiceImages();
		image.setImage(faceValue);
		diceImage.setImage(image.getImage());
		diceImage.setFitWidth(100);
		diceImage.setFitHeight(100);
	}
	
	private void setStatusText() {
		statusText.setText("==== Player 1 Turn ====\n\n"); // start text
		statusText.setFont(new Font("Arial", 15));
		statusText.setWrapText(true);
	}
	
	private void clearStatusText() {
		// Set Header text
		if (GameLogic.player1.isTurn()) {
			statusText.setText("==== Player 1 Turn ====\n\n");
		}
		else {
			statusText.setText("==== Player 2 Turn ====\n\n");
		}
		
	}
	
	private void setButtonSize(ArrayList<Button> allButton) {
		for (Button button : allButton) {
			button.setPrefWidth(150);
			button.setPrefHeight(50);
		}
		exitButton.setPadding(new Insets(70, 0, 0, 0));
	}
	
	private void setStartButtonDisable() {
		buyButton.setDisable(true);
		endTurnButton.setDisable(true);
		rollButton.setDisable(false);
		upgradeButton.setDisable(true);
	}
	
	private void setButtonAction() {
		rollButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameLogic.rollDice(); // rollDice then change dicePicture and faceValue
				GameLogic.move(); // move a player
				// set button behavior
				endTurnButton.setDisable(false);
				rollButton.setDisable(true);
				// play sound
				playSoundEffect("/rollDice.mp3");
			}
		});
		
		buyButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameLogic.buyArea();
				// set button behavior
				buyButton.setDisable(true);
				// play sound
				playSoundEffect("/buy.mp3");
			}
		});	
		
		upgradeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameLogic.upgradeProperty();
				// set button behavior
				upgradeButton.setDisable(true);
				// play sound
				playSoundEffect("/upgrade.mp3");
			}
		});

		endTurnButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameLogic.endTurn(); // change turn to other player
				clearStatusText(); // clear text
				// set button behavior
				endTurnButton.setDisable(true);
				rollButton.setDisable(false);
				buyButton.setDisable(true);
				upgradeButton.setDisable(true);
			}
		});
		
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0); // close program
			}
		});	
	}
	
	private void playSoundEffect(String url) {
		try {
			AudioClip buzzer = new AudioClip(getClass().getResource(url).toExternalForm());
			buzzer.play();
		}
		catch (Exception e){
			System.out.println("Soundtrack url doesn't exist.");
		}
	}
	
	public ImageView getDiceImage() {
		return diceImage;
	}

	public static int getFaceValue() {
		return faceValue;
	}

	public static void setFaceValue(int faceValue) {
		DicePane.faceValue = faceValue;
	}

	
	
}
