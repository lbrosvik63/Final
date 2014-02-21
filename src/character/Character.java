/**
 * 
 */
package character;

import java.util.Random;
import java.util.Scanner;

import weapons.Weapon;

import armor.Armor;

import group.Action;
import group.ActionType;


/**
 * Speed value based on scale 1 to 10 (1 is fastest)
 *
 */
public abstract class Character {

	protected Weapon weapon;
	protected Armor armor;
	protected Stats stats;
	
	public Character(){
		stats = new Stats();
	}
	
	
	
	public abstract Action primaryAttack();

	public int getFailChance() {
		return weapon.getMissPercent();
	}

	public abstract Action secondaryAttack();

	public abstract Action roleAttack();

	//TODO; NEEDS TO BE TESTED
	//TODO: ADD TO STRINGS TO ATTACKS AND CHARACTERS SO MENU CAN BE SPECIFIC TO EACH CHARACTER
	public Action actionMenu(Scanner sysIn){
		menuDisplay();
		return menuSelection(sysIn);
	}
	
	public abstract void menuDisplay();
	
	public Action menuSelection(Scanner sysIn){
		int choice = sysIn.nextInt();
		if(choice == 1)
			return primaryAttack();
		if(choice == 2)
			return secondaryAttack();
		if(choice == 3)
			return roleAttack();
		else//TODO HANDLE ERROR CHECKING
			return actionMenu(sysIn);//Recursive Call if dont select number from menu
	}
	
	/*
	 * First checks if HEAL or DAMAGE 
	 * HEAL:
	 * 		Applies to Character
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
			updateHealth(action);
			System.out.println(this +" healed for " + attackValue + " HP");
			System.out.println(this + " now has " + getHealthPoints() + " HP");
				
		case DAMAGE:
			num = rand.nextInt(101);
			//Check if Attack fails based on failChancePercent
			if(num <= action.getFailChancePercent()){
				System.out.println("Attack Missed");
			}
			else{
				num = rand.nextInt(101);
				if(num <= armor.getDodgeChance()){
					System.out.println(this + " dodged the attack");
				}
				else{
					//attackValue -= armor.getArmorValue();
					//healthPoints -= attackValue;
					updateHealth(action);
					System.out.println(this + " hit by attack:  -" + attackValue + " HP");
					if(getHealthPoints() < 1){
						System.out.println(this + " has been Expelled"); // Character was killed
					}
					else
						System.out.println(this + " now has " + getHealthPoints() + " HP");
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
	
	public String displayCharacter(){
		String temp = "" + this;
		temp += "Health: " + stats.getCurrentHealth() + "\n";
		temp += "Speed: " + weapon.getAttackSpeed() + "\n";
		temp += "Weapon: " + weapon + "\n";
		temp += "Armor: " + armor + "\n";
		
		return temp;
	}
	
}
