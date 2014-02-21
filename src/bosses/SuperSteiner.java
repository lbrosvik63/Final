package bosses;

import java.util.Scanner;

import character.Boss;

import weapons.Pen;

import group.Action;
import group.ActionType;
import group.AttackWho;
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
		System.out.println("Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10, 5);
	}

	@Override
	public Action secondaryAttack() {
		System.out.println("Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10, 5);
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
