package Game;

import java.util.HashSet;

import Pieces.ChessPiece;
import Pieces.CoordinatePair;
import Pieces.King;

/**
 * 
 * @author fh922310
 * A player in chess has a list of pieces that is used to keep track of how many pieces are left
 * as well as to use when placing pieces on the board.
 */
public class Player {
	
	private King king;
	private String color;
	private HashSet<ChessPiece> chessPieces;
	
	public boolean isChecked;
	
	public Player(String color) {
		this.color = color;
		chessPieces = new HashSet<ChessPiece>();
	}



	public HashSet<ChessPiece> getChessPieces(){
		return chessPieces;
	}
	
	public void addPiece(ChessPiece piece) {
		if(piece instanceof King) {
			king = (King)piece;
		}
		chessPieces.add(piece);
	}
	
	public void removePiece(ChessPiece piece){
		chessPieces.remove(piece);
	}
	public String getColor() {
		return color;
	}
	
	public King getKing() {
		return king;
	}

	//Checks if checked
	public boolean opponentIsChecked() {
		GameController controller = GameController.getInstance();
		Player opponent = controller.getOpponent();
		CoordinatePair opKingPosition = opponent.getKing().getPosition();

		for(ChessPiece piece: this.getChessPieces()) {
			HashSet<CoordinatePair> availableMoves = piece.updatePossibleMoves();
			for(CoordinatePair CP: availableMoves) {
				if(CP.equals(opKingPosition)) {	

					return true;
				}
			}
		}
		return false;
	}
	//TODO implement
	public boolean opponentIsCheckMate() {
		
		GameController controller = GameController.getInstance();
		Player opponent = controller.getOpponent();
		
		
		return false;
	}

	//TODO implement
	public boolean isStaleMate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
