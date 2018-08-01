package Pieces;
import java.util.HashSet;

import javax.swing.ImageIcon;

import Game.ChessBoard;
import Game.Player;


public class Farmer extends ChessPiece{

	private ImageIcon icon;
	
	public Farmer(CoordinatePair CoordPair, Player player) {
		super(CoordPair, player);
		readImage();
		availableMoves = new HashSet<CoordinatePair>();		
	}
	
	//TODO remake this according to true chessrules
	@Override
	public HashSet<CoordinatePair> updatePossibleMoves() {
		int x = super.getPosition().getX();
		int y = super.getPosition().getY();
		ChessBoard chessBoard = ChessBoard.getInstance();
		
		if (player.getColor() == "Black") {
		CoordinatePair forward = new CoordinatePair(x+1, y);
		CoordinatePair rightDiag = new CoordinatePair(x+1, y+1);
		CoordinatePair leftDiag = new CoordinatePair(x+1, y-1);
		CoordinatePair forwardTwo = new CoordinatePair(x+2, y);
		if(!chessBoard.occupiedByEnemy(forward, this.getPlayer())) {
			availableMoves.add(forward);
		}
		if(!chessBoard.outOfBounds(rightDiag)) {
			if(chessBoard.occupiedByEnemy(rightDiag, this.getPlayer())) {
			availableMoves.add(rightDiag);
			}
		}
		if(!chessBoard.outOfBounds(leftDiag)) {
			if(chessBoard.occupiedByEnemy(leftDiag, this.getPlayer())) {
			availableMoves.add(leftDiag);
			}
		}
		if(x == 1) {
			availableMoves.add(forwardTwo);
			}
		}
		else if(player.getColor() == "White"){
			CoordinatePair forward = new CoordinatePair(x-1, y);
			CoordinatePair rightDiag = new CoordinatePair(x-1, y+1);
			CoordinatePair leftDiag = new CoordinatePair(x-1, y-1);
			CoordinatePair forwardTwo = new CoordinatePair(x-2, y);
			if(!chessBoard.occupiedByEnemy(forward, this.getPlayer())) {
				availableMoves.add(forward);
			}
			if(!chessBoard.outOfBounds(rightDiag)) {
				if(chessBoard.occupiedByEnemy(rightDiag, this.getPlayer())) {
				availableMoves.add(rightDiag);
				}
			}
			if(!chessBoard.outOfBounds(leftDiag)) {
				if(chessBoard.occupiedByEnemy(leftDiag, this.getPlayer())) {
				availableMoves.add(leftDiag);
				}
			}
			if(x == 6) {
				availableMoves.add(forwardTwo);
				}
		}
		return availableMoves;
	}
	@Override
	protected void readImage() {
		if(player.getColor() == "White") {
		ImageIcon icon = new ImageIcon("src/images/White pawn.png");
		this.icon = icon;
		}
		else if(player.getColor()  == "Black") {
			ImageIcon icon = new ImageIcon("src/images/Black pawn.png");
			this.icon = icon;
		}
		else {
			System.out.println("Color not set properly");
		}
	}
	
	public ImageIcon getIcon() {
		return icon;
	}
	


}
