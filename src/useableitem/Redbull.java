package useableitem;

import group.Action;
import group.ActionType;
import group.AttackWho;

public class Redbull implements Item {

	@Override
	public Action useItem() {
		return new Action(ActionType.HEAL, AttackWho.ONE, 100, 0);
	}

	@Override
	public String itemDescription() {
		return "Heal: One - 100HP";
	}

	@Override
	public String itemName() {
		return "redbull";
	}

	@Override
	public String toString(){
		return "Redbull";
	}
	
	
}
