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
import Logic.GameLogic;

public class DicePane extends VBox {
	private Button rollButton;
	private Button endTurnButton;
	private Label diceLabel;
	private ImageView diceImage = new ImageView();
	private int faceValue;

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
		setDiceImage(faceValue);
		// Image i = new Image("dice1.png");
		// ImageView i2 = new ImageView(i);

		Button rollButton = new Button("ROLL");
		Button endTurnButton = new Button("END TURN");
		endTurnButton.setVisible(false);

		rollButton.setPrefWidth(150);
		rollButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Dice dice = new Dice();
				dice.roll();

				faceValue = dice.getFaceValue();
				setDiceImage(faceValue);
				if (GameLogic.player1.isTurn()) {
					GameLogic.player1.move(faceValue);
					endTurnButton.setVisible(true);
					rollButton.setVisible(false);
					GameLogic.player1.getCurrentSquare().setPlayer1ToSquare();
				} else if (GameLogic.player2.isTurn()) {
					GameLogic.player2.move(faceValue);
					endTurnButton.setVisible(true);
					rollButton.setVisible(false);
					GameLogic.player2.getCurrentSquare().setPlayer2ToSquare();
				}
			}
		});

		endTurnButton.setPrefWidth(150);
		endTurnButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (GameLogic.player1.isTurn() && GameLogic.player1.isEverRoll()) {
					// System.out.println(1);
					endTurnButton.setVisible(false);
					GameLogic.player1.setTurn(false);
					GameLogic.player2.setTurn(true);
					rollButton.setVisible(true);

				} else if (GameLogic.player2.isTurn() && GameLogic.player2.isEverRoll()) {
					System.out.println(2);
					endTurnButton.setVisible(false);
					GameLogic.player1.setTurn(true);
					GameLogic.player2.setTurn(false);
					rollButton.setVisible(true);
				}
			}
		});

		this.getChildren().addAll(diceLabel, this.getDiceImage(), rollButton, endTurnButton);

	}

	public void setDiceLabelText() {
		diceLabel.textProperty().setValue("DICE (1-6)");
	}

	public void setDiceImage(int faceValue) {
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

	public int getFaceValue() {
		return faceValue;
	}

}
