package card.mystery;

import player.Player;

public class StealCard extends MysteryCard{
	
	public StealCard() {
		this.setName("Steal");
		this.setDescription("Steal $50 from other player.");
	}

	public StealCard(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void useAbility(Player player, Player otherPlayer) {
		player.setMoney(player.getMoney() + 50);
		otherPlayer.setMoney(otherPlayer.getMoney() - 50);
	}
	
	
}
