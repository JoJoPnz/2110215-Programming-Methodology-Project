import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import property.Property;

public class PropertySqaure extends Square{
	public Property property;
	public int price;
	public int rent;
	
	public PropertySqaure(String Name,Property property,int price) {
		// TODO Auto-generated constructor stub
		super(Name);
		
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

	@Override
	public GridPane createGridPane() {
		// TODO Auto-generated method stub
		return null;
	}


}
