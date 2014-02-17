/**
 * 
 */
package groupproject;


/**
 * Speed value based on scale 1 to 10 (1 is fastest)
 *
 */
public class Character {

	protected Role role;
	protected Weapon weapon;
	protected Armor armor;
	protected int healthPoints;
	protected int speed;
	private int failChance;
	
	private RoleFactory roleFactory = new RoleFactory();
	
	public Character(String role){
		this.role = roleFactory.createRole(role);
		this.weapon = new Pen();//TODO: probably change
		this.armor = this.role.getArmor();
		this.failChance = weapon.getMissPercent();
	}
	
	public Action primaryAttack() {
		return role.primaryAttack();
	}

	public Action secondaryAttack() {
		return role.secondaryAttack();
	}

	public Action roleAttack() {
		return role.roleAttack();
	}

	
	public Reaction recieveAction(Action action)
	{
		HitOrMiss hitOrMiss = HitOrMiss.HIT;
		return new Reaction(hitOrMiss, 0);
	}
	
}
