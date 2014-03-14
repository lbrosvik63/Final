package bosses;

import weapons.DijkstrasAlgorithm;
import armor.HeavyClothing;
import character.Boss;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class Xu extends Boss {

	private final String priAtkName = "Intimidating Stare";
	private final String scdAtkName = "Pointer Stick Slap";
	private final String rolAtkName = "Challenging Q";
	
	private final int PRIMARYMAXVALUE = 75;
	private final int PRIMARYMINVALUE = 45;
	private final int SECONDARYMAXVALUE = 60;
	private final int SECONDARYMINVALUE = 15;
	
	public Xu() {
		stats.setMaxHealth(550);
		stats.setCurrentHealth(550);
		stats.setSpeed(7);
		weapon = new DijkstrasAlgorithm();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 25);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 15);
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
		return "Xu";
	}
}
