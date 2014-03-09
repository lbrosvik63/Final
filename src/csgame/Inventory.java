package csgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import useableitem.Item;
import weapons.Weapon;

public class Inventory {

	
	/*
	private Rectangle playButton = new Rectangle(151, 260, 140, 145);
	private Rectangle helpButton = new Rectangle(600, 260, 140, 145);
	private Rectangle quitButton = new Rectangle(378, 262, 140, 145);
	private Rectangle quit2Button = new Rectangle(151, 508, 140, 145);
	private Rectangle quit3Button = new Rectangle(378, 508, 140, 145);
	private Rectangle quit4Button = new Rectangle(600, 508, 140, 145);
	*/
	private Item selectedItem;
	private Weapon selectedWeapon;
	
	private Image tempImage;
	
	private int curItemPos = 0;
	private int curWeaponPos = 0;
	
	
	Image background = getImage("/data/inventory.png"); 
	Image poisonedapple = getImage("/data/poisenedapple_small.png");
	Image coffee = getImage("/data/coffee_small.png");
	Image redbull = getImage("/data/redbull_small.png");
	Image redbull4pack = getImage("/data/redbull4pack_small.png");
	Image fastfood = getImage("/data/fastfood_small.png");
	Image reversecompiler = getImage("/data/reversecompiler_small.png");
	Image snowday = getImage("/data/snowday_small.jpg");
	Image virus = getImage("/data/virus_small.png");
	Image key = getImage("/data/key_small.png");
	
	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}

	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 700);
		g.drawImage(background, 0, 0,null);
	
		renderItems(g);
		renderWeapons(g);
	/*	g2d.setColor(Color.WHITE);
		g2d.draw(playButton);
		g2d.draw(helpButton);
		g2d.draw(quitButton);
		g2d.draw(quit2Button);
		g2d.draw(quit3Button);
		g2d.draw(quit4Button);
		*/
	}
	
	
	public void renderItems(Graphics g){
		int tempX = 190;
		int tempY = 280;
		int tempPos = curItemPos;
		Item tempItem;
		for(int i = 0; i < 3; i++){
			if(tempPos < Game.group.getInventory().size()){//within bounds of arraylist
				tempItem = Game.group.getInventory().get(tempPos);
				assignImage(tempItem);
				g.drawImage(tempImage, tempX, tempY, null);//primary attack
				Font fnt0 = new Font("arial", Font.BOLD, 14);
				g.setFont(fnt0);
				g.setColor(Color.WHITE);
				g.drawString(tempItem.toString(), tempX, tempY + 80);
				tempPos ++;
			}
			tempX += 224;
		}
	}

	public void renderWeapons(Graphics g) {
		int tempX = 190;
		int tempY = 530;
		int tempPos = curWeaponPos;
		Weapon tempWeapon;
		for(int i = 0; i < 3; i++){
			if(tempPos < Game.group.getWeapons().size()){//within bounds of arraylist
				tempWeapon = Game.group.getWeapons().get(tempPos);
				assignImage(tempWeapon);
				g.drawImage(tempImage, tempX, tempY, null);//primary attack
				tempPos ++;
			}
			tempX += 224;
		}
	}
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}
	
	private void assignImage(Item item){
		if(item.toString().equalsIgnoreCase("Coffee"))
			tempImage = coffee;
		else if(item.toString().equalsIgnoreCase("Fast Food"))
			tempImage = fastfood;
		else if(item.toString().equalsIgnoreCase("Poisoned Apple"))
			tempImage = poisonedapple;
		else if(item.toString().equalsIgnoreCase("Redbull"))
			tempImage = redbull;
		else if(item.toString().equalsIgnoreCase("RedBull 4 Pack"))
			tempImage = redbull4pack;
		else if(item.toString().equalsIgnoreCase("Reverse Compiler"))
			tempImage = reversecompiler;
		else if(item.toString().equalsIgnoreCase("Snow Day"))
			tempImage = snowday;
		else if(item.toString().equalsIgnoreCase("Virus"))
			tempImage = virus;
		else if(item.toString().equalsIgnoreCase("Key"))
			tempImage = key;
		
	}
	
	private void assignImage(Weapon item){
		if(item.toString().equalsIgnoreCase("Coffee"))
			tempImage = coffee;
		else if(item.toString().equalsIgnoreCase("Fast Food"))
			tempImage = fastfood;
		else if(item.toString().equalsIgnoreCase("Poisoned Apple"))
			tempImage = poisonedapple;
		else if(item.toString().equalsIgnoreCase("Redbull"))
			tempImage = redbull;
		else if(item.toString().equalsIgnoreCase("Redbull 4 Pack"))
			tempImage = redbull4pack;
		else if(item.toString().equalsIgnoreCase("Reverse Compiler"))
			tempImage = reversecompiler;
		else if(item.toString().equalsIgnoreCase("Snow Day"))
			tempImage = snowday;
		else if(item.toString().equalsIgnoreCase("Virus"))
			tempImage = virus;
		
	}
	
	public void itemsScrollLeft() {
		curItemPos -= 3;
		if(curItemPos < 0)
			curItemPos = 0;
	}

	public void itemsScrollRight() {
		curItemPos +=3;
		if(curItemPos > Game.group.getInventory().size() -1){
			curItemPos = Game.group.getInventory().size() - 3;
			if(curItemPos < 0)
				curItemPos = 0;
		}
	}

	public void weaponsScrollLeft() {
		curWeaponPos -= 3;
		if(curWeaponPos < 0)
			curWeaponPos = 0;
	}

	public void weaponsScrollRight() {
		curWeaponPos +=3;
		if(curWeaponPos > Game.group.getWeapons().size() -1){
			curWeaponPos = Game.group.getWeapons().size() - 3;
			if(curWeaponPos < 0)
				curWeaponPos = 0;
		}
	}
	
	public void selectItem(int pos){
		System.out.println("Item: "+ pos + " selected");
	}
	
	public void selectWeapon(int pos){
		System.out.println("Weapon: "+ pos + " selected");
	}
	
	public void selectCharacter(int pos){
		
	}
}
