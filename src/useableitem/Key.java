package useableitem;

import group.Action;



public class Key implements Item {

	public String toString(){
		return "Key";
	}

	@Override
	public Action useItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String itemDescription() {
		// TODO Auto-generated method stub
		return "Unlocks Door";
	}

	@Override
	public String itemName() {
		// TODO Auto-generated method stub
		return null;
	}
}
