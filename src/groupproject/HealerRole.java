package groupproject;


public abstract class HealerRole implements Role {

	
	private int missChance = 0;
	private int baseAttack = 5;
	
	//Healer's attack value can be used to be added to the health of group members
	//
	@Override
	public Action roleAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0, 0);
	}

	@Override
	public abstract Action primaryAttack();
	

	@Override
	public abstract Action secondaryAttack();

}
