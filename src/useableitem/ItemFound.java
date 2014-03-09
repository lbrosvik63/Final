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

	//Image itemFound = getImage("/data/item_found.png");
	Image keyFound = getImage("/data/key_found.png");
	Image snowDay = getImage("/data/snowday_item.png");
	Image virus = getImage("/data/virus_item.png");
	Image redbull = getImage("/data/redbull_item.png");
	Image redbull4pack = getImage("/data/redbull4pack_item.png");
	Image reverseCompiler = getImage("/data/reversecompiler_item.png");
	Image poisenedapple = getImage("/data/poisenedapple_item.png");
	Image coffee = getImage("/data/coffee_found.png");
	Image fastfood = getImage("/data/fastfood_item.png");
	

	public void render(Graphics g, String item) {
		// TODO Auto-generated method stub
		
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 700);
		
		if(item.equalsIgnoreCase("Key")){
			g.drawImage(keyFound,0,0,null);
		}else if(item.equalsIgnoreCase("snow day")){
			g.drawImage(snowDay, 0, 0,null);
		}else if(item.equalsIgnoreCase("virus")){
			g.drawImage(virus, 0, 0,null);
		}else if(item.equalsIgnoreCase("redbull")){
			g.drawImage(redbull, 0, 0,null);
		}else if(item.equalsIgnoreCase("red bull four pack")){
			g.drawImage(redbull4pack, 0, 0,null);
		}else if(item.equalsIgnoreCase("reverse compiler")){
			g.drawImage(reverseCompiler, 0, 0,null);
		}else if(item.equalsIgnoreCase("poisened apple")){
			g.drawImage(poisenedapple, 0, 0,null);
		}else if(item.equalsIgnoreCase("coffee")){
			g.drawImage(coffee, 0, 0,null);
		}else if(item.equalsIgnoreCase("fast food")){
			g.drawImage(fastfood, 0, 0,null);
		}
		
		
	
	}
	
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}

}
