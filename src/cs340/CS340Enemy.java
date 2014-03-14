package cs340;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;
/*
 * All CS340 enemies have a Memory Leak attack
 */
public abstract class CS340Enemy extends Character {

	public CS340Enemy() {
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack();

	@Override
	public Action roleAttack() {
		System.out.println(this + " Memory Leak 128bytes lost");
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value, stats.getMissChance() + 15);
	}


}
