package groupproject;


public class Genius extends CasterRole {

	@Override
	public Action secondaryAttack() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, this.baseAttack + 20 , this.missChance + 10);
	}

	@Override
	public Action primaryAttack() {
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, this.baseAttack + 5, this.missChance);
	}
	@Override
	public Armor getArmor() {
		return new LightClothing();
	}
}
