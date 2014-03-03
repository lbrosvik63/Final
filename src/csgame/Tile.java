package csgame;

import java.awt.Image;
import java.awt.Rectangle;

public class Tile {

	private int tileX, tileY, speedX, type;//type = whether dirt tile or ocean tile
	public Image tileImage;
	private GroupGUI groupGUI = Game.groupGUI;
	//private Background bg = Game.getBg1();
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
		//if within 25 tiles surrounding character and not an empty tile
		if(r.intersects(groupGUI.yellowRed) && type !=0){//type 0 above == empty tile
			checkCollisions(groupGUI.rect);
			//checkVerticalCollision(Robot.rect,Robot.rect2);
			//checkSideCollision(Robot.rect3, Robot.rect4, Robot.footleft, Robot.footright);
		}
		
		//Was for layers of backgrounds
		
		/*if(type == 1){				//Ocen tile, slowly move in background
			if(bg.getSpeedX()==0){  // moves faster when scrolling
				speedX = -1;
			}else{
				speedX = -2;
			}
		} else {
			speedX = bg.getSpeedX()*5;
		}
		
		tileX += speedX;
	*/
	
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
	/*public Background getBg() {
		return bg;
	}
	public void setBg(Background bg) {
		this.bg = bg;
	}*/
	public void checkCollisions(Rectangle rect){//rect == our character
		if(rect.intersects(r) && type != 0){
			
			groupGUI.setSpeedY(0);
			
			if(r.getCenterX() - rect.getCenterX() > 0){ //On right
				groupGUI.setCenterY(tileY - 63);
			} else if(r.getCenterX() - rect.getCenterX() < 0){//On left
				groupGUI.setCenterY(tileY - 63);
			} else if(r.getCenterY() - rect.getCenterY() > 0){//on Down
				groupGUI.setCenterX(tileY - 63);
			} else if(r.getCenterY() - rect.getCenterY() < 0){//On Up
				groupGUI.setCenterX(tileY - 63);
			}
			
			
			
			
			
		}
	}
	
	
	/*
	public void checkVerticalCollision(Rectangle rtop, Rectangle rbot){
		if(rtop.intersects(r)){
			
		}
		if(rbot.intersects(r) && type == 8){
			robot.setJumped(false);
			robot.setSpeedY(0);
			robot.setCenterY(tileY - 63);
		}
	}
	
	public void checkSideCollision(Rectangle rleft, Rectangle rright, Rectangle leftfoot, Rectangle rightfoot){
		if(type != 5 && type !=2 && type !=0){
			if(rleft.intersects(r)){
				robot.setCenterX(tileX + 102);
				
				robot.setSpeedX(0);
			} else if(leftfoot.intersects(r)){
				robot.setCenterX(tileX + 85);
				robot.setSpeedX(0);
			}
			
			if(rright.intersects(r)){
				robot.setCenterX(tileX - 62);
				
				robot.setSpeedX(0);
			} else if(rightfoot.intersects(r)){
				robot.setCenterX(tileX - 45);
				robot.setSpeedX(0);
			}
		}
	}
*/
}
