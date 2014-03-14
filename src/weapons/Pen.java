package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;


public class Pen implements Weapon {

	private int missChance = 15;
	private int affectSpeed = 0;
	
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(25);
		attackValue += 15; //assures lowest value is 30
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
		return "can be deadly when thrown or use to puncture objects";
	}

	@Override
	public String attackName() {
		return "4. Pen attack";
	}

	public String toString(){
		return "Pen";
	}
}
