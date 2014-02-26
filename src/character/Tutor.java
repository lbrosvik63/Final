package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Tutor extends Healer {

	
	public Tutor() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(110);
		stats.setCurrentHealth(110);
		stats.setAttackVariation(6);
		stats.setBaseAttack(20);
		stats.setWeaponSpeed(weapon.getAttackSpeed());
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
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance());
	}
	
	@Override
	public void menuDisplay() {
		System.out.println("Tutor Attack Menu:");
		System.out.println("1. Summon PLUS Group");
		System.out.println("2. Shin Kick");
		System.out.println("3. Heal");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}

}
