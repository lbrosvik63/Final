package weapons;
//keep adding weapons...
//keep adding weapons...
//keep adding weapons...one for each boss

import java.util.Random;

import group.Action;
import group.ActionType;
import group.AttackWho;
import useableitem.Equipment;

//weapon for Koske
public class KendoSword implements Weapon, Equipment {

	private int missChance = 10;
	private int adjustSpeed = 1;
	
	@Override
	public String itemDescription() {
		return "Slices the stuff out of everyone";
	}

	@Override
	public String itemName() {
		return "Kendo Sword";
	}
	
	@Override
	public Action weaponAttack() {
		Random rand = new Random();
		int attackValue = rand.nextInt(50);
		attackValue += 15; 
		return new Action(ActionType.DAMAGE, AttackWho.ALL, attackValue, missChance);
	}

	@Override
	public int getMissPercent() {
		return missChance;
	}

	@Override
	public String attackName() {
		return "Kendo Slice";
	}

	@Override
	public int affectSpeed(int speed) {
		return speed - adjustSpeed;
	}
	
	public String toString(){
		return "Kendo Sword";
	}

}
