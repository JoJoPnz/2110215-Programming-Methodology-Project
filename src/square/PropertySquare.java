package square;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import property.Property;

public class PropertySquare extends Square {
	private Property property;
	private int price;
	private String condition;
	private boolean occupy;

	public PropertySquare(String Name, Property property, int price, String condition) {
		// TODO Auto-generated constructor stub
		super(Name);
		setPrice(price);
		setCondition(condition);
		createGridPane();
		setOccupy(false);
	}

	public boolean isOccupy() {
		return occupy;
	}

	public void setOccupy(boolean occupy) {
		this.occupy = occupy;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Property getProperty() {
		return property;
	}

	public int getPrice() {
		return price;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRent() {
		if (getProperty() == null) {
			return 0;
		} else {
			return property.getRent();
		}
	}

	public void createGridPane() {
		// TODO Auto-generated method stub

		if (getCondition().equals("first")) {
			Rectangle largeRectangle = createRectangle(200.0f, 25.0f, 150.0f, 100.0f, Color.WHITE, true);
			Rectangle smallRectangle = createRectangle(250.0f, 25.0f, 25.0f, 100.0f, Color.BLUE, true);
			this.setAlignment(Pos.BOTTOM_RIGHT);
			// Text nameText = new Text(getAppearName());
			// Text priceText = new Text("Price" + getPrice() + "\n Rent = " + getRent());
			Text nameText = new Text(getAppearName() + "\nPrice = " + getPrice());
			//Text priceText = new Text("Price");

			this.add(smallRectangle, 0, 0);
			this.add(largeRectangle, 0, 1);
			this.setValignment(nameText, VPos.CENTER);
			this.setHalignment(nameText, HPos.CENTER);

			// root.add(smallRectangle, 0, 1);
			this.add(nameText, 0, 1);
			//this.add(priceText, 0, 1);

			//this.setValignment(priceText, VPos.BOTTOM);
			//this.setHalignment(priceText, HPos.CENTER);

		} else if (getCondition().equals("second")) {

			/*Rectangle largeRectangle = createRectangle(200.0f, 25.0f, 150.0f, 100.0f, Color.WHITE, true);
			Rectangle smallRectangle = createRectangle(250.0f, 25.0f, 25.0f, 100.0f, Color.BLUE, true);*/
			
			Rectangle largeRectangle = createRectangle(200.0f, 25.0f, 100.0f, 150.0f, Color.WHITE, true);
			Rectangle smallRectangle = createRectangle(250.0f, 25.0f, 100.0f, 25.0f, Color.GREEN, true);
			this.setAlignment(Pos.BOTTOM_RIGHT);
			// Text nameText = new Text(getAppearName());
			// Text priceText = new Text("Price" + getPrice() + "\n Rent = " + getRent());
			Text nameText = new Text(getAppearName() + "\nPrice = "  + getPrice());
			//Text priceText = new Text("Price");
			
			nameText.setRotate(90);
			//priceText.setRotate(90);

			this.add(smallRectangle, 1, 1);
			this.add(largeRectangle, 0, 1);
			this.setValignment(nameText, VPos.CENTER);
			this.setHalignment(nameText, HPos.CENTER);

			// root.add(smallRectangle, 0, 1);
			this.add(nameText, 0, 1);
			//this.add(priceText, 0, 1);

			//this.setValignment(priceText, VPos.BOTTOM);
			//this.setHalignment(priceText, HPos.CENTER);

		}
		else if (getCondition().equals("third")) {
			
			Rectangle largeRectangle = createRectangle(200.0f, 25.0f, 150.0f, 100.0f, Color.WHITE, true);
			Rectangle smallRectangle = createRectangle(250.0f, 25.0f, 25.0f, 100.0f, Color.YELLOW, true);
			this.setAlignment(Pos.BOTTOM_RIGHT);
			// Text nameText = new Text(getAppearName());
			// Text priceText = new Text("Price" + getPrice() + "\n Rent = " + getRent());
			Text nameText = new Text(getAppearName() + "\nPrice = " + getPrice());
			//Text priceText = new Text("Price");
			
			nameText.setRotate(180);
			//priceText.setRotate(90);

			this.add(smallRectangle, 0, 1);
			this.add(largeRectangle, 0, 0);
			this.setValignment(nameText, VPos.CENTER);
			this.setHalignment(nameText, HPos.CENTER);

			// root.add(smallRectangle, 0, 1);
			this.add(nameText, 0, 0);
		}
		else if (getCondition().equals("fourth")) {
			Rectangle largeRectangle = createRectangle(200.0f, 25.0f, 100.0f, 150.0f, Color.WHITE, true);
			Rectangle smallRectangle = createRectangle(250.0f, 25.0f, 100.0f, 25.0f, Color.PINK, true);
			this.setAlignment(Pos.BOTTOM_RIGHT);
			// Text nameText = new Text(getAppearName());
			// Text priceText = new Text("Price" + getPrice() + "\n Rent = " + getRent());
			Text nameText = new Text(getAppearName() + "\nPrice = " + getPrice());
			//Text priceText = new Text("Price");
			
			nameText.setRotate(270);
			//priceText.setRotate(90);

			this.add(smallRectangle, 0, 0);
			this.add(largeRectangle, 1, 0);
			this.setValignment(nameText, VPos.CENTER);
			this.setHalignment(nameText, HPos.CENTER);

			// root.add(smallRectangle, 0, 1);
			this.add(nameText, 1, 0);
		}


	}

}