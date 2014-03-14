package character;

import bosses.*;
import cs211.*;
import cs260.*;
import cs320.*;
import cs340.*;
import cs454.*;
import cs490.*;


public class CharacterFactory {

	public CharacterFactory() {
	}
		
	public Character createCharacter(String role){
			
		if(role.equalsIgnoreCase("Cheater"))
			return new Cheater();
		if(role.equalsIgnoreCase("Tutor"))
			return new Tutor();
		if(role.equalsIgnoreCase("Genius"))
			return new Genius();
		if(role.equalsIgnoreCase("Jock"))
			return new Jock();
		if(role.equalsIgnoreCase("Slacker"))
			return new Slacker();
		if(role.equalsIgnoreCase("Nerd"))
			return new Nerd();
		
		if(role.equalsIgnoreCase("InheritanceEnemy"))
			return new InheritanceEnemy();
		if(role.equalsIgnoreCase("LinkedListEnemy"))
			return new LinkedListEnemy();
		if(role.equalsIgnoreCase("RecursionEnemy"))
			return new RecursionEnemy();
		
		if(role.equalsIgnoreCase("RegisterEnemy"))
			return new RegisterEnemy();
		if(role.equalsIgnoreCase("TaskSwitcherEnemy"))
			return new TaskSwitcherEnemy();
		if(role.equalsIgnoreCase("VerilogEnemy"))
			return new VerilogEnemy();
		
		if(role.equalsIgnoreCase("BigOEnemy"))
			return new BigOEnemy();
		if(role.equalsIgnoreCase("BinaryTreeEnemy"))
			return new BinaryTreeEnemy();
		if(role.equalsIgnoreCase("DynamicProgrammingEnemy"))
			return new DynamicProgrammingEnemy();
		
		if(role.equalsIgnoreCase("KernelEnemy"))
			return new KernelEnemy();
		if(role.equalsIgnoreCase("PThreadEnemy"))
			return new PThreadEnemy();
		if(role.equalsIgnoreCase("ShellEnemy"))
			return new ShellEnemy();
		
		if(role.equalsIgnoreCase("CodeSmellEnemy"))
			return new CodeSmellEnemy();
		if(role.equalsIgnoreCase("DecoratorEnemy"))
			return new DecoratorEnemy();
		if(role.equalsIgnoreCase("RefactoringEnemy"))
			return new RefactoringEnemy();
		
		if(role.equalsIgnoreCase("AgileEnemy"))
			return new AgileEnemy();
		if(role.equalsIgnoreCase("SRSEnemy"))
			return new SRSEnemy();
		if(role.equalsIgnoreCase("SeniorItisEnemy"))
			return new SeniorItisEnemy();
		
		if(role.equalsIgnoreCase("Peters"))
			return new Peters();
		if(role.equalsIgnoreCase("Imamura"))
			return new Imamura();
		if(role.equalsIgnoreCase("Strongarm"))
			return new Strongarm();
		if(role.equalsIgnoreCase("Xu"))
			return new Xu();
		if(role.equalsIgnoreCase("Steiner"))
			return new Steiner();
		if(role.equalsIgnoreCase("Capual"))
			return new Capual();
		if(role.equalsIgnoreCase("Tappan"))
			return new Tappan();
		if(role.equalsIgnoreCase("SuperSteiner"))
			return new SuperSteiner();
		
		if(role.equalsIgnoreCase("JackintheBox"))
			return new JackintheBox();
		if(role.equalsIgnoreCase("Grader"))
			return new GraderMinion();
		
		
		
		else
			return null;//We would throw a custom exception here
			
	}
	

}
