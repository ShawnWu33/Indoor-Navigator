
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
				
								
				
				//G101 Pharmacy
				mapMatrix[13][12] = new Tile(0,5,0,TileType.Shop0,13,12);
				mapMatrix[13][12].setDirection("R");
				mapMatrix[13][12].setR_description("foodcourt");
				mapMatrix[13][12].setD_description("monash meeting point");
				//G29 Hair cut
				mapMatrix[28][9] = new Tile(0,5,0,TileType.shop7,28,9);
				mapMatrix[28][9].setDirection("L");
				mapMatrix[28][9].setU_description("Campus centre entrance");
				mapMatrix[28][9].setL_description("dinning area");
				mapMatrix[28][9].setD_description("path to the monash bookstore and monash connect");
				//G26 comm bank
				mapMatrix[28][10] = new Tile(0,5,0,TileType.Room18,28,10);
				mapMatrix[28][10].setDirection("L");
				mapMatrix[28][10].setU_description("Campus centre entrance");
				mapMatrix[28][10].setL_description("dinning area");
				mapMatrix[28][10].setD_description("path to the monash bookstore and monash connect");
				//G25  ?? *phoneshop
				mapMatrix[28][11] = new Tile(0,5,0,TileType.Room19,28,11);
				mapMatrix[28][11].setDirection("L");
				mapMatrix[28][11].setU_description("Campus centre entrance");
				mapMatrix[28][11].setL_description("dinning area");
				mapMatrix[28][11].setD_description("path to the monash bookstore and monash connect");
				//G24 travle agency
				mapMatrix[28][13] = new Tile(0,5,0,TileType.Office4,28,12);
				mapMatrix[28][13].setDirection("L");
				mapMatrix[28][13].setU_description("Campus centre entrance");
				mapMatrix[28][13].setL_description("dinning area");
				mapMatrix[28][13].setD_description("path to the monash bookstore and monash connect");
				//G11 book shop
				mapMatrix[29][15] = new Tile(0,5,0,TileType.Shop1,29,15);
				mapMatrix[28][15].setDirection("L");
				mapMatrix[28][15].setU_description("intersection");
				mapMatrix[28][15].setL_description("stair to the second floor");
				mapMatrix[28][15].setD_description("path to the monash connect");
				//G163 monash connect
				mapMatrix[25][20] = new Tile(0,5,0,TileType.MonashConnect,25,20);
				mapMatrix[25][20].setDirection("R");
				mapMatrix[25][20].setU_description("intersection");
				mapMatrix[25][20].setR_description("monash book store");
				mapMatrix[25][20].setD_description("path to the campus centre entrance");
				//G32 coffee wise
				mapMatrix[24][13] = new Tile(0,5,0,TileType.Restaurant3,24,13);
				mapMatrix[24][13].setDirection("D");
				mapMatrix[24][13].setD_description("stair to second floor");
				mapMatrix[24][13].setR_description("path to the monash book store");
				mapMatrix[24][13].setL_description("path to the campus centre meeting point");
				//G36 MU shop
				mapMatrix[22][15] = new Tile(0,5,0,TileType.Shop3,22,15);
				mapMatrix[22][15].setDirection("U");
				mapMatrix[22][15].setU_description("peri peri chicken restaurant");
				mapMatrix[22][15].setR_description("path to the monash book store");
				mapMatrix[22][15].setL_description("path to the campus centre meeting point");
				//G37 Asian shop
				mapMatrix[20][15] = new Tile(0,5,0,TileType.Shop4,20,15);
				mapMatrix[20][15].setDirection("U");
				mapMatrix[20][15].setU_description("peri peri chicken restaurant");
				mapMatrix[20][15].setR_description("path to the monash book store");
				mapMatrix[20][15].setL_description("path to the campus centre meeting point");
				//G65 Optometrist
				mapMatrix[13][9] = new Tile(0,5,0,TileType.shop6,13,9);
				mapMatrix[13][9].setDirection("D");
				mapMatrix[13][9].setR_description("path to the food court");
				mapMatrix[13][9].setL_description("medecare centre");
				//G66 medicle centre
				mapMatrix[12][10] = new Tile(0,5,0,TileType.Medicare,12,10);
				mapMatrix[12][10].setDirection("R");
				mapMatrix[12][10].setU_description("Optometrist");
				mapMatrix[12][10].setR_description("path to the food court");
				mapMatrix[12][10].setL_description("pharmacy");
				//G144 female toilet
				mapMatrix[9][16] = new Tile(0,5,0,TileType.Toilet1,9,16);
				//G145 Male toilet
				mapMatrix[11][16] = new Tile(0,5,0,TileType.Toilet2,11,16);
				//G150 joe's pizza
				mapMatrix[16][18] = new Tile(0,5,0,TileType.Restaurant0,16,18);
				mapMatrix[16][18].setDirection("U");
				mapMatrix[16][18].setU_description("campus centre meeting point");
				mapMatrix[16][18].setR_description("Artichoke & Whitebait");
				mapMatrix[16][18].setL_description("stair to the second floor");
				//G38 Artichoke & Whitebait
				mapMatrix[18][18] = new Tile(0,5,0,TileType.Restaurant6,18,18);
				//G158 Neptune Fish&Chipery
				mapMatrix[19][20] = new Tile(0,5,0,TileType.Restaurant2,19,20);
				//G157 noodle centre
				mapMatrix[17][22] = new Tile(0,5,0,TileType.Restaurant8,17,22);
				//stairs
				mapMatrix[15][16] = new Tile(0,0,0,TileType.Stairs,15,16);
				mapMatrix[24][16] = new Tile(0,0,0,TileType.Stairs,24,16);
				
				//new add 2015.10.12
				mapMatrix[14][8] = new Tile(0,0,0,TileType.NWGate,14,8);
				mapMatrix[14][8].setDirection("D");
				mapMatrix[14][8].setD_description("North West Entrance");

				mapMatrix[19][22] = new Tile(0,0,0,TileType.SWGate,19,22);
				mapMatrix[19][22].setDirection("L");
				mapMatrix[19][22].setL_description("Noodle Centre");

				mapMatrix[27][7] = new Tile(0,0,0,TileType.NEGate,27,7);
				mapMatrix[27][7].setDirection("D");
				mapMatrix[27][7].setD_description("North East entrance");

				mapMatrix[14][9].setL_description("Optometrist");
				mapMatrix[14][9].setR_description("trash bin");

				mapMatrix[14][11].setL_description("phamarcy");
				mapMatrix[14][11].setR_description("food court");
				mapMatrix[14][12].setL_description("phamarcy");
				mapMatrix[14][12].setR_description("food court");
				mapMatrix[14][13].setL_description("phamarcy");
				mapMatrix[14][13].setR_description("food court");

				
				mapMatrix[15][15].setR_description("pillar and coffee shop");
				mapMatrix[15][15].setD_description("stair to first floor");

				mapMatrix[16][15].setL_description("pillar");
				mapMatrix[16][15].setR_description("coffee shop");
				
				mapMatrix[16][17].setD_description("pizza restaurant");
				mapMatrix[17][20].setL_description("elevator");
				mapMatrix[17][20].setD_description("automatic door");

				mapMatrix[18][20].setD_description("automatic door");
				mapMatrix[18][20].setR_description("fish and chips restaurant");



				mapMatrix[15][14].setU_description("food court");
				mapMatrix[15][14].setD_description("coffee shop");
				mapMatrix[16][14].setU_description("food court");
				mapMatrix[16][14].setD_description("coffee shop");
				mapMatrix[17][14].setU_description("food court");
				mapMatrix[17][14].setD_description("coffee shop");
				mapMatrix[18][14].setU_description("food court");
				mapMatrix[18][14].setD_description("coffee shop");


				mapMatrix[20][14].setD_description("asian grocery shop");
				mapMatrix[21][14].setU_description("Peri Peri chicken restaurant");
				mapMatrix[22][14].setD_description("monash convinient store");
				mapMatrix[21][14].setU_description("Peri Peri chicken restaurant");
				mapMatrix[24][14].setU_description("Coffee Wise");
				mapMatrix[25][14].setU_description("Coffee Wise");
				mapMatrix[26][14].setU_description("Coffee Wise");
				
				mapMatrix[27][13].setR_description("Travel Agency");
				mapMatrix[27][11].setR_description("Phone Shop");
				mapMatrix[27][10].setR_description("common bank");
				mapMatrix[27][9].setR_description("Hair and beauty");
				
				mapMatrix[27][18].setR_description("automaic door");

				mapMatrix[25][16].setL_description("stair to second floor");

				for(int i =14;i<27;i++){
					mapMatrix[i][14].setR_description(" walking path toward monash book store ");
				}
				
				
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

				remove(mapMatrix,16,13,"LD");
				remove(mapMatrix,16,13,"RD");
				remove(mapMatrix,16,13,"D");

				remove(mapMatrix,25,12,"LD");
				remove(mapMatrix,28,11,"U");
				remove(mapMatrix,28,10,"U");
				
				//new add 2015.10.12
				remove(mapMatrix,25,12,"LD");
				remove(mapMatrix,28,9,"D");
				remove(mapMatrix,28,9,"LD");
				remove(mapMatrix,28,9,"LU");
				remove(mapMatrix,28,10,"D");
				remove(mapMatrix,28,13,"D");

				remove(mapMatrix,26,14,"D");


				remove(mapMatrix,24,16,"UR");

				remove(mapMatrix,15,16,"D");
				remove(mapMatrix,15,16,"LD");
				remove(mapMatrix,15,16,"RD");
				remove(mapMatrix,15,16,"U");
				remove(mapMatrix,15,16,"UR");
				remove(mapMatrix,15,16,"LU");
				
				remove(mapMatrix,26,12,"UR");
				remove(mapMatrix,26,12,"RD");
				remove(mapMatrix,26,14,"LD");

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


	@Override
	public void teleport() {
		// TODO Auto-generated method stub
		
	}

}
