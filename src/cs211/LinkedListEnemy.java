package cs211;

import weapons.Calculator;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class LinkedListEnemy extends CS211Enemy {
	
	private final String priAtkName = "Null Pointer";
	private final String scdAtkName = "NEEDED";
	private final String rolAtkName = "Unreachable Node";
	
	
	public LinkedListEnemy() {
		weapon = new Calculator();
		armor = new LightClothing();
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		stats.setAttackVariation(10);
		stats.setBaseAttack(15);
		stats.setSpeed(10);
		stats.setMissChance(weapon.getMissPercent());
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		System.out.println(this + " Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance() + 15);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation() + 5);
		System.out.println(this + "Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, stats.getMissChance() +10);
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
		return "Linked List";
	}
}
