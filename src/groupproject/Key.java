package groupproject;

public class Key implements Item {

	public String itemName(){
		return "Key";
	}

	@Override
	public Action useItem() { //hopefully this doesn't screw up how the keys works, and maybe we will want to rework how the key works???
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String itemDescription() {
		return "Opens a door";
	}
}
