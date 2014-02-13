package groupproject;

public class CharacterFactory {

	public Character createCharacter(String character){
	
		if(character.equalsIgnoreCase("WARRIOR"))
			return new Warrior();
		if(character.equalsIgnoreCase("PALADIN"))
			return new Paladin();
		else
			return null;//We would throw a custom exception here
		
	}
	
}
