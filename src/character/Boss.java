package character;

import group.Action;
import group.ActionType;
import group.AttackWho;
/*
 * All Bosses have a heal attack. 25% Miss chance
 */
public abstract class Boss extends Character {

	private final int MAXHEALVALUE = 50;
	private final int MINHEALVALUE= 25;
	
	public Boss() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Action primaryAttack();

	@Override
	public abstract Action secondaryAttack() ;

	@Override
	public Action roleAttack() {
		int value = generateAttackValue(MINHEALVALUE, MAXHEALVALUE);
		System.out.println(this + " Heals");
		// TODO Auto-generated method stub
		return new Action(ActionType.HEAL, AttackWho.ONE, value, 25);
	}

}
