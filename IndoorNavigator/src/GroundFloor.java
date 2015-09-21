
public class GroundFloor extends CampusCenter {

	@Override
	public void initMap() {
		mapMatrix = new Tile[40][25];
		
		//path generation for Ground Floor
		for (int j=7;j<=17;j++){
			mapMatrix[16][j]= new Tile(0,0,0,TileType.Path);
		}	
		for (int j=9;j<=13;j++){
			mapMatrix[14][j]= new Tile(0,0,0,TileType.Path);
			mapMatrix[17][j]= new Tile(0,0,0,TileType.Path);
		}
		for (int j=18;j<=20;j++){
			mapMatrix[17][j]= new Tile(0,0,0,TileType.Path);
		}
		for (int j=20;j<=22;j++){
			mapMatrix[18][j]= new Tile(0,0,0,TileType.Path);
		}
		
		for (int j=8;j<=12;j++){
			mapMatrix[25][j]= new Tile(0,0,0,TileType.Path);
		}
		for (int j=19;j<=20;j++){
			mapMatrix[26][j]= new Tile(0,0,0,TileType.Path);
		}
		for (int j=8;j<=18;j++){
			mapMatrix[27][j]= new Tile(0,0,0,TileType.Path);
		}
		
		
		
		
		for (int i=25;i<=27;i++){
			mapMatrix[i][9]= new Tile(0,0,0,TileType.Path);
			mapMatrix[i][12]= new Tile(0,0,0,TileType.Path);
		}			
		for (int i=14;i<=33;i++){
			mapMatrix[i][14]= new Tile(0,0,0,TileType.Path);
		}
		for (int i=25;i<=28;i++){
			mapMatrix[i][15]= new Tile(0,0,0,TileType.Path);
			mapMatrix[i][16]= new Tile(0,0,0,TileType.Path);
		}			
		for (int i=26;i<=28;i++){
			mapMatrix[i][17]= new Tile(0,0,0,TileType.Path);
		}	
		for (int i=26;i<=27;i++){
			mapMatrix[i][18]= new Tile(0,0,0,TileType.Path);
		}	

		for (int i=7;i<=17;i++){
			mapMatrix[i][15]= new Tile(0,0,0,TileType.Path);
		}


		for (int i=14;i<=16;i++){
			mapMatrix[i][17]= new Tile(0,0,0,TileType.Path);
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//link path
		for(int j=9;j<=14;j++){
			mapMatrix[14][j].setD(mapMatrix[14][j+1]);
			mapMatrix[14][j+1].setU(mapMatrix[14][j]);
			mapMatrix[17][j].setD(mapMatrix[17][j+1]);
			mapMatrix[17][j+1].setU(mapMatrix[17][j]);
		}
		for(int j=7;j<=12;j++){
			mapMatrix[16][j].setD(mapMatrix[16][j+1]);
			mapMatrix[16][j+1].setU(mapMatrix[16][j]);			
		}
		for(int j=14;j<=16;j++){
			mapMatrix[16][j].setD(mapMatrix[16][j+1]);
			mapMatrix[16][j+1].setU(mapMatrix[16][j]);			
		}
		for(int j=18;j<=19;j++){
			mapMatrix[17][j].setD(mapMatrix[17][j+1]);
			mapMatrix[17][j+1].setU(mapMatrix[17][j]);
		}
		for(int j=20;j<=22;j++){
			mapMatrix[18][j].setD(mapMatrix[18][j+1]);
			mapMatrix[18][j+1].setU(mapMatrix[18][j]);
		}
		for(int j=8;j<=11;j++){
			mapMatrix[25][j].setD(mapMatrix[25][j+1]);
			mapMatrix[25][j+1].setU(mapMatrix[25][j]);
		}			
		for(int j=8;j<=17;j++){
			mapMatrix[27][j].setD(mapMatrix[27][j+1]);
			mapMatrix[27][j+1].setU(mapMatrix[27][j]);
		}
		
		
		
		
		
		
	}

	@Override
	public void teleport() {
		// TODO Auto-generated method stub
		
	}

}
