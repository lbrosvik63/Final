package csgame;


import java.awt.Image;
import java.awt.Rectangle;

public class Tile {

	private int tileX, tileY, speedX, type;//type = whether dirt tile or ocean tile
	public Image tileImage;
	private Rectangle r;
	
	public Tile(int x, int y, int typeInt) {
		
		tileX = x*64;		//40x40 pixels tiles
		tileY = y*64;		//Ex: (1,0) will be (40,0)
	
		type = typeInt;
		
		r = new Rectangle();
		
		if(type == 1){
			tileImage = Game.wall;
		}else if(type == 0) {
			tileImage = Game.grass;
		}else if(type == 2){
			tileImage = Game.grassitem;
		}else if(type == 3) {
			tileImage = Game.doorLocked;
		} 

	}
	//Check out Parallax Scrolling
	public void update(){
		
		//speedX = bg.getSpeedX() * 5;
		tileX += speedX;
		r.setBounds(tileX, tileY, 64, 64);
	
	}
	
	public int getTileX() {
		return tileX;
	}
	public void setTileX(int tileX) {
		this.tileX = tileX;
	}
	public int getTileY() {
		return tileY;
	}
	public void setTileY(int tileY) {
		this.tileY = tileY;
	}
	public int getSpeedX() {
		return speedX;
	}
	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Image getTileImage() {
		return tileImage;
	}
	public void setTileImage(Image tileImage) {
		this.tileImage = tileImage;
	}

}
