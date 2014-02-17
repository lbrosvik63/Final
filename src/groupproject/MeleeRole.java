package groupproject;


public abstract class MeleeRole implements Role {

	private int missChance = 5;
	private int baseAttack = 8;
	
	@Override
	public Action roleAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0, missChance);
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack();

}
