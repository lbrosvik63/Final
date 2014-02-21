package cs300;

import group.Action;
import group.ActionType;
import group.AttackWho;
import character.Character;

public abstract class CS300Enemy extends Character {

	public CS300Enemy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Action primaryAttack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action secondaryAttack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action roleAttack() {
		System.out.println("Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10, 5);
	}

	@Override
	public void menuDisplay() {
		// TODO Auto-generated method stub

	}

}
