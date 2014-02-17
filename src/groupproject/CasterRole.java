package groupproject;


public abstract class CasterRole implements Role {

	protected int missChance = 10;
	protected int baseAttack = 10;
	
	//Healer's attack value can be used to be added to the health of group members
	//
	@Override
	public Action roleAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, this.baseAttack, this.missChance);
	}

	@Override
	public abstract Action primaryAttack();
	

	@Override
	public abstract Action secondaryAttack();

}
