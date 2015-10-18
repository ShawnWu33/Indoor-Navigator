import java.util.ArrayList;


public abstract class Map {
	private String startLoc,endLoc;
	double scale;
	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	Tile[][] mapMatrix;
	
	public Tile[][] getMapMatrix() {
		return mapMatrix;
	}
	
	public Tile getTile(int x, int y){
		return mapMatrix[x][y];
	}
	
	public int getXLength() {
		return mapMatrix.length;
	}
	
	public int getYLength() {
		return mapMatrix[0].length;
	}

	public void setMapMatrix(Tile[][] mapMatrix) {
		this.mapMatrix = mapMatrix;
	}

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
