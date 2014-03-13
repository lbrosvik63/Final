package bosses;

import java.util.Scanner;

import character.Boss;

import weapons.Marker;
import weapons.Pen;

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
	private final String scdAtkName = "Grader Minions";
	private final String rolAtkName = "NEEDED";
	
	private final int PRIMARYMAXVALUE = 120;
	private final int PRIMARYMINVALUE = 90;
	private final int SECONDARYMAXVALUE = 4;//number of enemies he will summon
	private final int SECONDARYMINVALUE = 1;
	
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
		System.out.println(this + " 140dB Super Roar");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, 50);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + " Summons Graders to do his bidding");
		// TODO Auto-generated method stub
		return new Action(ActionType.SUMMON, AttackWho.ONE, value, 20);
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
