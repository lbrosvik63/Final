package groupproject;


public interface Role {
	public Action primaryAttack();
	public Action secondaryAttack();
	public Action roleAttack();
	public Armor getArmor();

}
