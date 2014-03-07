package csgame;

import group.HeroGroup;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import character.Character;
import character.Cheater;
import character.Genius;
import character.Jock;
import character.Nerd;
import character.Slacker;
import character.Tutor;
import csgame.Game.STATE;

public class CharacterSelection {

	private ArrayList<String> list = new ArrayList<String>();
	ArrayList<Character> herolist = new ArrayList<Character>();
	
	
	Character nerd1 = new Nerd();
	Character cheater1 = new Cheater();
	Character genius1 = new Genius();
	Character jock1 = new Jock();
	Character slacker1 = new Slacker();
	Character tutor1 = new Tutor();
	
	Image background = getImage("/data/selectcharacters.png");
	Image cheater = getImage("/data/cheater.jpg"); 
	Image genius = getImage("/data/genius.jpg");
	Image jock = getImage("/data/jock.png"); 
	Image nerd = getImage("/data/nerd.jpg");
	Image slacker = getImage("/data/slacker.png"); 
	Image tutor = getImage("/data/tutor.jpg");
	
	public CharacterSelection() {
		// TODO Auto-generated constructor stub
		herolist.add(cheater1);
		herolist.add(genius1);
		herolist.add(jock1);
		herolist.add(nerd1);
		herolist.add(slacker1);
		herolist.add(tutor1);
		
	}

	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 700);
		
		g.drawImage(background, 0, 0,null);
		
		g.drawImage(cheater, 75, 200, null);
		g.drawImage(genius, 75, 325, null);
		g.drawImage(jock, 75, 450, null);
		g.drawImage(nerd, 475, 200, null);
		g.drawImage(slacker, 475, 325, null);
		g.drawImage(tutor, 475, 450, null);
		
		printStats(g);
	
		
		

		
		
		
		
		/*
		if(battlestate == BATTLESTATE.HEROTURN){
			Font fnt0 = new Font("arial", Font.BOLD, 20);
			g.setFont(fnt0);
			g.setColor(Color.WHITE);
			g.drawString(selectedCharacter.getPriAtkName(), 375, 170);
			g.drawString(selectedCharacter.getScdAtkName(), 375, 270);
			g.drawString(selectedCharacter.getRolAtkName(), 375, 370);
			g.drawString("Use " + selectedCharacter.getWeapon().toString(), 375, 470);
			
		}
		*/
	}
	
	private void printStats(Graphics g){
		int x = 175;
		int y = 215;
		for(int i=0; i<3;i++){
			int maxhealth = herolist.get(i).getMaxHealthPoints();
			int speed = herolist.get(i).getSpeed();
			String name = herolist.get(i).toString();
			
			Font fnt0 = new Font("arial", Font.BOLD, 18);
			g.setFont(fnt0);
			g.setColor(Color.GREEN);
			g.drawString(name, x, y);
			
			fnt0 = new Font("arial", Font.BOLD, 14);
			g.setFont(fnt0);
			
			y+=16;
			g.drawString(" - HP: " + maxhealth, x, y);
			y+=16;
			g.drawString(" - Speed: " + speed, x, y);

			y += 96;
			
		}
		
		x = 575;
		y = 215;
		for(int i=3; i<herolist.size();i++){
			int maxhealth = herolist.get(i).getMaxHealthPoints();
			int speed = herolist.get(i).getSpeed();
			String name = herolist.get(i).toString();
			
			Font fnt0 = new Font("arial", Font.BOLD, 18);
			g.setFont(fnt0);
			g.setColor(Color.GREEN);
			g.drawString(name, x, y);
			
			fnt0 = new Font("arial", Font.BOLD, 14);
			g.setFont(fnt0);
			
			y+=16;
			g.drawString(" - HP: " + maxhealth, x, y);
			y+=16;
			g.drawString(" - Speed: " + speed, x, y);

			y += 96;
			
		}
	}
	
	public void addCharacter(String character){
		list.add(character);
		if(list.size() == 3){
			Game.group = new HeroGroup(list.get(0),list.get(1),list.get(2));
			//Insert CS211 Splash here
			Game.state = STATE.FINISHEDSELECT;
		}
	}
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}
}

