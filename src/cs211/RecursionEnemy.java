package cs211;

import weapons.Pen;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class RecursionEnemy extends CS211Enemy {

	private final int PRIMARYMAXVALUE = 20;
	private final int PRIMARYMINVALUE = 5;
	private final int SECONDARYMAXVALUE = 25;
	private final int SECONDARYMINVALUE = 8;
	
	public RecursionEnemy() {
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		weapon = new Pen();
		armor = new LightClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		System.out.println(this + " causes a StackOverflow");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value, 5);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + " to Know About it, You Must First Know About Recursion");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, 5);
	}

	public String toString(){
		return "Recursion";
	}
}
