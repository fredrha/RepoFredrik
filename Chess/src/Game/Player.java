package Game;

import java.util.HashSet;

import Pieces.ChessPiece;

/**
 * 
 * @author fh922310
 * A player in chess has a list of pieces that is used to keep track of how many pieces are left
 * as well as to use when placing pieces on the board.
 */
public class Player {
	
	
	private String color;
	private HashSet<ChessPiece> chessPieces;
	
	public Player(String color) {
		this.color = color;
		chessPieces = new HashSet<ChessPiece>();
	}



	public HashSet<ChessPiece> getChessPieces(){
		return chessPieces;
	}
	
	public void addPiece(ChessPiece piece) {
		chessPieces.add(piece);
	}
	
	public void removePiece(ChessPiece piece){
		chessPieces.remove(piece);
	}
	public String getColor() {
		return color;
	}


	//TODO Check conditions for check, stalemate and checkmate
	public void updateState() {
		
		
	}
}
