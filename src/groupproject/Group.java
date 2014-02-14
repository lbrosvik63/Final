package groupproject;

import java.util.ArrayList;

public class Group {
	
	//CharacterFactory factory = new CharacterFactory();
	Character c1; //java is referencing its own character...that needs to be changed.
	Character c2;
	Character c3;
	ArrayList<Item> inventory = new ArrayList<Item>();
	boolean areAlive;
	
	public Group (String char1, String char2, String char3) {
		c1 = new Character(char1);
		c2 = new Character(char2);
		c3 = new Character(char3);
		areAlive = true;
		//create characters using factory based on the ints passed in.
		
		
	}
	
	public void addToInventory(Item item){
		inventory.add(item);
	}
	
	public void displayInventory(){
		if(inventory.size() == 0)
			System.out.println("Inventory is empty.");
		else{
			for(Item item : inventory){
				System.out.println("\t" + item.toString());
			}
		}
			
	}//end displayInventory
	
	public boolean areAlive(){
		return areAlive;
	}
	
	public void setAreAlive(boolean areAlv){
		areAlive = areAlv;
	}

}
