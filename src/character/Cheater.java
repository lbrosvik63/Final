package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import weapons.Pen;
import armor.LightClothing;



public class Cheater extends Melee {

	private final int BASE = 17;
	private final int VARIATION = 5;
	
	public Cheater() {
		stats.setMaxHealth(135);
		stats.setCurrentHealth(80);
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
		System.out.println("Cheater Attack Menu:");
		System.out.println("1. Hack Network");
		System.out.println("2. Google Answer");
		System.out.println("3. Role Attack");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}

}
