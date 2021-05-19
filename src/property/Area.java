package property;

import Logic.GameLogic;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import square.PropertySquare;
import square.Square;

public class Area extends Property implements Upgradable {

	public Area(boolean isOccupy, int level, PropertySquare squareBuild, String pictureURL) {
		super(isOccupy, level, squareBuild);
		setRentArea();
		setPictureURL(pictureURL);
		createImage();
		addImageToSquare((Square) getSquareBuild());
	}

	public void setRentArea() {
		this.setRent(calculateIncome());
	}
	
	@Override
	public int calculateIncome() {
		int rent = 0;
		if (getLevel() == 0) {
			double rentRatio = 0.2;
			rent = (int) Math.round(rentRatio * getSquareBuild().getPrice());
		}
		return rent;
	}
	
	@Override
	public void upgrade() {
		if (GameLogic.player1.isTurn()) {
			PropertySquare currentSq = (PropertySquare) GameLogic.player1.getCurrentSquare();
			currentSq.getProperty().areaImage.setImage(null);
			currentSq.setProperty(new House(true, 1, currentSq, "blueHouse.png"));
		} else if (GameLogic.player2.isTurn()) {
			PropertySquare currentSq = (PropertySquare) GameLogic.player2.getCurrentSquare();
			currentSq.getProperty().areaImage.setImage(null);
			currentSq.setProperty(new House(true, 1, currentSq, "redHouse.png"));
		}
	}
}
