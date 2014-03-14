package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;


//Stu's weapon
public class Valgrind implements Weapon {

	private int adjustSpeed = 3;
	private int missChance = 5;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(25);
		attackValue += 45; //assures lowest value is 30
		return new Action(ActionType.DAMAGE, AttackWho.ONE, attackValue, missChance);
	}
	public int getMissPercent() {
		return this.missChance;
	}
	@Override
	public String itemDescription() {
		return "inflix massive damage";
	}

	@Override
	public String attackName() {
		return "Find memory leaks";
	}
	@Override
	public int affectSpeed(int speed) {
		return speed - adjustSpeed;
	}
	
	public String toString(){
		return "Valgrind";
	}

}
