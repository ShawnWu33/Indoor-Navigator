public class LevelOne extends CampusCenter{
	public void initMap() {
		mapMatrix = new Tile[31][20];
		//build level one map without connections
		for (int i=6; i<=28; i++) {
			mapMatrix[i][12] = new Tile(0, 0, 0,TileType.Path,i,12);
		}
		
		for (int i=8; i<=11; i++) {
			mapMatrix[28][i] = new Tile(0, 0, 0, TileType.Path,28,i);
		}
		
		mapMatrix[15][11] = new Tile(0, 0, 0, TileType.Path,15,11);
		
		for (int i=21; i<=24; i++) {
			mapMatrix[i][11] = new Tile(0, 0, 0,TileType.Path,i,11);
		}
		
		for (int i=13; i<=16; i++) {
			mapMatrix[20][i] = new Tile(0, 0, 0,TileType.Path,20,i);
		}
		
		for (int i=21; i<=26; i++) {
			mapMatrix[i][14] = new Tile(0, 0, 0, TileType.Path,i,14);
		}
		
		for (int i=13; i<=18; i++) {
			mapMatrix[i][13] = new Tile(0, 0, 0, TileType.Path,i,13);
		}
		
		for (int i=13; i<=16; i++) {
			mapMatrix[i][14] = new Tile(0, 0, 0, TileType.Path,i,14);
		}
		
		for (int i=13; i<=15; i++) {
			mapMatrix[i][15] = new Tile(0, 0, 0, TileType.Path,i,15);
		}
		
		mapMatrix[14][16] = new Tile(0, 0, 0, TileType.Path,14,16);
		
		//build connections between nodes
		for (int i=0; i<=30; i++) {
			for (int j=0; j<=19; j++) {
				//connect up
				if (j>0 && mapMatrix[i][j-1] != null&&mapMatrix[i][j]!=null) {
					mapMatrix[i][j].setU(mapMatrix[i][j-1]);
				}
				//connect down
				if (j<19 && mapMatrix[i][j+1]!= null&&mapMatrix[i][j]!=null) {
					mapMatrix[i][j].setD(mapMatrix[i][j+1]);
				}
				//connect left
				if (i>0 && mapMatrix[i-1][j] != null&&mapMatrix[i][j]!=null) {
					mapMatrix[i][j].setL(mapMatrix[i-1][j]);
				}
				//connect right
				if (i<30 && mapMatrix[i+1][j] != null&&mapMatrix[i][j]!=null) {
					mapMatrix[i][j].setR(mapMatrix[i+1][j]);
				}
				//connect left up
				if (i>0 && j>0 && mapMatrix[i-1][j-1] != null&&mapMatrix[i][j]!=null) {
					mapMatrix[i][j].setLU(mapMatrix[i-1][j-1]);
				}
				//connect right up
				if (i<30 && j>0 && mapMatrix[i+1][j-1] != null&&mapMatrix[i][j]!=null) {
					mapMatrix[i][j].setUR(mapMatrix[i+1][j-1]);
				}
				//connect left down
				if (i>0 && j<19 && mapMatrix[i-1][j+1] != null&&mapMatrix[i][j]!=null) {
					mapMatrix[i][j].setLD(mapMatrix[i-1][j+1]);
				}
				//connect right down
				if(i<30 && j<19 && mapMatrix[i+1][j+1] != null&&mapMatrix[i][j]!=null) {
					mapMatrix[i][j].setRD(mapMatrix[i+1][j+1]);
				}
			}
		}
	}
	
	public void teleport() {
		
	}
}
