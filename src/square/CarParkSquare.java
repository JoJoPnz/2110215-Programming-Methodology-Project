package square;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CarParkSquare extends Square{

	public static final String imageURL = "";

	public CarParkSquare() {
		super("Car parking lot");
		createGridPane();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createGridPane() {
		// TODO Auto-generated method stub

		Rectangle largeRectangle = createRectangle(200.0f, 75.0f, 175.0f, 175.0f, Color.LIGHTYELLOW, true);

		this.setAlignment(Pos.BOTTOM_RIGHT);
		// Text nameText = new Text(getAppearName());
		// Text priceText = new Text("Price" + getPrice() + "\n Rent = " + getRent());
		Text nameText = new Text(getAppearName());

		this.add(largeRectangle, 0, 0);
		this.setValignment(nameText, VPos.CENTER);
		this.setHalignment(nameText, HPos.CENTER);

		// root.add(smallRectangle, 0, 1);
		this.add(nameText, 0, 0);
		/*this.add(priceText, 0, 1);

		this.setValignment(priceText, VPos.BOTTOM);
		this.setHalignment(priceText, HPos.CENTER);*/
		
	}

}
