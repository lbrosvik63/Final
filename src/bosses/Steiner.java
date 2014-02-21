package bosses;

import java.util.Scanner;

import character.Boss;

import weapons.Pen;

import group.Action;
import group.ActionType;
import group.AttackWho;

import armor.MediumClothing;

public class Steiner extends Boss {

	public Steiner() {
		stats.setMaxHealth(200);
		stats.setCurrentHealth(200);
		weapon = new Pen();
		armor = new MediumClothing();
	}

	@Override
	public Action primaryAttack() {
		System.out.println("Homework Barrage: Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10, 5);
	}

	@Override
	public Action secondaryAttack() {
		System.out.println("Deafining Roar: Describe Attack Here");
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
