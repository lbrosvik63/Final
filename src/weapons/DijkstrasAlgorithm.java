package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;

import useableitem.Equipment;

//for Bojian
public class DijkstrasAlgorithm implements Weapon, Equipment {

	private int attackSpeed = 10;
	private int missChance = 5;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(35);
		attackValue += 35; //assures lowest value is 30
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
		return "Finds the shortest way to Death";
	}
	@Override
	public String itemName() {
		return "Dijkstra's Algorithm";
	}
	@Override
	public String attackName() {
		return "Dijkstra's Algorithm";
	}

}
