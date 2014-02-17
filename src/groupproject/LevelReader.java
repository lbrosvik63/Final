package groupproject;

public class LevelReader {

	public Level loadLevel(String string) {
		
		
		int size = 5;
		
		
		//read in first line, level size
		
		
		//create a level of that size
		LevelObject[][] map = new LevelObject[size][size];
		for(int x = 0; x< map.length; x++){
			for(int y = 0; y<map[x].length;y++){
				map[x][y] = new LevelObject();
			}//end for
		}//end for
		
		
		//Set Walls
		map[0][1].setWall(true);
		map[0][2].setWall(true);
		map[0][4].setWall(true);
		map[1][4].setWall(true);
		map[2][0].setWall(true);
		map[3][0].setWall(true);
		map[3][2].setWall(true);
		map[3][3].setWall(true);
		map[4][4].setDoor(true);
		map[0][3].setItem(new Key());
		
		
		
		Level lv = new Level(map);

		return lv;
	}

	
}

//how a file will look

/*
 linenumber
 map
 
 
 
 */
