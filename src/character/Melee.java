package character;

import group.Action;
import group.ActionType;
import group.AttackWho;

public abstract class Melee extends Character {

	public Melee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack() ;
	

	@Override
	public Action roleAttack() {
		return new Action(ActionType.DAMAGE, AttackWho.ALL, stats.getBaseAttack() * 2, stats.getMissChance() + 15);
	}

}
