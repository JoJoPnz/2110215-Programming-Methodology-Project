package player;

import java.util.ArrayList;

import Logic.GameLogic;
import board.GameBoard;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import property.Property;
import square.Square;

public class Player {
	private int money;
	private String characterPictureLink;
	private boolean turn;
	private ArrayList<Property> propertyHave;
	private Square currentSquare;
	private int currentPosition;
	private boolean isBankrupt;
	private boolean everRoll;
	private ImageView characterImage;
	private boolean inJail;

	public Player(String characterPictureLink) {
		// TODO Auto-generated constructor stub
		setMoney(2000);
		setCharacterPictureLink(characterPictureLink);
		setBankrupt(false);
		propertyHave = new ArrayList<Property>();
		setCurrentPosition(0);
		setCurrentSquare(GameBoard.myArray[0]);
		setTurn(false);
		setEverRoll(false);
		setCharacterImage();
	}

	public String getCharacterPictureLink() {
		return characterPictureLink;
	}

	public void setCharacterPictureLink(String characterPictureLink) {
		this.characterPictureLink = characterPictureLink;
	}

	public ImageView getCharacterImage() {
		return characterImage;
	}

	// Can Handle Try-catch

	public void setCharacterImage() {
		Image charImage = new Image(getCharacterPictureLink());
		this.characterImage = new ImageView(charImage);
		this.characterImage.setFitHeight(50);
		this.characterImage.setFitWidth(50);
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		if (money < 0) {
			this.money = 0;
		} else {
			this.money = money;
		}
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public void move(int FaceValue) {
		if (isTurn()) {
			int currentPos = (getCurrentPosition() + FaceValue) % 28;
			if (currentPos == 0) {
				setMoney(getMoney() + 200);
				System.out.println("Pass Start");
				System.out.println("Get Income = 200");
			}
			setCurrentPosition(currentPos);
			setCurrentSquare(GameBoard.myArray[currentPos]);
			setEverRoll(true);
			System.out.println(currentPos);
			
			if (this.getCurrentPosition() == 7) {
				this.setInJail(true);
			}
			else if (this.getCurrentPosition() == 21) {
				GameLogic.goToJail(this);
			}

			
			
		}

	}

	public ArrayList<Property> getPropertyHave() {
		return propertyHave;
	}

	public Square getCurrentSquare() {
		return currentSquare;
	}

	public boolean isBankrupt() {
		return isBankrupt;
	}

	public void setPropertyHave(ArrayList<Property> propertyHave) {
		this.propertyHave = propertyHave;
	}

	public void setCurrentSquare(Square currentSquare) {
		this.currentSquare = currentSquare;
	}

	public void setBankrupt(boolean isBankrupt) {
		this.isBankrupt = isBankrupt;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public boolean isEverRoll() {
		return everRoll;
	}

	public void setEverRoll(boolean everRoll) {
		this.everRoll = everRoll;
	}

	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

}