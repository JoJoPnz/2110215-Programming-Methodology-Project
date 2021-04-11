package card.mystery;

import player.Player;

public class TaxDodgeCard extends MysteryCard {
	
	public TaxDodgeCard() {
		this.setName("Tax Dodge");
		this.setDescription("Next time you are asked to pay taxes, you can ignore it. Keep this card until used.");
	}
	
	public TaxDodgeCard(String name, String description) {
		super(name, description);
	}
	
	@Override
	public void useAbility(Player player, Player otherPlayer) {
		
	}
	

}
