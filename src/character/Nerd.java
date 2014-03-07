package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.*;

//medium attackspeed
//medium attack
//large variation

public class Nerd extends Healer {
	
	private final String priAtkName = "Nerd Bomb";
	private final String scdAtkName = "Set Phaser to Kill";
	private final String rolAtkName = "Adjust Glasses";
	
	public Nerd() {
		weapon = new Calculator();
		armor = new LightClothing();
		stats.setMaxHealth(115);
		stats.setCurrentHealth(115);
		stats.setAttackVariation(15);
		stats.setBaseAttack(20);
		stats.setSpeed(9);
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
		return "Nerd";
	}

}
