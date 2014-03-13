package useableitem;

import group.Action;
import group.ActionType;
import group.AttackWho;

public class RedBullFourPack implements Item {

	@Override
	public Action useItem() {
		return new Action(ActionType.HEAL, AttackWho.ALL, 50, 0);
	}

	@Override
	public String itemDescription() {
		return "Heal: All - 50HP";
	}

	@Override
	public String itemName() {
		return "Redbull 4 Pack";
	}

	@Override
	public String toString(){
		return "Redbull 4 Pack";
	}
	
}
