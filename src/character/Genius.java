package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Genius extends Caster {
	
	public Genius() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(125);
		stats.setCurrentHealth(125);
		stats.setAttackVariation(5);
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
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value * 2, stats.getMissChance() + 35);
	}


	@Override
	public void menuDisplay() {
		System.out.println("Genius Attack Menu:");
		System.out.println("1. Mensa Attack");
		System.out.println("2. Blow Minds with Knowledge");
		System.out.println("3. Role Attack");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}
	
	public String toString(){
		return "Genius";
	}

}
