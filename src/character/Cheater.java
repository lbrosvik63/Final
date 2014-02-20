package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import weapons.Pen;
import armor.LightClothing;



public class Cheater extends Melee {

	public Cheater() {
		stats.setMaxHealth(80);
		stats.setCurrentHealth(80);
		weapon = new Pen();
		armor = new LightClothing();
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
		System.out.println("Cheater Attack Menu:");
		System.out.println("1. Hack Network");
		System.out.println("2. Google Answer");
		System.out.println("3. Role Attack");
		System.out.println("Choose your Attack");
		
	}

}
