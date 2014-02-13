package groupproject;

import java.util.Random;

public class Warrior extends Character {

	/* Warrior starts with 100HP, speed of 4, PlateArmor, Sword, MeleeRole
	 * 
	 */
	public Warrior(){
		role = new MeleeRole();
		weapon = new Sword();
		armor = new PlateArmor();
		healthPoints = 100;
		speed = 4;
	}
	
	// Value of primary attack is between 30 and 60
	@Override
	public int primaryAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(31);
		attackValue += 30; //assures lowest value is 30
		System.out.println("We can describe the Warrior Attack here.");
		return attackValue;
	}

}
