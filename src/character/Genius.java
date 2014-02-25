package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
import armor.LightClothing;
import weapons.Pen;





public class Genius extends Caster {

	private final int BASE = 17;
	private final int VARIATION = 5;
	
	private int baseAttack = 15;
	private int variation;
	
	public Genius() {
		stats.setMaxHealth(125);
		stats.setCurrentHealth(125);
		weapon = new Pen();
		armor = new LightClothing();
	}

	@Override
	public Action primaryAttack() {
		int value = generateAttackValue2(BASE, VARIATION);
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, weapon.getMissPercent());
	}

	@Override
	public Action secondaryAttack() {
		int value = generateAttackValue2(BASE, VARIATION);
		return new Action(ActionType.DAMAGE, AttackWho.ONE, value, weapon.getMissPercent());
	}


	@Override
	public void menuDisplay() {
		System.out.println("Genius Attack Menu:");
		System.out.println("1. Mensa Attack");
		System.out.println("2. Blow Minds with Knowledge");
		System.out.println("3. Role Attack");
		System.out.println(this.weapon.attackName());
		System.out.println("Choose your Attack");
		
	}
	
	public String toString(){
		return "Genius";
	}

}
