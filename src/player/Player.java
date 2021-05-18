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
	public static final int START_MONEY = 2000;

	public Player(String characterPictureLink) {
		// TODO Auto-generated constructor stub
		setInitialMoney(START_MONEY);
		setCharacterPictureLink(characterPictureLink);
		setBankrupt(false);
		propertyHave = new ArrayList<Property>();
		setCurrentPosition(0);
		setCurrentSquare(GameBoard.myArray[0]);
		setTurn(false);
		setCharacterImage();
	}

	private void setInitialMoney(int money) {
		// TODO Auto-generated method stub
		if (money < 0) {
			this.money = 0;
		} else {
			this.money = money;
		}
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
			this.setBankrupt(true);
			
		} else {
			this.money = money;
		}
		GameBoard.player1Label.setText("Player 1\nMoney: "+GameLogic.player1.getMoney());
		GameBoard.player2Label.setText("Player 2\nMoney: "+GameLogic.player2.getMoney());
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public void move(int FaceValue) {
//		System.out.println("Player1 Asset");
//		printAsset(GameLogic.player1);
//		System.out.println("Player2 Asset");
//		printAsset(GameLogic.player2);
		if (isTurn()) {
			int pastPos = getCurrentPosition();
			int currentPos = (getCurrentPosition() + FaceValue) % 28;

			// Get Salary (at start point)
			if (pastPos - currentPos > 0) {
				setMoney(getMoney() + 200);
				System.out.println("Pass Start");
				System.out.println("Get Income = 200");
				
				GameLogic.updateStatusText("You get income for 200$\n");
			}

			// if new position is JAIL --> setInJail to True
			if (currentPos == 7 || currentPos == 21) {
				this.setInJail(true);
				currentPos = 7;
				
				GameLogic.updateStatusText("You're in jail. :(\nCann't roll dice for 1 turn.\n");
			}

			// Set new position and square
			setCurrentPosition(currentPos);
			setCurrentSquare(GameBoard.myArray[currentPos]);
			System.out.println(currentPos);

			// Set player picture to a new Square
			this.getCurrentSquare().setPlayerToSquare(this);

			// Check what destination square and do action.
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
//					if (this.getMoney() < currentSq.getRent()) {
//						this.setBankrupt(true);
//					}
					GameLogic.payRent(this);
				}

				// Check isOccupied and money more than price
				else if (checkUnOccupyArea(currentSq) && (getMoney() >= currentSq.getPrice())) {
					DicePane.buyButton.setDisable(false);
				}

				// upgradable if you're the owner, have enough money and not reach max level
				// yet.
				else if (currentSq.getOwner() == this && currentProperty.getLevel() < 2
						&& this.getMoney() >= currentSq.getUpgradeCost()) {
					DicePane.upgradeButton.setDisable(false);
				}
			}
		}
	}

	public static void checkUpgradeArea() {
		if (GameLogic.player1.isTurn()) {
			PropertySquare currentSq = (PropertySquare) GameLogic.player1.getCurrentSquare();
			if (GameLogic.haveProperty(currentSq, GameLogic.player1)) {
				DicePane.upgradeButton.setDisable(false);

			}
		} else if (GameLogic.player2.isTurn()) {
			PropertySquare currentSq = (PropertySquare) GameLogic.player2.getCurrentSquare();
			if (GameLogic.haveProperty(currentSq, GameLogic.player2)) {
				DicePane.upgradeButton.setDisable(false);
			}
		}
	}

	public boolean checkUnOccupyArea(Square square) {
		if (square instanceof PropertySquare) {
			PropertySquare currentArea = (PropertySquare) square;
			// Check isOccupied and money more than price
			if (currentArea.getProperty() == null) {
				return true;
			}
		}
		return false;
	}

	public void printAsset(Player player) {
		for (Property eachProperty : player.getPropertyHave()) {
			System.out.println(eachProperty);
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

	public boolean isInJail() {
		return inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

}