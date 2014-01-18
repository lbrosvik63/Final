package assignment1;

public class Slash extends GameCharacter
{
	public Slash()
	{
		guitar = new GibsonFlyingV();
		solo = new SmashGuitar();
	}
	protected void displayName()
	{
		System.out.print("Slash: ");
	}
}
