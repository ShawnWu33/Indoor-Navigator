
public class Basement extends CampusCenter{
	public void initMap(){
		mapMatrix = new Tile[32][24];
		
		for(int j=19;j<24;j++){
			mapMatrix[8][j]= new Tile(0,0,0,TileType.Path,8,j);
		}
		
		mapMatrix[9][18] = new Tile(0,0,0,TileType.Path,9,18);
		mapMatrix[10][17] = new Tile(0,0,0,TileType.Path,10,17);
		mapMatrix[11][16] = new Tile(0,0,0,TileType.Path,11,16);
		mapMatrix[12][16] = new Tile(0,0,0,TileType.Path,12,16);
		mapMatrix[13][15] = new Tile(0,0,0,TileType.Path,13,15);
		mapMatrix[14][14] = new Tile(0,0,0,TileType.Path,14,14);
		mapMatrix[15][13] = new Tile(0,0,0,TileType.Path,15,13);
		
		mapMatrix[15][12] = new Tile(0,0,0,TileType.Path,15,12);
		mapMatrix[16][12] = new Tile(0,0,0,TileType.Path,16,12);
		mapMatrix[16][13] = new Tile(0,0,0,TileType.Path,16,13);
		
		mapMatrix[17][11] = new Tile(0,0,0,TileType.Path,17,11);
		mapMatrix[18][11] = new Tile(0,0,0,TileType.Path,18,11);
		mapMatrix[18][10] = new Tile(0,0,0,TileType.Path,18,10);
		
		for(int j = 6;j<10;j++){
			mapMatrix[19][j] = new Tile(0,0,0,TileType.Path,19,j);

		}

		//build connections between nodes
				for (int i=0; i<=31; i++) {
					for (int j=0; j<=23; j++) {
						//connect up
						if (j>0 && mapMatrix[i][j-1] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setU(mapMatrix[i][j-1]);
						}
						//connect down
						if (j<23 && mapMatrix[i][j+1]!= null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setD(mapMatrix[i][j+1]);
						}
						//connect left
						if (i>0 && mapMatrix[i-1][j] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setL(mapMatrix[i-1][j]);
						}
						//connect right
						if (i<31 && mapMatrix[i+1][j] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setR(mapMatrix[i+1][j]);
						}
						//connect left up
						if (i>0 && j>0 && mapMatrix[i-1][j-1] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setLU(mapMatrix[i-1][j-1]);
						}
						//connect right up
						if (i<31 && j>0 && mapMatrix[i+1][j-1] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setUR(mapMatrix[i+1][j-1]);
						}
						//connect left down
						if (i>0 && j<23 && mapMatrix[i-1][j+1] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setLD(mapMatrix[i-1][j+1]);
						}
						//connect right down
						if(i<31 && j<23 && mapMatrix[i+1][j+1] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setRD(mapMatrix[i+1][j+1]);
						}
					}
				}
				mapMatrix[11][16].setUR(mapMatrix[12][16]);
				mapMatrix[11][16].setR(null);
				mapMatrix[12][16].setLD(mapMatrix[11][16]);
				mapMatrix[12][16].setL(null);











		
	}

	@Override
	public void teleport() {
		// TODO Auto-generated method stub
		
	}
}
