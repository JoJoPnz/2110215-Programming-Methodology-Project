import javafx.scene.shape.Rectangle;

public abstract class Square {
	private String appearName;
	private String pictureVisualize;

	public Square(String appearName, String pictureVisualize) {
		// TODO Auto-generated constructor stub
		setAppearName(appearName);
		setPictureVisualize(pictureVisualize);
		
		Rectangle rectangle = new Rectangle(100, 100, 100, 100); // x,y,width,height
	}

	public String getAppearName() {
		return appearName;
	}

	public String getPictureVisualize() {
		return pictureVisualize;
	}

	public void setAppearName(String appearName) {
		this.appearName = appearName;
	}

	public void setPictureVisualize(String pictureVisualize) {
		this.pictureVisualize = pictureVisualize;
	}

}
