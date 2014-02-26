package cs211;

import weapons.Pen;
import armor.LightClothing;
import group.Action;
import group.ActionType;
import group.AttackWho;


public class InheritanceEnemy extends CS211Enemy {
	
	public InheritanceEnemy() {
		weapon = new Pen();
		armor = new LightClothing();
		stats.setMaxHealth(55);
		stats.setCurrentHealth(55);
		stats.setAttackVariation(12);
		stats.setBaseAttack(5);
		stats.setWeaponSpeed(weapon.getAttackSpeed());
		stats.setMissChance(weapon.getMissPercent());
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue(stats.getBaseAttack(), stats.getAttackVariation());
		System.out.println(this + " Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, stats.getMissChance());
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue(stats.getBaseAttack() + 4, stats.getAttackVariation());
		System.out.println(this + " Describe Attack Here");
		// TODO Auto-generated method stub
		return new Action(ActionType.DAMAGE, AttackWho.TWO, value, stats.getMissChance() + 20);
	}

	public String toString(){
		return "Inheritance";
	}
	
}
