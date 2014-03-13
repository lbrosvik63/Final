package csgame;

import group.HeroGroup;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import useableitem.Item;
import useableitem.Key;
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
	private Key keyObject = new Key();
	private int curItemPos = 0;
	private int curWeaponPos = 0;
	
	private HeroGroup group = Game.group;
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
	
		
		
		renderGroup(g);
		renderItems(g);
		renderWeapons(g);
	
	}
	
	public void renderGroup(Graphics g){
		Font fnt0 = new Font("arial", Font.BOLD, 20);
		g.setFont(fnt0);
		g.setColor(Color.WHITE);
		int x1 = 20;
		int y1 = 40;
		for(int i = 0; i<group.getGroup().size(); i ++){
			g.drawString(i+1 + ". " + group.getGroup().get(i) , x1, y1);
			y1 += 30;
		}
		
		
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
				Font fnt1 = new Font("arial", Font.BOLD, 10);
				g.setFont(fnt1);
				g.setColor(Color.WHITE);
				g.drawString(tempItem.itemDescription(), tempX, tempY + 90);
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
				g.drawImage(tempImage, tempX, tempY, null);
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
	/*
	 * 3 Items shown from curItemPos to curItemPos + 2
	 * passed in int can be between 0 - 2 (0 selects leftmost item, 1 selects center item, 2 selects rightmost item) 
	 */
	public void selectItem(int pos){
		System.out.println("Item: "+ pos + " selected");
		if(pos > -1 && pos < 3){
			int index = curItemPos + pos;
			if(index < Game.group.getInventory().size() ){
				
				//remove from list if it is not a key
				if(!Game.group.getInventory().get(index).toString().equalsIgnoreCase("KEY")){
					selectedItem = Game.group.getInventory().remove(index);
					if(Game.battle != null){
						Game.battle.setInventoryAction(selectedItem.useItem());
					}else
						Game.group.determineAction(selectedItem.useItem());
				}
			}
				
				
		}
		
	}
	
	public void selectWeapon(int pos){
		System.out.println("Weapon: "+ pos + " selected");
		if(pos > -1 && pos < 3){
			int index = curItemPos + pos;
			if(index < Game.group.getWeapons().size() ){
				selectedWeapon = Game.group.getWeapons().remove(index);
				
			}
				
				
		}
	}
	
	public void selectCharacter(int pos){
		System.out.println("Student: "+ pos+1 + " selected");
		if(pos > -1 && pos < 3){
			if(selectedWeapon != null ){
				selectedWeapon = Game.group.getWeapons().remove(pos);//remove from weaponlist
				Weapon tempWeapon = group.getGroup().get(pos).getWeapon();//get character's current weapon
				group.addToWeapons(tempWeapon);//add to weaponlist
				group.getGroup().get(pos).setWeapon(selectedWeapon);//equip character w/new weapon
				selectedWeapon = null;
			}
		}
	}
	
	public Weapon getSelectedWeapon() {
		return selectedWeapon;
	}
}
