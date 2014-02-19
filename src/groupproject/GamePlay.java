package groupproject;

import java.io.IOException;
import java.util.Scanner;

public class GamePlay {

	private Group goodGuys;
	private Level level;
	private int curRow;
	private int curCol;
	private boolean hasKey = false;
	private boolean escaped = false;
	private Scanner kb;
	
	//Starting Position defaults to 0,0
	public GamePlay(Group gdGuys, Level lvl, Scanner sysIn){
		goodGuys = gdGuys;
		level = lvl;
		curRow = 0;
		curCol = 0;
		level.setPathAtPosition(curRow, curCol, 'X');//Marks starting position
		kb = sysIn;
		
	}
	//User can choose the starting position
	public GamePlay(Group gdGuys, Level lvl, int rowStart, int colStart, Scanner sysIn){
		goodGuys = gdGuys;
		level = lvl;
		curRow = rowStart;
		curCol = colStart;
		level.setPathAtPosition(curRow, curCol, 'X');//Marks starting position
		kb = sysIn;
	}
	
	
	//Returns true if Succeed in escaping
	//Returns false if group dies
	public boolean playLevel(){
		
		System.out.println(level);
		
		while(goodGuys.areAlive() && !escaped){
			displayMenu();
			menuChoice();
			positionAction();
			System.out.println(level);
		}
		return exit();
		
		
	}//end playLevel
	
	
	
	private boolean exit(){
		//kb.close();
		if(escaped)//unlocked the door
			return true;
		if(!goodGuys.areAlive())//group is dead
			System.out.println("Your Team is Dead. GAME OVER");
		
		return false;
	}//end of exit
	
	
	
	public void displayMenu(){
		System.out.println("Options");
		System.out.println("W - Move Up");
		System.out.println("S - Move Down");
		System.out.println("A - Move Left");
		System.out.println("D - Move Right");
		System.out.println("1 - Inventory");
		System.out.println("2 - Save Game");
		System.out.println("3 - Quit");
	}//end displayMenu
	
	
	
	
	public void menuChoice(){
		//kb = new Scanner(System.in);
		//TODO: ADD ERROR CHECKING
//		int choice = kb.nextInt();
		
		
		Scanner reader = new Scanner(System.in);
		char c = reader.next().charAt(0);
		//char c = strUserAnswer.charAt(0);
		
		
		if(c == 'W' || c == 'w' || c == 'A' || c == 'a' || c == 'S' || c == 's' || c == 'D' || c == 'd'){//Selected a Move Option
			move(c);
		}
		else if(c == '1'){//Display Inventory
			goodGuys.displayInventory();
		}
		else if(c == '2'){// Save Game
			
		}
		else if(c == '3'){//Quit
			System.out.println("Goodbye");
			this.exit();
			//TODO: SET UP EXIT
		}
		
	}//end menuChoice
	
	
	
	/*	
	 * 	Determines if requested move is valid.
	 *  If valid checks to see the type of LevelObject that is there : Wall, Door, Available
	 *  Moves group to requested position if possible
	 */
	private void move(char c){
		int testRow = curRow;
		int testCol = curCol;
		LevelObject temp;
		
		if(c == 'W' || c == 'w')//Move Up
			testRow --;
		else if(c == 'S' || c == 's')//Move Down
			testRow ++;
		else if(c == 'A' || c == 'a')//Move Left
			testCol --;
		else if(c == 'D' || c == 'd')//Move Right
			testCol ++;
			
		
		if(testRow < 0 || testRow >= level.getSideLength() || 
		   testCol < 0 || testCol >= level.getSideLength())//invalid move
			System.out.println("That is the edge of the map");
		else{
				
			temp = level.getPosition(testRow, testCol);
			if(temp.isWall()){
				System.out.println("There is a wall there");
				level.setPathAtPosition(testRow, testCol, 'W');
			}
				
			else if(temp.isDoor()){//TODO: RIGHT NOW WITHOUT KEY YOU CANNOT MOVE ONTO THE DOOR SPACE
				if(!hasKey){
					System.out.println("Its a Door.  You need a key to unlock it");
					level.setPathAtPosition(testRow, testCol, 'D');
					//Below Code would allow you to move onto door space w/out key
					level.setPathAtPosition(curRow, curCol, 'O');//As leave marks as visited
					System.out.println("Move Successful");
					curRow = testRow;
					curCol = testCol;
					level.setPathAtPosition(curRow, curCol, 'X');//Marks current position
				}
					
				else{
					System.out.println("You unlocked the door!");
					
					escaped = true;
				}
					
			}
			else{//Valid Unblocked place to move
				temp = level.getPosition(curRow, curCol);
				if(temp.isDoor())//Special case leave off of door space
					level.setPathAtPosition(curRow, curCol, 'D');
				else
					level.setPathAtPosition(curRow, curCol, 'O');//As leave marks as visited
				//System.out.println("Move Successful");
				curRow = testRow;
				curCol = testCol;
				level.setPathAtPosition(curRow, curCol, 'X');//Marks current position
			}
					
		}
				
		
	}//end move
	
	
	
	
	/*	Determines what actions to take at current position
	 * 	If position has a Group of Enemies --> Initiates a Battle between the Groups
	 *  If positions has Items --> Will reward after battle or free if no enemies
	 */
	public void positionAction(){
		LevelObject position = level.getPosition(curRow, curCol);
		if(!position.hasGroup() && !position.hasItem()){//Clear Space (No enemies or items)
			System.out.println("Nothing here");
		}
		else{//Positions has enemies and/or items
			if(position.hasGroup()){//Initiate Battle
				Battle theBattle = new Battle(goodGuys, position.getBadGuys(), kb);
				System.out.println("Enemies Encountered. Battle Beginning....\n");
				theBattle.startBattle();
			}
			//TODO: CHANGE THIS TO ITEMGENERATOR
			if(goodGuys.areAlive() && position.hasItem()){//Will check after battle, or if no enemies present
				Item tempItem = position.getItem();
				System.out.println("You found a " + tempItem);//TODO: MAKE SURE ITEM HAS toString()
				if(tempItem.toString().equalsIgnoreCase("KEY"))
					foundKey();
				goodGuys.addToInventory(tempItem);
			}
			//Clear position of Groups and Items
			position.setBadGuys(null);
			position.setItem(null);
		}
		
	}
	
	
	
	private void foundKey(){
		hasKey = true;
	}
	
}//end class
