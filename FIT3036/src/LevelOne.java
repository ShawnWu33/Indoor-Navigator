public class LevelOne extends CampusCenter{
	public void initMap() {
		Tile[][] levelOne = new Tile[31][20];
		//build level one map without connections
		for (int i=6; i<=28; i++) {
			levelOne[i][12] = new Tile(0, 0, 0,TileType.Path);
		}
		
		for (int i=8; i<=11; i++) {
			levelOne[28][i] = new Tile(0, 0, 0, TileType.Path);
		}
		
		levelOne[15][11] = new Tile(0, 0, 0, TileType.Path);
		
		for (int i=21; i<=24; i++) {
			levelOne[i][11] = new Tile(0, 0, 0,TileType.Path);
		}
		
		for (int i=13; i<=16; i++) {
			levelOne[20][i] = new Tile(0, 0, 0,TileType.Path);
		}
		
		for (int i=21; i<=26; i++) {
			levelOne[i][14] = new Tile(0, 0, 0, TileType.Path);
		}
		
		for (int i=13; i<=18; i++) {
			levelOne[i][13] = new Tile(0, 0, 0, TileType.Path);
		}
		
		for (int i=13; i<=16; i++) {
			levelOne[i][14] = new Tile(0, 0, 0, TileType.Path);
		}
		
		for (int i=13; i<=15; i++) {
			levelOne[i][15] = new Tile(0, 0, 0, TileType.Path);
		}
		
		levelOne[14][16] = new Tile(0, 0, 0, TileType.Path);
		
		//build connections between nodes
		for (int i=0; i<=30; i++) {
			for (int j=0; j<=19; j++) {
				//connect up
				if (j>0 && levelOne[i][j-1] != null) {
					levelOne[i][j].setU(levelOne[i][j-1]);
				}
				//connect down
				if (j<19 && levelOne[i][j+1]!= null) {
					levelOne[i][j].setD(levelOne[i][j+1]);
				}
				//connect left
				if (i>0 && levelOne[i-1][j] != null) {
					levelOne[i][j].setL(levelOne[i-1][j]);
				}
				//connect right
				if (i<30 && levelOne[i+1][j] != null) {
					levelOne[i][j].setR(levelOne[i+1][j]);
				}
				//connect left up
				if (i>0 && j>0 && levelOne[i-1][j-1] != null) {
					levelOne[i][j].setLU(levelOne[i-1][j-1]);
				}
				//connect right up
				if (i<30 && j>0 && levelOne[i+1][j-1] != null) {
					levelOne[i][j].setUR(levelOne[i+1][j-1]);
				}
				//connect left down
				if (i>0 && j<19 && levelOne[i-1][j+1] != null) {
					levelOne[i][j].setLD(levelOne[i-1][j+1]);
				}
				//connect right down
				if(i<30 && j<19 && levelOne[i+1][j+1] != null) {
					levelOne[i][j].setRD(levelOne[i+1][j+1]);
				}
			}
		}
	}
	
	public void teleport() {
		
	}
}
