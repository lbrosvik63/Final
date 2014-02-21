package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Slacker extends Caster {

	public Slacker() {
		stats.setMaxHealth(65);
		stats.setCurrentHealth(65);
		weapon = new Pen();
		armor = new LightClothing();
	}

	@Override
	public Action primaryAttack() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 3, 0);
	}

	@Override
	public Action secondaryAttack() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 3, 0);
	}


	@Override
	public void menuDisplay() {
		System.out.println("Slacker Attack Menu:");
		System.out.println("1. Slack Attack");
		System.out.println("2. Feign Effort");
		System.out.println("3. Role Attack");
		System.out.println("Choose your Attack");
		
	}

}
