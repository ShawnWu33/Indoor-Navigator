import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
	
	public Tile getLocationTile(String location, Map map) {
		for (int x=0; x<map.getXLength(); x++) {
			for (int y=0; y<map.getYLength(); y++) {
				if (map.getTile(x, y)!=null && map.getTile(x, y).getType().roomName == location) {
					return map.getTile(x, y);
				}
			}
		}
		return null;
	}
	
	public void redirection(PriorityQueue<Tile> open, ArrayList<Tile> expandedTiles, Tile current) {
		//counter for expandedTile
		int i=0;
		//the loop go through each element in expandedTiles
		while (i<expandedTiles.size()) {
			//if the tile in expandedTile is already in open
			if (open.contains(expandedTiles.get(i))) {
				//transfer this open to a array list
				ArrayList<Tile> openArray = new ArrayList<>(open);
				//if the total cost from its current parent is  greater than its new parent then we redirect it
				if (openArray.get(openArray.indexOf(expandedTiles.get(i))).getfCost() > expandedTiles.get(i).getfCost()) {
					//here is where the redirection occurred
					openArray.get(openArray.indexOf(expandedTiles.get(i))).setParent(current);
				}
				//no matter redirection occurred or not, we delete the tile from expandedTiles
				expandedTiles.remove(i);
				//here we reconstruct open back to a priority queue
				open.clear();
				for (int j=0; i<openArray.size(); j++) {
					open.add(openArray.get(j));
				}
			}
			i++;
		}
	}
	
	public void expandCurrentTile(Tile current, ArrayList<Tile> open, ArrayList<Tile> close, Map map) {
		ArrayList<Tile> expandedTiles = new ArrayList<>();
		//add all connected tiles (with current) to expandedTiles
		int tentative_g_cost = current.getgCost() + 1;
		if (current.getU() != null && !close.contains(current.getU())) {
			if(!open.contains(current.getU()) || tentative_g_cost < current.getU().getgCost()){
				current.getU().setgCost(tentative_g_cost);
				current.getU().setfCost(current.getU().getgCost()+current.getU().gethCost());
				current.getU().setParent(current);
				expandedTiles.add(current.getU());
				if(!open.contains(current.getU())){
				open.add(current.getU());
				}
			}
		}
		if (current.getD() != null && !close.contains(current.getD())) {
			if(!open.contains(current.getD()) || tentative_g_cost < current.getD().getgCost()){

				current.getD().setgCost(tentative_g_cost);
				current.getD().setfCost(current.getD().getgCost()+current.getD().gethCost());
				current.getD().setParent(current);
				expandedTiles.add(current.getD());
				if(!open.contains(current.getD())){
				open.add(current.getD());
				}
			}
		}
		if (current.getL() != null && !close.contains(current.getL())) {
			if(!open.contains(current.getL()) || tentative_g_cost < current.getL().getgCost()){

				current.getL().setgCost(tentative_g_cost);
				current.getL().setfCost(current.getL().getgCost()+current.getL().gethCost());
				current.getL().setParent(current);
				expandedTiles.add(current.getL());
				if(!open.contains(current.getL())){
				open.add(current.getL());
				}
			}
		}
		if (current.getR() != null && !close.contains(current.getR())) {
			if(!open.contains(current.getR()) || tentative_g_cost < current.getR().getgCost()){

				current.getR().setgCost(tentative_g_cost);
				current.getR().setfCost(current.getR().getgCost()+current.getR().gethCost());
				current.getR().setParent(current);
				expandedTiles.add(current.getR());
				if(!open.contains(current.getR())){
				open.add(current.getR());
				}
			}

		}
		if (current.getLU() != null && !close.contains(current.getLU())) {
			if(!open.contains(current.getLU()) || tentative_g_cost < current.getLU().getgCost()){

				current.getLU().setgCost(tentative_g_cost);
				current.getLU().setfCost(current.getLU().getgCost()+current.getLU().gethCost());
				current.getLU().setParent(current);
				expandedTiles.add(current.getLU());
				if(!open.contains(current.getLU())){
				open.add(current.getLU());
				}
			}
		}
		if (current.getUR() != null && !close.contains(current.getUR())) {
			if(!open.contains(current.getUR()) || tentative_g_cost < current.getUR().getgCost()){

				current.getUR().setgCost(tentative_g_cost);
				current.getUR().setfCost(current.getUR().getgCost()+current.getUR().gethCost());
				current.getUR().setParent(current);
				expandedTiles.add(current.getUR());
				if(!open.contains(current.getUR())){
				open.add(current.getUR());
				}
			}

		}
		if (current.getLD() != null && !close.contains(current.getLD())) {
			if(!open.contains(current.getLD()) || tentative_g_cost < current.getLD().getgCost()){

				current.getLD().setgCost(tentative_g_cost);
				current.getLD().setfCost(current.getLD().getgCost()+current.getLD().gethCost());
				current.getLD().setParent(current);
				expandedTiles.add(current.getLD());
				if(!open.contains(current.getLD())){
				open.add(current.getLD());
				}
			}
		}
		if (current.getRD() != null && !close.contains(current.getRD())) {
			if(!open.contains(current.getRD()) || tentative_g_cost < current.getRD().getgCost()){

			current.getRD().setgCost(tentative_g_cost);
			current.getRD().setfCost(current.getRD().getgCost()+current.getRD().gethCost());
			current.getRD().setParent(current);
			expandedTiles.add(current.getRD());
			if(!open.contains(current.getRD())){
				open.add(current.getRD());
			}
			}
		}
		//redirection
		//redirection(open, expandedTiles, current);
		
	}
	
	public ArrayList<String> aStarPathFinding(Tile startTile, Tile endTile, Map map) {
		//initialize the path, path will contains the finally route
		ArrayList<String> path = new ArrayList<>();
		//initialize the current, current is the node we choose to expand in each iteration
		Tile current = startTile;
		//initialize open and close lists
		
		ArrayList<Tile> open = new ArrayList<>();
		open.add(current);
		ArrayList<Tile> close = new ArrayList<>();
		for (;;) {
			//if the open is empty then return failure
			if (open.size() == 0) {
				return null;
			}
			//choose the tile with the lowest f
			int min = open.get(0).getfCost();
			int index=0;
			for(int i =1;i<open.size();i++){
				if(open.get(i).getfCost()<min){
					min = open.get(i).getfCost();
					index = i;
				}
			}
			current = open.get(index);
			open.remove(index);
			close.add(current);
			//check if we reached the goal
			//if (current.getType().name() == endTile.getType().name()) {
			  if(current == endTile){
				path = construct_path(current);
				return path;
			}
			expandCurrentTile(current, open, close, map);
		}
	}
	public ArrayList<String> construct_path(Tile endTile){
		ArrayList<String> path = new ArrayList<>();
		Tile current = endTile;
		while(current.getParent()!=null){
			if(current.getParent()==current.getU()){
				path.add(0, "D");
			}
			else if(current.getParent()==current.getUR()){
				path.add(0, "LD");
			}
			else if(current.getParent()==current.getR()){
				path.add(0, "L");
			}
			else if(current.getParent()==current.getRD()){
				path.add(0, "LU");
			}
			else if(current.getParent()==current.getD()){
				path.add(0, "U");
			}
			else if(current.getParent()==current.getLD()){
				path.add(0, "UR");
			}
			else if(current.getParent()==current.getL()){
				path.add(0, "R");
			}
			else if(current.getParent()==current.getLU()){
				path.add(0, "RD");
			}
			current = current.getParent();
		}
		return path;
	}
	public void findOutRoute(String initialLocation, String destination, String building, String level) {
		Map map = null;
		if (building == "Campus centre") {
			if (level == "Ground") {
				map = new GroundFloor();
			}
			else if (level == "level 1") {
				map = new LevelOne();
			}
			//else if level == "base"
			else {
				System.out.println("Cannot find " + level);
				//error
				System.exit(0);
			}
		}
		//else if (building == "something else") 
		else {
			System.out.println("Cannot find " + building);
			//error
			System.exit(0);
		}

		Tile startTile = getLocationTile(initialLocation, map);
		Tile destinationTile = getLocationTile(destination, map);
		startTile = map.getTile(16, 14);
		destinationTile = map.getTile(16, 13);
		//set H cost
		for(int i =0;i<=39;i++){
			for(int j=0;j<=24;j++){
				if(map.getTile(i, j)!=null){
					map.getTile(i, j).sethCost(Math.abs(destinationTile.getX()-i)+Math.abs(destinationTile.getY()-j)+map.getTile(i,j).gethCost());
				}
			}
		}
		
		if (startTile != null && destinationTile != null) {
			ArrayList<String>path = aStarPathFinding(startTile, destinationTile, map);
			System.out.println(path);
			if (path == null) {
				
				System.out.println("Failure: cannot find a path.");
				//error
				System.exit(0);
			}
		}
		else {
			//error
			System.out.println("Cannot find initial/destination location.");
			System.exit(0);
		}
	}

}
