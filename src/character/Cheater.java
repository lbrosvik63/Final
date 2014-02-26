package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import weapons.Pen;
import armor.LightClothing;



public class Cheater extends Melee {
	
	public Cheater() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(135);
		stats.setCurrentHealth(80);
		stats.setAttackVariation(8);
		stats.setBaseAttack(17);
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
		System.out.println("Cheater Attack Menu:");
		System.out.println("1. Hack Network");
		System.out.println("2. Google Answer");
		System.out.println("3. Role Attack");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}
	
	
	@Override
	public String toString(){
		return "Cheater";
	}

}
