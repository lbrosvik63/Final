package groupproject;


public class LightClothing implements Armor {

	private final int dodgeChance = 25;
	private final int armorValue = 0;
	
	@Override
	public int getDodgeChance() {
		return this.dodgeChance;
	}

	@Override
	public int getArmorValue() {
		return this.armorValue;
	}

}
