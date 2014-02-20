package weapons;

import useableitem.Item;
import group.Action;
import group.ActionType;
import group.AttackWho;

public class PoisenedApple implements Item {

	@Override
	public Action useItem() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 100, 0);
	}

	@Override
	public String itemDescription() {
		return "poisens the teacher";
	}

	@Override
	public String itemName() {
		return "poisened apple";
	}

}
