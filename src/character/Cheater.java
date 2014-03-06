package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import weapons.Pen;
import armor.LightClothing;



public class Cheater extends Melee {
	
	private final String priAtkName = "Google Answer";
	private final String scdAtkName = "Malware Attack";
	private final String rolAtkName = "Copy Someone";
	
	public Cheater() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(135);
		stats.setCurrentHealth(135);
		stats.setAttackVariation(8);
		stats.setBaseAttack(17);
		stats.setSpeed(3);
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
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance());
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
	
	
	@Override
	public String toString(){
		return "Cheater";
	}

}
