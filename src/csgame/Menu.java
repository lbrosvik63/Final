package csgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Menu {

	
	
	Image background = getImage("/data/mainpage.png"); 
	Image buttonstart = getImage("/data/startbutton.png");
	Image buttonexit = getImage("/data/exitbutton.png");
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 700);
		
		g.drawImage(background, 0, 50,null);
		
		g.drawImage(buttonstart, 75, 420, null);//primary attack
		g.drawImage(buttonexit, 75, 520, null);//secondary attack
		
	
		
	
	}
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}
	
}
