package Pieces;

import java.util.HashSet;

import javax.swing.ImageIcon;

import GUI.ChessBoardPanel;
import Game.ChessBoard;
import Game.Player;

//Class which could be used to make other chesspieces from.
public abstract class ChessPiece{
	
	private CoordinatePair Coords;
	protected Player player;
	private ImageIcon icon;
	protected HashSet<CoordinatePair> availableMoves;
	
	
	public ChessPiece(CoordinatePair CoordPair , Player player){
		Coords = CoordPair;		
		this.player = player;
		ChessBoard chessboard = ChessBoard.getInstance();
		chessboard.addPiece(this, CoordPair);

		this.player = player;
		this.player.addPiece(this);
		
	}
	protected HashSet<CoordinatePair> getPossibleMoves(){
		return availableMoves;
	}
	
	/**
	 * List of possible moves a certain piece can make depending on its coordinates and type.
	 * @return a list of CoordinatePairs
	 */
	public abstract HashSet<CoordinatePair> updatePossibleMoves();
	/**
	 * Checks if the target location is is the piece's list of available moves
	 * @param piece
	 * @param CoordP
	 * @return true if successful, false if not.
	 */
	public boolean isMoveLegal(CoordinatePair CoordP) {
		HashSet<CoordinatePair> CoordList = updatePossibleMoves();
			if(CoordList.contains(CoordP)) {	
				return true;
		}
		return false;
	}
	public void clearAvailableMoves(HashSet<CoordinatePair> availableMoves) {
		if(availableMoves != null)
		availableMoves.clear();
	}
	
	/**
	 * Moves a farmerPiece to Coordpair
	 * @param CoordPair are coordinates
	 */
	public boolean move(CoordinatePair CoordP) {
		if(!isMoveLegal(CoordP)) {
			return false;
		}
		ChessBoard chessBoard = ChessBoard.getInstance();
		ChessPiece enemy = chessBoard.getSquare(CoordP);
		if(enemy != null) {
			killEnemy(enemy);
			
		}
		chessBoard.movePiece(this, CoordP);
		Coords = CoordP;
		
		//clear the old available moves as the piece moves
		clearAvailableMoves(getPossibleMoves());
		return true;	
	}
	
	public void killEnemy(ChessPiece enemy) {
		System.out.println("Killed enemy a piece");
		ChessBoard chessBoard = ChessBoard.getInstance();
		chessBoard.removePiece(enemy.getPosition());
		enemy.getPlayer().removePiece(enemy);
	}
	
	public CoordinatePair getPosition() {
		return Coords;	
	}
	public void setPosition(CoordinatePair CoordP) {
		Coords = CoordP;
	}
	protected abstract void readImage();
	
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon i) {
		this.icon = i;
	}
	
	public Player getPlayer() {
		return player;
	}

}
