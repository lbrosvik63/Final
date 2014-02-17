package groupproject;


public class MediumClothing implements Armor {

	private final int dodgeChance = 12;
	private final int armorValue = 20;
	
	@Override
	public int getDodgeChange() {
		return this.dodgeChance;
	}

	@Override
	public int getArmorValue() {
		return this.armorValue;
	}

}
