package property;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import square.PropertySquare;
import square.Square;

public class Hotel extends Property  {

	public Hotel(boolean isOccupy, int level, PropertySquare squareBuild, String pictureURL) {
		super(isOccupy,level,squareBuild);
		setRentArea();
		setPictureURL(pictureURL);
		createImage();
		addImageToSquare((Square)getSquareBuild());
	}

	private void setRentArea() {
		this.setRent(calculateIncome());
	}

	@Override
	public int calculateIncome() {
		int rent = 0;
		if (getLevel() == 2) {
			double rentRatio = 0.5;
			rent = (int) Math.round(rentRatio * getSquareBuild().getPrice());
		}
		return rent;
	}
}
