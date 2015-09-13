
public class GroundFloor extends CampusCenter {

	@Override
	public void initMap() {
		Tile[][] groundfloor = new Tile[40][25];
		
		//path generation for Ground Floor
		for (int j=7;j<=17;j++){
			groundfloor[16][j]= new Tile(0,0,0,TileType.Path);
		}	
		for (int j=9;j<=13;j++){
			groundfloor[14][j]= new Tile(0,0,0,TileType.Path);
			groundfloor[17][j]= new Tile(0,0,0,TileType.Path);
		}
		for (int j=18;j<=20;j++){
			groundfloor[17][j]= new Tile(0,0,0,TileType.Path);
		}
		for (int j=20;j<=22;j++){
			groundfloor[18][j]= new Tile(0,0,0,TileType.Path);
		}
		
		for (int j=8;j<=12;j++){
			groundfloor[25][j]= new Tile(0,0,0,TileType.Path);
		}
		for (int j=19;j<=20;j++){
			groundfloor[26][j]= new Tile(0,0,0,TileType.Path);
		}
		for (int j=8;j<=18;j++){
			groundfloor[27][j]= new Tile(0,0,0,TileType.Path);
		}
		
		
		
		
		for (int i=25;i<=27;i++){
			groundfloor[i][9]= new Tile(0,0,0,TileType.Path);
			groundfloor[i][12]= new Tile(0,0,0,TileType.Path);
		}			
		for (int i=14;i<=33;i++){
			groundfloor[i][14]= new Tile(0,0,0,TileType.Path);
		}
		for (int i=25;i<=28;i++){
			groundfloor[i][15]= new Tile(0,0,0,TileType.Path);
			groundfloor[i][16]= new Tile(0,0,0,TileType.Path);
		}			
		for (int i=26;i<=28;i++){
			groundfloor[i][17]= new Tile(0,0,0,TileType.Path);
		}	
		for (int i=26;i<=27;i++){
			groundfloor[i][18]= new Tile(0,0,0,TileType.Path);
		}	

		for (int i=7;i<=17;i++){
			groundfloor[i][15]= new Tile(0,0,0,TileType.Path);
		}


		for (int i=14;i<=16;i++){
			groundfloor[i][17]= new Tile(0,0,0,TileType.Path);
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//link path
		for(int j=9;j<=14;j++){
			groundfloor[14][j].setD(groundfloor[14][j+1]);
			groundfloor[14][j+1].setU(groundfloor[14][j]);
			groundfloor[17][j].setD(groundfloor[17][j+1]);
			groundfloor[17][j+1].setU(groundfloor[17][j]);
		}
		for(int j=7;j<=12;j++){
			groundfloor[16][j].setD(groundfloor[16][j+1]);
			groundfloor[16][j+1].setU(groundfloor[16][j]);			
		}
		for(int j=14;j<=16;j++){
			groundfloor[16][j].setD(groundfloor[16][j+1]);
			groundfloor[16][j+1].setU(groundfloor[16][j]);			
		}
		for(int j=18;j<=19;j++){
			groundfloor[17][j].setD(groundfloor[17][j+1]);
			groundfloor[17][j+1].setU(groundfloor[17][j]);
		}
		for(int j=20;j<=22;j++){
			groundfloor[18][j].setD(groundfloor[18][j+1]);
			groundfloor[18][j+1].setU(groundfloor[18][j]);
		}
		for(int j=8;j<=11;j++){
			groundfloor[25][j].setD(groundfloor[25][j+1]);
			groundfloor[25][j+1].setU(groundfloor[25][j]);
		}			
		for(int j=8;j<=17;j++){
			groundfloor[27][j].setD(groundfloor[27][j+1]);
			groundfloor[27][j+1].setU(groundfloor[27][j]);
		}
		
		
		
		
		
		
	}

	@Override
	public void teleport() {
		// TODO Auto-generated method stub
		
	}

}
