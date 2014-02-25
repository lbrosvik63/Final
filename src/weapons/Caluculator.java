package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;

import useableitem.Equipment;

public class Caluculator implements Equipment, Weapon {

	private int attackSpeed = 10;
	private int missChance = 5;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(71);
		attackValue += 15; //assures lowest value is 30
		System.out.println("Pen Attack");
		return new Action(ActionType.DAMAGE, AttackWho.ONE, attackValue, missChance);
	}
	public int getAttackSpeed()
	{
		return this.attackSpeed;
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

}
