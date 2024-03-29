package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.MediumClothing;
import weapons.*;

//fast attackspeed
//small attack
//medium variation

public class Jock extends Melee {
	
	private final String priAtkName = "Body Slam";
	private final String scdAtkName = "Keyboard Smash";
	private final String rolAtkName = "Roid Rage";
	
	public Jock() {
		weapon = new Stapler();
		armor = new MediumClothing();
		stats.setMaxHealth(150);
		stats.setCurrentHealth(150);
		stats.setAttackVariation(7);
		stats.setBaseAttack(18);
		stats.setSpeed(8);
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
		return "Jock";
	}

}
