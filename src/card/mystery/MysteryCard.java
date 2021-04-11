package card.mystery;

import card.Card;
import player.Player;

public abstract class MysteryCard extends Card{
	
	public MysteryCard() {
		super();
	}
	
	public MysteryCard(String name,String description) {
		super(name,description);
	}

}
