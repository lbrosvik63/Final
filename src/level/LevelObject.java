package level;

import useableitem.Coffee;
import useableitem.FastFood;
import useableitem.Item;
import useableitem.RedBullFourPack;
import useableitem.Redbull;
import useableitem.ReverseCompiler;
import useableitem.SnowDay;
import useableitem.Virus;
import group.Group;


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

	
	public void setItems(String string) {
		// TODO Auto-generated method stub
		if(string.equalsIgnoreCase("Coffee"))
			this.item = new Coffee();
		
		if(string.equalsIgnoreCase("FastFood"))
			this.item = new FastFood();
		
		if(string.equalsIgnoreCase("RedBull"))
			this.item = new Redbull();
		
		if(string.equalsIgnoreCase("RedBullFourPack"))
			this.item = new RedBullFourPack();
		
		if(string.equalsIgnoreCase("ReverseCompiler"))
			this.item = new ReverseCompiler();
		
		if(string.equalsIgnoreCase("SnowDay"))
			this.item = new SnowDay();
		
		if(string.equalsIgnoreCase("Virus"))
			this.item = new Virus();
		
	}//end setItem(string)
}
