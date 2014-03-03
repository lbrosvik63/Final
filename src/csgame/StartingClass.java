package csgame;

import gameplay.Battle;
import group.Group;
import group.HeroGroup;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import level.Level;
import level.LevelObject;
import level.LevelReader;
import bosses.Capual;
import bosses.Imamura;
import bosses.Peters;
import bosses.Steiner;
import bosses.Strongarm;
import bosses.SuperSteiner;
import bosses.Tappan;
import bosses.Xu;
import character.Boss;
//THE WORKING VERSION RIGHT NOW
//THE WORKING VERSION RIGHT NOW



/*
 * NOTE: 1920 x 1080 pixels => 1920 horizontal pixels & 1080 vertical pixels
 * 		 (0,0) => top left corner  -- (1919,1079) => bottom right corner
 */

public class StartingClass extends Applet implements Runnable, KeyListener {

	Camera cam;
	
	private static GroupGUI groupGUI;//static so other classes can access it (for collision detection)
	//accessed by Tile class   (private Robot robot = StartingClass.getRobot();
	
	//private Heliboy hb, hb2;
	private Image currentSprite, image, character, character2, character3, characterDown,
	characterJumped, background, battleBackground;
	
	public static Image wall, grass, grassitem, doorOpen, doorLocked, levelLoad; //tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, tiledirt;
	
	private URL base;
	private Graphics second;
	private static Background bg1, bg2, bgBattle; // make static so can create getters/setters for them 
										// to be used in other classes for movement
	private Animation anim, hanim;
	
	private ArrayList<Tile> tilearray = new ArrayList<Tile>();
	private Tile[][] tilearray2;
	
	private int width = 896;
	private int height = 832;
	
	private Menu menu;
	private BattleMenu battleMenu;
	private LoadingLevel splashScreen;
	public static enum STATE{ //usually make a enum class and dont use public static
		MENU,
		CHARACTERSELECT,
		GAME,
		BEATLEVEL,
		BEATBOSS,
		DEAD,
		BATTLE,
		BEATGAME
	};
	
	public static STATE state = STATE.MENU;
	public static int health = 100 *3;
	
	
	static Boss[] bosses = {new Peters(), new Imamura(), new Strongarm(),
							new Xu(), new Steiner(), new Capual(), new Tappan(), new SuperSteiner()};
	
	
	static String levelNames [] = {"C:\\Users\\2Watch\\workspace\\Final\\level260.txt", 
									"data/map7.txt", 
									"C:\\Users\\2Watch\\workspace\\Final\\level.txt",
									"C:\\Users\\2Watch\\workspace\\Final\\level2.txt"}; 
	private Level theLevel;
	private int currLevel = 0;
	private int currBoss = 0;
	private int doorRow;
	private int doorCol;
	
	public static Battle battle;
	public static Group heroGroup;
	
	public StartingClass() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		
		setSize(width, height);
		
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(new MouseInput());
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("EWU: Escape from CS Department");
		
		try{
			base = getDocumentBase();
		} catch(Exception e) {
			//TODO: handle exception
		}
		
		cam = new Camera(0,0);
		menu = new Menu();
		battleMenu = new BattleMenu();
		
		//TODO: CHANGE TO INSTANTIATE FROM GROUP SELECTION MENU
		heroGroup = new HeroGroup("Nerd", "Jock", "Tutor");
		//Image Setups 
		
		character = getImage(base, "data/heroes.png");
	
		levelLoad = getImage(base, "data/nextlevelsplash.jpg");
		battleBackground = getImage(base, "backgrounds/keyboard.jpg");
		//background = getImage(base, "data/background.png");
		
		
		grass = getImage(base, "data/grass.png");
		grassitem = getImage(base, "data/grassitem.png");
		wall = getImage(base, "data/wall.png");
		doorOpen = getImage(base, "data/dooropen.png");
		doorLocked = getImage(base, "data/doorlocked.png");
	
		currentSprite = character;
	}
	
	/*
	 * define hb & hb2 BELOW the Background creation
	 * the Enemy superclass looks for these backgrounds, so if they are not defined, your game will crash
	 * 
	 */
	@Override
	public void start() {
			//bg1 = new Background(0,0);
			bgBattle = new Background(0,0);
			//bg2 = new Background(2160,0);
			groupGUI = new GroupGUI();//now can call getRobot() as soon as tiles initialized
			

			
			try {
				loadNextLevel(levelNames[currLevel]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		Thread thread = new Thread(this);
		thread.start();
	}

	private void loadNextBoss(){
		//TODO:
	}
	
	
	
	private void loadNextLevel(String filename) throws IOException{
		
		LevelReader reader = new LevelReader();

		
		theLevel = null;

		 try {
			theLevel = reader.loadLevel(levelNames[currLevel]);//load 1st level
		} catch (IOException e) {
			System.out.println("ERROR: Level reading failed!");
		}
		 //Set Character at Starting Point
		 groupGUI.setCenterX(theLevel.getStartCol() * 64 + 32);
		 groupGUI.setCenterY(theLevel.getStartRow() * 64 + 32);
		 
		 int sideLength = theLevel.getSideLength();
		 LevelObject levOb;
		 Tile t;
		 tilearray2 = new Tile[sideLength][sideLength];
		 
		 for (int j= 0; j <sideLength; j++){
				for (int i =0; i<sideLength; i++){
					
					levOb = theLevel.getMap()[j][i];
					if(levOb.isWall()){
						t = new Tile(i,j, 1);
					}else if(levOb.hasGroup() || levOb.hasItem()){
						t = new Tile(i,j, 2);
					}else if(levOb.isDoor()){
						t = new Tile(i,j, 3);
						doorRow = j;
						doorCol =i;
					}
					else{
						t = new Tile(i,j, 0);
					}
					
					tilearray2[j][i] = t;
		 
				}
		 }
		 //Keeps track of position in level Array
		currLevel ++;
	}
	

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void run() {
		while(true){
			if(state == STATE.DEAD){
				splashScreen = new LoadingLevel("C:\\Users\\2Watch\\workspace\\Final\\src\\data\\gameoversplash.png", (Frame) this.getParent().getParent());
				currLevel = 0;
				currLevel = 0;
				state = STATE.MENU;
				break;//break the loop to finish the current play
			}
			if(state == STATE.GAME){
			
				groupGUI.update();
			
				
				//Check if you landed on Door
				if(groupGUI.getRow() == doorRow && groupGUI.getColumn() == doorCol){
					System.out.println("ON THE DOOR");
					state = STATE.BEATBOSS;//TODO: change to BEATLEVEL
				}//encountered enemy group
				else if(theLevel.getPosition(groupGUI.getRow(), groupGUI.getColumn()).hasGroup()){
					System.out.println("Battle Commencing");
					battle = new Battle(heroGroup,theLevel.getPosition(groupGUI.getRow(), groupGUI.getColumn()).getBadGuys());
					state = STATE.BATTLE;
				}
					
				updateTiles();
			//	hb.update();
				//hb2.update();
				//bg1.update();
				//bg2.update();
				
				//animate();
				
				//Change camera view
				cam.tick(groupGUI,width,height,tilearray2.length,tilearray2[0].length);
				repaint();
				
				
			} else if(state == STATE.BATTLE){
				
				bgBattle.update();
				repaint();
				
			}//end state == battle
			else if(state == STATE.BEATLEVEL){
				//Load & initiate next Boss Battle
				//Insert Splash Screen
				
				state = STATE.BATTLE;
			} else if(state == STATE.BEATBOSS){
				//insert splash screen
				splashScreen = new LoadingLevel("C:\\Users\\2Watch\\workspace\\Final\\src\\data\\gameoversplash.png", (Frame) this.getParent().getParent());
				//load next level
				if(currLevel < levelNames.length){
					try {
						loadNextLevel(levelNames[currLevel]);
						System.out.println("Loaded Next Level");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					state = STATE.GAME;
				}
				else{//no more levels == WON ENTIRE GAME
					//TODO: must account for superSteiner does not do so right now
				}
			}
				
			try{
				Thread.sleep(17);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void update(Graphics g) {//Double buffering so movement of image looks smooth
		if(image == null){
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}
		//CAMERA test
		Graphics2D second2d = (Graphics2D)second;
		
		
		
		
		second.setColor(getBackground());
		second.fillRect(0,0,getWidth(),getHeight());
		second.setColor(getForeground());
		//Anything between will be affected
		second2d.translate(cam.getX(), cam.getY());//begin CAMERA
		paint(second);
		
		g.drawImage(image, 0, 0, this);
		second2d.translate(-cam.getX(), -cam.getY());//end CAMERA
	}
	
	/*
	 * Images are painted in the order they appear.
	 * If want character above(on top of) background => put drawImage(character) after drawImage(background)
	 * 
	 *  if image has dimensions 96 x 96 if paint 48 pixels less in both X & Y then will represent center
	 *  drawImage starts at the top left corner of the image where put coordinates
	 */
	
	@Override
	public void paint(Graphics g) {
		//g.drawImage(background, bg1.getBgX(), bg1.getBgY(),this);
		//g.drawImage(background, bg2.getBgX(), bg2.getBgY(),this);
		
		if(state == STATE.GAME){
			paintTiles(g);
		
		
		//For debugging marks out collision detection rectangles
		//g.drawRect((int)robot.rect.getX(), (int)robot.rect.getY(), (int)robot.rect.getWidth(),(int)robot.rect.getHeight());
		//g.drawRect((int)robot.rect2.getX(), (int)robot.rect2.getY(), (int)robot.rect2.getWidth(),(int)robot.rect2.getHeight());
		
			g.drawImage(currentSprite, groupGUI.getCenterX()-32, groupGUI.getCenterY()-32, this);
		//Drawing health bar (doesnt move with camera)
			g.setColor(Color.GRAY);
			g.fillRect(5, 5, 300, 25);
			
			g.setColor(Color.GREEN);
			g.fillRect(5, 5, health, 25);
			
			g.setColor(Color.WHITE);
			g.drawRect(5, 5, 300, 25);
		
		
		} else if(state == STATE.MENU){
			g.drawImage(battleBackground, bgBattle.getBgX(), bgBattle.getBgY(),this);
			menu.paint(g);
			
		} else if(state == STATE.BATTLE){
			
			battleMenu.paint(g);
			
		} 
		
		
		
		//g.drawImage(hanim.getImage(), hb.getCenterX()-48,hb.getCenterY()-48, this);
		//g.drawImage(hanim.getImage(), hb2.getCenterX()-48,hb2.getCenterY()-48, this);
		//
	}
	
	private void updateTiles(){
		
		

		
		//Works for this game
		
		for(int i =0; i<tilearray2.length;i++) {
			for(int j = 0; j<tilearray2[i].length; j++){
				Tile t = tilearray2[i][j];
				t.update();
			}
		}
		
		
		//From Robot Tutorial
		/*for(int i=0; i<tilearray.size();i++){
			Tile t = (Tile) tilearray.get(i);
			t.update();
		}*/
	}
	
	
	private void paintTiles(Graphics g){
		for(int i =0; i<tilearray2.length;i++) {
			for(int j = 0; j<tilearray2[i].length; j++){
				Tile t = tilearray2[i][j];
				g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY(), this);
			}
		}
		
		/*for(int i = 0; i<tilearray.size();i++){
			Tile t = (Tile) tilearray.get(i);
			g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY(),this);
		}*/
	}
	
	
	public void animate(){
		//anim.update(10);
		//hanim.update(50);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(state == STATE.GAME){
			
		
			switch(e.getKeyCode()){
			case KeyEvent.VK_UP:
				if( tilearray2[groupGUI.getRow() - 1][groupGUI.getColumn()].getType() != 1){//not a wall
					groupGUI.moveUp();
					groupGUI.setMovingUp(true);
				}
				
				break;
			
			case KeyEvent.VK_DOWN:
				if( tilearray2[groupGUI.getRow() + 1][groupGUI.getColumn()].getType() != 1){//not a wall
					groupGUI.moveDown();
					groupGUI.setMovingDown(true);
				}
				break;
			
			case KeyEvent.VK_LEFT:
				if( tilearray2[groupGUI.getRow()][groupGUI.getColumn() - 1].getType() != 1){//not a wall
					groupGUI.moveLeft();
					groupGUI.setMovingLeft(true);
				}
				break;
				
			case KeyEvent.VK_RIGHT:
				if( tilearray2[groupGUI.getRow()][groupGUI.getColumn() + 1].getType() != 1){//not a wall
					groupGUI.moveRight();
					groupGUI.setMovingRight(true);
				}
				break;
	
			}
		}//end if state = game
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			groupGUI.stop();
			break;
		
		case KeyEvent.VK_DOWN:
			groupGUI.stop();
			break;
		
		case KeyEvent.VK_LEFT:
			groupGUI.stop();
			break;
			
		case KeyEvent.VK_RIGHT:
			groupGUI.stop();
			break;
			
	
		}
	}
	
	public static Background getBg1(){
		return bg1;
	}
	
	public static Background getBg2(){
		return bg2;
	}
	
	public static GroupGUI getGroupGUI(){
		return groupGUI;
	}
	
}//end class
