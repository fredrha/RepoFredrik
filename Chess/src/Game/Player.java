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
	
	public boolean isChecked = false;
	
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
		Chess chess = Chess.getInstance();
		GameController controller = GameController.getInstance();
		Player opponent = controller.getOpponent();
		CoordinatePair opKingPosition = opponent.getKing().getPosition();

		for(ChessPiece piece: this.getChessPieces()) {
			HashSet<CoordinatePair> availableMoves = piece.updatePossibleMoves();
			for(CoordinatePair CP: availableMoves) {
				if(CP.equals(opKingPosition)) {
					
					chess.updateGameState("checked");
					return true;
					
				}
			}
		}
		return false;
	}
	
	//TODO fix so that this works properly. 
	//Checks if all of the opponents kings possible moves are included in the possible moves
	//of the current players pieces possible moves.
	public boolean opponentIsCheckMate() {
		
		GameController controller = GameController.getInstance();
		Player opponent = controller.getOpponent();
		HashSet<CoordinatePair> kingsMoves = opponent.getKing().updatePossibleMoves();
		int i = 0;
		
		for(ChessPiece piece: this.getChessPieces()) {
			HashSet<CoordinatePair> availableMoves = piece.updatePossibleMoves();
			for(CoordinatePair CP: availableMoves) {
				for(CoordinatePair KCP:kingsMoves) {
					if(KCP.equals(CP)) {	
						i++;
					}
				}

			}
		}
		if(i == kingsMoves.size()) {
			return true;
		}
		
		return false;
	}

	//TODO implement
	public boolean isStaleMate() {
		// TODO Auto-generated method stub
		return false;
	}



	public void killKing() {
		king = null;
	}
	
	
}
