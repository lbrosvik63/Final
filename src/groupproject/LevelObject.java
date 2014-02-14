package groupproject;


public class LevelObject {
	
	private Group badGuys;
	private Item item;
	private boolean isDoor;
	private boolean isWall;
	
	public LevelObject() {
		isWall = false;
		isDoor = false;
	}
	
	public LevelObject(Group group){
		badGuys = group;
		isDoor = false;
	}
	
	public LevelObject(Item itm){
		item = itm;
		isDoor = false;
	}
	
	public LevelObject(Group group, Item itm){
		badGuys = group;
		item = itm;
		isDoor = false;
	}
	


	public Group getBadGuys() {
		return badGuys;
	}

	public void setBadGuys(Group badGuys) {
		this.badGuys = badGuys;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isDoor() {
		return isDoor;
	}

	public void setDoor(boolean isDoor) {
		this.isDoor = isDoor;
	}

	public boolean isWall() {
		return isWall;
	}

	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}

	public boolean hasGroup(){
		if(badGuys == null)
			return false;
		return true;
	}
	
	public boolean hasItem(){
		if(item == null)
			return false;
		return true;
	}
}
