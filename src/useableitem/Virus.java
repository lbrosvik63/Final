package useableitem;

import group.Action;
import group.ActionType;
import group.AttackWho;

public class Virus implements Item {

	@Override
	public Action useItem() {
		return new Action(ActionType.DAMAGE, AttackWho.ONE, 200, 10);
	}

	@Override
	public String itemDescription() {
		return "Attack: One - 200HP";
	}

	@Override
	public String itemName() {
		return "virus";
	}

	@Override
	public String toString(){
		return "Virus";
	}
}
