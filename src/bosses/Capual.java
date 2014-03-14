package bosses;

import character.Boss;

import weapons.GofBible;
import group.Action;
import group.ActionType;
import group.AttackWho;

import armor.MediumClothing;
/*
 * Capual doesnt have strong attacks but 2 of his attacks heal so he is hard to kill
 */
public class Capual extends Boss {

	private final String priAtkName = "Quick & Dirty Attack";
	private final String scdAtkName = "Has You Slap Yourself";
	private final String rolAtkName = "Drinks Pints";
	
	private final int PRIMARYMAXVALUE = 70;
	private final int PRIMARYMINVALUE = 50;
	private final int SECONDARYMAXVALUE = 30;
	private final int SECONDARYMINVALUE = 40;
	
	public Capual() {
		stats.setMaxHealth(750);
		stats.setCurrentHealth(750);
		stats.setSpeed(7);
		weapon = new GofBible();
		armor = new MediumClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		System.out.println(this + " Quick & Dirty Attack");
		
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value, 5);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + " Throws Back a Couple of Pints");
		
		return new Action(ActionType.HEAL, AttackWho.ONE, value, 45);
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
		return "Capaul";
	}

}
