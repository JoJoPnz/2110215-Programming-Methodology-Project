
import java.util.ArrayList;

public abstract class Player {
	private int money;
	private String characterPictureLink;
	private boolean turn;
<<<<<<< HEAD
	private ArrayList<Property> propertyHave;
	private String skill;

=======
	private boolean isBankrupt;
	
	
>>>>>>> fe5cd3487c15d063322c8b4ed599e8edbd67ab37
	public Player() {
		// TODO Auto-generated constructor stub

	}

	public String getCharacterPictureLink() {
		return characterPictureLink;
	}

	public ArrayList<Property> getCityHave() {
		return propertyHave;
	}

	public void setCharacterPictureLink(String characterPictureLink) {
		this.characterPictureLink = characterPictureLink;
	}

	public void setCityHave(ArrayList<Property> cityHave) {
		this.propertyHave = cityHave;
	}

	public int getMoney() {
		return money;
	}

	public String getCharacterPicture() {
		return characterPictureLink;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setMoney(int money) {
		if (money < 0) {
			this.money = 0;
		}
		else {
			this.money = money;
		}
	}

	public void setCharacterPicture(String characterPicture) {
		this.characterPictureLink = characterPicture;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

}
