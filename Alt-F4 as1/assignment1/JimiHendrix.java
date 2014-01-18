package assignment1;

public class JimiHendrix extends GameCharacter
{
	public JimiHendrix()
	{
		guitar = new FenderTelecaster();
		solo = new SetOnFire();
	}
	protected void displayName()
	{
		System.out.print("Jimi: ");
	}
}
