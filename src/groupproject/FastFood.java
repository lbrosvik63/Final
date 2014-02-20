package groupproject;

public class FastFood implements Item {

	@Override
	public Action useItem() {
		return new Action(ActionType.HEAL, AttackWho.ONE, 75, 0);
	}

	@Override
	public String itemDescription() {
		return "motivates one student to study harder\n";
	}

	@Override
	public String itemName() {
		return "fast food";
	}

}
