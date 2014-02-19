package groupproject;


public class HeavyClothing implements Armor {

	private final int dodgeChance = 5;
	private final int armorValue = 40;
	
	@Override
	public int getDodgeChance() {
		return this.dodgeChance;
	}

	@Override
	public int getArmorValue() {
		return this.armorValue;
	}

}
