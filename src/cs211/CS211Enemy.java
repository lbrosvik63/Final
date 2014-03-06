package cs211;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;

public abstract class CS211Enemy extends Character {

	private final int ROLEMAXVALUE = 15;
	private final int ROLEMINVALUE = 11;
	
	public CS211Enemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack() ;

	@Override
	public abstract Action secondaryAttack();

	@Override
	public Action roleAttack() {
		int value = generateAttackValue(ROLEMINVALUE, ROLEMAXVALUE);
		System.out.println(this + " produces a NullPointerException");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 5);
	}



}
