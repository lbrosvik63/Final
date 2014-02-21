package cs260;

import weapons.Pen;
import armor.LightClothing;
import group.Action;

public class VerilogEnemy extends CS260Enemy {

	public VerilogEnemy() {
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		weapon = new Pen();
		armor = new LightClothing();
	}

	@Override
	public Action primaryAttack() {
		System.out.println("Describe Attack Here");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action secondaryAttack() {
		System.out.println("Describe Attack Here");
		// TODO Auto-generated method stub
		return null;
	}

}
