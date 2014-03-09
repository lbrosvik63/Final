package useableitem;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;


public class ItemFound {

	Image itemFound = getImage("/data/item_found.png");
	Image keyFound = getImage("/data/key_found.png");
	

	public void render(Graphics g, String item) {
		// TODO Auto-generated method stub
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 700);
		
		if(item.equalsIgnoreCase("Key")){
			g.drawImage(keyFound,0,0,null);
		}else{
			g.drawImage(itemFound, 0, 0,null);
		}
		
	
	}
	
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}

}














