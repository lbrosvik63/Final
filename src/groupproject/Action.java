package groupproject;
//NOTE: CHANGED Action.action to Action.target
//		CHANGED target & healOrHurt types from Enum to AttackWho & ActionType respectively
// (you can erase notes once you've read them)


/*
 * The point of this class is to create an object that will tell the battle object the intent 
 * of the action. The battle needs to know whether the action is intended to be damage towards
 * an enemy player or if it should heal a fellow group member. 
 */
public class Action {
	private AttackWho target;//AttackWho.ONE, AttackWho.TWO, or AttackWho.ALL
	private ActionType healOrHurt;//ActionType.HEAL or ActionType.DAMAGE
	private int actionValue;//damage or healing done
	private int failChancePercent;//1 is 1

	public Action(ActionType healOrHurt, AttackWho target, int actionValue, int failChancePercent)
	{
		this.target = target;
		this.healOrHurt = healOrHurt;
		this.actionValue = actionValue;
		this.failChancePercent = failChancePercent;
	}
	public AttackWho getTarget()
	{
		return this.target;
	}
	public ActionType getHealOrHurt()
	{
		return this.healOrHurt;
	}
	public int getActionValue()
	{
		return this.actionValue;
	}
	public void setActionValue(int action)
	{
		this.actionValue = action;
	}
	public void addFailChancePercent(int failChance)
	{
		this.failChancePercent = failChancePercent + failChance;
	}
	public int getFailChancePercent()
	{
		return this.failChancePercent;
	}
	public String toString()
	{
		return "action: " + target + "\nactionValue: " + actionValue + "\nheal or hurt? " + healOrHurt;
	}

}
