import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

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
		int tentative_g_cost_2 = current.getgCost()+2;
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
			if(!open.contains(current.getLU()) || tentative_g_cost_2 < current.getLU().getgCost()){

				current.getLU().setgCost(tentative_g_cost_2);
				current.getLU().setfCost(current.getLU().getgCost()+current.getLU().gethCost());
				current.getLU().setParent(current);
				expandedTiles.add(current.getLU());
				if(!open.contains(current.getLU())){
				open.add(current.getLU());
				}
			}
		}
		if (current.getUR() != null && !close.contains(current.getUR())) {
			if(!open.contains(current.getUR()) || tentative_g_cost_2 < current.getUR().getgCost()){

				current.getUR().setgCost(tentative_g_cost_2);
				current.getUR().setfCost(current.getUR().getgCost()+current.getUR().gethCost());
				current.getUR().setParent(current);
				expandedTiles.add(current.getUR());
				if(!open.contains(current.getUR())){
				open.add(current.getUR());
				}
			}

		}
		if (current.getLD() != null && !close.contains(current.getLD())) {
			if(!open.contains(current.getLD()) || tentative_g_cost_2 < current.getLD().getgCost()){

				current.getLD().setgCost(tentative_g_cost_2);
				current.getLD().setfCost(current.getLD().getgCost()+current.getLD().gethCost());
				current.getLD().setParent(current);
				expandedTiles.add(current.getLD());
				if(!open.contains(current.getLD())){
				open.add(current.getLD());
				}
			}
		}
		if (current.getRD() != null && !close.contains(current.getRD())) {
			if(!open.contains(current.getRD()) || tentative_g_cost_2 < current.getRD().getgCost()){

			current.getRD().setgCost(tentative_g_cost_2);
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
	public ArrayList<ArrayList<String>> findOutRoute(String initialLocation, String destination, String building, String level,String start_floor, String end_floor) {
		ArrayList<ArrayList<String>> output = new ArrayList<>();
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
		Map ground = new GroundFloor();
		ground.setScale(1.0);
		Map levelOne = new LevelOne();
		levelOne.setScale(3.0);
		//Tile startTile = getLocationTile(initialLocation, map);
		//Tile destinationTile = getLocationTile(destination, map);
		
		Tile startTile = getLocationTile(initialLocation, ground);
		Tile destinationTile = getLocationTile(destination, ground);		
		
		
		startTile = ground.getTile(14, 8);
		destinationTile = ground.getTile(28, 9);
		
		
		if(start_floor == "ground" && end_floor == "ground"){
			for(int i =0;i<=ground.getXLength()-1;i++){
				for(int j=0;j<=ground.getYLength()-1;j++){
					if(ground.getTile(i, j)!=null){
						ground.getTile(i, j).sethCost(Math.abs(destinationTile.getX()-i)+Math.abs(destinationTile.getY()-j)+ground.getTile(i,j).gethCost());
					}
				}
			}
			ArrayList<String>path = aStarPathFinding(startTile, destinationTile, map);
			System.out.println(path);
			output = get_route_description(path,ground,startTile);
			
		}
		else if(start_floor =="ground"&& end_floor =="level1"){
			Tile temp_destination =null;
			Tile temp_start = null;
			if(startTile.getX()<21){
				temp_destination = ground.getTile(15, 16);
				temp_start = levelOne.getTile(12, 13);
				}
			else{
				temp_destination = ground.getTile(24, 16);
				temp_start = levelOne.getTile(19, 13);
			}
				//set ground H
				for(int i =0;i<=ground.getXLength()-1;i++){
					for(int j=0;j<=ground.getYLength()-1;j++){
						if(ground.getTile(i, j)!=null){
							ground.getTile(i, j).sethCost(Math.abs(temp_destination.getX()-i)+Math.abs(temp_destination.getY()-j)+ground.getTile(i,j).gethCost());
						}
					}
				}
				//set level 1 H
				for(int i =0;i<=levelOne.getXLength()-1;i++){
					for(int j=0;j<=levelOne.getYLength()-1;j++){
						if(levelOne.getTile(i, j)!=null){
							levelOne.getTile(i, j).sethCost(Math.abs(destinationTile.getX()-i)+Math.abs(destinationTile.getY()-j)+levelOne.getTile(i,j).gethCost());
						}
					}
				}
				ArrayList<String>path = aStarPathFinding(startTile, temp_destination, ground);
				System.out.println(path);

				output = get_route_description(path,ground,startTile);
				
				
				path = aStarPathFinding(temp_start, destinationTile, levelOne);
				System.out.println(path);

				String newRoute = output.get(1).get(output.get(1).size()-1);
				newRoute += " and walk up to the stair to level one";
				output.get(1).remove(output.get(1).size() -1);
				output.get(1).add(newRoute);
				
				ArrayList<ArrayList<String>> new_output = get_route_description(path,levelOne,temp_start);
				for(int i =0;i<new_output.get(0).size();i++){
					output.get(0).add(new_output.get(0).get(i));
				}
				for(int i =0;i<new_output.get(1).size();i++){
					output.get(1).add(new_output.get(1).get(i));
				}
				for(int i =0;i<new_output.get(2).size();i++){
					output.get(2).add(new_output.get(2).get(i));
				}
				for(int i =0;i<new_output.get(3).size();i++){
					output.get(3).add(new_output.get(3).get(i));
				}
				
				
			
			
			
		}
		
		/*
		startTile = map.getTile(14, 8);
		destinationTile = map.getTile(15, 16);
		//set H cost
		for(int i =0;i<=map.getXLength()-1;i++){
			for(int j=0;j<=map.getYLength()-1;j++){
				if(map.getTile(i, j)!=null){
					map.getTile(i, j).sethCost(Math.abs(destinationTile.getX()-i)+Math.abs(destinationTile.getY()-j)+map.getTile(i,j).gethCost());
				}
			}
		}
		
		if (startTile != null && destinationTile != null) {
			ArrayList<String>path = aStarPathFinding(startTile, destinationTile, map);
			System.out.println(path);

			
			output = get_route_description(path,map,startTile);
			
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
		*/
		return output;
	}

	private ArrayList<ArrayList<String>> get_route_description(ArrayList<String> path, Map map, Tile startTile) {
		// TODO Auto-generated method stub
		
		ArrayList<String> q_route_description = new ArrayList<>();
		ArrayList<String> q_env_description = new ArrayList<>();
		ArrayList<String> q_L_env_description = new ArrayList<>();
		ArrayList<String> q_R_env_description = new ArrayList<>();
		String output ="";
		int counter=0;
		int x = startTile.getX();
		int y = startTile.getY();
		String current_direction=null,current_facing=null;
		Tile current_position = map.getTile(x, y);
		if(startTile.getDirection()!=null){
			if(startTile.getDirection()=="R"){
				current_direction=startTile.getDirection();
				current_facing = "East";
			}
			if(startTile.getDirection()=="L"){
				current_direction=startTile.getDirection();
				current_facing = "West";
				}
			if(startTile.getDirection()=="U"){
				current_direction=startTile.getDirection();
				current_facing = "North";
				}
			if(startTile.getDirection()=="D"){
				current_direction=startTile.getDirection();
				current_facing = "South";
				}
		}
		
		//description of current position
		ArrayList<String[]> result = new ArrayList<>();
		result = get_route_distance(path);
		String turn = "";
		if(current_direction == result.get(0)[0]){
			q_env_description.add("You are at "+ current_position.getType().roomName +" facing " + current_facing +" "+ get_env_description(current_position,current_direction,"current"));
		}
		for(int i=0;i<result.size();i++){
			if(current_direction == result.get(i)[0]){
				if(result.get(i)[0]=="R"||result.get(i)[0]=="L"||result.get(i)[0]=="D"||result.get(i)[0]=="U"){
					q_route_description.add("Moving forward for "+ Double.parseDouble(result.get(i)[1])*map.getScale()+ " meters");
				}
				else if(result.get(i)[0]=="UR"||result.get(i)[0]=="RD"||result.get(i)[0]=="LD"||result.get(i)[0]=="LU"){
					q_route_description.add("Moving forward for "+ Double.parseDouble(result.get(i)[1])*map.getScale()*1.4 + " meters");

				}
			}
			if(current_direction !=result.get(i)[0]){
				turn = get_degree(current_direction,result.get(i)[0]);
				if(result.get(i)[0]=="R"||result.get(i)[0]=="L"||result.get(i)[0]=="D"||result.get(i)[0]=="U"){
					q_route_description.add("Turn " + turn +" move foreward for "+ Double.parseDouble(result.get(i)[1])*map.getScale() + " meters" );
				}
				else if(result.get(i)[0]=="UR"||result.get(i)[0]=="RD"||result.get(i)[0]=="LD"||result.get(i)[0]=="LU"){
					q_route_description.add("Turn " + turn +" move foreward for "+ Double.parseDouble(result.get(i)[1])*map.getScale()*1.4 + " meters" );

				}
				current_direction = result.get(i)[0];
				
				
			}
		}
		ArrayList<String> L_env_description = new ArrayList<>();
		String L_env ="";
		ArrayList<String> R_env_description = new ArrayList<>();
		String R_env ="";		
		current_direction=startTile.getDirection();
		for(int i=0;i<result.size();i++){
			if(current_direction==result.get(i)[0]){
				for(int j=0;j<Integer.parseInt(result.get(i)[1]);j++){
					current_position =move(result.get(i)[0],current_position);
					if(!L_env_description.contains(get_env_description(current_position,current_direction,"left"))){
						L_env_description.add(get_env_description(current_position,current_direction,"left"));
					}
					if(!R_env_description.contains(get_env_description(current_position,current_direction,"right"))){
						R_env_description.add(get_env_description(current_position,current_direction,"right"));
					}
				}
				for(int l=0;l<L_env_description.size();l++){
					L_env += L_env_description.get(l) +" ";
				}
				for(int r=0;r<R_env_description.size();r++){
					R_env += R_env_description.get(r) +" ";
				}
				q_L_env_description.add(L_env);
				q_R_env_description.add(R_env);
				R_env_description.clear();
				R_env ="";
				L_env_description.clear();
				L_env ="";
			}
			if(current_direction!=result.get(i)[0] ){
				q_env_description.add("You are at "+ current_position.getType().roomName +" facing " + current_facing+" "+ get_env_description(current_position,current_direction,"current"));
				current_direction = result.get(i)[0];
				current_facing = get_facing(current_direction);
				for(int j =0;j<Integer.parseInt(result.get(i)[1]);j++){
					current_position= move(result.get(i)[0],current_position);
					if(!L_env_description.contains(get_env_description(current_position,current_direction,"left"))){
						L_env_description.add(get_env_description(current_position,current_direction,"left"));
					}
					if(!R_env_description.contains(get_env_description(current_position,current_direction,"right"))){
						R_env_description.add(get_env_description(current_position,current_direction,"right"));
					}
				}
				for(int l=0;l<L_env_description.size();l++){
					L_env += L_env_description.get(l)+" ";
				}
				for(int r=0;r<R_env_description.size();r++){
				
					R_env += R_env_description.get(r) +" ";
				}
				q_L_env_description.add(L_env);
				q_R_env_description.add(R_env);
				R_env_description.clear();
				R_env ="";
				L_env_description.clear();
				L_env ="";
			}			
		}
		ArrayList<ArrayList<String>> return_list = new ArrayList<>();
		return_list.add(q_env_description);
		return_list.add(q_route_description);
		return_list.add(q_L_env_description);
		return_list.add(q_R_env_description);

		/*
		System.out.println(q_route_description);
		System.out.println(q_env_description);
		System.out.println(q_L_env_description);
		System.out.println(q_R_env_description);
		 */
		return return_list;
		
		
		
		
	}

	private String get_facing(String current_direction) {
		// TODO Auto-generated method stub
		if(current_direction=="R"){
			return " East ";
		}
		else if(current_direction == "RD"){
			return " South-East ";
		}
		else if(current_direction == "D"){
			return " South ";
		}
		else if(current_direction == "LD"){
			return " South-West ";
		}
		else if(current_direction == "L"){
			return " West ";
		}
		else if(current_direction == "LU"){
			return " North-West ";
		}
		else if(current_direction == "U"){
			return " North ";
		}
		else if(current_direction == "UR"){
			return " North-East ";
		}
		return null;
	}

	private String get_degree(String current_direction, String next) {
		// TODO Auto-generated method stub
		String result = "";
		if(current_direction == "U"){
			if(next == "UR"){
				result = "clockwise 45 degree";
			}
			else if(next == "R"){
				result = "clockwise 90 degree";
			}
			else if(next == "RD"){
				result = "clockwise 135 degree";
			}
			else if(next == "D"){
				result = "clockwise 180 degree";
			}
			else if(next == "LD"){
				result = "anti clockwise 135 degree";
			}
			else if(next == "L"){
				result = "anti clockwise 90 degree";
			}
			else if(next == "LU"){
				result = "anti clockwise 45 degree";
			}
		}
		
		else if(current_direction == "UR"){
			if(next == "R"){
				result = "clockwise 45 degree";
			}
			else if(next == "RD"){
				result = "clockwise 90 degree";
			}
			else if(next == "D"){
				result = "clockwise 135 degree";
			}
			else if(next == "LD"){
				result = "clockwise 180 degree";
			}
			else if(next == "L"){
				result = "anti clockwise 135 degree";
			}
			else if(next == "LU"){
				result = "anti clockwise 90 degree";
			}
			else if(next == "U"){
				result = "anti clockwise 45 degree";
			}
		}
		else if(current_direction == "R"){
			if(next == "RD"){
				result = "clockwise 45 degree";
			}
			else if(next == "D"){
				result = "clockwise 90 degree";
			}
			else if(next == "LD"){
				result = "clockwise 135 degree";
			}
			else if(next == "L"){
				result = "clockwise 180 degree";
			}
			else if(next == "LU"){
				result = "anti clockwise 135 degree";
			}
			else if(next == "U"){
				result = "anti clockwise 90 degree";
			}
			else if(next == "UR"){
				result = "anti clockwise 45 degree";
			}
		}
		else if(current_direction == "RD"){
			if(next == "D"){
				result = "clockwise 45 degree";
			}
			else if(next == "LD"){
				result = "clockwise 90 degree";
			}
			else if(next == "L"){
				result = "clockwise 135 degree";
			}
			else if(next == "LU"){
				result = "clockwise 180 degree";
			}
			else if(next == "U"){
				result = "anti clockwise 135 degree";
			}
			else if(next == "UR"){
				result = "anti clockwise 90 degree";
			}
			else if(next == "R"){
				result = "anti clockwise 45 degree";
			}
		}
		else if(current_direction == "D"){
			if(next == "LD"){
				result = "clockwise 45 degree";
			}
			else if(next == "L"){
				result = "clockwise 90 degree";
			}
			else if(next == "LU"){
				result = "clockwise 135 degree";
			}
			else if(next == "U"){
				result = "clockwise 180 degree";
			}
			else if(next == "UR"){
				result = "anti clockwise 135 degree";
			}
			else if(next == "R"){
				result = "anti clockwise 90 degree";
			}
			else if(next == "RD"){
				result = "anti clockwise 45 degree";
			}
		}
		else if(current_direction == "LD"){
			if(next == "L"){
				result = "clockwise 45 degree";
			}
			else if(next == "LU"){
				result = "clockwise 90 degree";
			}
			else if(next == "U"){
				result = "clockwise 135 degree";
			}
			else if(next == "UR"){
				result = "clockwise 180 degree";
			}
			else if(next == "R"){
				result = "anti clockwise 135 degree";
			}
			else if(next == "RD"){
				result = "anti clockwise 90 degree";
			}
			else if(next == "D"){
				result = "anti clockwise 45 degree";
			}
		}
		else if(current_direction == "L"){
			if(next == "LU"){
				result = "clockwise 45 degree";
			}
			else if(next == "U"){
				result = "clockwise 90 degree";
			}
			else if(next == "UR"){
				result = "clockwise 135 degree";
			}
			else if(next == "R"){
				result = "clockwise 180 degree";
			}
			else if(next == "RD"){
				result = "anti clockwise 135 degree";
			}
			else if(next == "D"){
				result = "anti clockwise 90 degree";
			}
			else if(next == "LD"){
				result = "anti clockwise 45 degree";
			}
		}
		else if(current_direction == "LU"){
			if(next == "U"){
				result = "clockwise 45 degree";
			}
			else if(next == "UR"){
				result = "clockwise 90 degree";
			}
			else if(next == "R"){
				result = "clockwise 135 degree";
			}
			else if(next == "RD"){
				result = "clockwise 180 degree";
			}
			else if(next == "D"){
				result = "anti clockwise 135 degree";
			}
			else if(next == "LD"){
				result = "anti clockwise 90 degree";
			}
			else if(next == "L"){
				result = "anti clockwise 45 degree";
			}
		}
		
		
		
		
		return result;
	}

	private String get_env_description(Tile current_position, String current_direction,String state) {
		// TODO Auto-generated method stub
		String env_description="";
		if(state == "current"){
			if(current_direction=="R"){
				if(current_position.getR_description()!=null){
					env_description = "In front of you is " + current_position.getR_description();
				}
				if(current_position.getU_description()!=null){
					env_description = env_description + " on you left hand side is " +current_position.getU_description();
				}
				if(current_position.getD_description()!=null){
					env_description = env_description + " on you right hand side is " +current_position.getD_description();
				}
				
			}
			else if(current_direction=="D"){
				if(current_position.getD_description()!=null){
					env_description = "In front of you is " + current_position.getD_description();
				}
				if(current_position.getR_description()!=null){
					env_description = env_description + " on you left hand side is " +current_position.getR_description();
				}
				if(current_position.getL_description()!=null){
					env_description = env_description + " on you right hand side is " +current_position.getL_description();
				}		
			}
			else if(current_direction=="L"){
				if(current_position.getL_description()!=null){
					env_description = "In front of you is " + current_position.getL_description();
				}
				if(current_position.getD_description()!=null){
					env_description = env_description + " on you left hand side is " +current_position.getD_description();
				}
				if(current_position.getU_description()!=null){
					env_description = env_description + " on you right hand side is " +current_position.getU_description();
				}
			}
			else if(current_direction=="LD"){
				
				if(current_position.getD_description()!=null){
					env_description = env_description + " on you left hand side is " +current_position.getU_description();
				}
				if(current_position.getL_description()!=null){
					env_description = env_description + " on you right hand side is " +current_position.getL_description();
				}
			}
			else if(current_direction=="LU"){
				if(current_position.getL_description()!=null){
					env_description = env_description + " on you left hand side is " +current_position.getL_description();
				}
				if(current_position.getU_description()!=null){
					env_description = env_description + " on you right hand side is " +current_position.getU_description();
				}
			}
			else if(current_direction=="RD"){
				
				if(current_position.getR_description()!=null){
					env_description = env_description + " on you left hand side is " +current_position.getR_description();
				}
				if(current_position.getD_description()!=null){
					env_description = env_description + " on you right hand side is " +current_position.getD_description();
				}
			}
			else if(current_direction=="U"){
				if(current_position.getU_description()!=null){
					env_description = "In front of you is " + current_position.getU_description();
				}
				if(current_position.getL_description()!=null){
					env_description = env_description + " on you left hand side is " +current_position.getL_description();
				}
				if(current_position.getR_description()!=null){
					env_description = env_description + " on you right hand side is " +current_position.getR_description();
				}
			}
			else if(current_direction=="UR"){
				
				if(current_position.getU_description()!=null){
					env_description = env_description + " on you left hand side is " +current_position.getU_description();
				}
				if(current_position.getR_description()!=null){
					env_description = env_description + " on you right hand side is " +current_position.getR_description();
				}
			}
		}
		
		
		else if(state == "left"){
			if(current_direction=="R"){
				if(current_position.getU_description()!=null){
					env_description = env_description + current_position.getU_description();
				}				
			}
			else if(current_direction=="D"){
				if(current_position.getR_description()!=null){
					env_description = env_description + current_position.getR_description();
				}
			}
			else if(current_direction=="L"){
				if(current_position.getD_description()!=null){
					env_description = env_description + current_position.getD_description();
				}
			}
			else if(current_direction=="LD"){		
				if(current_position.getD_description()!=null){
					env_description = env_description + current_position.getU_description();
				}
			}
			else if(current_direction=="LU"){
				if(current_position.getL_description()!=null){
					env_description = env_description + current_position.getL_description();
				}
			}
			else if(current_direction=="RD"){
				
				if(current_position.getR_description()!=null){
					env_description = env_description + current_position.getR_description();
				}
			}
			else if(current_direction=="U"){
				if(current_position.getL_description()!=null){
					env_description = env_description + current_position.getL_description();
				}
			}
			else if(current_direction=="UR"){
				if(current_position.getU_description()!=null){
					env_description = env_description +current_position.getU_description();
				}
			}
		}
		
		
		else if(state== "right"){
			if(current_direction=="R"){
				if(current_position.getD_description()!=null){
					env_description = env_description + current_position.getD_description();
				}
				
			}
			else if(current_direction=="D"){
				if(current_position.getL_description()!=null){
					env_description = env_description + current_position.getL_description();
				}		
			}
			else if(current_direction=="L"){
				if(current_position.getU_description()!=null){
					env_description = env_description + current_position.getU_description();
				}
			}
			else if(current_direction=="LD"){
				if(current_position.getL_description()!=null){
					env_description = env_description +current_position.getL_description();
				}
			}
			else if(current_direction=="LU"){
				if(current_position.getU_description()!=null){
					env_description = env_description + current_position.getU_description();
				}
			}
			else if(current_direction=="RD"){
				if(current_position.getD_description()!=null){
					env_description = env_description + current_position.getD_description();
				}
			}
			else if(current_direction=="U"){
				if(current_position.getR_description()!=null){
					env_description = env_description + current_position.getR_description();
				}
			}
			else if(current_direction=="UR"){

				if(current_position.getR_description()!=null){
					env_description = env_description +  current_position.getR_description();
				}
			}
		}
		
		
		
		
		return env_description;
	}

	
	
	
	
	
	private ArrayList<String[]> get_route_distance(ArrayList<String> test){
		ArrayList<String[]> result = new ArrayList<>();
		Integer i = 0;
		Integer j = 0;
		String temp = "";
		temp = test.get(0);
		for (i = 0; i < test.size(); i++) {
			if (i != test.size() - 1) {
				if (test.get(i) == temp) {
					j++;
				} else {
					String[] 叫啥好呢 = { temp, j.toString() };
					result.add(叫啥好呢);
					//System.out.println("The element is (" + temp + "," + j.toString() + ")");
					temp = test.get(i);
					j = 1;
				}
			} else {
				if (test.get(i) == temp) {
					j++;
					String[] 叫啥好呢 = { temp, j.toString() };
					result.add(叫啥好呢);
					//System.out.println("The element is (" + temp + "," + j.toString() + ")");
					temp = test.get(i);
					j = 1;
				} else {
					String[] 叫啥好呢 = { temp, j.toString() };
					result.add(叫啥好呢);
					//System.out.println("The element is (" + temp + "," + j.toString() + ")");
					temp = test.get(i);
					j = 1;
					String[] 随便叫个啥 = { temp, j.toString() };
					result.add(随便叫个啥);
					//System.out.println("The element is (" + temp + "," + j.toString() + ")");

				}
			}
		}
		return result;
	}
	
	
	
	private Tile move(String current_direction, Tile current_position) {
		// TODO Auto-generated method stub
		if(current_direction=="R"){
			return current_position.getR();
		}
		else if(current_direction=="D"){
			return current_position.getD();
		}
		else if(current_direction=="L"){
			return current_position.getL();
		}
		else if(current_direction=="LD"){
			return current_position.getLD();
		}
		else if(current_direction=="LU"){
			return current_position.getLU();
		}
		else if(current_direction=="RD"){
			return current_position.getRD();
		}
		else if(current_direction=="U"){
			return current_position.getU();
		}
		else if(current_direction=="UR"){
			return current_position.getUR();
		}
		return current_position;
	}



}
