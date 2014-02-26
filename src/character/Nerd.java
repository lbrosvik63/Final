package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Nerd extends Healer {
	
	public Nerd() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(115);
		stats.setCurrentHealth(115);
		stats.setAttackVariation(17);
		stats.setBaseAttack(18);
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
		System.out.println("Nerd Attack Menu:");
		System.out.println("1. Nerd Bomb");
		System.out.println("2. Phaser Stun");
		System.out.println("3. Heal");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}
	
	public String toString(){
		return "Nerd";
	}

}
