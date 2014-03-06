package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Genius extends Caster {
	
	private final String priAtkName = "Mensa Attack";
	private final String scdAtkName = "Drop Knowledge";
	private final String rolAtkName = "Telapathic Assault";
	
	public Genius() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(125);
		stats.setCurrentHealth(125);
		stats.setAttackVariation(5);
		stats.setBaseAttack(20);
		stats.setSpeed(4);
		stats.setMissChance(weapon.getMissPercent());
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance());
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value * 2, stats.getMissChance() + 35);
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
		return "Genius";
	}

}
