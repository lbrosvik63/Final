package bosses;

import weapons.Pen;
import armor.HeavyClothing;

import character.Boss;

import group.Action;
import group.ActionType;
import group.AttackWho;

public class Tappan extends Boss {

	private final int PRIMARYMAXVALUE = 110;
	private final int PRIMARYMINVALUE = 75;
	private final int SECONDARYMAXVALUE = 85;
	private final int SECONDARYMINVALUE = 35;
	
	public Tappan() {
		stats.setMaxHealth(850);
		stats.setCurrentHealth(850);
		stats.setSpeed(8);
		weapon = new Pen();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		System.out.println(this + " Finds Instanceof: Tells you to shoot yourself now");
		
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 5);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + " Summons Pumpkin Suit: Describe Attack Here");
		
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 5);
	}


	
	public String toString(){
		return "Tappan";
	}

}
