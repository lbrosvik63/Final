package cs211;

import weapons.Pen;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class RecursionEnemy extends CS211Enemy {

	private final String priAtkName = "Endless Loop";
	private final String scdAtkName = "Stack Overflow";
	private final String rolAtkName = "NEEDED";
	
	public RecursionEnemy() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		stats.setAttackVariation(10);
		stats.setBaseAttack(15);
		stats.setSpeed(9);
		stats.setMissChance(weapon.getMissPercent());
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		System.out.println(this + " causes a StackOverflow");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value, stats.getMissChance());
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack() + 3, stats.getAttackVariation() + 3);
		System.out.println(this + " to Know About it, You Must First Know About Recursion");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, stats.getMissChance());
	}

	@Override
	public String getPriAtkName() {
		return priAtkName;
	}
	
	@Override
	public String getScdAtkName() {
		return scdAtkName;
	}
	
	@Override
	public String getRolAtkName() {
		return rolAtkName;
	}
	
	public String toString(){
		return "Recursion";
	}
}
