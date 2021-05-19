package property;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import square.PropertySquare;
import square.Square;

public abstract class Property {
	protected ImageView areaImage;
	private boolean occupy;
	private int rent;
	private int level;
	private PropertySquare squareBuild;
	private String pictureURL;
	public static final int MAX_LEVEL = 2;

	public Property(boolean isOccupy, int level, PropertySquare squareBuild) {
		setOccupy(isOccupy);
		setLevel(level);
		setSquareBuild(squareBuild);
	}
	
	public ImageView getAreaImage() {
		return areaImage;
	}
	
	public void setAreaImage(ImageView areaImage) {
		this.areaImage = areaImage;
	}
	
	public boolean isOccupy() {
		return occupy;
	}

	public void setOccupy(boolean occupy) {
		this.occupy = occupy;
	}

	public int getRent() {
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

	public PropertySquare getSquareBuild() {
		return squareBuild;
	}

	public void setSquareBuild(PropertySquare squareBuild) {
		this.squareBuild = squareBuild;
	}

	public String getPictureURL() {
		return pictureURL;
	}

	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	
	public void createImage() {
		Image charImage = new Image(getPictureURL());
		this.areaImage = new ImageView(charImage);
		this.areaImage.setFitHeight(50);
		this.areaImage.setFitWidth(50);
	}
	
	public void addImageToSquare(Square currentSquare) {
		ImageView imageViewProperty = getAreaImage();
		PropertySquare currentSq = (PropertySquare) currentSquare;
		if (currentSq.getCondition() == "first") {
			currentSquare.add(imageViewProperty, 0, 1);
			currentSquare.setValignment(imageViewProperty, VPos.TOP);
			currentSquare.setHalignment(imageViewProperty, HPos.CENTER);
		} else if (currentSq.getCondition() == "second") {
			currentSquare.add(imageViewProperty, 0, 1);
			currentSquare.setValignment(imageViewProperty, VPos.CENTER);
			currentSquare.setHalignment(imageViewProperty, HPos.RIGHT);
		} else if (currentSq.getCondition() == "third") {
			currentSquare.add(imageViewProperty, 0, 0);
			currentSquare.setValignment(imageViewProperty, VPos.BOTTOM);
			currentSquare.setHalignment(imageViewProperty, HPos.CENTER);
		} else if (currentSq.getCondition() == "fourth") {
			currentSquare.add(imageViewProperty, 1, 0);
			currentSquare.setValignment(imageViewProperty, VPos.CENTER);
			currentSquare.setHalignment(imageViewProperty, HPos.LEFT);
		}
	}
	
	public abstract int calculateIncome();
}
