package groupproject;


public class RoleFactory {

	public Role createRole(String role){
	
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
		else
			return null;//We would throw a custom exception here
		
	}
	
}
