package groupproject;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LevelReader {

	FileReader fs;
	LevelObject[][] map;
	@SuppressWarnings("resource")
	public Level loadLevel(String fileName) throws IOException {
		
		
		int size = 5;
		
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
	 
	 size = Integer.parseInt(split[0]);
	 	 
	 int sizeSquared = size * size;
	 

		//create a level of that size
		map = new LevelObject[size][size];
		for(int x = 0; x< map.length; x++){
			for(int y = 0; y<map[x].length;y++){
				map[x][y] = new LevelObject();
			}//end for
		}//end for
	 
	 
	 
	 for(int i = 1; i < split.length; i ++){
		 
		 //if its still on the map part
		 if(i < sizeSquared + 1){
			 
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
				// System.out.println("door set at " + x + " , " +  y);
			 }
			 else if(split[i].equalsIgnoreCase("I")){
				 System.out.println("--item encountered --");
				 
			 }
			 else if(split[i].equalsIgnoreCase("G")){
				 System.out.println("--group encountered encountered --");
			 }
			 else if(split[i].equalsIgnoreCase("B")){
				 System.out.println("-- both group and item here --");
			 }
		 }//end if
	 }//end for
		
		
		Level lv = new Level(map);

		return lv;
	}//end load level
	
	
	private int getY(int size, int i) {
		
		return (i-1) % size;
	}//end getY
	private int getX(int size, int i) {
		
		i = i -1;	
		i = i/size;
		return i;
	}//end getX
}//end class LEVEL READER

