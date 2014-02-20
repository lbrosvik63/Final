package character;

import java.util.Scanner;

import weapons.Pen;

import group.Action;
import armor.HeavyClothing;


public class SuperSteiner extends Boss {

	public SuperSteiner() {
		stats.setMaxHealth(300);
		stats.setCurrentHealth(300);
		weapon = new Pen();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action secondaryAttack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action actionMenu(Scanner sysIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void menuDisplay() {
		// TODO Auto-generated method stub
		
	}

}
