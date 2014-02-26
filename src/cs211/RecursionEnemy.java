package cs211;

import weapons.Pen;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class RecursionEnemy extends CS211Enemy {

	private final int PRIMARYMAXVALUE = 20;
	private final int PRIMARYMINVALUE = 5;
	private final int SECONDARYMAXVALUE = 25;
	private final int SECONDARYMINVALUE = 8;
	
	public RecursionEnemy() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		stats.setAttackVariation(20);
		stats.setBaseAttack(5);
		stats.setWeaponSpeed(weapon.getAttackSpeed());
		stats.setMissChance(weapon.getMissPercent());
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(stats.getBaseAttack(), stats.getAttackVariation());
		System.out.println(this + " causes a StackOverflow");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value, stats.getMissChance());
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(stats.getBaseAttack() + 3, stats.getAttackVariation() + 3);
		System.out.println(this + " to Know About it, You Must First Know About Recursion");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, stats.getMissChance());
	}

	public String toString(){
		return "Recursion";
	}
}
