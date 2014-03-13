/**
 * 
 */
package character;

import java.util.Random;
import weapons.Weapon;
import armor.Armor;
import group.Action;
import group.ActionType;


/**
 * Speed value based on scale 1 to 10 (1 is fastest)
 *
 */
public abstract class Character {

	
	protected Weapon weapon;
	protected Armor armor;
	protected Stats stats;
	
	public Character(){
		stats = new Stats();
	}
	
	public abstract Action primaryAttack();
	
	//public abstract void menuDisplay();
	
	public abstract Action secondaryAttack();

	public abstract Action roleAttack();
	
	public Action weaponAttack(){
		return weapon.weaponAttack();
	}

	public int getFailChance() {
		return stats.getMissChance();
	}
	
	public int getHealthPoints(){
		return stats.getCurrentHealth();
	}
	
	public int getMaxHealthPoints(){
		return stats.getMaxHealth();
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		
	}

	public int getSpeed() {
		int tempSpeed = stats.getSpeed();
		tempSpeed = weapon.affectSpeed(tempSpeed);
		return tempSpeed;
	}

	//public Action actionMenu(Scanner sysIn){
	//	return menuSelection(sysIn);
	//}
	
	public boolean isAlive(){
		if(stats.getCurrentHealth() > 0)
			return true;
		return false;
	}

	
	public Action genRandomAttack(){
		Random rand = new Random();
		int choice = rand.nextInt(4) + 1;//Number between 1 - 4
		if(choice == 1)
			return primaryAttack();
		if(choice == 2)
			return secondaryAttack();
		if(choice == 3)
			return roleAttack();
		//(choice == 4)
		return weapon.weaponAttack();
		
	}
	
	
	
	/*
	 * First checks if HEAL or DAMAGE 
	 * HEAL:
	 * 		Applies to Character
	 * DAMAGE:
	 * 		Checks if attack fails due to Action.failChancePercent
	 * 		Then checks if attack fails due to armor.getDodgeChance
	 * 		Removes armor's value from attack value
	 * 		Displays if attack results in character's death or their remaining HP
	 * 
	 * 	Returns amount of damage/health recieved (0 if missed)
	 */
	public void recieveAction(Action action)
	{
		Random rand = new Random();
		int num = rand.nextInt(101);
		switch(action.getHealOrHurt()){
		case HEAL:
			updateHealth(action);
			break;
		case DAMAGE:
			num = rand.nextInt(101);
			//Check if Attack fails based on failChancePercent
			if(num <= action.getFailChancePercent()){
				break;
			}
			else{
				num = rand.nextInt(101);
				if(num <= armor.getDodgeChance()){
					break;
				}
				else{
					updateHealth(action);
				}
			}
			break;
		case SUMMON:
			//do nothing
		}//end switch
		
		
	}//end recieveAttack
	
	public void updateHealth(Action action){
		if(action.getHealOrHurt() == ActionType.HEAL)
			stats.updateCurrentHealth(action.getActionValue());
		else if(action.getHealOrHurt() == ActionType.DAMAGE){
			int actionValue = action.getActionValue();
			
			
			actionValue -= (actionValue * (armor.getArmorValue() / 100.0)); //hopefully doesnt cause trunkation errors
			System.out.println(this + " hit by attack:  -" + actionValue + " HP");
			stats.updateCurrentHealth(actionValue * -1);
		}
	}
	
	protected int generateAttackValue(int min, int max){
		Random rand = new Random();
		int difference = max - min;
		int value = rand.nextInt(difference + 1);
		value += min;
		return value;
	}
	protected int generateAttackValue2(int base, int variation){
		Random rand = new Random();
		int value = rand.nextInt(variation + 1);
		int attack = value + base;
		return attack;
	}
	
	public String displayCharacter(){
		
		if(this.isAlive()){
			int curr = stats.getCurrentHealth();
			int max = stats.getMaxHealth();
			return this + "   " + curr + "/" + max + " HP";
		}
		
		return this + "   Expelled";
	}

	public abstract String getPriAtkName();

	public abstract String getScdAtkName();

	public abstract String getRolAtkName();
}
