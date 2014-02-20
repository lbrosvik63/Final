package useableitem;

import group.Action;
import group.ActionType;
import group.AttackWho;

public class ReverseCompiler implements Item {

	@Override
	public Action useItem() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 10000, 0);
	}

	@Override
	public String itemDescription() {
		return "destroys one enemy";
	}

	@Override
	public String itemName() {
		return "reverse compiler";
	}

}
