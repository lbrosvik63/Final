package groupproject;

public class Genius extends CasterRole {

	@Override
	public Action secondaryAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0);
	}

	@Override
	public Action primaryAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0);
	}

}
