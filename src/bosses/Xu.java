package bosses;

import weapons.Pen;
import armor.HeavyClothing;
import character.Boss;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class Xu extends Boss {

	private final int PRIMARYMAXVALUE = 75;
	private final int PRIMARYMINVALUE = 45;
	private final int SECONDARYMAXVALUE = 60;
	private final int SECONDARYMINVALUE = 15;
	
	public Xu() {
		stats.setMaxHealth(550);
		stats.setCurrentHealth(550);
		stats.setSpeed(7);
		weapon = new Pen();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		System.out.println(this + " Dumbfounds with Time Complexity Question");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 25);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + " Pointer Stick Slap");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 15);
	}



	public String toString(){
		return "Xu";
	}
}
