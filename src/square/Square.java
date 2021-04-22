package square;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Arrays;

import Logic.GameLogic;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public abstract class Square extends GridPane {
	private String appearName;
	private boolean hasPlayer1;
	private boolean hasPlayer2;

	public Square(String appearName) {
		// TODO Auto-generated constructor stub
		setAppearName(appearName);
	}

	public String getAppearName() {
		return appearName;
	}

	public void setAppearName(String appearName) {
		if (appearName.isEmpty()) {
			this.appearName = "Default Name";
		} else {
			this.appearName = appearName;
		}

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

	public void setPlayer1ToSquare() {
		int[] setSpecialSquare = { 0, 7, 14, 21 };
		Arrays.sort(setSpecialSquare);
		int toCheckValue = GameLogic.player1.getCurrentPosition();

		boolean isSpecialSquare = false;
		for (int eachSpecialIdx : setSpecialSquare) {
			if (eachSpecialIdx == toCheckValue) {
				isSpecialSquare = true;
			
				break;
			}
		}
		if (isSpecialSquare) {
			ImageView imageViewChar = GameLogic.player1.getCharacterImage();
			this.add(imageViewChar, 0, 0);
			/*if (GameLogic.player1.getCurrentPosition() == 21) {
				
			}
			else if (GameLogic.player1.getCurrentPosition() == 14){
				
			}*/
			// this.setAlignment(Pos.BOTTOM_CENTER);
		} else {
			ImageView imageViewChar = GameLogic.player1.getCharacterImage();

			if (GameLogic.player1.getCurrentPosition() < 14 && GameLogic.player1.getCurrentPosition() > 7) {
				this.add(imageViewChar, 0, 1);
				this.setValignment(imageViewChar, VPos.CENTER);
				this.setHalignment(imageViewChar, HPos.LEFT);

			} else if (GameLogic.player1.getCurrentPosition() < 7) {
				this.add(imageViewChar, 0, 1);
				this.setValignment(imageViewChar, VPos.BOTTOM);
				this.setHalignment(imageViewChar, HPos.CENTER);
			} else {
				if (GameLogic.player1.getCurrentPosition() < 22) {
					this.add(imageViewChar, 0, 0);
					this.setValignment(imageViewChar, VPos.TOP);
					this.setHalignment(imageViewChar, HPos.CENTER);
				} else {
					this.add(imageViewChar, 1, 0);
					this.setValignment(imageViewChar, VPos.CENTER);
					this.setHalignment(imageViewChar, HPos.RIGHT);
				}
			}

		}

	}

	// if (GameLogic.player1.getCurrentPosition() in setSpecialSquare) {

	// }

	public void setPlayer2ToSquare() {
		int[] setSpecialSquare = { 0, 7, 14, 21 };
		Arrays.sort(setSpecialSquare);
		int toCheckValue = GameLogic.player2.getCurrentPosition();

		int res = Arrays.binarySearch(setSpecialSquare, toCheckValue);
		boolean isSpecialSquare = false;
		for (int eachSpecialIdx : setSpecialSquare) {
			if (eachSpecialIdx == toCheckValue) {
				isSpecialSquare = true;
				break;
			}
		}
		if (isSpecialSquare) {
			ImageView imageViewChar = GameLogic.player2.getCharacterImage();
			this.add(imageViewChar, 0, 0);
			// this.setAlignment(Pos.BOTTOM_CENTER);
		} else {
			ImageView imageViewChar = GameLogic.player2.getCharacterImage();

			if (GameLogic.player2.getCurrentPosition() < 14 && GameLogic.player2.getCurrentPosition() > 7) {
				this.add(imageViewChar, 0, 1);
				this.setValignment(imageViewChar, VPos.CENTER);
				this.setHalignment(imageViewChar, HPos.LEFT);

			} else if (GameLogic.player2.getCurrentPosition() < 7) {
				this.add(imageViewChar, 0, 1);
				this.setValignment(imageViewChar, VPos.BOTTOM);
				this.setHalignment(imageViewChar, HPos.CENTER);
			} else {
				if (GameLogic.player2.getCurrentPosition() < 22) {
					this.add(imageViewChar, 0, 0);
					this.setValignment(imageViewChar, VPos.TOP);
					this.setHalignment(imageViewChar, HPos.CENTER);
				} else {
					this.add(imageViewChar, 1, 0);
					this.setValignment(imageViewChar, VPos.CENTER);
					this.setHalignment(imageViewChar, HPos.RIGHT);
				}
			}

		}

	}

	public abstract void createGridPane();
}
