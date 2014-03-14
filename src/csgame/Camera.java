package csgame;

import group.HeroGroup;

public class Camera {

	private float x, y;
	
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void tick(HeroGroup groupGUI, int width, int height,int tileRows, int tileColumns){
		int characterCenterX = groupGUI.getCenterX();
		int characterCenterY = groupGUI.getCenterY();
		
		if(characterCenterX <= 416){
			x = 0;
		} else if(characterCenterX >= tileColumns*64 - width/2){//Tile[] columns * 64pixels - 1/2 width of Viewing Frame
			x = width - tileColumns * 64;
		} 
		else{
			x = - groupGUI.getCenterX() + width / 2 ;
		}
		if(characterCenterY <= 416){
			y = 0;
		} else if(characterCenterY >= (tileRows*62 + 62)- height/2){//for height must adjust for less viewable area on top & bottom
			y = -80 + height - tileRows * 62;
		}
		else{
			y = - groupGUI.getCenterY() + height / 2;
		}
		
	}
	
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}
