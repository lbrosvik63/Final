package bosses;

import weapons.JavaApi;
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

	private final String priAtkName = "Man's Code";
	private final String scdAtkName = "Summon Jack";
	private final String rolAtkName = "Ridiculous Video";
	
	private final int PRIMARYMAXVALUE = 42;
	private final int PRIMARYMINVALUE = 42;
	private final int SECONDARYMAXVALUE = 42;
	private final int SECONDARYMINVALUE = 42;
	
	public Peters() {
		stats.setMaxHealth(250);
		stats.setCurrentHealth(250);
		stats.setSpeed(6);
		weapon = new JavaApi();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 20);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		return new Action(ActionType.SUMMON, AttackWho.ALL, 211, 30);
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
		return "Peters";
	}
}
