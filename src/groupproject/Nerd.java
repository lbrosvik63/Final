package groupproject;


public class Nerd extends HealerRole {

	
	@Override
	public Action primaryAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0, 0);
	}

	@Override
	public Action secondaryAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 0, 0);
	}

	@Override
	public Armor getArmor() {
		return new LightClothing();
	}

}
