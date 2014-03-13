package bosses;

import character.Boss;

import weapons.Marker;
import weapons.Valgrind;
import group.Action;
import group.ActionType;
import group.AttackWho;

import armor.MediumClothing;
//Could make Steiner slow but high damage attacks
public class Steiner extends Boss {

	private final String priAtkName = "Deafining Roar";
	private final String scdAtkName = "Summon Minion";
	private final String rolAtkName = "Homework Barrage";
	
	private final int PRIMARYMAXVALUE = 100;
	private final int PRIMARYMINVALUE = 50;
	private final int SECONDARYMAXVALUE = 80;
	private final int SECONDARYMINVALUE = 30;
	
	public Steiner() {
		stats.setMaxHealth(650);
		stats.setCurrentHealth(650);
		stats.setSpeed(11);
		weapon = new Valgrind();
		armor = new MediumClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, 45);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		return new Action(ActionType.SUMMON, AttackWho.ALL, 340, 25);
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
		return "Steiner";
	}
}
