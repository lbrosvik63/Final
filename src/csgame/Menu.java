package csgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Menu {

	
	
	Image background = getImage("/data/mainpage.png"); 
	Image buttonstart = getImage("/data/startbutton.png");
	Image buttonexit = getImage("/data/exitbutton.png");
	
	public Menu() {
	}

	
	public void render(Graphics g){
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
