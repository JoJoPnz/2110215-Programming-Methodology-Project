package card.mystery;

import player.Player;

public class GoBackwardCard extends MysteryCard {
	
	public GoBackwardCard() {
		this.setName("Go Backward");
		this.setDescription("Go Back 3 Spaces");
	}
	
	public GoBackwardCard(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void useAbility(Player player) {
		
	}

}
