package square;

import Logic.GameLogic;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import player.Player;
import property.Area;
import property.Hotel;
import property.Property;

public class PropertySquare extends Square {
	private Property property;
	private int price;
	private String condition;
	private boolean occupy;
	private Player owner;

	public PropertySquare(String Name, Property property, int price, String condition) {
		super(Name);
		setPrice(price);
		setCondition(condition);
		setOccupy(false);
		createGridPane();
		setUpTooltip();
	
	}

	public int getUpgradeCost() {
		Property property = this.getProperty();
		int level = property.getLevel();
		if (level == 0) {
			double costRatio = 1.5;
			int cost = (int) Math.round(costRatio * this.getPrice());
			return cost;
		}
		else if (level == 1) {
			double costRatio = 2.0;
			int cost = (int) Math.round(costRatio * this.getPrice());
			return cost;
		}
		else {
			return 0;
		}
	}
	
	private boolean canGetUpgradeCost() {
		if (this.property == null || this.property.getLevel() >= Property.MAX_LEVEL) {
			return false;
		}
		return true;
	}
	
	// player 1 = Blue,player 2 Red
	public boolean buildProperty(Player player) {
		String propertyPicture;
		if (player == GameLogic.player1) {
			propertyPicture = "blueFlag.png";
		}
		else {
			propertyPicture = "redFlag.png";
		}
			
		if (getProperty() == null) {
			Property newArea = new Area(true, 0, this, propertyPicture);
			setProperty(newArea);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean canGetRent() {
		if (this.getProperty() == null) {
			return false;
		}
		return true;
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
		return property.getRent();
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public void createGridPane() {
		Text nameText = new Text(getAppearName() + "\nPrice = " + getPrice());
		nameText.setTextAlignment(TextAlignment.CENTER);
		nameText.setFont(Font.font("Arial", FontWeight.BOLD, 12));
		if (getCondition().equals("first")) {
			Rectangle largeRectangle = createRectangle(200.0f, 25.0f, 150.0f, 100.0f, Color.web("#d4e8cd"), true);
			Rectangle smallRectangle = createRectangle(250.0f, 25.0f, 25.0f, 100.0f, Color.BLUE, true);
			this.setAlignment(Pos.BOTTOM_RIGHT);
			this.add(smallRectangle, 0, 0);
			this.add(largeRectangle, 0, 1);
			this.setValignment(nameText, VPos.CENTER);
			this.setHalignment(nameText, HPos.CENTER);
			this.add(nameText, 0, 1);
			
		} else if (getCondition().equals("second")) {
			Rectangle largeRectangle = createRectangle(200.0f, 25.0f, 100.0f, 150.0f, Color.web("#d4e8cd"), true);
			Rectangle smallRectangle = createRectangle(250.0f, 25.0f, 100.0f, 25.0f, Color.GREEN, true);
			this.setAlignment(Pos.BOTTOM_RIGHT);
			nameText.setRotate(90);
			this.add(smallRectangle, 1, 1);
			this.add(largeRectangle, 0, 1);
			this.setValignment(nameText, VPos.CENTER);
			this.setHalignment(nameText, HPos.CENTER);
			this.add(nameText, 0, 1);
	
		} else if (getCondition().equals("third")) {
			Rectangle largeRectangle = createRectangle(200.0f, 25.0f, 150.0f, 100.0f, Color.web("#d4e8cd"), true);
			Rectangle smallRectangle = createRectangle(250.0f, 25.0f, 25.0f, 100.0f, Color.YELLOW, true);
			this.setAlignment(Pos.BOTTOM_RIGHT);
			nameText.setRotate(180);
			this.add(smallRectangle, 0, 1);
			this.add(largeRectangle, 0, 0);
			this.setValignment(nameText, VPos.CENTER);
			this.setHalignment(nameText, HPos.CENTER);
			this.add(nameText, 0, 0);
		} else if (getCondition().equals("fourth")) {
			Rectangle largeRectangle = createRectangle(200.0f, 25.0f, 100.0f, 150.0f, Color.web("#d4e8cd"), true);
			Rectangle smallRectangle = createRectangle(250.0f, 25.0f, 100.0f, 25.0f, Color.RED, true);
			this.setAlignment(Pos.BOTTOM_RIGHT);
			nameText.setRotate(270);
			this.add(smallRectangle, 0, 0);
			this.add(largeRectangle, 1, 0);
			this.setValignment(nameText, VPos.CENTER);
			this.setHalignment(nameText, HPos.CENTER);
			this.add(nameText, 1, 0);
		}
	}
	
	@Override
	public void setUpTooltip() {
		tooltip = new Tooltip();
		tooltip.setFont(new Font(17));
		tooltip.setText("City : " + this.getAppearName() + "\n" +
						"Price : " + this.getPrice() + "$\n");
		if (this.canGetRent()) {
			tooltip.setText(tooltip.getText() + "Rent : " + this.getRent() + "$\n");
		}
		if (this.canGetUpgradeCost()) {
			tooltip.setText(tooltip.getText() + "Upgrade cost : " + this.getUpgradeCost() + "$\n");
		}
		
		this.setOnMouseMoved((MouseEvent e) -> {
			tooltip.show(this, e.getScreenX()+10, e.getScreenY()+10);
		});
		this.setOnMouseExited((MouseEvent e) -> {
			tooltip.hide();
		});
	}
	
}