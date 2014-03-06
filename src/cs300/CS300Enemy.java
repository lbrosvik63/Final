package cs300;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;

public abstract class CS300Enemy extends Character {

	public CS300Enemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action primaryAttack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action secondaryAttack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action roleAttack() {
		System.out.println("Describe Attack Here");
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance() + 15);
	}

	

}
