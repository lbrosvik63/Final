package weapons;

import group.Action;
import group.ActionType;
import group.AttackWho;

import java.util.Random;



//Tom's weapon
//Gang of four's bible
public class GofBible implements Weapon {

	private int adjustSpeed = 3;
	private int missChance = 0;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(50);
		attackValue += 55; //assures lowest value is 30
		System.out.println("Stapler Attack");
		return new Action(ActionType.DAMAGE, AttackWho.TWO, attackValue, missChance);
	}
	public int getMissPercent() {
		return this.missChance;
	}
	@Override
	public String itemDescription() {
		return "Finds patterns of Death";
	}

	@Override
	public String attackName() {
		return "Pattern of Death";
	}
	@Override
	public int affectSpeed(int speed) {
		return speed - adjustSpeed;
	}
	
	public String toString(){
		return "Gang of Four";
	}

}
