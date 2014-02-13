/**
 * 
 */
package groupproject;

/**
 * Speed value based on scale 1 to 10 (1 is fastest)
 *
 */
public abstract class Character {

	protected Role role;
	protected Weapon weapon;
	protected Armor armor;
	protected int healthPoints;
	protected int speed;

	/* primaryAttack is specific to each individual character subclass
	 *  and must be implemented in every subclass
	 */
	public abstract int primaryAttack();
	
	
	/* secondaryAttack is based on the character's Role
	 * 
	 */
	public int secondaryAttack(){
		return role.roleAttack();
	}
	
	
	/* weaponAttack is based on the weapon the character currently possesses
	 * 
	 */
	public int weaponAttack(){
		return weapon.weaponAttack();
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
