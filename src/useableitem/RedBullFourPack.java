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
		return "allows a student to study longer before falling asleep\n";
	}

	@Override
	public String itemName() {
		return "red bull four pack";
	}

	@Override
	public String toString(){
		return "red bull four pack";
	}
	
}
