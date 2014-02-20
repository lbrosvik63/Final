package character;

import group.Action;

public abstract class EasyEnemy extends Character {

	public EasyEnemy() {
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
