package groupproject;

public class Stats {
	private int maxHealth = 100;
	private int currentHealth = 100;
	
	public int getMaxHealth(){
		return this.maxHealth;
	}
	
	public int getCurrentHealth(){
		return this.currentHealth;
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

}
