package bosses;

import java.util.Scanner;

import weapons.Pen;
import armor.HeavyClothing;

import character.Boss;

import group.Action;
import group.ActionType;
import group.AttackWho;

public class Tappan extends Boss {

	public Tappan() {
		stats.setMaxHealth(300);
		stats.setCurrentHealth(300);
		weapon = new Pen();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		System.out.println("Finds Instanceof: Tells you to shoot yourself now");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10, 5);
	}

	@Override
	public Action secondaryAttack() {
		System.out.println("Summons Pumpkin Suit: Describe Attack Here");
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
