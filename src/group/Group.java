package group;

import java.util.ArrayList;
import java.util.Random;

import character.Character;
import character.CharacterFactory;
import useableitem.Item;

public abstract class Group {
	
	CharacterFactory factory = new CharacterFactory();
	ArrayList<Character> group = new ArrayList<Character>();
	ArrayList<Item> inventory = new ArrayList<Item>();
	
	
	public Group(ArrayList<Character> characterList){
		for(Character character : characterList){
			group.add(character);
		}
	}
	
	public Group (String char1, String char2, String char3) {
		group.add(factory.createCharacter(char1));
		group.add(factory.createCharacter(char2));
		group.add(factory.createCharacter(char3));

		//create characters using factory based on the Strings passed in.
		
		
	}
	
	public ArrayList<Character> getGroup() {
		return group;
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
	
	//Group determines if character's action is to heal group or to attack enemy
	//returns null if heal, otherwise returns attack action
	public abstract Action determineAction(Action action);
	
	public abstract void recieveAction(Action action);
	
	//Return: A Valid Living Group Member
	//Picks Random Character from group: if dead then selects a different character
	//TODO: TEST
	protected Character randomLivingGroupMember(){
		Random rand = new Random();
		int select = rand.nextInt(group.size());
		while(!group.get(select).isAlive())//while character is dead
			select = rand.nextInt(group.size());
		
		return group.get(select);
	}
	
	
	public abstract boolean areAlive();
	
	public String toString(){
		String temp = "";
		for(Character character : group){
			temp += character.displayCharacter() + "\n";
			
		}
		return temp;
	}

}
