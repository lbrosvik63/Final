package csgame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;


public class SlScreen {

	//Image itemFound = getImage("/data/item_found.png");
	Image level211 = getImage("/data/level211splash.png");
	Image level260 = getImage("/data/level260splash.png");
	Image level300 = getImage("/data/level300splash.png");
	Image level320 = getImage("/data/level320splash.png");
	Image level340 = getImage("/data/level340splash.png");
	Image level454 = getImage("/data/level454splash.png");
	Image level490 = getImage("/data/level490splash.png");
	Image fail = getImage("/data/failure.png");
	Image end = getImage("/data/endofgame.png");
	

	public void render(Graphics g, int pictureNumber) {
		// TODO Auto-generated method stub
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 700);
		
		
		
		
		if(pictureNumber == 0){
			g.drawImage(level211,0,0,null);
		}
		else if(pictureNumber == 1){
			g.drawImage(level260, 0, 0,null);
		}
		else if(pictureNumber == 2){
			g.drawImage(level300, 0, 0,null);
		}
		else if(pictureNumber == 3){
			g.drawImage(level320, 0, 0,null);
		}
		else if(pictureNumber == 4){
			g.drawImage(level340, 0, 0,null);
		}
		else if(pictureNumber == 5){
			g.drawImage(level454, 0, 0,null);
		}
		else if(pictureNumber == 6){
			g.drawImage(level490, 0, 0,null);
		}
		else if(pictureNumber == 7){
			
		}
		else if(pictureNumber == 8){
			
		}
		else if(pictureNumber == 9){
			
		}
		else if(pictureNumber == 100){
			g.drawImage(fail, 0, 0,null);

		}
		else if(pictureNumber == 101){
			g.drawImage(end, 0, 0,null);
		}
	
	
	}
	
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}

}