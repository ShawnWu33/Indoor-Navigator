public class Tile {
	private int gCost,hCost,fCost;
	private TileType type;
	private Tile U,UR,R,RD,D,LD,L,LU;
	
	public Tile(int g,int h ,int f, TileType type){
		this.gCost = g;
		this.hCost = h;
		this.fCost = f;
		this.type = type;
	}
//test1324
	//sb
	//test 3

	public int getgCost() {
		return gCost;
	}

	public void setgCost(int gCost) {
		this.gCost = gCost;
	}

	public int gethCost() {
		return hCost;
	}

	public void sethCost(int hCost) {
		this.hCost = hCost;
	}

	public int getfCost() {
		return fCost;
	}

	public void setfCost(int fCost) {
		this.fCost = fCost;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

	public Tile getU() {
		return U;
	}

	public void setU(Tile u) {
		U = u;
	}

	public Tile getUR() {
		return UR;
	}

	public void setUR(Tile uR) {
		UR = uR;
	}

	public Tile getR() {
		return R;
	}

	public void setR(Tile r) {
		R = r;
	}

	public Tile getRD() {
		return RD;
	}

	public void setRD(Tile rD) {
		RD = rD;
	}

	public Tile getD() {
		return D;
	}

	public void setD(Tile d) {
		D = d;
	}

	public Tile getLD() {
		return LD;
	}

	public void setLD(Tile lD) {
		LD = lD;
	}

	public Tile getL() {
		return L;
	}

	public void setL(Tile l) {
		L = l;
	}

	public Tile getLU() {
		return LU;
	}

	public void setLU(Tile lU) {
		LU = lU;
	}
	
	
	
}
