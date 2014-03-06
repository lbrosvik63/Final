package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;

import useableitem.Equipment;

//Tom's weapon
//Gang of four's bible
public class GofBible implements Weapon, Equipment {

	private int attackSpeed = 10;
	private int missChance = 5;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(50);
		attackValue += 55; //assures lowest value is 30
		System.out.println("Stapler Attack");
		return new Action(ActionType.DAMAGE, AttackWho.TWO, attackValue, missChance);
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
		return "Finds patterns of Death";
	}
	@Override
	public String itemName() {
		return "Gang of Four Bible";
	}
	@Override
	public String attackName() {
		return "Pattern of Death";
	}

}
