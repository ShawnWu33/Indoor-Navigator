public class Tile {
	private int gCost,hCost,fCost,x,y;
	private TileType type;
	private Tile U,UR,R,RD,D,LD,L,LU, parent;
	private String U_description=null,D_description=null,L_description=null,R_description=null,direction =null;
	
	
	public String getU_description() {
		return U_description;
	}


	public void setU_description(String u_description) {
		U_description = u_description;
	}


	public String getD_description() {
		return D_description;
	}


	public void setD_description(String d_description) {
		D_description = d_description;
	}


	public String getL_description() {
		return L_description;
	}


	public void setL_description(String l_description) {
		L_description = l_description;
	}


	public String getR_description() {
		return R_description;
	}


	public void setR_description(String r_description) {
		R_description = r_description;
	}


	public String getDirection() {
		return direction;
	}


	public void setDirection(String direction) {
		this.direction = direction;
	}


	public Tile(int g,int h ,int f, TileType type,int x, int y){
		this.gCost = g;
		this.hCost = h;
		this.fCost = f;
		this.type = type;
		this.x =x;
		this.y = y;
	}
	




	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


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
	
	public void setParent(Tile parent) {
		this.parent = parent;
	}
	
	public Tile getParent() {
		return parent;
	}
	
	
	
	
}
