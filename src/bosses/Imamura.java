package bosses;

import weapons.Pen;
import armor.HeavyClothing;
import character.Boss;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class Imamura extends Boss {

	public Imamura() {
		stats.setMaxHealth(300);
		stats.setCurrentHealth(300);
		weapon = new Pen();
		armor = new HeavyClothing();
	}

	@Override
	public Action primaryAttack() {
		System.out.println("Kendo Strike: Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10, 5);
	}

	@Override
	public Action secondaryAttack() {
		System.out.println("Standard Deviation of Human Anatomy: Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10, 5);
	}

	@Override
	public void menuDisplay() {
		// TODO Auto-generated method stub

	}

}
