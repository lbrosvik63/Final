package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Slacker extends Caster {

	private final int BASE = 17;
	private final int VARIATION = 5;
	
	public Slacker() {
		stats.setMaxHealth(125);
		stats.setCurrentHealth(125);
		weapon = new Pen();
		armor = new LightClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue2(BASE, VARIATION);
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, weapon.getMissPercent());
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue2(BASE, VARIATION);
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, weapon.getMissPercent());
	}


	@Override
	public void menuDisplay() {
		System.out.println("Slacker Attack Menu:");
		System.out.println("1. Slack Attack");
		System.out.println("2. Feign Effort");
		System.out.println("3. Role Attack");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}

}
