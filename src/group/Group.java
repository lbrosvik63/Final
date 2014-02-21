package group;

import java.util.ArrayList;
import java.util.Random;

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
		
		
		Character tempCharctr;
		//TODO: TEST
		switch(action.getTarget()){
		case ONE:
			tempCharctr = randomLivingGroupMember();
			tempCharctr.recieveAction(action);
		case TWO:
			//evenly distributes attackValue to each character
			action.setActionValue(action.getActionValue() /2);
			
			tempCharctr = randomLivingGroupMember();
			tempCharctr.recieveAction(action);
			
			tempCharctr = randomLivingGroupMember();
			tempCharctr.recieveAction(action);
		case ALL:
			//evenly distributes attackValue to each group member
			action.setActionValue(action.getActionValue() / group.size());
			//Passes on Attack to every 
			for(Character character : group){
				character.recieveAction(action);
			}
		}
		
		
	}
	
	//Return: A Valid Living Group Member
	//Picks Random Character from group: if dead then selects a different character
	//TODO: TEST
	private Character randomLivingGroupMember(){
		Random rand = new Random();
		int select = rand.nextInt(group.size());
		while(group.get(select).getHealthPoints() < 1)
			select = rand.nextInt(group.size());
		
		return group.get(select);
	}
	
	
	public boolean areAlive(){
		
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
