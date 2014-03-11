package bosses;

import weapons.Pen;
import armor.HeavyClothing;
import character.Boss;
import group.Action;
import group.ActionType;
import group.AttackWho;
//Could Make Imamura Quicker with smaller damage
public class Imamura extends Boss {

	private final String priAtkName = "Kendo Strike";
	private final String scdAtkName = "Standard Deviation";
	private final String rolAtkName = "NEEDED";
	
	private final int PRIMARYMAXVALUE = 25;
	private final int PRIMARYMINVALUE = 20;
	private final int SECONDARYMAXVALUE = 30;
	private final int SECONDARYMINVALUE = 15;
	
	public Imamura() {
		stats.setMaxHealth(350);
		stats.setCurrentHealth(350);
		stats.setSpeed(6);
		weapon = new Pen();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(PRIMARYMINVALUE, PRIMARYMAXVALUE);
		System.out.println(this + " Kendo Strike: Describe Attack Here");
	
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, 10);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(SECONDARYMINVALUE, SECONDARYMAXVALUE);
		System.out.println(this + " Describes the Standard Deviation of Human Anatomy");
		
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value, 15);
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
		return "Imamura";
	}

}
