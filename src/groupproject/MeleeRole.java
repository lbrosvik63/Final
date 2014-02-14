package groupproject;

public abstract class MeleeRole implements Role {

	@Override
	public Action roleAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0);
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack();

}
