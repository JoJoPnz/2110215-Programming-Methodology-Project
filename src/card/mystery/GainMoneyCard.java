package card.mystery;

import player.Player;

public class GainMoneyCard extends MysteryCard {
	
	public GainMoneyCard() {
		this.setName("Gain Interest.");
		this.setDescription("You gain 10% interest on all your cash, take 10% of your total cash amount from the bank.");
	}
	
	public GainMoneyCard(String name, String description) {
		super(name, description);
	}

	@Override
	public void useAbility(Player player) {
		int currentMoney = player.getMoney();
		int newMoney = currentMoney + (int)(0.1 * currentMoney);
		player.setMoney(newMoney);
	}
	
}
