package gameplay;

import group.Group;
import group.HeroGroup;

import java.io.IOException;
import java.util.Scanner;

import level.Level;
import level.LevelReader;

public class Game {
	
	static Group myGroup;

	static String characters [] = {"Genius", "Cheater", "Nerd", "Jock", "Tutor", "Slacker"}; 
	static String levelNames [] = {"easy.txt", "level.txt", "level2.txt"};

	
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		int ch1 = -1;
		int ch2 = -1;
		int ch3 = -1;
	
		System.out.println("WELCOME TO THE ------- GAME!\n\n");
		
		//validating so the three characters are chose correctly
		while(ch1 < 0 || ch1 > 6 || ch2 < 0 || ch2 > 6 || ch3 < 0 || ch3 > 6){
			
			//create character selection
			System.out.println("Please make a character choice\n");
			System.out.println("1. Genius");
			System.out.println("2. Cheater");
			System.out.println("3. Nerd");
			System.out.println("4. Jock");
			System.out.println("5. Tutor");
			System.out.println("6. Slacker");
			
			System.out.println("Enter your choice of characters!");
			
			//@SuppressWarnings("resource")
			System.out.print("Enter the first choice:  ");
			ch1 = (int)sc.nextInt();
			System.out.print("Enter the second choice: ");
			ch2 = (int)sc.nextInt();
			System.out.print("Enter the third choice:  ");
			ch3 = (int)sc.nextInt();
			
			
			
			//sc.close(); Causes a problem....no idea why.
		}//end while
		
		ch1--; ch2--; ch3--; //so that the array values line up
		
		//creating a group with three characters
		String first, second, third;
		
		//converting from int's, to strings.
		first = characters[ch1];
		second = characters[ch2];
		third = characters[ch3];
		
		System.out.println("\nThe three characters in your group will be: " + first + ", " + second + ", and " + third + "\n\n");
		
		myGroup = new HeroGroup(first,second,third);
		
		boolean keepPlaying; //check whether level passed and should keep going
		
		LevelReader reader = new LevelReader();
		
		
		//for each level load level
		for(int i = 0; i < levelNames.length; i++){                  //not sure how this is going to work exactly, but this is where the maps come in.
	
			 Level theLevel = null;
	
			 try {
				theLevel = reader.loadLevel(levelNames[i]);
			} catch (IOException e) {
				System.out.println("ERROR: Level reading failed!");
			}
			
			
			 GamePlay gmply = new GamePlay(myGroup, theLevel, sc); 
			 keepPlaying = gmply.playLevel();
			 
			if(keepPlaying == false)
			{
				//you lost
			
				System.out.println("Unfortunately you have failed.");
				break;
			}
			
			System.out.println("\n\n CONGRATS ON PASSING THE LEVEL \n\n");
			
	
			
		}//end for
		
		System.out.println("You did great and passed the levels");
		sc.close();
	}//end main	
	
	
}//end Game
