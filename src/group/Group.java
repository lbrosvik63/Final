package group;

import java.util.ArrayList;

import character.Character;
import character.CharacterFactory;
import useableitem.Item;

public class Group {
	
	CharacterFactory factory = new CharacterFactory();
	ArrayList<Character> group = new ArrayList<Character>();
	public ArrayList<Character> getGroup() {
		return group;
	}

	ArrayList<Item> inventory = new ArrayList<Item>();
	//boolean areAlive;
	
	
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
	public Action determineAction(Action action){
		
		System.out.println("Group Determined Action to take.");
		
		switch(action.getHealOrHurt()){
		case HEAL:
			//Will send Action to appropriate Group Members
			//Need way to determine specific members to send to
			switch(action.getTarget()){
			case ONE:
				
			case TWO:
				
			case ALL:
				//evenly distributes attackValue to each group member
				action.setActionValue(action.getActionValue() / group.size());
				//Passes on Attack to every 
				for(Character character : group){
					character.recieveAction(action);
				}
			}
		case DAMAGE:
			//Sends Action to Enemy Group
			return action;
		}
		
		return null;
		
	}
	
	public void recieveAction(Action action){
		
		System.out.println("Group Recieved an Action.");
		//TODO: Need way to determine specific members to send to
		switch(action.getTarget()){
		case ONE:
			
		case TWO:
			
		case ALL:
			//evenly distributes attackValue to each group member
			action.setActionValue(action.getActionValue() / group.size());
			//Passes on Attack to every 
			for(Character character : group){
				character.recieveAction(action);
			}
		}
		
		
	}
	
	
	//TODO: NEEDS TO BE TESTED : If it works then don't need to have areAlive variable
	public boolean areAlive(){
		//return areAlive; //original 
		
		//Testing
		for(Character character : group){
			if(character.getHealthPoints() > 0)//if 1 character is alive
				return true;
		}
		return false;
	}
	
	public String toString(){
		String temp = "";
		for(Character character : group){
			temp += character.toString();
		}
		return temp;
	}

}
