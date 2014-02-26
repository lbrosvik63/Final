package cs211;

import weapons.Pen;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class LinkedListEnemy extends CS211Enemy {
	
	public LinkedListEnemy() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		stats.setAttackVariation(13);
		stats.setBaseAttack(7);
		stats.setWeaponSpeed(weapon.getAttackSpeed());
		stats.setMissChance(weapon.getMissPercent());
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(stats.getBaseAttack(), stats.getAttackVariation());
		System.out.println(this + " Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance() + 15);
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(stats.getBaseAttack(), stats.getAttackVariation() + 5);
		System.out.println(this + "Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ALL, value, stats.getMissChance() +10);
	}

	public String toString(){
		return "Linked List";
	}
}
