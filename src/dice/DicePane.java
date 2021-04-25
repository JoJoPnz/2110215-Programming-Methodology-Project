package dice;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import player.Player;
import square.PropertySquare;
import Logic.GameLogic;

public class DicePane extends VBox {
	private Button rollButton;
	private Button endTurnButton;
	public static Button buyButton = new Button("Buy Area");
	public static Button upgradeButton = new Button("Upgrade Area");
	private Label diceLabel;
	private static ImageView diceImage = new ImageView();
	private static int faceValue;

	public DicePane() {
		this.setAlignment(Pos.CENTER);
		this.setPrefWidth(300);
		this.setSpacing(15);
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		diceLabel = new Label();
		diceLabel.setFont(new Font("Arial", 20));
		setDiceLabelText();

		this.faceValue = 1;
		setDiceImage(faceValue); // default dice picture

		Button rollButton = new Button("ROLL");
		Button endTurnButton = new Button("END TURN");

		buyButton.setDisable(true);
		buyButton.setPrefWidth(150);
		endTurnButton.setDisable(true);

		rollButton.setPrefWidth(150);
		rollButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameLogic.rollDice(); // rollDice then change dicePicture and faceValue
				GameLogic.move(); // move a player

				// set button behavior
				endTurnButton.setDisable(false);
				rollButton.setDisable(true);
			}
		});
		// buyButton.setOnAction();
		buyButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameLogic.buyArea();
				if (GameLogic.player1.isTurn()) {
					((PropertySquare) GameLogic.player1.getCurrentSquare()).setOccupy(true);
					GameLogic.player1.getPropertyHave()
							.add(((PropertySquare) GameLogic.player1.getCurrentSquare()).getProperty());
				} else if (GameLogic.player2.isTurn()) {
					((PropertySquare) GameLogic.player2.getCurrentSquare()).setOccupy(true);
					GameLogic.player2.getPropertyHave()
							.add(((PropertySquare) GameLogic.player2.getCurrentSquare()).getProperty());

				}
				buyButton.setDisable(true);
			}
		});
		
		upgradeButton.setPrefWidth(150);
		upgradeButton.setDisable(true);
		upgradeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameLogic.upgradeProperty();
				upgradeButton.setDisable(true);
			}
		});
		
		endTurnButton.setPrefWidth(150);
		endTurnButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameLogic.endTurn(); // change turn to other player

				// set button behavior
				endTurnButton.setDisable(true);
				rollButton.setDisable(false);
				buyButton.setDisable(true);
				upgradeButton.setDisable(true);
			}
		});

		this.getChildren().addAll(diceLabel, this.getDiceImage(), rollButton, buyButton, upgradeButton, endTurnButton);

	}

	public void setDiceLabelText() {
		diceLabel.textProperty().setValue("DICE (1-6)");
	}

	public static void setDiceImage(int faceValue) {
		DiceImages i = new DiceImages();
		i.setImage(faceValue);
		diceImage.setImage(i.getImage());
		diceImage.setFitWidth(200);
		diceImage.setFitHeight(200);
		// this.diceImage = new ImageView(i.getImage());
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

	public static Button getBuyButton() {
		return buyButton;
	}

	public void setBuyButton(Button buyButton) {
		this.buyButton = buyButton;
	}

}
