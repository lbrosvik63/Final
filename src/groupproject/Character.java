/**
 * 
 */
package groupproject;

import java.util.Random;
import java.util.Scanner;


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
		this.healthPoints = 100;
		this.speed = 1;
		this.armor = this.role.getArmor();
		this.failChance = weapon.getMissPercent();
	}
	
	public Action primaryAttack() {
		return role.primaryAttack();
	}

	public int getFailChance() {
		return failChance;
	}

	public void setFailChance(int failChance) {
		this.failChance = failChance;
	}

	public Action secondaryAttack() {
		return role.secondaryAttack();
	}

	public Action roleAttack() {
		return role.roleAttack();
	}

	//TODO; NEEDS TO BE TESTED
	//TODO: ADD TO STRINGS TO ATTACKS AND CHARACTERS SO MENU CAN BE SPECIFIC TO EACH CHARACTER
	public Action actionMenu(Scanner sysIn){
		System.out.println("Character Attack Menu:");
		System.out.println("\t1. Primary Attack");
		System.out.println("\t2. Secondary Attack");
		System.out.println("\t3. Role Attack");
		System.out.println("Choose your Attack");
		int choice = sysIn.nextInt();
		if(choice == 1)
			return primaryAttack();
		if(choice == 2)
			return secondaryAttack();
		if(choice == 3)
			return roleAttack();
		else
			return actionMenu(sysIn);
	}
	
	
	/*
	 * First checks if HEAL or DAMAGE 
	 * HEAL:
	 * 		Checks if heal fails due to Action.failChancePercent
	 * DAMAGE:
	 * 		Checks if attack fails due to Action.failChancePercent
	 * 		Then checks if attack fails due to armor.getDodgeChance
	 * 		Removes armor's value from attack value
	 * 		Displays if attack results in character's death or their remaining HP
	 * 
	 */
	public void recieveAction(Action action)
	{
		int attackValue = action.getActionValue();
		Random rand = new Random();
		int num = rand.nextInt(101);
		switch(action.getHealOrHurt()){
		case HEAL:
			//Check if Heal fails based on failChancePercent
			if(num <= action.getFailChancePercent())
				System.out.println("Heal Failed");
			else{
				healthPoints += attackValue;
				System.out.println("InsertCharacterNameHere healed for " + attackValue + " HP");
				System.out.println("InsertCharacterNameHere now has " + healthPoints + " HP");
			}
				
		case DAMAGE:
			num = rand.nextInt(101);
			//Check if Attack fails based on failChancePercent
			if(num <= action.getFailChancePercent()){
				System.out.println("Attack Missed");
			}
			else{
				num = rand.nextInt(101);
				if(num <= armor.getDodgeChance()){
					System.out.println("InsertCharacterNameHere dodged the attack");
				}
				else{
					attackValue -= armor.getArmorValue();
					healthPoints -= attackValue;
					System.out.println("Attack lands -" + attackValue + " HP");
					if(healthPoints < 1){
						healthPoints = 0;
						System.out.println("InsertCharacterNameHere has been Expelled"); // Character was killed
					}
					else
						System.out.println("InsertCharacterNameHere now has " + healthPoints + " HP");
				}
			}
		}//end switch
		
			
	}//end recieveAttack
	
	
	
	public int getHealthPoints(){
		return this.healthPoints;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public String toString(){
		String temp = "";
		temp += role + ":\n";
		temp += "Health: " + healthPoints + "\n";
		temp += "Speed: " + speed + "\n";
		temp += "Weapon: " + weapon + "\n";
		temp += "Armor: " + armor + "\n";
		
		return temp;
	}
	
}
