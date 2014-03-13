package bosses;

import weapons.Pen;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;
import cs211.CS211Enemy;

public class JackintheBox extends CS211Enemy {

	private final String priAtkName = "$ Menu";
	private final String scdAtkName = "Soda to Face";
	private final String rolAtkName = "Deep Fried Fist";
	
	
	public JackintheBox(){
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(15);
		stats.setCurrentHealth(15);
		stats.setAttackVariation(5);
		stats.setBaseAttack(5);
		stats.setSpeed(10);
		stats.setMissChance(weapon.getMissPercent());
	}
	
	
	@Override
	public Action primaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance());
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack() , stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value, stats.getMissChance() + 20);
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
		return "JackintheBox";
	}

}
