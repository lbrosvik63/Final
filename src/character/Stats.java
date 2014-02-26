package character;

public class Stats {
	private int maxHealth;
	private int currentHealth;
	private int baseAttack;
	private int attackVariation;
	private int missChance;
	private int weaponSpeed;
	
	public int getMaxHealth(){
		return this.maxHealth;
	}
	
	public int getCurrentHealth(){
		return this.currentHealth;
	}
	
	public void setCurrentHealth(int value){
		currentHealth = value;
	}
	
	public void updateCurrentHealth(int addToHealth){
		int newHealth = currentHealth + addToHealth;
		
		if(newHealth > maxHealth)
			newHealth = maxHealth;
		else if(newHealth < 1)
			newHealth = 0;
		this.currentHealth = newHealth;
	}
	
	public void setMaxHealth(int newMax){
		this.maxHealth = newMax;
	}
	
	public void setBaseAttack(int attack){
		this.baseAttack = attack;
	}
	
	public int getBaseAttack(){
		return this.baseAttack;
	}
	
	public void setAttackVariation(int variation){
		this.attackVariation = variation;
	}
	
	public int getAttackVariation(){
		return this.attackVariation;
	}
	
	public void setMissChance(int miss){
		this.missChance = miss;
	}
	
	public int getMissChance(){
		return this.missChance;
	}
	
	public void setWeaponSpeed(int speed){
		this.weaponSpeed = speed;
	}
	
	public int getWeaponSpeed(){
		return this.weaponSpeed;
	}

}
