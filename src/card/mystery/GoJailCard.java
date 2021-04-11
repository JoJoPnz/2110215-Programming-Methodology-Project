package card.mystery;

import player.Player;

public class GoJailCard extends MysteryCard {
	
	public GoJailCard() {
		this.setName("Jail");
		this.setDescription("Go directly to jail.");
	}
	
	public GoJailCard(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void useAbility(Player player, Player otherPlayer) {
		
	}
	
}
