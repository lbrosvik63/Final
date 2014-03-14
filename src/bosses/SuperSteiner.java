package bosses;

import character.Boss;

import weapons.Marker;
import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.HeavyClothing;

/*
 * Super Steiner is slow but extremely powerful
 * Secondary Attack will summon between 1 - 4 Minions (Graders)
 */
public class SuperSteiner extends Boss {

	private final String priAtkName = "140dB Super Roar";
	private final String scdAtkName = "Summon Minion";
	private final String rolAtkName = "Diploma in Your Face";
	
	private final int PRIMARYMAXVALUE = 120;
	private final int PRIMARYMINVALUE = 90;
	
	public SuperSteiner() {
		stats.setMaxHealth(1000);
		stats.setCurrentHealth(1000);
		stats.setSpeed(14);
		weapon = new Marker();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, 50);
	}

	@Override
	public Action secondaryAttack() {
		return new Action(ActionType.SUMMON, AttackWho.ONE, 340, 20);
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
		return "Super Steiner";
	}

}
