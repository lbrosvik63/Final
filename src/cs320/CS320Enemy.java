package cs320;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;
/*
 * All CS320 enemies can heal
 */
public abstract class CS320Enemy extends Character {
	
	public CS320Enemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack() ;

	@Override
	public abstract Action secondaryAttack();

	@Override
	public Action roleAttack() {
		System.out.println(this + " Increases its Space Complexity");
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.HEAL, AttackWho.ONE, value, 0);
	}



}
