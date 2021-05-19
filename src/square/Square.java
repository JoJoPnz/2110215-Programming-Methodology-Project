package square;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import player.Player;

import java.util.Arrays;

import Logic.GameLogic;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.*;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public abstract class Square extends GridPane {
	private String appearName;
	protected Tooltip tooltip;
	public Square(String appearName) {
		setAppearName(appearName);
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

	public void setPlayerToSquare(Player player) {
		int[] setSpecialSquare = { 0, 7, 14, 21 };
		Arrays.sort(setSpecialSquare);
		ImageView imageViewChar = player.getCharacterImage();
		int toCheckValue = player.getCurrentPosition();

		// Check player's currentPosition is a specialSquare or not
		boolean isSpecialSquare = false;
		for (int eachSpecialIdx : setSpecialSquare) {
			if (eachSpecialIdx == toCheckValue) {
				isSpecialSquare = true;
				break;
			}
		}
		
		if (isSpecialSquare) {
			this.add(imageViewChar, 0, 0);
		} else {

			if (player.getCurrentPosition() < 14 && player.getCurrentPosition() > 7) {
				this.add(imageViewChar, 0, 1);
				this.setValignment(imageViewChar, VPos.CENTER);
				this.setHalignment(imageViewChar, HPos.LEFT);

			} else if (player.getCurrentPosition() < 7) {
				this.add(imageViewChar, 0, 1);
				this.setValignment(imageViewChar, VPos.BOTTOM);
				this.setHalignment(imageViewChar, HPos.CENTER);
			} else {
				if (player.getCurrentPosition() < 22) {
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
	
	public abstract void setUpTooltip();
	
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
	
}
