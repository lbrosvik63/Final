package character;

import group.Action;

public abstract class HardEnemy extends Character {

	public HardEnemy() {
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