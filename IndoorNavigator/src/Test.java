import java.util.ArrayList;


public class Test {
	public static void expandNode(ArrayList<Tile> open, ArrayList<Tile> close, Tile current, Tile[][] groundFloor) {
		//the array keeps the expanded nodes
		ArrayList<Tile> children = new ArrayList<>();
		//add children of the current node to the array
		if (current.getU() != null) {
			current.getU().setgCost(current.getgCost()+1);
			current.getU().setfCost(current.getU().getgCost()+current.getU().gethCost());
			children.add(current.getU());
		}
		if (current.getUR() != null) {
			current.getUR().setgCost(current.getgCost()+1);
			current.getUR().setfCost(current.getUR().getgCost()+current.getUR().gethCost());
			children.add(current.getUR());
		}
		if (current.getR() != null) {
			current.getR().setgCost(current.getgCost()+1);
			current.getR().setfCost(current.getR().getgCost()+current.getR().gethCost());
			children.add(current.getR());
		}
		if (current.getRD() != null) {
			current.getRD().setgCost(current.getgCost()+1);
			current.getRD().setfCost(current.getRD().getgCost()+current.getRD().gethCost());
			children.add(current.getRD());
		}
		if (current.getD() != null) {
			current.getD().setgCost(current.getgCost()+1);
			current.getD().setfCost(current.getD().getgCost()+current.getD().gethCost());
			children.add(current.getD());
		}
		if (current.getLD() != null) {
			current.getLD().setgCost(current.getgCost()+1);
			current.getLD().setfCost(current.getLD().getgCost()+current.getLD().gethCost());
			children.add(current.getLD());
		}
		if (current.getL() != null) {
			current.getL().setgCost(current.getgCost()+1);
			current.getL().setfCost(current.getL().getgCost()+current.getL().gethCost());
			children.add(current.getL());
		}
		if (current.getLU() != null) {
			current.getLU().setgCost(current.getgCost()+1);
			current.getLU().setfCost(current.getLU().getgCost()+current.getLU().gethCost());
			children.add(current.getLU());
		}
		//remove visited nodes from expanded node
		for (int i=0; i<children.size(); i++) {
			for (int j=0; j<close.size(); j++) {
				if (children.get(i) == close.get(j)) {
					children.remove(i);
				}
			}
		}
		//get the child with minimum f
		Tile min = children.get(0);
		int i = 1;
		for (i=1; i<children.size(); i++) {
			if (children.get(i).getfCost() < min.getfCost()) {
				min = children.get(i);
			}
		}
		open.add(0, children.get(i));
		children.remove(i);
		
		for (i=0; i<children.size(); i++) {
			open.add(children.get(i));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//path generation for Ground Floor
		Tile[][] groundfloor = new Tile[40][25];

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
				groundfloor[13][10] = new Tile(0,0,0,TileType.Path);
				groundfloor[15][9] = new Tile(0,0,0,TileType.Path);
				groundfloor[28][9] = new Tile(0,0,0,TileType.level_101);
				
				for(int i =0;i<=39;i++){
					for(int j=0;j<=24;j++){
						if(groundfloor[i][j]!=null){
							groundfloor[i][j].setU(groundfloor[i][j-1]);
							groundfloor[i][j].setUR(groundfloor[i+1][j-1]);
							groundfloor[i][j].setR(groundfloor[i+1][j]);
							groundfloor[i][j].setRD(groundfloor[i+1][j+1]);
							groundfloor[i][j].setD(groundfloor[i][j+1]);
							groundfloor[i][j].setLD(groundfloor[i-1][j+1]);
							groundfloor[i][j].setL(groundfloor[i-1][j]);
							groundfloor[i][j].setLU(groundfloor[i-1][j-1]);
						}
					}
				}
				for(int i =0;i<=39;i++){
					for(int j=0;j<=24;j++){
						if(groundfloor[i][j]!=null){
							groundfloor[i][j].sethCost(Math.abs(28-i)+Math.abs(9-j));
						}
					}
				}
				
				System.out.println(groundfloor[28][9].getType());
				
				ArrayList<Tile> open = new ArrayList<>();
				ArrayList<Tile> close = new ArrayList<>();
				open.add(groundfloor[13][10]);
				
				Tile current = null;
				for(;;) {
					if (open.size() == 0) {
						System.out.println("Failure");
					}
					current = open.get(0);
					current = open.remove(0);
					close.add(current);
					if (current.getType().roomName == "office") {
						System.out.println("success");
					}
					expandNode(open, close, current, groundfloor);
				}	
	}
}
