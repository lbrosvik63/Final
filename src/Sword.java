package groupproject;

import java.util.Random;

public class Sword implements Weapon {

	
	//Sword attack has value between 15 - 85
	// so it has a higher risk, but you could potentially land a big hit.
	@Override
	public int weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(71);
		attackValue += 15; //assures lowest value is 30
		System.out.println("Sword Attack");
		return attackValue;
	}

}
