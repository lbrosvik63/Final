package groupproject;

import java.util.Random;

public class Jock extends MeleeRole {

	@Override
	public Action primaryAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(31);
		attackValue += 30; //assures lowest value is 30
		System.out.println("We can describe the Warrior Attack here.");
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0, 0);
	}

	@Override
	public Action secondaryAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0, 0);
	}
	@Override
	public Armor getArmor() {
		return new LightClothing();
	}

}
