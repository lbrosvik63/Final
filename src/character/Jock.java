package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.MediumClothing;
import weapons.Pen;

public class Jock extends Melee {

	private final int BASE = 17;
	private final int VARIATION = 5;
	
	public Jock() {
		stats.setMaxHealth(150);
		stats.setCurrentHealth(150);
		weapon = new Pen();
		armor = new MediumClothing();
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
