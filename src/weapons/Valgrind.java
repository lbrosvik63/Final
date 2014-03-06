package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;

import useableitem.Equipment;

//Stu's weapon
public class Valgrind implements Weapon, Equipment {

	private int attackSpeed = 10;
	private int missChance = 5;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(25);
		attackValue += 45; //assures lowest value is 30
		System.out.println("Stapler Attack");
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
		return "inflix massive damage";
	}
	@Override
	public String itemName() {
		return "Valgrind";
	}
	@Override
	public String attackName() {
		return "Find memory leaks";
	}

}
