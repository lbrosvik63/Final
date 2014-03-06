package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;
import weapons.Stapler;

public class Slacker extends Caster {

	private final String priAtkName = "Procrastinate";
	private final String scdAtkName = "Hack Attack";
	private final String rolAtkName = "Take Nap";
	
	
	public Slacker() {
		weapon = new Stapler();
		armor = new LightClothing();
		stats.setMaxHealth(125);
		stats.setCurrentHealth(125);
		stats.setAttackVariation(15);
		stats.setBaseAttack(15);
		stats.setSpeed(8);
		stats.setMissChance(weapon.getMissPercent());
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance());
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue2(stats.getBaseAttack(), stats.getAttackVariation());
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value + 5, stats.getMissChance());
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
	
	
}
