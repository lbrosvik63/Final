package csgame;

import gameplay.Battle;
import group.EnemyGroup;
import group.Group;
import group.HeroGroup;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import useableitem.Item;
import useableitem.ItemFound;
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
/*
 * TODO: SET UP CHARACTER SELECTION AND THEN INITIATE LEVEL LOADING ETC
 */
public class Game extends Canvas implements Runnable, KeyListener{

	private static final long serialVersionUID = 1L;
	private boolean running = false;
	private Thread thread;
	
	public static int WIDTH, HEIGHT;
	
	static JFrame frame = new JFrame("Escape the EWU Computer Science Department");
	
	//JTextArea battleResults = new JTextArea(0,600);
	
	Camera cam;
	public static HeroGroup group;
	
	private Image image;
	
	public static Image wall, grass, grassitem, doorOpen, doorLocked, levelLoad;
	//private Graphics second;
	private Tile[][] tilearray2;
	
	private Menu menu;
	private LoadingLevel splashScreen;
	
	public static String[] bosses = { "Peters", "Imamura", "Strongarm", "Xu", "Steiner", "Capual", "Tappan", "SuperSteiner"};

	public static String levelNames[] = {
			"Levels/level211.txt",
			"Levels/level260.txt", "Levels/level300.txt",
			"Levels/level320.txt","Levels/level340.txt","Levels/level454.txt","Levels/level490.txt" };
	
	
	private Level theLevel;
	private int currLevel = 0;
	private int currBoss = 0;
	private int doorRow;
	private int doorCol;

	public static Battle battle;
	//public static Group heroGroup;
	public static CharacterSelection cselect;
	public static ItemFound itemfound;
	public static Inventory inventory;
	
	
	
	public static enum STATE{ //usually make a enum class and dont use public static
		MENU,
		CHARACTERSELECT,
		FINISHEDSELECT,
		GAME,
		INVENTORY,
		BEATLEVEL,
		BEATBOSS,
		DEAD,
		BATTLE,
		BOSSBATTLE,
		WONBATTLE,
		BEATGAME, ITEMFOUND
	};
	
	public static STATE state = STATE.MENU;
	private STATE prevState;
	
	private void init(){
		
		
		WIDTH = getWidth();
		HEIGHT = getHeight();
		addKeyListener(this);
		addMouseListener(new MouseInput());
		
		
		
		cselect = new CharacterSelection();
		itemfound = new ItemFound();
		group = new HeroGroup("Nerd","Cheater","Tutor");
		inventory = new Inventory();
		
		
		cam = new Camera(0,0);
		menu = new Menu();
		

		
		//character = group.getPlayerImage();

		levelLoad = getImage("/data/gameoversplash.png");//TODO: Change to different
		//grass = getImage("/data/grass.png");
		grass = getImage("/data/floortile.png");
		//grassitem = getImage("/data/grassitem.png");
		grassitem = getImage("/data/flooritem.png");
		//wall = getImage("/data/wall.png");
		wall = getImage("/data/bricktile.jpg");
		doorOpen = getImage("/data/dooropen.png");
		doorLocked = getImage("/data/doorlocked.png");
		
	/*	
		try {
			loadNextLevel(levelNames[currLevel]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
				splashScreen = new LoadingLevel("/data/gameoversplash.png", frame);
				//splashScreen = new LoadingLevel("C:\\Users\\2Watch\\workspace\\Final\\src\\data\\gameoversplash.png", frame);
				currLevel = 0;
				currLevel = 0;
				state = STATE.MENU;
				break;//TODO: TEST - break the loop to finish the current play
			}
			if(state == STATE.GAME){
			
				group.update();
			
				
				//Check if you landed on Door
				if(group.getRow() == doorRow && group.getColumn() == doorCol && group.getHasKey()){
					System.out.println("ON THE DOOR");
					cam.setX(0);
					cam.setY(0);
					group.setHasKey(false);
					state = STATE.BEATLEVEL;//TODO: change to BEATLEVEL
				}//encountered enemy group
				else if(theLevel.getPosition(group.getRow(), group.getColumn()).hasGroup()){
					System.out.println("Battle Commencing");
					cam.setX(0);
					cam.setY(0);
					battle = new Battle(group,theLevel.getPosition(group.getRow(), group.getColumn()).getBadGuys());
					state = STATE.BATTLE;
		  	    }//Pick Up Item
				else if(theLevel.getPosition(group.getRow(), group.getColumn()).hasItem()){
					
					cam.setX(0);
					cam.setY(0);
					
					Item item = theLevel.getPosition(group.getRow(), group.getColumn()).getItem();
					group.addToInventory(item);
					if(item.toString().equalsIgnoreCase("KEY")){
						
						group.setHasKey(true);
						tilearray2[doorRow][doorCol].setTileImage(doorOpen);
					}
					
					state = STATE.ITEMFOUND;			
					
				}//end found item
					
				updateTiles();
				
				//Change camera view
				cam.tick(group,WIDTH,HEIGHT,tilearray2.length,tilearray2[0].length);
				
				
				
			} else if(state == STATE.BATTLE){
				cam.setX(0);
				cam.setY(0);
				battle.update();
				
				
			}//end state == battle
			else if(state == STATE.WONBATTLE){
				//Pick up item and clear spot of group
				if(theLevel.getPosition(group.getRow(), group.getColumn()).hasItem()){
					Item item = theLevel.getPosition(group.getRow(), group.getColumn()).getItem();
					group.addToInventory(item);
					theLevel.getPosition(group.getRow(), group.getColumn()).setItem(null);
				}
				theLevel.getPosition(group.getRow(), group.getColumn()).setBadGuys(null);
				
				tilearray2[group.getRow()][group.getColumn()].setTileImage(grass);
				state = STATE.GAME;
			}
			else if(state == STATE.BEATLEVEL){
				cam.setX(0);
				cam.setY(0);
				
				System.out.println("You beat the level");
				//TODO: Next Boss Battle Scene
				battle = new Battle(group,new EnemyGroup(bosses[currBoss]));
				currBoss ++;
				state = STATE.BOSSBATTLE;
				
			} else if(state == STATE.BOSSBATTLE){
				//TODO: Insert Boss Battle Screen
				
				battle.update();
			}
			else if(state == STATE.BEATBOSS){
				cam.setX(0);
				cam.setY(0);
				splashScreen = new LoadingLevel("/data/gameoversplash.png", frame);
				//load next level if available
				if(currLevel < levelNames.length){
					try {
						loadNextLevel(levelNames[currLevel]);
						System.out.println("Loaded Next Level");
					} catch (IOException e) {
						// TODO Auto-generated catch blocks
						e.printStackTrace();
					}
					state = STATE.GAME;
				}
				else{//no more levels == WON ENTIRE GAME
					//TODO: must account for superSteiner does not do so right now
				}
			}
			else if(state == STATE.CHARACTERSELECT){
				
			}
			else if(state == STATE.FINISHEDSELECT){
				if(currLevel < levelNames.length){
					try {
						loadNextLevel(levelNames[currLevel]);
						System.out.println("Loaded Next Level");
					} catch (IOException e) {
						// TODO Auto-generated catch blocks
						e.printStackTrace();
					}
					state = STATE.GAME;
				}
			}
			else if(state == STATE.ITEMFOUND){
					
				cam.setX(0);
				cam.setY(0);

			}
			
			try {
				render();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			try{
				Thread.sleep(17);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	private void update(){//updates
		
		
		
		if(state == STATE.GAME){
			cam.tick(group,WIDTH,HEIGHT,tilearray2.length,tilearray2[0].length);
			group.update();
			updateTiles();
		}
		
	}
	
	private void render() throws IOException{//graphics like paint
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
			group.render(g);
		
		
		
		} else if(state == STATE.MENU){
			
			menu.render(g);
			
		} else if(state == STATE.INVENTORY){
			
			inventory.render(g);
			
		}else if(state == STATE.BATTLE){
			
			battle.render(g);
			
		} else if(state == STATE.BOSSBATTLE){
			battle.render(g);
		} else if(state == STATE.CHARACTERSELECT){
			cselect.render(g);
		}
		else if(state == STATE.ITEMFOUND){
			
			Item item = theLevel.getPosition(group.getRow(), group.getColumn()).getItem();
			itemfound.render(g,item.toString());
		}
		
		
		
		g.drawImage(image, 0, 0, this);
		g2d.translate(-cam.getX(), -cam.getY());//end CAMERA
		
		
		 
		
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
		 group.setCenterX(theLevel.getStartCol() * 64 + 32);
		 group.setCenterY(theLevel.getStartRow() * 64 + 32);
		 
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
				if( tilearray2[group.getRow() - 1][group.getColumn()].getType() != 1){//not a wall
					group.moveUp();
					//groupGUI.setMovingUp(true);
				}
				
				break;
			
			case KeyEvent.VK_DOWN:
				if( tilearray2[group.getRow() + 1][group.getColumn()].getType() != 1){//not a wall
					group.moveDown();
					//groupGUI.setMovingDown(true);
				}
				break;
			
			case KeyEvent.VK_LEFT:
				if( tilearray2[group.getRow()][group.getColumn() - 1].getType() != 1){//not a wall
					group.moveLeft();
					//groupGUI.setMovingLeft(true);
				}
				break;
				
			case KeyEvent.VK_RIGHT:
				if( tilearray2[group.getRow()][group.getColumn() + 1].getType() != 1){//not a wall
					group.moveRight();
					//groupGUI.setMovingRight(true);
				}
				break;
				
			case KeyEvent.VK_K: //CHEAT FOR TESTING
					group.setHasKey(true);
					tilearray2[doorRow][doorCol].setTileImage(doorOpen);
					
				break;
				
			case KeyEvent.VK_I: //inventory
				cam.setX(0);
				cam.setY(0);
				prevState = state;
				state = STATE.INVENTORY;
			break;
	
			}
		}//end if state = game
		else if(state == STATE.BATTLE || state == STATE.BOSSBATTLE){
			switch(e.getKeyCode()){
			case KeyEvent.VK_ESCAPE:
				theLevel.getPosition(group.getRow(), group.getColumn()).setBadGuys(null);
				theLevel.getPosition(group.getRow(), group.getColumn()).setItem(null);
				tilearray2[group.getRow()][group.getColumn()].setTileImage(grass);
				if(state == STATE.BATTLE)
					state = STATE.GAME;
				else if(state == STATE.BOSSBATTLE)
					state = STATE.BEATBOSS;
				break;
				
			case KeyEvent.VK_SPACE:
				battle.generateEnemyAttack();
				break;
				
			case KeyEvent.VK_I: //inventory
				cam.setX(0);
				cam.setY(0);
				prevState = state;
				state = STATE.INVENTORY;
				
			break;
		}
		
		}//end if state == battle
		
		else if(state == STATE.INVENTORY){
			switch(e.getKeyCode()){
			case KeyEvent.VK_I:
				state = prevState;
			}
		}
		
		else if(state == STATE.ITEMFOUND){
			switch(e.getKeyCode()){
			case KeyEvent.VK_ENTER:
				theLevel.getPosition(group.getRow(), group.getColumn()).setItem(null);
				tilearray2[group.getRow()][group.getColumn()].setTileImage(grass);
				state = STATE.GAME;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
/*
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
			
	
		}*/
	}
	
	private Image getImage(String location){
		ImageIcon i = new ImageIcon(getClass().getResource(location));
		return i.getImage();
	}

}
