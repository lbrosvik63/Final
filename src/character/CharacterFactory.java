package character;

import cs211.*;
import cs260.*;
import cs300.*;
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
		else
			return null;//We would throw a custom exception here
			
	}
	

}
