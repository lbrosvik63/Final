package gameplay;

import group.Action;
import group.Group;
import character.Character;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.ImageIcon;

import csgame.Game;
import csgame.Game.STATE;

public class Battle {
	
	private Group goodGuys;
	private Group enemies;
	private int enemyClock;
	private int heroClock;
	//Possibly use an AttackQueue to set order of attacks for each turn
	private LinkedList<Character> heroQueue = new LinkedList<Character>();
	private LinkedList<Character> enemyQueue = new LinkedList<Character>();
	private Scanner kb;
	
	
	private Character selectedCharacter = null;
	Image boss = getImage("/data/cpeters1.png");
	Image background = getImage("/data/battlemenu.png"); 
	Image button = getImage("/data/blankbutton.png");
	
	private enum BATTLESTATE{
		LOADHEROES,
		LOADENEMIES,
		SELECTHERO,
		SELECTENEMY,
		HEROTURN,
		ENEMYTURN
	};
	
	private BATTLESTATE battlestate = BATTLESTATE.LOADENEMIES;
	/*
	public Battle(Group goodGuys, Group enemies, Scanner sysIn){
		this.goodGuys = goodGuys;
		this.enemies = enemies;
		enemyClock = 0;
		heroClock =0;
		kb = sysIn;
		attackQueue = new LinkedList<Character>();
	}*/
	
	public Battle(Group goodGuys, Group enemies){
		this.goodGuys = goodGuys;
		this.enemies = enemies;
		enemyClock = 0;
		heroClock =0;
		
	}
	
	
	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 900, 700);
		
		g.drawImage(background, 75, 0,null);
		
		g.drawImage(button, 350, 125, null);//primary attack
		g.drawImage(button, 350, 225, null);//secondary attack
		g.drawImage(button, 350, 325, null);//special attack
		g.drawImage(button, 350, 425, null);//weapon attack
		
		if(battlestate == BATTLESTATE.HEROTURN){
			Font fnt0 = new Font("arial", Font.BOLD, 20);
			g.setFont(fnt0);
			g.setColor(Color.WHITE);
			g.drawString(selectedCharacter.getPriAtkName(), 375, 170);
			g.drawString(selectedCharacter.getScdAtkName(), 375, 270);
			g.drawString(selectedCharacter.getRolAtkName(), 375, 370);
			g.drawString("Use " + selectedCharacter.getWeapon().toString(), 375, 470);
			
		}
		else if(battlestate == BATTLESTATE.ENEMYTURN){
			Font fnt0 = new Font("arial", Font.BOLD, 20);
			g.setFont(fnt0);
			g.setColor(Color.WHITE);
			g.drawString(selectedCharacter.getPriAtkName(), 375, 170);
			g.drawString(selectedCharacter.getScdAtkName(), 375, 270);
			g.drawString(selectedCharacter.getRolAtkName(), 375, 370);
			g.drawString("Use " + selectedCharacter.getWeapon().toString(), 375, 470);
			
			Font fnt1 = new Font("arial", Font.BOLD, 20);
			g.setFont(fnt1);
			g.setColor(Color.WHITE);
			g.drawString("Press Spacebar to Continue", 325, 600);
		}
		
		
		
		//For each hero starting at coordinates (10,100)
		int x = 50, y = 175;
		for (int i = 0; i < goodGuys.getGroup().size(); i++) {

			int maxhealth = goodGuys.getGroup().get(i).getMaxHealthPoints();
			int curhealth = goodGuys.getGroup().get(i).getHealthPoints();
			String name = goodGuys.getGroup().get(i).toString();
			
			if(selectedCharacter != null && name == selectedCharacter.toString()){
				g.setColor(Color.YELLOW);
				g.fillRect(x,y,50,10);
			}
			
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

		// For each enemy starting at coordinates (10,100)
		 x = 600; y = 175;
		for (int i = 0; i < enemies.getGroup().size(); i++) {

			int maxhealth = enemies.getGroup().get(i).getMaxHealthPoints();
			int curhealth = enemies.getGroup().get(i).getHealthPoints();
			String name = enemies.getGroup().get(i).toString();
			
			if(selectedCharacter != null && name == selectedCharacter.toString()){
				g.setColor(Color.YELLOW);
				g.fillRect(x,y,50,10);
			}
			
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
		
		
		if(Game.state == STATE.BOSSBATTLE){
			g.drawImage(boss, 650, 300,null);
		}
		
	
	}//end paint
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}
	
	//TODO: change boss image based on loaded boss
	private void setBossImage(){
		
	}
	
	public void update(){
		if(!goodGuys.areAlive()){
			Game.state = STATE.DEAD;
		}
		else if(!enemies.areAlive()){
			if(Game.state == STATE.BOSSBATTLE)
				Game.state = STATE.BEATBOSS;
			else
				Game.state = STATE.WONBATTLE;
		}
		else if(battlestate == BATTLESTATE.LOADENEMIES){
			enemiesToQueue();
		}
		else if(battlestate == BATTLESTATE.SELECTENEMY){
			getEnemyFromQueue();
		}
		else if(battlestate == BATTLESTATE.ENEMYTURN){
			
		}
		else if(battlestate == BATTLESTATE.LOADHEROES){
			heroesToQueue();
		}
		else if(battlestate == BATTLESTATE.SELECTHERO){
			getHeroFromQueue();
		}
		else if(battlestate == BATTLESTATE.HEROTURN){
			
		}
	}
	
	public void heroPrimaryAttack() {
		if(battlestate == BATTLESTATE.HEROTURN && selectedCharacter != null){
			Action action = selectedCharacter.primaryAttack();
			action = goodGuys.determineAction(action);
			if(action != null){//Is an Attack Against Enemy
				enemies.recieveAction(action);
			}
			battlestate = BATTLESTATE.SELECTHERO;
		}
	}

	public void heroSecondaryAttack() {
		if(battlestate == BATTLESTATE.HEROTURN && selectedCharacter != null){
			Action action = selectedCharacter.secondaryAttack();
			action = goodGuys.determineAction(action);
			if(action != null){//Is an Attack Against Enemy
				enemies.recieveAction(action);
			}
			battlestate = BATTLESTATE.SELECTHERO;
		}
	}

	public void heroRoleAttack() {
		if(battlestate == BATTLESTATE.HEROTURN && selectedCharacter != null){
			Action action = selectedCharacter.roleAttack();
			action = goodGuys.determineAction(action);
			if(action != null){//Is an Attack Against Enemy
				enemies.recieveAction(action);
			}
			battlestate = BATTLESTATE.SELECTHERO;
		}
	}

	public void heroWeaponAttack() {
		if(battlestate == BATTLESTATE.HEROTURN && selectedCharacter != null){
			Action action = selectedCharacter.weaponAttack();
			action = goodGuys.determineAction(action);
			if(action != null){//Is an Attack Against Enemy
				enemies.recieveAction(action);
			}
			battlestate = BATTLESTATE.SELECTHERO;
		}
	}
	//Activated by Keyboard: Spacebar
	public void generateEnemyAttack(){
		System.out.println("generating enemy attack");
		if(battlestate == BATTLESTATE.ENEMYTURN){
			Action action;
			action = selectedCharacter.genRandomAttack();
			action = enemies.determineAction(action);
			if(action != null){//Is an Attack Against goodGuys
				System.out.println("Incoming Attack:");
				goodGuys.recieveAction(action);
			}
			battlestate = BATTLESTATE.SELECTENEMY;
		}
	
		
	}//end runEnemyAttacks
	
	
	public void enemiesToQueue(){
		enemyClock ++;
		System.out.println("enemy size: "+ enemies.getGroup().size());
		System.out.println("enemy speed: "+ enemies.getGroup().get(0).getSpeed());
			for(Character character : enemies.getGroup()){//Add Good Guys to Queue
				if(enemyClock % character.getSpeed() == 0){
					enemyQueue.offer(character);
				System.out.println("adding enemy to queue. Clock is: "+ enemyClock);
				}
				System.out.println(enemyClock + "% "+ character.getSpeed() + " = "+ enemyClock % character.getSpeed());
			}
			battlestate = BATTLESTATE.SELECTENEMY;
		
	}//end startBattle
	
	public void heroesToQueue(){
		heroClock ++;
	
			for(Character character : goodGuys.getGroup()){//Add Good Guys to Queue
				if(character.getHealthPoints() > 0 && heroClock % character.getSpeed() == 0){
					heroQueue.offer(character);
				System.out.println("adding hero to queue. Clock is: "+ heroClock);
				}
			}
		
			battlestate = BATTLESTATE.SELECTHERO;
	
	}//end startBattle
	
	/*
	 * Takes Characters in AttackQueue 1 by 1 and allows them to attack or heal
	 * After each turn, it checks if team that was attacked is still alive
	 * Returns: True - both groups are still alive after all attacks in queue
	 * 			False - one group is defeated
	 * TODO: NEED TO DISPLAY ENEMY INFORMATION BEFORE EACH TURN
	 */
	private void getHeroFromQueue(){
		
		if(heroQueue.peek() != null){
			selectedCharacter = heroQueue.poll();
			battlestate = BATTLESTATE.HEROTURN;
		}
		else {// no heroes on remaining on this turn
			selectedCharacter = null;
			battlestate = BATTLESTATE.LOADENEMIES;
		}

	}// end emptyAttackQueue

	private void getEnemyFromQueue() {
		System.out.println("getting enemy from queue SIZE: "+ enemyQueue.size());
		if (enemyQueue.peek() != null) {
			System.out.println("entered peek");
			selectedCharacter = enemyQueue.poll();
			battlestate = BATTLESTATE.ENEMYTURN;
		} else {// no enemies remaining on this tick
			System.out.println("loading heroes");
			selectedCharacter = null;
			battlestate = BATTLESTATE.LOADHEROES;
		}

	}// end emptyAttackQueue
	

	
	public Group getGoodGuys() {
		return goodGuys;
	}

	public void setGoodGuys(Group goodGuys) {
		this.goodGuys = goodGuys;
	}

	public Group getEnemies() {
		return enemies;
	}

	public void setEnemies(Group enemies) {
		this.enemies = enemies;
	}
	
}//end class
