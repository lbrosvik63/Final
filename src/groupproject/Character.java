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

	private Role role;
	private Weapon weapon;
	private Armor armor;
	private Stats stats;
	
	private RoleFactory roleFactory = new RoleFactory();
	
	public Character(String role){
		this.role = roleFactory.createRole(role);
		this.weapon = new Pen();//TODO: probably change
		this.armor = this.role.getArmor();
	}
	
	public Action primaryAttack() {
		return role.primaryAttack();
	}

	public int getFailChance() {
		return weapon.getMissPercent();
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
//			if(num <= action.getFailChancePercent())
//				System.out.println("Heal Failed");
//			else{
			
			//heals never miss, DA!!! dont you ever play RPG's???: Luke
			
			//healthPoints += attackValue;
			updateHealth(action);
			System.out.println("InsertCharacterNameHere healed for " + attackValue + " HP");
			System.out.println("InsertCharacterNameHere now has " + getHealthPoints() + " HP");
				
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
					//attackValue -= armor.getArmorValue();
					//healthPoints -= attackValue;
					updateHealth(action);
					System.out.println("Attack lands -" + attackValue + " HP");
					if(getHealthPoints() < 1){
						System.out.println("InsertCharacterNameHere has been Expelled"); // Character was killed
					}
					else
						System.out.println("InsertCharacterNameHere now has " + getHealthPoints() + " HP");
				}
			}
		}//end switch
		
			
	}//end recieveAttack
	
	public void updateHealth(Action action){
		if(action.getHealOrHurt() == ActionType.HEAL)
			stats.updateCurrentHealth(action.getActionValue());
		else if(action.getHealOrHurt() == ActionType.DAMAGE){
			int actionValue = action.getActionValue();
			
			actionValue += (actionValue * (armor.getArmorValue() / 100.0)); //hopefully doesnt cause trunkation errors
			stats.updateCurrentHealth(actionValue * -1);
		}
	}
	
	public int getHealthPoints(){
		return stats.getCurrentHealth();
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public int getSpeed() {
		return weapon.getAttackSpeed();
	}
	
	public String toString(){
		String temp = "";
		temp += role + ":\n";
		temp += "Health: " + stats.getCurrentHealth() + "\n";
		temp += "Speed: " + weapon.getAttackSpeed() + "\n";
		temp += "Weapon: " + weapon + "\n";
		temp += "Armor: " + armor + "\n";
		
		return temp;
	}
	
}
