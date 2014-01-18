package assignment1;

public class AngusYoung extends GameCharacter
{
	public AngusYoung()
	{	
		guitar = new GibsonSG();
		solo = new JumpOffStage();
	}
	protected void displayName()
	{
		System.out.print("Angus: ");
	}
}
