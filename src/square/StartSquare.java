package square;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartSquare extends Square {
	public static final String imageURL = "/startPoint.png";
	
	public StartSquare() {
		super("Game Start");
		createGridPane();
		setUpTooltip();
	}

	@Override
	public void createGridPane() {
		Rectangle largeRectangle = createRectangle(200.0f, 75.0f, 175.0f, 175.0f, Color.LIGHTGREEN, true);
		Image img = new Image(imageURL);
		largeRectangle.setFill(new ImagePattern(img));
		this.setAlignment(Pos.BOTTOM_RIGHT);
		this.add(largeRectangle, 0, 0);
	}
	
	@Override
	public void setUpTooltip() {
		tooltip = new Tooltip();
		tooltip.setFont(new Font(17));
		tooltip.setText("Start Point!\n" + "Get 200$ every round.");
		
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX()+10, e.getScreenY()+10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
	
}
