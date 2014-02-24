package level;



import group.EnemyGroup;
import group.Group;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import useableitem.Key;

public class LevelReader {

	FileReader fs;
	LevelObject[][] map;
	int size = -1, itemsLoc = -1,itemsEnd = -1,enemiesLoc = -1, enemiesEnd = -1;
	ArrayList<String> enemies;
	ArrayList<String> items;
	int startRow;
	int startCol;
	

	public Level loadLevel(String fileName) throws IOException {
		
		String split [] = readFile(fileName);
		size = Integer.parseInt(split[0]);
		createMap();
		setEnemiesItems(split);
		itterateThroughString(split);
		Level lv = new Level(map);
		return lv;
	
	}//end load level
	

	private void itterateThroughString(String[] split) {
		
		Random randomGenerator = new Random();
		
		for(int i = 1; i < split.length; i ++){
			 
			 //if its still on the map part
			 if(i < (size * size) + 1){
				 
				 int x = getX(size, i);
				 int y = getY(size, i);
				 
				 if(split[i].equalsIgnoreCase("W")){
					 map[x][y].setWall(true);
					// System.out.println("wall set at " + x + " , " +  y);
				 }
				 else if(split[i].equalsIgnoreCase("K")){
					 map[x][y].setItem(new Key());
					// System.out.println("key set at " + x + " , " +  y);
				 }
				 else if(split[i].equalsIgnoreCase("D")){
					 map[x][y].setDoor(true);
					
				 }
				 else if(split[i].equalsIgnoreCase("S")){
					 startCol = y;
					 startRow = x;
				 }
				 else if(split[i].equalsIgnoreCase("I")){
					 
					if(!items.isEmpty()){ 
						 int randomInt = randomGenerator.nextInt(items.size()- 1);
						 map[x][y].setItems(items.get(randomInt));
					}//end if
						
				 }
				 else if(split[i].equalsIgnoreCase("G")){
					 
					 if(!enemies.isEmpty()){
						 int r1 = randomGenerator.nextInt(enemies.size()- 1);
						 int r2 = randomGenerator.nextInt(enemies.size()- 1);
						 int r3 = randomGenerator.nextInt(enemies.size()- 1);					 
						 map[x][y].setBadGuys(new EnemyGroup(enemies.get(r1),enemies.get(r2),enemies.get(r3)));
					 }//end if
				 }//end else if
				 else if(split[i].equalsIgnoreCase("B")){
					 
					 if(!enemies.isEmpty() && !items.isEmpty()){
					 
						 int r1 = randomGenerator.nextInt(enemies.size()- 1);
						 int r2 = randomGenerator.nextInt(enemies.size()- 1);
						 int r3 = randomGenerator.nextInt(enemies.size()- 1);					 
						 map[x][y].setBadGuys(new EnemyGroup(enemies.get(r1),enemies.get(r2),enemies.get(r3)));
						 
						 int randomInt = randomGenerator.nextInt(items.size()- 1);
						 map[x][y].setItems(items.get(randomInt));
					 }//end if
				 }
			 }//end if
		 }//end for
	}


	private void createMap() {
		//create a level of that size
				map = new LevelObject[size][size];
				for(int x = 0; x< map.length; x++){
					for(int y = 0; y<map[x].length;y++){
						map[x][y] = new LevelObject();
					}//end for
				}//end for
	}


	private String[] readFile(String fileName)throws IOException {
		
		//read in first line, level size
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		while(line != null){
			
			sb.append(line);
			// sb.append(System.lineSeparator());
			sb.append(" ");
			line = br.readLine();
		}
		String everything = sb.toString();
		String split [] = everything.split(" ");
		return split;
	}//end readFile


	private void setEnemiesItems(String[] split) {
		// TODO Auto-generated method stub
		int k;
		
		for(int i = 0; i < split.length; i++){
			
			if(split[i].equalsIgnoreCase("Items:")){
				itemsLoc = i;
				for(k = i; !split[k].equalsIgnoreCase("||"); k ++);
				itemsEnd = k;
			}//end if
			else if(split[i].equalsIgnoreCase("Enemies:")){
				enemiesLoc = i;
				for(k = i; !split[k].equalsIgnoreCase("||"); k ++);
				enemiesEnd = k;
			}//end else if
		}//end for
		
		
		if(itemsLoc != -1 && itemsEnd > itemsLoc + 1){
		
			items = new ArrayList<String>();
			populateList(split,items, itemsLoc, itemsEnd);
			
		}
		if(enemiesLoc!= -1 && enemiesEnd > enemiesLoc + 1){
			
			enemies = new ArrayList<String>();
			populateList(split, enemies, enemiesLoc, enemiesEnd);
		}
			
		
		
	}//end setEnemiesItems


	private void populateList(String[] split, ArrayList<String> items2, int beg, int end) {
		// TODO Auto-generated method stub
		for(int i = beg + 1; i < end; i ++){
			items2.add(split[i]);
		}//end for
	}//end populateList


	private int getY(int size, int i) {
		
		return (i-1) % size;
	}//end getY
	private int getX(int size, int i) {
		
		i = i -1;	
		i = i/size;
		return i;
	}//end getX
	
	public int getStartRow(){
		return this.startRow;
	}//get Start Row
	public int getStartCol(){
		return this.startCol;
	}//end get Start Col
	
}//end class LEVEL READER

