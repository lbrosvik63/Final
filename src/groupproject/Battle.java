package groupproject;

import java.util.LinkedList;
import java.util.Scanner;

public class Battle {
	
	private Group goodGuys;
	private Group enemies;
	private int clock;
	//Possibly use an AttackQueue to set order of attacks for each turn
	private LinkedList<Character> attackQueue;
	private Scanner kb;
	
	public Battle(Group goodGuys, Group enemies, Scanner sysIn){
		this.goodGuys = goodGuys;
		this.enemies = enemies;
		clock = 0;
		kb = sysIn;
		attackQueue = new LinkedList<Character>();
	}
	
	public void startBattle(){
		
		while(goodGuys.areAlive() && enemies.areAlive()){
			clock ++;
			
			/*//Need to Make Group Iterable so we can use an enhanced for loop
			if(clock % enemies.c1.getSpeed() == 0)
				attackQueue.push(enemies.c1);
			if(clock % enemies.c2.getSpeed() == 0)
				attackQueue.push(enemies.c2);
			if(clock % enemies.c3.getSpeed() == 0)
				attackQueue.push(enemies.c3);
			
			if(clock % goodGuys.c1.getSpeed() == 0)
				attackQueue.push(goodGuys.c1);
			if(clock % goodGuys.c2.getSpeed() == 0)
				attackQueue.push(goodGuys.c2);
			if(clock % goodGuys.c3.getSpeed() == 0)
				attackQueue.push(goodGuys.c3);
			*/
			for(Character character : enemies.group){//Add Bad Guys to Queue
				if(character.getHealthPoints() > 0 && clock % character.getSpeed() == 0)
					attackQueue.offer(character);
			}
			
			for(Character character : goodGuys.group){//Add Good Guys to Queue
				if(character.getHealthPoints() > 0 && clock % character.getSpeed() == 0)
					attackQueue.offer(character);
			}
			
			emptyAttackQueue();
			
		}//end while loop
	}//end startBattle
	
	/*
	 * Takes Characters in AttackQueue 1 by 1 and allows them to attack or heal
	 * After each turn, it checks if team that was attacked is still alive
	 * Returns: True - both groups are still alive after all attacks in queue
	 * 			False - one group is defeated
	 * TODO: NEED TO DISPLAY ENEMY INFORMATION BEFORE EACH TURN
	 */
	private boolean emptyAttackQueue(){
		Character tempCharacter;
		Action action;
		while(attackQueue.peek() != null){
			
			tempCharacter = attackQueue.poll();
			action = tempCharacter.actionMenu(kb);
			
			if(goodGuys.group.contains(tempCharacter)){//Goes through appropriate group
				action = goodGuys.determineAction(action);
				if(action != null){//Is an Attack Against Enemy
					enemies.recieveAction(action);
					if(!enemies.areAlive())//breaks out of method if enemies are dead
						return false;
				}
			}
			else{
				action = enemies.determineAction(action);
				if(action != null){//Is an Attack Against goodGuys
					goodGuys.recieveAction(action);
					if(!goodGuys.areAlive())//breaks out of method if goodGuys are dead
						return false;
				}	
			}
	
		}//end while
		
		return true;//attackQueue emptied and both teams still alive
		
	}//end emptyAttackQueue
	
	
}//end class
