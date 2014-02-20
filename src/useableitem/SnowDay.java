package useableitem;

import group.Action;
import group.ActionType;
import group.AttackWho;

public class SnowDay implements Item {

	@Override
	public Action useItem() {
		return new Action(ActionType.DAMAGE, AttackWho.ALL, 10000, 0);
	}

	@Override
	public String itemDescription() {
		return "ends class early, destroys all enemies";
	}

	@Override
	public String itemName() {
		return "snow day";
	}

}
