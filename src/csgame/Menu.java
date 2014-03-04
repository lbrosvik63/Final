package csgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {

	//private Rectangle playButton = new Rectangle(StartingClass.WIDTH /2 + 320, 150, 100, 50);
	//private Rectangle helpButton = new Rectangle(StartingClass.WIDTH /2 + 320, 250, 100, 50);
	//private Rectangle quitButton = new Rectangle(StartingClass.WIDTH /2 + 320, 350, 100, 50);
	private Rectangle playButton = new Rectangle(Game.WIDTH /2 - 50, 150, 100, 50);
	private Rectangle helpButton = new Rectangle(Game.WIDTH /2 -50, 250, 100, 50);
	private Rectangle quitButton = new Rectangle(Game.WIDTH /2 -50, 350, 100, 50);
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.RED);
		g.drawString("Escape from Comp. Sci.", Game.WIDTH /2 -275, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 19, playButton.y + 30);
		g2d.draw(playButton);
		g.drawString("Help", helpButton.x + 19, helpButton.y + 30);
		g2d.draw(helpButton);
		g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
		g2d.draw(quitButton);
	}
}