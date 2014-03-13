package group;

import java.util.ArrayList;
import java.util.Random;

import character.Character;

/*
 *  When enemies are vanquished they are removed from EnemyGroup
 */
public class EnemyGroup extends Group {

	public EnemyGroup(ArrayList<Character> characterList) {
		super(characterList);
		// TODO Auto-generated constructor stub
	}

	public EnemyGroup(String char1, String char2, String char3) {
		super(char1, char2, char3);
		// TODO Auto-generated constructor stub
	}
	
	public EnemyGroup(String character){
		super(character);
	}
	
	@Override
	public void recieveAction(Action action){
		
		
		Character tempCharctr;
		//TODO: TEST
		switch(action.getTarget()){
		case ONE:
			tempCharctr = randomLivingGroupMember();
			tempCharctr.recieveAction(action);
			break;
		case TWO:
			//evenly distributes attackValue to each character
			action.setActionValue(action.getActionValue() /2);
			
			tempCharctr = randomLivingGroupMember();
			tempCharctr.recieveAction(action);
			
			tempCharctr = randomLivingGroupMember();
			tempCharctr.recieveAction(action);
			break;
		case ALL:
			//evenly distributes attackValue to each group member
			action.setActionValue(action.getActionValue() / group.size());
			//Passes on Attack to every enemy. If only 1 then full strength attack sent to enemy
			for(Character character : group){
				character.recieveAction(action);
			}
		}
		
		
	}
	
	
	@Override
	public Action determineAction(Action action) {
		switch(action.getHealOrHurt()){
		case HEAL:
			//Will send Action to appropriate Group Members
			//Need way to determine specific members to send to
			Character tempCharctr;
			switch(action.getTarget()){
			case ONE:
				tempCharctr = randomLivingGroupMember();
				tempCharctr.recieveAction(action);
				return null;
			case TWO:
				action.setActionValue(action.getActionValue() /2);
				
				tempCharctr = randomLivingGroupMember();
				tempCharctr.recieveAction(action);
				
				tempCharctr = randomLivingGroupMember();
				tempCharctr.recieveAction(action);
				return null;
			case ALL:
				//evenly distributes attackValue to each group member
				action.setActionValue(action.getActionValue() / group.size());
				//Distributes heal to each groupMember 
				for(Character character : group){
					character.recieveAction(action);
				}
				return null;
			}
		case DAMAGE:
			//Sends Action to Enemy Group
			return action;
			
		case SUMMON:
			//Summons Character
			if(action.getActionValue() == 211){
				this.addGroupMember("JackintheBox");
			}
			else if(action.getActionValue() == 340){
				this.addGroupMember("Grader");
			}
		}
		
		return null;
		
	}
	

	
	//Return: A Valid Living Group Member
	//Picks Random Character from group
	//TODO: TEST
	@Override
	protected Character randomLivingGroupMember(){
		Random rand = new Random();
		int select = rand.nextInt(group.size());
		
		return group.get(select);
	}
	
	
	/*
	 *  Checks each character to see if they are alive.
	 *  If they are dead => removes character from group.
	 */
	@Override
	public boolean areAlive() {
		boolean alive = false;
		
		for(int x = 0; x< group.size(); x++){
			if(group.get(x).isAlive())//character is alive
				alive = true;
			else{
				group.remove(x);//Remove dead enemy
				x --;//so dont skip over next enemy in list
			}
				
		}
		return alive;
	}

	

}
