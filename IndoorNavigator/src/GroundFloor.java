
public class GroundFloor extends CampusCenter {

	
	@Override
	public void initMap() {
		mapMatrix = new Tile[40][25];
		
		//path generation for mapMatrix Floor
		
		//[16][7] - [16][17]
		for (int j=7;j<=17;j++){
			mapMatrix[16][j]= new Tile(0,0,0,TileType.Path,16,j);
		}	
		
		//[14][9] - [14][13]
		//[17][9] - [17][13]
		for (int j=9;j<=13;j++){
			mapMatrix[14][j]= new Tile(0,0,0,TileType.Path,14,j);
			mapMatrix[17][j]= new Tile(0,0,0,TileType.Path,17,j);
		}
		//[17][18] - [17][20]
		for (int j=18;j<=20;j++){
			mapMatrix[17][j]= new Tile(0,0,0,TileType.Path,17,j);
		}
		
		//[18][20] - [18][22]
		for (int j=20;j<=22;j++){
			mapMatrix[18][j]= new Tile(0,0,0,TileType.Path,18,j);
		}
		//[25][8] - [25][12]
		for (int j=8;j<=12;j++){
			mapMatrix[25][j]= new Tile(0,0,0,TileType.Path,25,j);
		}
		for (int j=19;j<=20;j++){
			mapMatrix[26][j]= new Tile(0,0,0,TileType.Path,26,j);
		}
		//[27][8] - [27][18]
		for (int j=8;j<=18;j++){
			mapMatrix[27][j]= new Tile(0,0,0,TileType.Path,27,j);
		}
		
		
		//[25][9] - [27][9]
		//[25][12] - [27][12]
		for (int i=25;i<=27;i++){
			mapMatrix[i][9]= new Tile(0,0,0,TileType.Path,i,9);
			mapMatrix[i][12]= new Tile(0,0,0,TileType.Path,i,12);
		}
		//[14][14] - [33][14]
		for (int i=14;i<=33;i++){
			mapMatrix[i][14]= new Tile(0,0,0,TileType.Path,i,14);
		}
		//[25][15] - [28][15]
		//[25][16] - [28][16]
		for (int i=25;i<=28;i++){
			mapMatrix[i][15]= new Tile(0,0,0,TileType.Path,i,15);
			mapMatrix[i][16]= new Tile(0,0,0,TileType.Path,i,16);
		}	
		//[26][17] - [28][17]
		for (int i=26;i<=28;i++){
			mapMatrix[i][17]= new Tile(0,0,0,TileType.Path,i,17);
		}	
		//[26][18] - [27][18]
		for (int i=26;i<=27;i++){
			mapMatrix[i][18]= new Tile(0,0,0,TileType.Path,i,18);
		}	
		//[7][15] - [17][15]
		for (int i=7;i<=17;i++){
			mapMatrix[i][15]= new Tile(0,0,0,TileType.Path,i,15);
		}


		for (int i=14;i<=16;i++){
			mapMatrix[i][17]= new Tile(0,0,0,TileType.Path,i,17);
		}

			//update foodcourt
		
				for (int j=7;j<=13;j++){
					mapMatrix[16][j]= new Tile(0,5,0,TileType.Foodcourt,16,j);
				}	
				for (int j=9;j<=13;j++){
					mapMatrix[17][j]= new Tile(0,5,0,TileType.Foodcourt,17,j);
				}
				mapMatrix[13][12] = new Tile(0,0,0,TileType.Shop0,13,12);
				mapMatrix[28][9] = new Tile(0,0,0,TileType.shop7,28,9);
		
		
				//build connections between nodes
				for (int i=0; i<=39; i++) {
					for (int j=0; j<=24; j++) {
						//connect up
						if (j>0 && mapMatrix[i][j-1] != null &&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setU(mapMatrix[i][j-1]);
						}
						//connect down
						if (j<24 && mapMatrix[i][j+1]!= null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setD(mapMatrix[i][j+1]);
						}
						//connect left
						if (i>0 && mapMatrix[i-1][j] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setL(mapMatrix[i-1][j]);
						}
						//connect right
						if (i<39 && mapMatrix[i+1][j] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setR(mapMatrix[i+1][j]);
						}
						//connect left up
						if (i>0 && j>0 && mapMatrix[i-1][j-1] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setLU(mapMatrix[i-1][j-1]);
						}
						//connect right up
						if (i<39 && j>0 && mapMatrix[i+1][j-1] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setUR(mapMatrix[i+1][j-1]);
						}
						//connect left down
						if (i>0 && j<24 && mapMatrix[i-1][j+1] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setLD(mapMatrix[i-1][j+1]);
						}
						//connect right down
						if(i<39 && j<24 && mapMatrix[i+1][j+1] != null&&mapMatrix[i][j]!=null) {
							mapMatrix[i][j].setRD(mapMatrix[i+1][j+1]);
						}
					}
				}
				mapMatrix[16][13].getD().setU(null);
				mapMatrix[16][13].getLD().setUR(null);
				mapMatrix[16][13].getRD().setLU(null);
				mapMatrix[16][13].setD(null);
				mapMatrix[16][13].setLD(null);
				mapMatrix[16][13].setRD(null);


		
		

		

		
		
		
		
		
		
	}
	

	@Override
	public void teleport() {
		// TODO Auto-generated method stub
		
	}

}
