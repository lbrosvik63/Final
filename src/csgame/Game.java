package csgame;

import gameplay.Battle;
import group.Group;
import group.HeroGroup;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

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

import csgame.StartingClass.STATE;

public class Game extends Canvas implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	private Window window;
	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH, HEIGHT;
	
	static JFrame frame = new JFrame("Escape the EWU Computer Science Department");
	
	Camera cam;
	public static GroupGUI groupGUI;
	
	private Image image, character, currentSprite;
	
	public static Image wall, grass, grassitem, doorOpen, doorLocked, levelLoad;
	private Graphics second;
	private Tile[][] tilearray2;
	
	private Menu menu;
	private BattleMenu battleMenu;
	private LoadingLevel splashScreen;
	
	public static Boss[] bosses = { new Peters(), new Imamura(),
			new Strongarm(), new Xu(), new Steiner(), new Capual(),
			new Tappan(), new SuperSteiner() };

	public static String levelNames[] = {
			"Levels/level340.txt",
			"Levels/level260.txt", "Levels/level300.txt",
			"Levels/level320.txt","Levels/level340.txt","Levels/level454.txt","Levels/level490.txt" };
	private Level theLevel;
	private int currLevel = 0;
	private int currBoss = 0;
	private int doorRow;
	private int doorCol;

	public static Battle battle;
	public static Group heroGroup;
	
	
	
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
	
	
	private void init(){
		
		WIDTH = getWidth();
		HEIGHT = getHeight();
		addKeyListener(this);
		addMouseListener(new MouseInput());
		
		
		groupGUI = new GroupGUI();
		
		heroGroup = new HeroGroup("Nerd","Jock","Tutor");
		
		cam = new Camera(0,0);
		menu = new Menu();
		battleMenu = new BattleMenu();
		

		
		character = groupGUI.getPlayerImage();

		levelLoad = getImage("/data/gameoversplash.png");//TODO: Change to different
		grass = getImage("/data/grass.png");
		grassitem = getImage("/data/grassitem.png");
		wall = getImage("/data/wall.png");
		doorOpen = getImage("/data/dooropen.png");
		doorLocked = getImage("/data/doorlocked.png");
		
		
		try {
			loadNextLevel(levelNames[currLevel]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public synchronized void start(){
		if(running)//Failsafe: if already running, dont create thread again
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run(){
		init();
		this.requestFocus();
		while(true){
			update();
			if(state == STATE.DEAD){
				cam.setX(0);
				cam.setY(0);
				splashScreen = new LoadingLevel("C:\\Users\\2Watch\\workspace\\Final\\src\\data\\gameoversplash.png", frame);
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
					cam.setX(0);
					cam.setY(0);
					state = STATE.BEATBOSS;//TODO: change to BEATLEVEL
				}//encountered enemy group
//				else if(theLevel.getPosition(groupGUI.getRow(), groupGUI.getColumn()).hasGroup()){
//					System.out.println("Battle Commencing");
//					cam.setX(0);
//					cam.setY(0);
//					battle = new Battle(heroGroup,theLevel.getPosition(groupGUI.getRow(), groupGUI.getColumn()).getBadGuys());
//					state = STATE.BATTLE;
//				}
					
				updateTiles();
				
				//Change camera view
				cam.tick(groupGUI,WIDTH,HEIGHT,tilearray2.length,tilearray2[0].length);
				
				
				
			} else if(state == STATE.BATTLE){
				cam.setX(0);
				cam.setY(0);
				//bgBattle.update();
				
				
			}//end state == battle
			else if(state == STATE.BEATLEVEL){
				cam.setX(0);
				cam.setY(0);
				//Load & initiate next Boss Battle
				//Insert Splash Screen
				
				state = STATE.BATTLE;
			} else if(state == STATE.BEATBOSS){
				cam.setX(0);
				cam.setY(0);
				//insert splash screen
				//splashScreen = new LoadingLevel("C:\\Users\\2Watch\\workspace\\Final\\src\\data\\gameoversplash.png", (Frame) this.getParent().getParent());
				splashScreen = new LoadingLevel("C:\\Users\\2Watch\\workspace\\Final\\src\\data\\gameoversplash.png", frame);
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
			render();	
			try{
				Thread.sleep(17);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	private void update(){//updates
		
		
		
		if(state == STATE.GAME){
			cam.tick(groupGUI,WIDTH,HEIGHT,tilearray2.length,tilearray2[0].length);
			groupGUI.update();
			updateTiles();
		}
		
	}
	
	private void render(){//graphics like paint
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D)g;
		//////////////////////////////////
		
		//Draw here
		//g.setColor(Color.black);
		//g.fillRect(0, 0, getWidth(), getHeight());

		
		
		
		
		g.setColor(getBackground());
		g.fillRect(0,0,getWidth(),getHeight());
		g.setColor(getForeground());
		//Anything between will be affected
		g2d.translate(cam.getX(), cam.getY());//begin CAMERA
		paint(g);
		
		if(state == STATE.GAME){
			renderTiles(g);
			groupGUI.render(g);
		
		
		
			//g.drawImage(currentSprite, groupGUI.getCenterX()-32, groupGUI.getCenterY()-32, this);
		/*Drawing health bar (doesnt move with camera)
			g.setColor(Color.GRAY);
			g.fillRect(5, 5, 300, 25);
			
			g.setColor(Color.GREEN);
			g.fillRect(5, 5, 250, 25);
			
			g.setColor(Color.WHITE);
			g.drawRect(5, 5, 300, 25);
		*/
		
		} else if(state == STATE.MENU){
			//g.drawImage(battleBackground, bgBattle.getBgX(), bgBattle.getBgY(),this);
			menu.paint(g);
			
		} else if(state == STATE.BATTLE){
			
			battleMenu.paint(g);
			
		}
		
		
		
		g.drawImage(image, 0, 0, this);
		g2d.translate(-cam.getX(), -cam.getY());//end CAMER
		
		
		 
		
		//////////////////////////////////
		g.dispose();
		bs.show();
	}
	

private void loadNextLevel(String filename) throws IOException{
		
		LevelReader reader = new LevelReader();

		
		theLevel = null;

		 try {
			theLevel = reader.loadLevel(levelNames[currLevel]);//load 1st level
		} catch (IOException e) {
			System.out.println("FATAL ERROR: Level reading failed!  Exiting...");
			System.exit(1);
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
	
	private void updateTiles() {

		// Works for this game

		for (int i = 0; i < tilearray2.length; i++) {
			for (int j = 0; j < tilearray2[i].length; j++) {
				Tile t = tilearray2[i][j];
				t.update();
			}
		}
	}
	
	private void renderTiles(Graphics g){
		for(int i =0; i<tilearray2.length;i++) {
			for(int j = 0; j<tilearray2[i].length; j++){
				Tile t = tilearray2[i][j];
				g.drawImage(t.getTileImage(), t.getTileX(), t.getTileY(), this);
			}
		}
	}
	
	
	public static void main(String[] args){
		
		//new Window(800, 600, "Escape the EWU Computer Science Department", new Game());
		//setPreferredSize(new Dimension(w,h));
		//game.setMaximumSize(new Dimension(w,h));
		//game.setMinimumSize(new Dimension(w,h));
		Game game = new Game();
		//JFrame frame = new JFrame("Escape the EWU Computer Science Department");
		//frame.setSize(800, 600);
		frame.setPreferredSize(new Dimension(900,700));
		frame.setMaximumSize(new Dimension(900,700));
		frame.setMinimumSize(new Dimension(900,700));
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
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
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}

}
