package square;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.*;
import javafx.scene.layout.GridPane;

public abstract class Square extends GridPane {
	private String appearName;

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

	public abstract void createGridPane();
}
