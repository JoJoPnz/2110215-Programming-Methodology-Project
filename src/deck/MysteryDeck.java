package deck;
import java.util.ArrayList;

import card.Card;
import card.mystery.*;

public class MysteryDeck extends Deck{
	
	public MysteryDeck() {
		this.addOneCard(new GainMoneyCard());
		this.addOneCard(new GoBackwardCard());
		this.addOneCard(new GoForwardCard());
		this.addOneCard(new GoJailCard());
		this.addOneCard(new MercifulCard());
		this.addOneCard(new StealCard());
		this.addOneCard(new TaxDodgeCard());
	}
	
	public MysteryDeck(String name, String description, ArrayList<Card> deckList) {
		super(name, description, deckList);
	}
	
	
	
}
