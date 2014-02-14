package groupproject;

import java.util.Random;

public class Pen implements Weapon {

	private int attackSpeed;
	@Override
	public int weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(71);
		attackValue += 15; //assures lowest value is 30
		System.out.println("Pen Attack");
		return attackValue;
	}
	public int getAttackSpeed()
	{
		return this.attackSpeed;
	}

}
