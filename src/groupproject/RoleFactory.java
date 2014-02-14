package groupproject;

public class RoleFactory {

	public Role createRole(String role){
	
		if(role.equalsIgnoreCase("Cheater"))
			return new Cheater();
		//if(role.equalsIgnoreCase("PALADIN"))
			//return new Paladin();
		else
			return null;//We would throw a custom exception here
		
	}
	
}
