package cs490;

import weapons.Pen;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class SeniorItisEnemy extends CS490Enemy {
	
	private final String priAtkName = "Steal Motivation";
	private final String scdAtkName = "Stir Crazy";
	private final String rolAtkName = "Job Interview";
	
	public SeniorItisEnemy() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		stats.setAttackVariation(20);
		stats.setBaseAttack(5);
		stats.setSpeed(3);
		stats.setMissChance(weapon.getMissPercent());
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance());
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(stats.getBaseAttack() + 3, stats.getAttackVariation() + 2);
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value, stats.getMissChance() + 15);
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
		return "Senioritis";
	}

}
