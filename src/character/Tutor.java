package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Tutor extends Healer {

	private final int BASE = 17;
	private final int VARIATION = 5;
	
	public Tutor() {
		stats.setMaxHealth(110);
		stats.setCurrentHealth(110);
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
		System.out.println("Tutor Attack Menu:");
		System.out.println("1. Summon PLUS Group");
		System.out.println("2. Shin Kick");
		System.out.println("3. Role Attack");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}

}
