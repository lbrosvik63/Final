package groupproject;

public class Cheater extends MeleeRole {

	@Override
	public Action primaryAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0);
	}

	@Override
	public Action secondaryAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0);
	}

}
