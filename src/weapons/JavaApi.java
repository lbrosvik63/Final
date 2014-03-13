package weapons;
//keep adding weapons...
//keep adding weapons...
//keep adding weapons...one for each boss

import java.util.Random;

import group.Action;
import group.ActionType;
import group.AttackWho;
import useableitem.Equipment;


//weapon for Peters
public class JavaApi implements Weapon, Equipment {

	private int missChance = 10;
	private int affectSpeed = 1;
	
	@Override
	public String itemDescription() {
		return "All your Java answers are here";
	}

	@Override
	public String itemName() {
		return "JavaApi";
	}
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(25);
		attackValue += 25; 
		return new Action(ActionType.DAMAGE, AttackWho.ONE, attackValue, missChance);
	}

	@Override
	public int getMissPercent() {
		return missChance;
	}

	@Override
	public String attackName() {
		return "API lookup";
	}

	@Override
	public int affectSpeed(int speed) {
		return speed - affectSpeed;
	}

	public String toString(){
		return "Java API";
	}
}
