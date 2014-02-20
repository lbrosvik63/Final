package character;

import group.Action;

public abstract class Boss extends Character {

	public Boss() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack() ;

	@Override
	public Action roleAttack() {
		// TODO Auto-generated method stub
		return null;
	}

}
