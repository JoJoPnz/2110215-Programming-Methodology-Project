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
import Logic.GameLogic;

public class DicePane extends VBox {
	private Button rollButton;
	private Button endTurnButton;
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
		setDiceImage(faceValue); //default dice picture
		// Image i = new Image("dice1.png");
		// ImageView i2 = new ImageView(i);

		Button rollButton = new Button("ROLL");
		Button endTurnButton = new Button("END TURN");;
		endTurnButton.setDisable(true);
		
		rollButton.setPrefWidth(150);
		rollButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				GameLogic.rollDice(); // rollDice then change dicePicture and faceValue
				if (GameLogic.player1.isTurn()) {
					GameLogic.player1.move(faceValue);
					GameLogic.player1.getCurrentSquare().setPlayerToSquare(GameLogic.player1);
					
				} else if (GameLogic.player2.isTurn()) {
					GameLogic.player2.move(faceValue);
					GameLogic.player2.getCurrentSquare().setPlayerToSquare(GameLogic.player2);
				}
				
				endTurnButton.setDisable(false);
				rollButton.setDisable(true);
			}
		});

		endTurnButton.setPrefWidth(150);
		endTurnButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (GameLogic.player1.isTurn()) {	
					
					System.out.println("player1 isJail = " + GameLogic.player1.isInJail());
					System.out.println("player2 isJail = " + GameLogic.player2.isInJail());
					
					if (GameLogic.player2.isInJail()) {
						System.out.println("Player2 in jail");
						GameLogic.player1.setTurn(true);
						GameLogic.player2.setTurn(false);
						GameLogic.player2.setInJail(false);
						System.out.println(GameLogic.player2.isInJail());

					} else {
						GameLogic.player1.setTurn(false);
						GameLogic.player2.setTurn(true);

					}

				} else if (GameLogic.player2.isTurn()) {

					System.out.println("player1 isJail = " + GameLogic.player1.isInJail());
					System.out.println("player2 isJail = " + GameLogic.player2.isInJail());
					
					if (GameLogic.player1.isInJail()) {
						System.out.println("Player1 in jail");
						GameLogic.player1.setTurn(false);
						GameLogic.player2.setTurn(true);
						GameLogic.player1.setInJail(false);
						System.out.println(GameLogic.player1.isInJail());

					} else {
						GameLogic.player1.setTurn(true);
						GameLogic.player2.setTurn(false);
					}
				}

				endTurnButton.setDisable(true);
				rollButton.setDisable(false);
			}
		});

		this.getChildren().addAll(diceLabel, this.getDiceImage(), rollButton, endTurnButton);

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

	public int getFaceValue() {
		return faceValue;
	}

	public static void setFaceValue(int faceValue) {
		DicePane.faceValue = faceValue;
	}
	

}
