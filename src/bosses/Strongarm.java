package bosses;

import weapons.Pen;
import armor.LightClothing;
import character.Boss;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class Strongarm extends Boss {

	private final int PRIMARYMAXVALUE = 5;
	private final int PRIMARYMINVALUE = 1;
	private final int SECONDARYMAXVALUE = 10;
	private final int SECONDARYMINVALUE = 5;
	
	public Strongarm() {
		stats.setMaxHealth(5);
		stats.setCurrentHealth(5);
		weapon = new Pen();
		armor = new LightClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		System.out.println(this + " Gives You the Answer");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 50);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + " Tells Irrelevant Story");
		// TODO Auto-generated method stub
		return new Action(ActionType.HEAL, AttackWho.ONE, value, 50);
	}

	@Override
	public void menuDisplay() {
		// TODO Auto-generated method stub

	}

	public String toString(){
		return "Strongarm";
	}
}
