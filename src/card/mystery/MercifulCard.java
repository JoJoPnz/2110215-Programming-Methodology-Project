package card.mystery;

import player.Player;

public class MercifulCard extends MysteryCard {
	
	public MercifulCard() {
		this.setName("Merciful");
		this.setDescription("You save a cat in a tree and the grateful owner gives you $25.");
	}

	public MercifulCard(String name, String description) {
		super(name, description);
	}

	@Override
	public void useAbility(Player player) {
		player.setMoney(player.getMoney() + 25);
	}
	
}
