package level;
/*
 *  Level Representation
 *  - : Unvisited Block
 *  O : Visited Location
 *  X : Current Location
 *  W : Wall
 *  D : Door
 */


public class Level {

	private LevelObject[][] map;
	private int sideLength;
	private char[][] path;
	private int startRow;
	private int startCol;
	
	
	public Level(LevelObject[][] map2){
		sideLength = map2.length;
		path = new char[sideLength][sideLength];
		map = map2;
		
		for(int x = 0; x< path.length; x++){
			for(int y = 0; y<path[x].length;y++){
				path[x][y] = '-';
			}
		}
	}
	//Creates a blank map.
	//Map Dimensions = mapSideLength x mapSideLength
	public Level(int mapSideLength){
		sideLength = mapSideLength;
		path = new char[sideLength][sideLength];
		map = new LevelObject[mapSideLength][mapSideLength];
		for(int x = 0; x< map.length; x++){
			for(int y = 0; y<map[x].length;y++){
				map[x][y] = new LevelObject();
				path[x][y] = '-';
			}
		}
	}

	public void setPathAtPosition(int row, int col, char value){
		
		path[row][col] = value;
		
	}//end setPathAtPosition
	
	public String toString(){
		String temp = "";
		for(int x = 0; x< path.length; x++){
			temp += "  ";
			for(int y = 0; y<path[x].length;y++){
				temp += " ";
				temp += path[x][y];
			}
			temp += "\n";
		}
		return temp;
	}
	
	
	public LevelObject getPosition(int row, int col){
		return map[row][col];
	}
	
	public int getSideLength(){
		return sideLength;
	}
	
	public LevelObject[][] getMap() {
		return map;
	}
	public void setMap(LevelObject[][] map) {
		this.map = map;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getStartCol() {
		return startCol;
	}
	public void setStartCol(int startCol) {
		this.startCol = startCol;
	}
			
}
