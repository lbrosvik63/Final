/**
 * 
 */
package groupproject;

/**
 * Speed value based on scale 1 to 10 (1 is fastest)
 *
 */
public class Character implements Role{

	protected Role role;
	protected Weapon weapon;
	protected Armor armor;
	protected int healthPoints;
	protected int speed;
	private RoleFactory roleFactory = new RoleFactory();
	
	public Character(String role){
		this.role = roleFactory.createRole(role);
		//this.weapon =
		//this.armor =
	}
	
	@Override
	public Action primaryAttack() {
		return role.primaryAttack();
	}

	@Override
	public Action secondaryAttack() {
		return role.secondaryAttack();
	}

	@Override
	public Action roleAttack() {
		return role.roleAttack();
	}
	/* recieveAttack takes the incoming attack from an opponent and 
	 * decreases its value based on the character's armor.
	 * The resulting hit value is subtracted from the character's health
	 */
	public void recieveAttack(int attackValue){
		int alteredValue = armor.deflectAttack(attackValue);
		healthPoints -= alteredValue;
	}




	
	
}
