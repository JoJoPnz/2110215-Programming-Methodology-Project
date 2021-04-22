package property;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import square.PropertySquare;
import square.Square;

public class Hotel extends Property {
	private ImageView areaImage;

	public Hotel(boolean isOccupy, int level, PropertySquare squareBuild, String pictureURL) {
		// TODO Auto-generated constructor stub
		super(isOccupy,level,squareBuild);
		setRentArea(squareBuild.getPrice());
		setPictureURL(pictureURL);
		createImage();
		addImageToSquare((Square)getSquareBuild());
	}
	

	private void setRentArea(int price) {
		// TODO Auto-generated method stub
		super.setRent(calculateIncome());
	}


	@Override
	public int calculateIncome() {
		// TODO Auto-generated method stub
		int rent = 0;
		if (getLevel() == 1) {
			double rentRatio = 0.5;
			rent = (int) Math.round(rentRatio * getSquareBuild().getPrice());

		}
		return rent;
	}

	@Override
	public void createImage() {
		// TODO Auto-generated method stub
		Image charImage = new Image(getPictureURL());
		this.areaImage = new ImageView(charImage);
		this.areaImage.setFitHeight(60);
		this.areaImage.setFitWidth(70);
	}
	

	public ImageView getAreaImage() {
		return areaImage;
	}


	public void setAreaImage(ImageView areaImage) {
		this.areaImage = areaImage;
	}


	@Override
	public void addImageToSquare(Square currentSquare) {
		// TODO Auto-generated method stub
		ImageView imageViewProperty = getAreaImage();
		//ImageView imageViewCharPlayer2 = GameLogic.player2.getCharacterImage();
		currentSquare.add(imageViewProperty, 0, 1);
		//this.add(imageViewCharPlayer1,7, 7);
		//this.add(imageViewCharPlayer2,7, 7);
		
		currentSquare.setValignment(imageViewProperty, VPos.TOP);
		currentSquare.setHalignment(imageViewProperty, HPos.CENTER);
	}

}
