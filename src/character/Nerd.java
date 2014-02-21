package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;

public class Nerd extends Healer {

	public Nerd() {
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		weapon = new Pen();
		armor = new LightClothing();
	}

	@Override
	public Action primaryAttack() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10, 5);
	}

	@Override
	public Action secondaryAttack() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10, 5);
	}



	@Override
	public void menuDisplay() {
		System.out.println("Nerd Attack Menu:");
		System.out.println("1. Nerd Bomb");
		System.out.println("2. Phaser Stun");
		System.out.println("3. Role Attack");
		System.out.println("Choose your Attack");
		
	}
	
	public String toString(){
		return "Nerd";
	}

}
