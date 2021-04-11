package card.mystery;

import player.Player;

public class GoForwardCard extends MysteryCard {

	public GoForwardCard() {
		this.setName("Go Forward");
		this.setDescription("Go Forward 3 Spaces");
	}
	
	public GoForwardCard(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void useAbility(Player player) {
		
	}
	
}
