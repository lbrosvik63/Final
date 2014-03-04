package csgame;

import group.Group;
import character.Character;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class BattleMenu {

	Background bg = new Background(0,0);
	Image background = getImage("/data/battlemenu.png"); 
	Image button = getImage("/data/blankbutton.png");
	
	
	private Rectangle attack1Button = new Rectangle(350, 200, 200, 50);
	private Rectangle attack2Button = new Rectangle(420, 250, 100, 50);
	private Rectangle attackRoleButton = new Rectangle(420, 350, 100, 50);
	
	
	
	public BattleMenu() {
		// TODO Auto-generated constructor stub
	}

	
	public void paint(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 700);
		
		g.drawImage(background, 75, 0,null);
		
		g.drawImage(button, 350, 125, null);
		g.drawImage(button, 350, 225, null);
		g.drawImage(button, 350, 325, null);
		g.drawImage(button, 350, 425, null);
		
		/*Font fnt0 = new Font("arial", Font.BOLD, 40);
		g.setFont(fnt0);
		g.setColor(Color.RED);
		g.drawString("Battle Menu", 150, 50);
		*/
		Group test1 = Game.battle.getGoodGuys();//TODO: error here null pointer
		ArrayList<Character> test2 = test1.getGroup();
		Character test3 = test2.get(0);
		
		//For each hero starting at coordinates (10,100)
		int x = 50, y = 175;
		for (int i = 0; i < Game.battle.getGoodGuys().getGroup().size(); i++) {

			int maxhealth = Game.battle.getGoodGuys().getGroup().get(i).getMaxHealthPoints();
			int curhealth = Game.battle.getGoodGuys().getGroup().get(i).getHealthPoints();
			String name = Game.battle.getGoodGuys().getGroup().get(i).toString();
			
			Font fnt0 = new Font("arial", Font.BOLD, 14);
			g.setFont(fnt0);
			g.setColor(Color.GREEN);
			g.drawString(name, x, y);
			
			y+=16;
			g.setColor(Color.GRAY);
			g.fillRect(x, y, maxhealth, 20);

			g.setColor(Color.GREEN);
			g.fillRect(x, y, curhealth, 15);

			g.setColor(Color.WHITE);
			g.drawRect(x, y, maxhealth, 15);

			y += 64;

		}

		// For each hero starting at coordinates (10,100)
		 x = 600; y = 175;
		for (int i = 0; i < Game.battle.getEnemies().getGroup().size(); i++) {

			int maxhealth = Game.battle.getEnemies().getGroup().get(i).getMaxHealthPoints();
			int curhealth = Game.battle.getEnemies().getGroup().get(i).getHealthPoints();
			String name = Game.battle.getEnemies().getGroup().get(i).toString();
			
			Font fnt0 = new Font("arial", Font.BOLD, 14);
			g.setFont(fnt0);
			g.setColor(Color.GREEN);
			g.drawString(name, x, y);
			
			y+=16;
			g.setColor(Color.GRAY);
			g.fillRect(x, y, maxhealth, 20);

			g.setColor(Color.GREEN);
			g.fillRect(x, y, curhealth, 15);

			g.setColor(Color.WHITE);
			g.drawRect(x, y, maxhealth, 15);

			y += 64;

		}
	
		
		//Drawing health bar (doesnt move with camera)
		/*g.setColor(Color.GRAY);
		g.fillRect(5, 5, 300, 25);
		
		g.setColor(Color.GREEN);
		g.fillRect(5, 5, health, 25);
		
		g.setColor(Color.WHITE);
		g.drawRect(5, 5, 300, 25);
		*/
		/*
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		
		g.drawString("Heroes", 1,90);
		g.drawString("Enemies", 200, 200);
		
		g.drawString("Attack 1", attack1Button.x + 19, attack1Button.y + 30);
		g2d.draw(attack1Button);
		g.drawString("Attack 2", attack2Button.x + 19, attack2Button.y + 30);
		g2d.draw(attack2Button);
		g.drawString("Role Attack", attackRoleButton.x + 19, attackRoleButton.y + 30);
		g2d.draw(attackRoleButton);
		*/
	}
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}
}
