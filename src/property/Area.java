package property;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import square.PropertySquare;

public class Area extends Property {
	private ImageView Areaimage;
	public Area(boolean isOccupy,int level,PropertySquare squareBuild,String pictureURL) {
		// TODO Auto-generated constructor stub
		//super(isOccupy,rent,level,squareBuild);
		//super();
		//super();
		//setRent(level,squareBuild);
		setSquareBuild(squareBuild);
		setLevel(level);
		setRent(squareBuild.getPrice());
		setPictureURL(pictureURL);
	}

	public void setRent(int price) {
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
	
	public void createImageFlag() {
		Image charImage = new Image(getPictureURL());
		this.Areaimage = new ImageView(charImage);
		this.Areaimage.setFitHeight(50);
		this.Areaimage.setFitWidth(50);
	}


	
	
}
