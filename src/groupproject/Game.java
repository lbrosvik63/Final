package groupproject;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	static Group myGroup;
	static String characters [] = {"Genius", "cheater", "Nerd", "fourth", "fifth", "sixth"}; 
	static String levelNames [] = {"level.txt", "level.txt", "level.txt"};
	
	public static void main(String args[]){
		
		int ch1 = -1;
		int ch2 = -1;
		int ch3 = -1;
	
		//validating so the three characters are chose correctly
		while(ch1 < 0 || ch1 > 6 || ch2 < 0 || ch2 > 6 || ch3 < 0 || ch3 > 6){
			
			//create character selection
			System.out.println("Please make a character choice\n");
			System.out.println("1. Genius");
			System.out.println("2. Cheater");
			System.out.println("3. Nerd");
			System.out.println("4. fourth");
			System.out.println("5. fifth");
			System.out.println("6. sixth");
			
			System.out.println("Enter 3 choice and press enter in between all of them");
			
			Scanner sc = new Scanner(System.in);
			ch1 = (int)sc.nextInt();
			ch2 = (int)sc.nextInt();
			ch3 = (int)sc.nextInt();
			
			
			//sc.close(); casuses a problem....no idea why.
		}//end while
		
		System.out.printf("the three characters are %d, %d, %d\n\n", ch1,ch2,ch3);
		
		ch1--; ch2--; ch3--; //so that the array values line up
		
		//creating a group with three characters
		String first, second, third;
		
		//converting from int's, to strings.
		first = characters[ch1];
		second = characters[ch2];
		third = characters[ch3];
		
		myGroup = new Group(first,second,third);
		
		boolean keepPlaying; //check whether level passed and should keep going
		
		LevelReader reader = new LevelReader();
		
		
		//for each level load level
		for(int i = 0; i < levelNames.length; i++){                  //not sure how this is going to work exactly, but this is where the maps come in.
		
			
			 Level theLevel = reader.loadLevel(levelNames[i]);
			 GamePlay gmply = new GamePlay(myGroup, theLevel); 
			 keepPlaying = gmply.playLevel();
			 
			if(keepPlaying == false)
			{
				//you lost
				System.out.println("Unfortunately you have failed.");
				break;
			}
			
		}//end for
		
		System.out.println("You did great and passed the levels");
	}//end main	
	
	
}//end Game
