package csgame;

import java.awt.Color;
import java.awt.Font;
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
		
		Font fnt0 = new Font("arial", Font.BOLD, 25);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		g.drawString("Press i for Instructions" , 50, 625);
		
	
	}
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}
	
}
