package cs490;

import java.util.Random;
import java.util.Scanner;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;
/*
 * All CS490 enemies can heal
 */
public abstract class CS490Enemy extends Character {

	private final int ROLEMAXVALUE = 30;//value of heal
	private final int ROLEMINVALUE = 15;
	
	public CS490Enemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack() ;

	@Override
	public abstract Action secondaryAttack();
	
	@Override
	public Action roleAttack() {
		System.out.println(this + " causes group argument");
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.HEAL, AttackWho.TWO, value, stats.getMissChance() + 15);
	}


}
