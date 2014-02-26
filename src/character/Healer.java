package character;

import group.Action;
import group.ActionType;
import group.AttackWho;

public abstract class Healer extends Character {
	
	public Healer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack() ;
	
	@Override 
	public abstract void menuDisplay();

	@Override
	public Action roleAttack() {
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.HEAL, AttackWho.ONE, value * 2, 0);
	}

}
