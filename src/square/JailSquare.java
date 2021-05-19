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

public class JailSquare extends Square {
	public static final String imageURL = "/inJail.png";
	
	public JailSquare() {
		super("Jail");
		createGridPane();
		setUpTooltip();
	}

	@Override
	public void createGridPane() {
		Rectangle largeRectangle = createRectangle(200.0f, 75.0f, 175.0f, 175.0f, Color.RED, true);
		Image img = new Image(imageURL);
		largeRectangle.setFill(new ImagePattern(img));
		this.setAlignment(Pos.BOTTOM_RIGHT);
		this.add(largeRectangle, 0, 0);
	}
	
	@Override
	public void setUpTooltip() {
		tooltip = new Tooltip();
		tooltip.setFont(new Font(17));
		tooltip.setText("Jail!\n" + "You can't roll the dice for 1 turn");
		
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX()+10, e.getScreenY()+10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
	
}
