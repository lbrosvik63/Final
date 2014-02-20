package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.MediumClothing;
import weapons.Pen;

public class Jock extends Melee {

	public Jock() {
		stats.setMaxHealth(115);
		stats.setCurrentHealth(115);
		weapon = new Pen();
		armor = new MediumClothing();
	}

	@Override
	public Action primaryAttack() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0, 0);
	}

	@Override
	public Action secondaryAttack() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0, 0);
	}


	@Override
	public void menuDisplay() {
		System.out.println("Jock Attack Menu:");
		System.out.println("1. Body Slam");
		System.out.println("2. Keyboard Smash");
		System.out.println("3. Role Attack");
		System.out.println("Choose your Attack");
		
	}

}
