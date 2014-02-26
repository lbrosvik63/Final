package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.MediumClothing;
import weapons.Pen;

public class Jock extends Melee {
	
	public Jock() {
		weapon = new Pen();
		armor = new MediumClothing();
		stats.setMaxHealth(150);
		stats.setCurrentHealth(150);
		stats.setAttackVariation(3);
		stats.setBaseAttack(22);
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
		System.out.println("Jock Attack Menu:");
		System.out.println("1. Body Slam");
		System.out.println("2. Keyboard Smash");
		System.out.println("3. Role Attack");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}
	public String toString(){
		return "Jock";
	}

}
