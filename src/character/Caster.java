package character;

import group.Action;
import group.ActionType;
import group.AttackWho;


public abstract class Caster extends Character {

	public Caster() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack() ;
	

	@Override
	public Action roleAttack() {
		
		return new Action(ActionType.DAMAGE, AttackWho.ONE, stats.getBaseAttack() * 2, stats.getMissChance() + 25);
	}

}
