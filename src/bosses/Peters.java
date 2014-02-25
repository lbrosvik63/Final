package bosses;

import weapons.Pen;
import armor.HeavyClothing;
import character.Boss;
import group.Action;
import group.ActionType;
import group.AttackWho;
/*
 * All Peter's attacks (except heal) land for 42 HP
 */
public class Peters extends Boss {

	private final int PRIMARYMAXVALUE = 42;
	private final int PRIMARYMINVALUE = 42;
	private final int SECONDARYMAXVALUE = 42;
	private final int SECONDARYMINVALUE = 42;
	
	public Peters() {
		stats.setMaxHealth(250);
		stats.setCurrentHealth(250);
		weapon = new Pen();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		System.out.println(this + " Throws Man's Code at you");
		
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 20);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + "Shows a Ridiculous Video");
		
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, 30);
	}

	@Override
	public void menuDisplay() {
		// TODO Auto-generated method stub

	}

	public String toString(){
		return "Peters";
	}
}
