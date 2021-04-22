package player;

import java.util.ArrayList;

import Logic.GameLogic;
import board.GameBoard;
import dice.DicePane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import property.Property;
import square.PropertySquare;
import square.Square;

public class Player {
	private int money;
	private String characterPictureLink;
	private boolean turn;
	private ArrayList<Property> propertyHave;
	private Square currentSquare;
	private int currentPosition;
	private boolean isBankrupt;
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
			int pastPos = getCurrentPosition();
			int currentPos = (getCurrentPosition() + FaceValue) % 28;
			
			// Get Salary (at start point)
			if (pastPos - currentPos > 0) {
				setMoney(getMoney() + 200);
				System.out.println("Pass Start");
				System.out.println("Get Income = 200");
			}
			
			// if new position is JAIL --> setInJail to True
			if (currentPos == 7 || currentPos == 21) {
				this.setInJail(true);
				currentPos = 7;
			}
			
			
			// Set new position and square
			setCurrentPosition(currentPos);
			setCurrentSquare(GameBoard.myArray[currentPos]);
			System.out.println(currentPos);
			
			// Set player picture to a new Square
			this.getCurrentSquare().setPlayerToSquare(this);
			if (this.getCurrentSquare() instanceof PropertySquare) {
				PropertySquare currentSq = (PropertySquare) this.getCurrentSquare();
				// Check isOccupied and money more than price
				if (checkUnOccupyArea(currentSq) && (getMoney()>= currentSq.getPrice())) {
					DicePane.buyButton.setDisable(false);
				}
			}
		}}

	public boolean checkUnOccupyArea(Square square) {
		if (this.getCurrentSquare() instanceof PropertySquare) {
			PropertySquare currentArea = (PropertySquare) this.getCurrentSquare();
			// Check isOccupied and money more than price
			if (!currentArea.isOccupy()) {
				return true;
			}

		}
		return false;
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

	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

}