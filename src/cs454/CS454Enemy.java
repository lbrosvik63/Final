package cs454;

import java.util.Random;
import java.util.Scanner;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;
/*
 * All CS454 enemies have an AntiPattern Attack
 */
public abstract class CS454Enemy extends Character {

	private final int ROLEMAXVALUE = 40;
	private final int ROLEMINVALUE = 25;
	
	public CS454Enemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack();

	@Override
	public Action roleAttack() {
		System.out.println(this + " AntiPattern Attack");
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, stats.getMissChance() + 10);
	}



}
