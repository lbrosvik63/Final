package csgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;


public class SlScreen {

	//Image itemFound = getImage("/data/item_found.png");
	Image l211 = getImage("/data/level211splash.png");
	Image l260 = getImage("/data/level260splash.png");
	Image l300 = getImage("/data/level300splash.png");
	Image l320 = getImage("/data/level320splash.png");
	Image l340 = getImage("/data/level340splash.png");
	Image l454 = getImage("/data/level454splash.png");
	Image l490 = getImage("/data/level490splash.png");
	
	Image fail = getImage("/data/failure.png");
	Image end = getImage("/data/endofgame.png");
	
	Image s211 = getImage("/data/story_211.png");
	Image s260 = getImage("/data/story_260.png");
	Image s300 = getImage("/data/story_300.png");
	Image s320 = getImage("/data/story_320.png");
	Image s340 = getImage("/data/story_340.png");
	Image s454 = getImage("/data/story_454.png");
	Image s490 = getImage("/data/story_490.png");
	
	Image m211 = getImage("/data/mom_211.png");
	Image m260 = getImage("/data/mom_260.png");
	Image m300 = getImage("/data/mom_300.png");
	//Image m320 = getImage("/data/mom_320.png");
	Image m340 = getImage("/data/mom_340.png");
	Image m454 = getImage("/data/mom_454.png");
	Image m490 = getImage("/data/mom_490.png");
	
	Image p211 = getImage("/data/professor_211.png");
	Image p260 = getImage("/data/professor_260.png");
	Image p300 = getImage("/data/professor_300.png");
//	Image p320 = getImage("/data/professor_320.png");
	Image p340 = getImage("/data/professor_340.png");
	Image p454 = getImage("/data/professor_454.png");
	Image p490 = getImage("/data/professor_490.png");
	
	

	public void render(Graphics g, int pictureNumber) {
		// TODO Auto-generated method stub
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 700);
		
		
		
//CSCD 211	
		if(pictureNumber == 0){
			g.drawImage(l211,0,0,null);
		}
		else if(pictureNumber == 1){
			g.drawImage(s211, 0, 0,null);
		}		
		else if(pictureNumber == 2){
			g.drawImage(m211, 0, 0,null);
			
		}else if(pictureNumber == 3){
			g.drawImage(p211, 0, 0,null);
		}
//CSCD260		
		else if(pictureNumber == 4){
			g.drawImage(l260,0,0,null);
		}
		else if(pictureNumber == 5){
			g.drawImage(s260, 0, 0,null);
		}		
		else if(pictureNumber == 6){
			g.drawImage(m260, 0, 0,null);
			
		}else if(pictureNumber == 7){
			g.drawImage(p260, 0, 0,null);
		}
//CSCD300		
		else if(pictureNumber == 8){
			g.drawImage(l300,0,0,null);
		}
		else if(pictureNumber == 9){
			g.drawImage(s300, 0, 0,null);
		}		
		else if(pictureNumber == 10){
			g.drawImage(m300, 0, 0,null);
			
		}else if(pictureNumber == 11){
			g.drawImage(p300, 0, 0,null);
		}
//CSCD320		
		else if(pictureNumber == 12){
			g.drawImage(l320,0,0,null);
		}
		else if(pictureNumber == 13){
			g.drawImage(s320, 0, 0,null);
		}		
		else if(pictureNumber == 14){
			g.drawImage(m340, 0, 0,null); //TODO: ADD and change to m320
			
		}else if(pictureNumber == 15){
			g.drawImage(p340, 0, 0,null); //TODO: ADD and change to p320
		}
//CSCD340		
		else if(pictureNumber == 16){
			g.drawImage(l340,0,0,null);
		}
		else if(pictureNumber == 17){
			g.drawImage(s340, 0, 0,null);
		}		
		else if(pictureNumber == 18){
			g.drawImage(m340, 0, 0,null);
			
		}else if(pictureNumber == 19){
			g.drawImage(p340, 0, 0,null);
		}
//CSCD454		
		else if(pictureNumber == 20){
			g.drawImage(l454,0,0,null);
		}
		else if(pictureNumber == 21){
			g.drawImage(s454, 0, 0,null);
		}		
		else if(pictureNumber == 22){
			g.drawImage(m454, 0, 0,null);
			
		}else if(pictureNumber == 23){
			g.drawImage(p454, 0, 0,null);
		}
//CSCD490		
		else if(pictureNumber == 24){
			g.drawImage(l490,0,0,null);
		}
		else if(pictureNumber == 25){
			g.drawImage(s490, 0, 0,null);
		}		
		else if(pictureNumber == 26){
			g.drawImage(m490, 0, 0,null);
			
		}else if(pictureNumber == 27){
			g.drawImage(p490, 0, 0,null);
		}
		
//FAIL		
	    else if(pictureNumber == 100){
			g.drawImage(fail, 0, 0,null);

		}
		else if(pictureNumber == 101){
			g.drawImage(end, 0, 0,null);
		}
	
	
	}//end render
	
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}

}