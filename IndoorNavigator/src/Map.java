
public abstract class Map {
	private String startLoc,endLoc;

	public  Map(){
		this.initMap();
		
	}
	
	public abstract void initMap();
	
	public String getStartLoc() {
		return startLoc;
	}

	public void setStartLoc(String startLoc) {
		this.startLoc = startLoc;
	}

	public String getEndLoc() {
		return endLoc;
	}

	public void setEndLoc(String endLoc) {
		this.endLoc = endLoc;
	}
	
}
