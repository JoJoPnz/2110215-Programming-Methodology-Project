package card;
import deck.Deck;
import player.Player;

public abstract class Card {
	private String name;
	private String description;
	
	public Card() {
		
	}

	public Card(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public abstract void useAbility(Player player, Player otherPlayer);
	
	public void addToDeck(Deck deck) {
		deck.getDeckList().add(this);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
