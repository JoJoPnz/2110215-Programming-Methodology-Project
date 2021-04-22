package property;

import Logic.GameLogic;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import square.PropertySquare;
import square.Square;

public class Area extends Property {
	private ImageView areaImage;

	public Area(boolean isOccupy, int level, PropertySquare squareBuild, String pictureURL) {
		// TODO Auto-generated constructor stub
		// super(isOccupy,rent,level,squareBuild);
		// super();
		// super();
		// setRent(level,squareBuild);
		super(isOccupy,level,squareBuild);
		setRentArea(squareBuild.getPrice());
		setPictureURL(pictureURL);
		createImage();
		addImageToSquare((Square)getSquareBuild());
	}
	
	public void setRentArea(int price) {
		// TODO Auto-generated method stub
		super.setRent(calculateIncome());

	}

	@Override
	public int calculateIncome() {
		// TODO Auto-generated method stub
		int rent = 0;
		if (getLevel() == 0) {
			double rentRatio = 0.2;
			rent = (int) Math.round(rentRatio * getSquareBuild().getPrice());

		}
		return rent;
	}
	


	public ImageView getAreaImage() {
		return areaImage;
	}

	public void setAreaimage(ImageView areaimage) {
		areaImage = areaimage;
	}

	public void createImage() {
		Image charImage = new Image(getPictureURL());
		this.areaImage = new ImageView(charImage);
		this.areaImage.setFitHeight(50);
		this.areaImage.setFitWidth(50);
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
		
		//currentSquare.setValignment(imageViewCharPlayer2, VPos.BOTTOM);
		//currentSquare.setHalignment(imageViewCharPlayer2, HPos.RIGHT);
	}



}
