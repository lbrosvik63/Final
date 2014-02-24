package cs211;

import weapons.Pen;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class LinkedListEnemy extends CS211Enemy {

	private final int PRIMARYMAXVALUE = 25;
	private final int PRIMARYMINVALUE = 7;
	private final int SECONDARYMAXVALUE = 18;
	private final int SECONDARYMINVALUE = 8;
	
	public LinkedListEnemy() {
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		weapon = new Pen();
		armor = new LightClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		System.out.println(this + " Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 25);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + "Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, 15);
	}

	public String toString(){
		return "Linked List";
	}
}
