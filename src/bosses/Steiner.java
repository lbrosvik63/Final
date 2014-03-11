package bosses;

import character.Boss;

import weapons.Pen;

import group.Action;
import group.ActionType;
import group.AttackWho;

import armor.MediumClothing;
//Could make Steiner slow but high damage attacks
public class Steiner extends Boss {

	private final String priAtkName = "Deafining Roar";
	private final String scdAtkName = "Homework Barrage";
	private final String rolAtkName = "NEEDED";
	
	private final int PRIMARYMAXVALUE = 100;
	private final int PRIMARYMINVALUE = 50;
	private final int SECONDARYMAXVALUE = 80;
	private final int SECONDARYMINVALUE = 30;
	
	public Steiner() {
		stats.setMaxHealth(650);
		stats.setCurrentHealth(650);
		stats.setSpeed(11);
		weapon = new Pen();
		armor = new MediumClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		System.out.println(this + " Buries You with Homework");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, 45);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + " Deafining Roar");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, 25);
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
