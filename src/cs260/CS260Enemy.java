package cs260;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;

public abstract class CS260Enemy extends Character {
	
	public CS260Enemy() {
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack();

	@Override
	public Action roleAttack() {
		System.out.println(this + " MIPS Shutdown");
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance() + 15);
	}

}
