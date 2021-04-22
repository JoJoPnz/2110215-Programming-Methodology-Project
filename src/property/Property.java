package property;

import square.PropertySquare;

public abstract class Property {

	private boolean occupy;
	private int rent;
	private int level;
	private int upgradeCost;
	private PropertySquare squareBuild;
	private String pictureURL;

	public Property() {
		setOccupy(false);
		setRent(0);
		setLevel(0);
	}

	public Property(boolean isOccupy, int rent, int level, PropertySquare squareBuild) {
		// TODO Auto-generated constructor stub
		setOccupy(isOccupy);
		setRent(rent);
		setLevel(level);
	}

	public boolean isOccupy() {
		return occupy;
	}

	public void setOccupy(boolean occupy) {
		this.occupy = occupy;
	}

	public int getRent() {
		// TODO Auto-generated method stub
		return this.rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public abstract int calculateIncome();

	public PropertySquare getSquareBuild() {
		return squareBuild;
	}

	public void setSquareBuild(PropertySquare squareBuild) {
		this.squareBuild = squareBuild;
	}

	public int getUpgradeCost() {
		return upgradeCost;
	}

	public void setUpgradeCost(int upgradeCost) {
		this.upgradeCost = upgradeCost;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public abstract void createImage();
}
