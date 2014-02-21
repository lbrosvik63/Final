package cs211;

import weapons.Pen;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class LinkedListEnemy extends CS211Enemy {

	public LinkedListEnemy() {
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		weapon = new Pen();
		armor = new LightClothing();
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
		return new Action(ActionType.DAMAGE, AttackWho.ALL, 10, 5);
	}

}
