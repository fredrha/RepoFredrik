package Pieces;
import java.util.ArrayList;

import javax.swing.JButton;

//Class which could be used to make other chesspieces from.
public abstract class ChessPiece extends JButton{
	
	private CoordinatePair Coords;
	private boolean isAlive;
	private boolean selected;
	protected String color;
	
	private ArrayList<CoordinatePair> availableMoves;
	public ChessPiece(CoordinatePair CoordPair , String color){
		Coords = CoordPair;		
		this.color = color;
		isAlive = true;
	}
	
	/**
	 * List of possible moves a certain piece can make depending on its coordinates and type.
	 * @return a list of CoordinatePairs
	 */
	public abstract ArrayList<CoordinatePair> getPossibleMoves();
	
	/**
	 * Coves a chess piece to Coordpair
	 * @param CoordPair are coordinates
	 */
	public void move(CoordinatePair CoordPair) {
		Coords = CoordPair;
	}
	
	public CoordinatePair getPosition() {
		return Coords;	
	}
	
	public void setIsAlive(boolean b) {
		isAlive = b;
	}
	public boolean getIsAlive() {
		return isAlive;
	}
	
	public void setIsSelected(boolean b) {
		isAlive = b;
	}
	public boolean getSelected() {
		return selected;
	}

}
