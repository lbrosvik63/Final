package character;

import java.util.Scanner;

import weapons.Pen;

import group.Action;

import armor.MediumClothing;

public class Capual extends Boss {

	public Capual() {
		stats.setMaxHealth(200);
		stats.setCurrentHealth(200);
		weapon = new Pen();
		armor = new MediumClothing();
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
