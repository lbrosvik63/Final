//luke
package assignment1;

public abstract class GameCharacter 
{
	Guitar guitar;
	Solo solo;
	
	public GameCharacter()
	{

	}
	
	public void useGuitar()
	{
		displayName();
		guitar.playGuitar();
	}
	
	public void performSolo()
	{
		displayName();
		solo.playSolo();
	}
	public void setGuitar(Guitar newGuitar)
	{
		displayName();
		guitar = newGuitar;
		guitar.displayGuitar();
	}
	public void setSolo(Solo newSolo)
	{
		displayName();
		solo = newSolo;
		solo.displaySolo();
	}
	protected abstract void displayName();

}

