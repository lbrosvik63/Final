package groupproject;

public class TestLevel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LevelObject[][] map = new LevelObject[5][5];
		for(int x = 0; x< map.length; x++){
			for(int y = 0; y<map[x].length;y++){
				map[x][y] = new LevelObject();
			}
		}
		
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
		
		Group myGroup = new Group("Warrior", "Paladin", "Warrior");
		Level lv1 = new Level(map);
		
		GamePlay gmply = new GamePlay(myGroup, lv1);
		gmply.playLevel();
		
	}

	
	
}
