package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;

public class Calculator implements Weapon {

	private int affectSpeed = 0;
	private int missChance = 15;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(15);
		attackValue += 30; //assures lowest value is 30
		System.out.println("Pen Attack");
		return new Action(ActionType.DAMAGE, AttackWho.ONE, attackValue, missChance);
	}
	public int affectSpeed(int speed)
	{
		
		return speed - affectSpeed;
	}
	public int getMissPercent() {
		return this.missChance;
	}
	@Override
	public String itemDescription() {
		return "is the quickest way to the correct answer";
	}
	
	@Override
	public String attackName() {
		return "4. Calculator attack";
	}
	
	public String toString(){
		return "Calculator";
	}

}
