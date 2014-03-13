package bosses;

import weapons.Pen;
import armor.LightClothing;
import character.Boss;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class Strongarm extends Boss {

	private final String priAtkName = "Confusion";
	private final String scdAtkName = "Irrelevant Story";
	private final String rolAtkName = "Gives Answer";
	
	private final int PRIMARYMAXVALUE = 5;
	private final int PRIMARYMINVALUE = 1;
	private final int SECONDARYMAXVALUE = 10;
	private final int SECONDARYMINVALUE = 5;
	
	public Strongarm() {
		stats.setMaxHealth(5);
		stats.setCurrentHealth(5);
		stats.setSpeed(8);
		weapon = new Pen();
		armor = new LightClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 50);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		return new Action(ActionType.HEAL, AttackWho.ONE, value, 50);
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
		return "Strongarm";
	}
}
