package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;


public class Stapler implements Weapon {

	private int attackSpeed = 0;
	private int missChance = 15;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(25);
		attackValue += 35; //assures lowest value is 30
		System.out.println("Stapler Attack");
		return new Action(ActionType.DAMAGE, AttackWho.TWO, attackValue, missChance);
	}
	public int affectSpeed(int speed)
	{
		return speed + 2;
	}
	public int getMissPercent() {
		return this.missChance;
	}
	@Override
	public String itemDescription() {
		return "Rains staples on multiple victims";
	}

	@Override
	public String attackName() {
		return "4. Stapler attack";
	}

	public String toString(){
		return "Stapler";
	}
}
