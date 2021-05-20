package player;

import java.util.ArrayList;

import Application.GameBoard;
import Logic.GameLogic;
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
	public static final int START_MONEY = 2000;
	public static final int MAX_POSITION = 28;
	public static final int JAIL_POSITION = 7;
	public static final int GOTOJAIL_POSITION = 21;

	public Player(String characterPictureLink) {
		setInitialMoney(START_MONEY);
		setCharacterPictureLink(characterPictureLink);
		setBankrupt(false);
		propertyHave = new ArrayList<Property>();
		setCurrentPosition(0);
		setCurrentSquare(GameBoard.myArray[0]);
		setTurn(false);
		setCharacterImage();
	}
	
	public boolean checkUnOccupyArea(Square square) {
		if (square instanceof PropertySquare) {
			PropertySquare currentArea = (PropertySquare) square;
			if (currentArea.getProperty() == null) {
				return true;
			}
		}
		return false;
	}
	
	public void move(int FaceValue) {
		if (isTurn()) {
			int pastPos = getCurrentPosition();
			int currentPos = (getCurrentPosition() + FaceValue) % MAX_POSITION;

			// Get Salary (at start point)
			if (pastPos - currentPos > 0) {
				setMoney(getMoney() + 200);
				GameLogic.updateStatusText("You get income for 200$\n");
			}

			// if new position is JAIL --> setInJail to True
			if (currentPos == JAIL_POSITION || currentPos == GOTOJAIL_POSITION) {
				this.setInJail(true);
				currentPos = JAIL_POSITION;
				GameLogic.updateStatusText("You're in jail. :(\nCan't roll dice for 1 turn.\n");
			}

			// Set new position and square
			setCurrentPosition(currentPos);
			setCurrentSquare(GameBoard.myArray[currentPos]);

			// Set player picture to a new Square
			this.getCurrentSquare().setPlayerToSquare(this);
			
			// Check what destination square and do action.
			doDestinationSquareAction();
		}
	}
	
	private void doDestinationSquareAction() {
		if (this.getCurrentSquare() instanceof PropertySquare) {
			PropertySquare currentSq = (PropertySquare) this.getCurrentSquare();
			Property currentProperty = currentSq.getProperty();
			// Check isOccupied and has money more than price --> can buy
			if (checkUnOccupyArea(currentSq) && (getMoney() >= currentSq.getPrice())) {
				DicePane.buyButton.setDisable(false);
			}
			// opponent area --> pay
			else if (!checkUnOccupyArea(currentSq) && currentSq.getOwner() != this) {
				DicePane.buyButton.setDisable(true);
				GameLogic.payRent(this);
			}
			// can upgrade if you're the owner, have enough money and not reach max level yet.
			else if (currentSq.getOwner() == this && currentProperty.getLevel() < Property.MAX_LEVEL
					&& this.getMoney() >= currentSq.getUpgradeCost()) {
				DicePane.upgradeButton.setDisable(false);
			}
		}
	}
	
	private void setInitialMoney(int money) {
		if (money < 0) {
			this.money = 0;
		} else {
			this.money = money;
		}
	}
	
	public void setMoney(int money) {
		if (money < 0) {
			this.money = 0;
			this.setBankrupt(true);
			GameLogic.updateStatusText("You are bankrupted !!!!! \n");
			GameLogic.alertBankrupt();
			GameLogic.endGame();
			
		} else {
			this.money = money;
		}
		GameBoard.player1Label.setText("Player 1\nMoney: "+GameLogic.player1.getMoney() + "$");
		GameBoard.player2Label.setText("Player 2\nMoney: "+GameLogic.player2.getMoney() + "$");
	}
	
	public void setCharacterImage() {
		Image charImage = new Image(getCharacterPictureLink());
		this.characterImage = new ImageView(charImage);
		this.characterImage.setFitHeight(50);
		this.characterImage.setFitWidth(50);
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

	public int getMoney() {
		return money;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
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