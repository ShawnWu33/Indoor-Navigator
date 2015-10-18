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
		
		//196 dining rm
		mapMatrix[13][11] = new Tile(0,0,0,TileType.level_196,13,11);
		mapMatrix[13][11].setDirection("D");
		mapMatrix[13][11].setL_description("stair to ground floor");

		mapMatrix[14][11] = new Tile(0,0,0,TileType.level_196,14,11);
		mapMatrix[14][11].setDirection("D");

		//199 asian restaurant
		mapMatrix[15][11] = new Tile(0,0,0,TileType.level_199,15,11);
		mapMatrix[15][11].setDirection("D");

		//1120 sir john's bar
		mapMatrix[13][16] = new Tile(0,0,0,TileType.level_1120,13,16);
		mapMatrix[13][16].setDirection("U");

		
		//stair 
		mapMatrix[12][13] = new Tile(0,0,0,TileType.Stairs,12,13);
		mapMatrix[12][13].setDirection("R");

		
		
		
		mapMatrix[19][13] = new Tile(0,0,0,TileType.Stairs,19,13);
		mapMatrix[19][13].setDirection("R");

		mapMatrix[21][10] = new Tile(0,0,0,TileType.level_170,21,10);
		mapMatrix[21][10].setDirection("D");

		mapMatrix[22][10] = new Tile(0,0,0,TileType.level_169,22,10);
		mapMatrix[22][10].setDirection("D");

		mapMatrix[23][10] = new Tile(0,0,0,TileType.level_168,23,10);
		mapMatrix[23][10].setDirection("D");

		mapMatrix[24][10] = new Tile(0,0,0,TileType.level_166A,24,10);
		mapMatrix[24][10].setDirection("D");


		mapMatrix[25][11] = new Tile(0,0,0,TileType.level_163,25,11);
		mapMatrix[25][11].setDirection("D");


		mapMatrix[29][12] = new Tile(0,0,0,TileType.level_1144,29,12);
		mapMatrix[29][12].setDirection("L");


		mapMatrix[19][12].setD_description("stairs to ground floor");
		
		mapMatrix[13][12].setU_description("entrance of dinning room");
		mapMatrix[13][12].setD_description("path to sir john's bar");
		
		mapMatrix[14][12].setU_description("entrance of dinning room");
		mapMatrix[14][12].setD_description("airport lounge");
		mapMatrix[15][12].setD_description("airport lounge");
		mapMatrix[16][12].setD_description("airport lounge");
		mapMatrix[17][12].setD_description("airport lounge");
		mapMatrix[18][12].setD_description("airport lounge");
		
		mapMatrix[13][13].setR_description("airport lounge");
		mapMatrix[13][14].setR_description("airport lounge");
		mapMatrix[13][15].setR_description("airport lounge");




		
		
		
		
		
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
		
		remove(mapMatrix,19,13,"L");
		remove(mapMatrix,19,13,"LU");
		remove(mapMatrix,19,13,"U");
		remove(mapMatrix,19,13,"UR");
		remove(mapMatrix,19,13,"RD");

		remove(mapMatrix,12,13,"LU");
		remove(mapMatrix,12,13,"U");
		remove(mapMatrix,12,13,"UR");
		remove(mapMatrix,12,13,"RD");


		remove(mapMatrix,21,10,"R");
		remove(mapMatrix,22,10,"R");
		remove(mapMatrix,23,10,"R");
		remove(mapMatrix,24,10,"RD");
		remove(mapMatrix,25,11,"L");

		remove(mapMatrix,13,16,"R");
		remove(mapMatrix,13,16,"UR");

		
		
		
		
		
		
		
		
	}

	private void remove(Tile[][] mapMatrix, int x, int y,String dir) {
		if(dir == "R"){
			mapMatrix[x][y].setR(null);
			mapMatrix[x+1][y].setL(null);
		}
		else if(dir =="UR"){
			mapMatrix[x][y].setUR(null);
			mapMatrix[x+1][y-1].setLD(null);
		}
		else if(dir =="U"){
			mapMatrix[x][y].setU(null);
			mapMatrix[x][y-1].setD(null);
		}
		else if(dir == "LU"){
			mapMatrix[x][y].setLU(null);
			mapMatrix[x-1][y-1].setRD(null);

		}
		else if(dir =="L"){
			mapMatrix[x][y].setL(null);
			mapMatrix[x-1][y].setR(null);

		}
		else if(dir == "LD"){
			mapMatrix[x][y].setLD(null);
			mapMatrix[x-1][y+1].setUR(null);

		}
		else if(dir =="D"){
			mapMatrix[x][y].setD(null);
			mapMatrix[x][y+1].setU(null);

		}
		else if(dir =="RD"){
			mapMatrix[x][y].setRD(null);
			mapMatrix[x+1][y+1].setUR(null);

		}
	}
	public void teleport() {
		
	}
}
