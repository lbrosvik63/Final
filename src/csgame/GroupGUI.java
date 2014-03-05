package csgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GroupGUI {

		private boolean hasKey = false;
	
		//Constants
		
		//final int MOVESPEED = 5;
		
		
	

		private int centerX = 96;
		private int centerY = 96;
		private int row = (centerY - 32)/64; //used to determine position on array[][] map
	

		private int column = (centerX - 32)/64;
		
		private boolean movingUp = false;
		private boolean movingDown = false;
		
		private boolean movingLeft = false;
		private boolean movingRight = false;
		
			//private static Background bg1 = StartingClass.getBg1();
			//private static Background bg2 = StartingClass.getBg2();

		private int speedX = 0;
		private int speedY = 0;
		
		public static Rectangle rect = new Rectangle(0,0,0,0);
		public static Rectangle rect2 = new Rectangle(0,0,0,0);
		public static Rectangle rect3 = new Rectangle(0,0,0,0);//left hand
		public static Rectangle rect4 = new Rectangle(0,0,0,0);//right hand
		public static Rectangle yellowRed = new Rectangle(0,0,0,0);//Makes 5x5 rectangle around character
		//so only check for collision in those 25 squares
		public static Rectangle footleft = new Rectangle(0,0,0,0);//check for collisions with tiles 
		public static Rectangle footright = new Rectangle(0,0,0,0);//shorter than the arm
		
		private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

		public GroupGUI(){
			
		}
		
		
		public void update() {

			// Moves Character or Scrolls Background accordingly.
			if (speedX < 0) {
				centerX += speedX;
				column = (centerX - 32)/64;
			} 
	
			centerX += speedX;
			column = (centerX - 32)/64;
			// Updates Y Position
			centerY += speedY;
			row = (centerY - 32)/64;
			

			
			
			rect.setRect(centerX - 32, centerY - 32, 64, 64);
		
		} 

		public int getCenterX() {
			return centerX;
		}

		public void setCenterX(int centerX) {
			this.centerX = centerX;
		}

		public int getCenterY() {
			return centerY;
		}

		public void setCenterY(int centerY) {
			this.centerY = centerY;
		}

	

		public int getSpeedX() {
			return speedX;
		}

		public void setSpeedX(int speedX) {
			this.speedX = speedX;
		}

		public int getSpeedY() {
			return speedY;
		}

		public void setSpeedY(int speedY) {
			this.speedY = speedY;
		}
		
		
		
		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}

		public boolean getHasKey() {
			return hasKey;
		}


		public void setHasKey(boolean hasKey) {
			this.hasKey = hasKey;
		}
		

		public void moveDown() {
			//speedY = MOVESPEED;
			centerY += 64;
			row = (centerY - 32)/64;
		}

		public void moveUp() {
			//speedY = -MOVESPEED;
			centerY -= 64;
			row = (centerY - 32)/64;
		}
		
		public void moveRight() {
			//speedX = MOVESPEED;
			centerX += 64;
			column = (centerX - 32)/64;
		}

		public void moveLeft() {
			//speedX = -MOVESPEED;
			centerX -= 64;
			column = (centerX - 32)/64;
		}

		public void stopDown(){
			//setMovingDown(false);
			//stop();
		}
		
		public void stopUp(){
			//setMovingUp(false);
			//stop();
		}
		
		public void stopRight(){
			//setMovingRight(false);
			//stop();
		}
		
		public void stopLeft(){
			//setMovingLeft(false);
			//stop();
		}
		/*
		public void stop() {
			if(isMovingRight() == false && isMovingRight() == false && 
					isMovingUp() == false && isMovingDown() == false){//stationary
				speedX = 0;
				speedY = 0;
			}
			
			if(isMovingRight() == false && isMovingRight() == true  && 
					isMovingUp() == false && isMovingDown() == false){//moving left
				moveLeft();
			}
			
			if(isMovingRight() == true && isMovingRight() == false  && 
					isMovingUp() == false && isMovingDown() == false){//moving right
				moveRight();
			}
			
			if(isMovingRight() == false && isMovingRight() == false  && 
					isMovingUp() == true && isMovingDown() == false){//moving up
				moveUp();
			}
			
			if(isMovingRight() == false && isMovingRight() == false  && 
					isMovingUp() == false && isMovingDown() == true){//moving Down
				moveDown();
			}
			
		}*/
		
		
		

		public boolean isMovingRight() {
			return movingRight;
		}
		
		public void setMovingRight(boolean moving){
			this.movingRight = moving;
		}
		
		public boolean isMovingLeft() {
			return movingLeft;
		}
		
		public void setMovingLeft(boolean moving){
			this.movingLeft = moving;
		}

		

		public void setMovingDown(boolean b) {
			movingDown = b;
			
		}

		

		public void setMovingUp(boolean b) {
			movingUp = b;
			
		}

		public boolean isMovingUp() {
			return movingUp;
		}

		public boolean isMovingDown() {
			return movingDown;
		}
		
		public Image getPlayerImage(){
			ImageIcon i = new ImageIcon(getClass().getResource("/data/heroes.png"));
			return i.getImage();
		}
		
		public void render(Graphics g) {
			g.drawImage(getPlayerImage(), centerX -32, centerY -32, null);
			
		}
}
