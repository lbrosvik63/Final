package groupproject;

/*
 * The point of this class is to create an object that will tell the battle object the intent 
 * of the action. The battle needs to know whether the action is intended to be damage towards
 * an enemy player or if it should heal a fellow group member. 
 */
public class Action {
	private Enum action;//AttackWho.ONE, AttackWho.TWO, or AttackWho.ALL
	private Enum healOrHurt;//ActionType.HEAL or ActionType.DAMAGE
	private int actionValue;//damage or healing done

	public Action(Enum action, Enum healOrHurt, int actionValue)
	{
		this.action = action;
		this.healOrHurt = healOrHurt;
		this.actionValue = actionValue;
	}
	public Enum getAction()
	{
		return this.action;
	}
	public Enum getHealOrHurt()
	{
		return this.healOrHurt;
	}
	public int getActionValue()
	{
		return this.actionValue;
	}
	public String toString()
	{
		return "action: " + action + "\nactionValue: " + actionValue + "\nheal or hurt? " + healOrHurt;
	}

}
