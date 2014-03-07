package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.*;

//medium attackspeed
//medium attack
//small variation

public class Tutor extends Healer {

	private final String priAtkName = "Summon PLUS";
	private final String scdAtkName = "Shin Kick";
	private final String rolAtkName = "Impart Knowledge";
	
	public Tutor() {
		weapon = new Calculator();
		armor = new LightClothing();
		stats.setMaxHealth(110);
		stats.setCurrentHealth(110);
		stats.setAttackVariation(5);
		stats.setBaseAttack(25);
		stats.setSpeed(10);
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
	
	public String toString(){
		return "Tutor";
	}

}
