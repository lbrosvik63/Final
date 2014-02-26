package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Slacker extends Caster {

	
	public Slacker() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(125);
		stats.setCurrentHealth(125);
		stats.setAttackVariation(15);
		stats.setBaseAttack(15);
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
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value + 5, stats.getMissChance());
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
