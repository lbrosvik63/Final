package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;

import useableitem.Equipment;

public class Pen implements Weapon, Equipment {

	private int attackSpeed = 7;
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
		return speed + 1;
	}
	public int getMissPercent() {
		return this.missChance;
	}
	@Override
	public String itemDescription() {
		return "can be deadly when thrown or use to puncture objects";
	}
	@Override
	public String itemName() {
		return "pen";
	}
	@Override
	public String attackName() {
		return "4. Pen attack";
	}

	public String toString(){
		return "Pen";
	}
}
