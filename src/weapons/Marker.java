package weapons;

import java.util.Random;

import group.Action;
import group.ActionType;
import group.AttackWho;

public class Marker implements Weapon {

	private int missChance = 15;
	private int affectSpeed = 2;
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(45);
		attackValue += 15; //assures lowest value is 30
		System.out.println("Marker Projectile");
		return new Action(ActionType.DAMAGE, AttackWho.ONE, attackValue, missChance);
		
	}

	@Override
	public int affectSpeed(int speed) {
		return speed + affectSpeed;
	}

	@Override
	public int getMissPercent() {
		return this.missChance;
	}

	@Override
	public String attackName() {
		return "Marker Projectile";
	}
	
	public String toString(){
		return "Marker";
	}

	@Override
	public String itemDescription() {
		return "Dangerous Projectile";
	}
}


