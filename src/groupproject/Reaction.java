package groupproject;

public class Reaction {
	private Enum hitOrMiss;
	private int damageDone;
	
	public Reaction(Enum hitOrMiss, int damageDone)
	{
		this.hitOrMiss = hitOrMiss;
		this.damageDone = damageDone;
	}
	public Enum getHitOrMiss()
	{
		return this.hitOrMiss;
	}
	public int getDamageDone()
	{
		return this.damageDone;
	}

}
