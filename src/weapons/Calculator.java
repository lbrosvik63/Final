package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;

import useableitem.Equipment;

public class Calculator implements Equipment, Weapon {

	private int attackSpeed = 2;
	private int missChance = 5;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(71);
		attackValue += 15; //assures lowest value is 30
		System.out.println("Pen Attack");
		return new Action(ActionType.DAMAGE, AttackWho.ONE, attackValue, missChance);
	}
	public int affectSpeed(int speed)
	{
		speed -= 1;
		if(speed < 1)
			speed = 1;
		return speed;
	}
	public int getMissPercent() {
		return this.missChance;
	}
	@Override
	public String itemDescription() {
		return "is the quickest way to the correct answer";
	}
	@Override
	public String itemName() {
		return "calculator";
	}
	@Override
	public String attackName() {
		return "4. Calculator attack";
	}
	
	public String toString(){
		return "Calculator";
	}

}
