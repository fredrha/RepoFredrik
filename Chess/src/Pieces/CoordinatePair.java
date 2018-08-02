package Pieces;

public class CoordinatePair {

	private int xCoord;
	private int yCoord;
	public CoordinatePair(int x, int y) {
		xCoord = x; 
		yCoord = y;
	}
	
	public int getY() {
		return yCoord;
	}
	public int getX() {
		return xCoord;
	}
	public boolean equals(CoordinatePair CoordP) {
		if(this.xCoord == CoordP.getX() && this.yCoord == CoordP.getY()) {
			return true;
		}
		return false;
	}
		
}
