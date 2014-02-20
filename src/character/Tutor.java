package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Tutor extends Healer {

	public Tutor() {
		stats.setMaxHealth(90);
		stats.setCurrentHealth(90);
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
		System.out.println("Tutor Attack Menu:");
		System.out.println("1. Summon PLUS Group");
		System.out.println("2. Shin Kick");
		System.out.println("3. Role Attack");
		System.out.println("Choose your Attack");
		
	}

}
