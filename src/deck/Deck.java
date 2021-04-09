package deck;
import java.util.ArrayList;

import card.Card;

public class Deck {
	private String name;
	private String description;
	private int numberOfCards;
	private ArrayList<Card> deckList;
	
	
	public Deck(String name, String description, ArrayList<Card> deckList) {
		this.name = name;
		this.description = description;
		this.deckList = deckList;
		this.numberOfCards = deckList.size();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getNumberOfCards() {
		return numberOfCards;
	}

	public ArrayList<Card> getDeckList() {
		return deckList;
	}

	
	
	
}
