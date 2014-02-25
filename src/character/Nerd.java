package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Nerd extends Healer {

	private final int BASE = 17;
	private final int VARIATION = 5;
	
	public Nerd() {
		stats.setMaxHealth(115);
		stats.setCurrentHealth(115);
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
		System.out.println("Nerd Attack Menu:");
		System.out.println("1. Nerd Bomb");
		System.out.println("2. Phaser Stun");
		System.out.println("3. Role Attack");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}
	
	public String toString(){
		return "Nerd";
	}

}
