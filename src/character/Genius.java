package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;





public class Genius extends Caster {

	public Genius() {
		stats.setMaxHealth(75);
		stats.setCurrentHealth(75);
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
		System.out.println("Genius Attack Menu:");
		System.out.println("1. Mensa Attack\n");
		System.out.println("2. Blow Minds with Knowledge");
		System.out.println("3. Role Attack");
		System.out.println("Choose your Attack");
		
	}

}
