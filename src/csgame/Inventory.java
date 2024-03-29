package csgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import useableitem.Item;
import weapons.Weapon;

public class Inventory {


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
	
	Image pen = getImage("/data/small_pen.jpg"); 
	Image calculator = getImage("/data/small_calculator.jpg");
	Image dijkstras = getImage("/data/small_dijkstra.png");
	Image gof = getImage("/data/small_gof.jpg");
	Image javaapi = getImage("/data/small_javaapi.png");
	Image kendostick = getImage("/data/small_kendo.jpg");
	Image stapler = getImage("/data/small_stapler.jpg");
	Image valgrind = getImage("/data/small_valgrind.png");
	
	
	
	public Inventory() {
	}

	public void render(Graphics g){
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
		for(int i = 0; i<Game.group.getGroupSize(); i ++){
			g.drawString(i+1 + ". " + Game.group.getCharacter(i), x1, y1);
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
				tempItem = Game.group.getItem(tempPos);
				assignImage(tempItem);
				g.drawImage(tempImage, tempX, tempY, null);//primary attack
				Font fnt0 = new Font("arial", Font.BOLD, 14);
				g.setFont(fnt0);
				g.setColor(Color.WHITE);
				g.drawString(tempItem.toString(), tempX-15, tempY + 80);
				Font fnt1 = new Font("arial", Font.BOLD, 10);
				g.setFont(fnt1);
				g.setColor(Color.WHITE);
				g.drawString(tempItem.itemDescription(), tempX - 30, tempY + 90);
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
				tempWeapon = Game.group.getWeapon(tempPos);
				assignImage(tempWeapon);
				g.drawImage(tempImage, tempX, tempY, null);
				Font fnt0 = new Font("arial", Font.BOLD, 14);
				g.setFont(fnt0);
				g.setColor(Color.WHITE);
				g.drawString(tempWeapon.toString(), tempX-15, tempY + 80);
				Font fnt1 = new Font("arial", Font.BOLD, 10);
				g.setFont(fnt1);
				g.setColor(Color.WHITE);
				g.drawString(tempWeapon.itemDescription(), tempX - 30, tempY + 90);
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
		if(item.toString().equalsIgnoreCase("Calculator"))
			tempImage = calculator;
		else if(item.toString().equalsIgnoreCase("Dijkstra's Algorithm"))
			tempImage = dijkstras;
		else if(item.toString().equalsIgnoreCase("Gang of Four"))
			tempImage = gof;
		else if(item.toString().equalsIgnoreCase("Java API"))
			tempImage = javaapi;
		else if(item.toString().equalsIgnoreCase("Kendo Stick"))
			tempImage = kendostick;
		else if(item.toString().equalsIgnoreCase("Pen"))
			tempImage = pen;
		else if(item.toString().equalsIgnoreCase("Stapler"))
			tempImage = stapler;
		else if(item.toString().equalsIgnoreCase("Valgrind"))
			tempImage = valgrind;
		
	}
	
	public void itemsScrollLeft() {
		curItemPos -= 3;
		if(curItemPos < 0)
			curItemPos = 0;
	}

	public void itemsScrollRight() {
		curItemPos +=3;
		if(curItemPos > Game.group.getItemInventorySize() -1){
			curItemPos = Game.group.getItemInventorySize() - 3;
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
		if(curWeaponPos > Game.group.getWeaponInventorySize() -1){
			curWeaponPos = Game.group.getWeaponInventorySize() - 3;
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
			if(index < Game.group.getItemInventorySize() ){
				
				//remove from list if it is not a key
				if(!Game.group.getItem(index).toString().equalsIgnoreCase("KEY")){
					selectedItem = Game.group.removeFromInventory(index);
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
			if(index < Game.group.getWeaponInventorySize() ){
				selectedWeapon = Game.group.removeFromWeapons(index);
				
			}
				
				
		}
	}
	/*
	 * After you select your weapon then you select a Character to assign it to
	 */
	public void selectCharacter(int pos){
		System.out.println("Student: "+ pos+1 + " selected");
		if(pos > -1 && pos < 3){
			if(selectedWeapon != null ){
				Weapon tempWeapon = Game.group.getCharacterWeapon(pos);//get character's current weapon
				Game.group.addToWeapons(tempWeapon);//add to weaponlist
				
				Game.group.setCharacterWeapon(pos, selectedWeapon);//equip character w/new weapon
				System.out.println(Game.group.getGroup().get(pos) + " got " + selectedWeapon);
				selectedWeapon = null;
			}
		}
	}
	
	public Weapon getSelectedWeapon() {
		return selectedWeapon;
	}
}
