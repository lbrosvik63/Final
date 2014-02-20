package useableitem;

import group.Action;
import group.ActionType;
import group.AttackWho;

public class Coffee implements Item {

	@Override
	public Action useItem() {
		return new Action(ActionType.HEAL, AttackWho.ONE, 125, 0);
	}

	@Override
	public String itemDescription() {
		return "lets student study longer";
	}

	@Override
	public String itemName() {
		return "coffee";
	}

}
