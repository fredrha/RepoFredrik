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

	//Checks if the opponent is checked
	public boolean opponentIsChecked() {
		Chess chess = Chess.getInstance();
		GameController controller = GameController.getInstance();
		Player opponent = controller.getOpponent();
		CoordinatePair opKingPosition = opponent.getKing().getPosition();

		for(ChessPiece piece: this.getChessPieces()) {
			HashSet<CoordinatePair> availableMoves = piece.updatePossibleMoves();
			
			if(availableMoves.contains(opKingPosition)) {
					chess.updateGameState("checked");
					return true;
				}
		}
		return false;
	}
	
	//Checks if all of the opponents kings possible moves are included in the possible moves
	//of the current player.
	public boolean opponentIsCheckMate() {
		
		GameController controller = GameController.getInstance();
		Player opponent = controller.getOpponent();
		
		HashSet<CoordinatePair> currentPlayermoves = new HashSet<CoordinatePair>();
		for(ChessPiece piece: this.getChessPieces()) {
			currentPlayermoves.addAll(piece.updatePossibleMoves());
		}
		HashSet<CoordinatePair> kingsMoves = opponent.getKing().updatePossibleMoves();
		for(CoordinatePair CP: kingsMoves) {
			if(!currentPlayermoves.contains(CP)) {
				System.out.println(CP.getX() + " " + CP.getY());
				return false;
				}
		}
		return true;
	}

	//TODO implement
	public boolean isStaleMate() {
		// TODO Auto-generated method stub
		return false;
	}


	
}
