import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class App {
	
	public Tile getLocationTile(String location, Map map) {
		for (int x=0; x<map.getXLength(); x++) {
			for (int y=0; y<map.getYLength(); y++) {
				if (map.getTile(x, y).getType().name() == "location") {
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
	
	public void expandCurrentTile(Tile current, PriorityQueue<Tile> open, ArrayList<Tile> close, Map map) {
		ArrayList<Tile> expandedTiles = new ArrayList<>();
		//add all connected tiles (with current) to expandedTiles
		if (current.getU() != null && !close.contains(current.getU())) {
			current.getU().setgCost(current.getgCost()+1);
			current.getU().setfCost(current.getU().getgCost());
			expandedTiles.add(current.getU());
		}
		if (current.getD() != null && !close.contains(current.getD())) {
			current.getD().setgCost(current.getgCost()+1);
			current.getD().setfCost(current.getD().getgCost());
			expandedTiles.add(current.getD());
		}
		if (current.getL() != null && !close.contains(current.getL())) {
			current.getL().setgCost(current.getgCost()+1);
			current.getL().setfCost(current.getL().getgCost());
			expandedTiles.add(current.getL());
		}
		if (current.getR() != null && !close.contains(current.getR())) {
			current.getR().setgCost(current.getgCost()+1);
			current.getR().setfCost(current.getR().getgCost());
			expandedTiles.add(current.getR());
		}
		if (current.getLU() != null && !close.contains(current.getLU())) {
			current.getLU().setgCost(current.getgCost()+1);
			current.getLU().setfCost(current.getLU().getgCost());
			expandedTiles.add(current.getLU());
		}
		if (current.getUR() != null && !close.contains(current.getUR())) {
			current.getUR().setgCost(current.getgCost()+1);
			current.getUR().setfCost(current.getUR().getgCost());
			expandedTiles.add(current.getUR());
		}
		if (current.getLD() != null && !close.contains(current.getLD())) {
			current.getLD().setgCost(current.getgCost()+1);
			current.getLD().setfCost(current.getLD().getgCost());
			expandedTiles.add(current.getLD());
		}
		if (current.getRD() != null && !close.contains(current.getRD())) {
			current.getRD().setgCost(current.getgCost()+1);
			current.getRD().setfCost(current.getRD().getgCost());
			expandedTiles.add(current.getRD());
		}
		//redirection
		redirection(open, expandedTiles, current);
		
	}
	
	public ArrayList<String> aStarPathFinding(Tile startTile, Tile endTile, Map map) {
		//initialize the path, path will contains the finally route
		ArrayList<String> path = new ArrayList<>();
		//initialize the current, current is the node we choose to expand in each iteration
		Tile current = startTile;
		//initialize open and close lists
		Comparator<Tile> theComparator = new Comparator<Tile>() {
			@Override
			public int compare(Tile o1, Tile o2) {
				// TODO Auto-generated method stub
				return o2.getfCost() - o1.getfCost();
			}
		};
		PriorityQueue<Tile> open = new PriorityQueue<>(theComparator);
		open.add(current);
		ArrayList<Tile> close = new ArrayList<>();
		for (;;) {
			//if the open is empty then return failure
			if (open.size() == 0) {
				return null;
			}
			//choose the tile with the lowest f
			current = open.poll();
			//check if we reached the goal
			if (current.getType().name() == endTile.getType().name()) {
				return path;
			}
			expandCurrentTile(current, open, close, map);
		}
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
		
		if (startTile != null && destinationTile != null) {
			ArrayList<String>path = aStarPathFinding(startTile, destinationTile, map);
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