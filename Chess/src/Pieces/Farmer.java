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
	
	@Override
	public HashSet<CoordinatePair> updatePossibleMoves() {
		int x = super.getPosition().getX();
		int y = super.getPosition().getY();
		ChessBoard chessBoard = ChessBoard.getInstance();
		HashSet<CoordinatePair> tmpList = new HashSet<CoordinatePair>();	
		
		if (player.getColor() == "Black") {
		CoordinatePair forward = new CoordinatePair(x+1, y);
		CoordinatePair rightDiag = new CoordinatePair(x+1, y+1);
		CoordinatePair leftDiag = new CoordinatePair(x+1, y-1);
		CoordinatePair forwardTwo = new CoordinatePair(x+2, y);
		if(!chessBoard.outOfBounds(forward)) {
			if(!chessBoard.occupiedByEnemy(forward, this.getPlayer())) {
				tmpList.add(forward);
			}
		}
		if(!chessBoard.outOfBounds(rightDiag)) {
			if(chessBoard.occupiedByEnemy(rightDiag, this.getPlayer())) {
				tmpList.add(rightDiag);
			}
		}
		if(!chessBoard.outOfBounds(leftDiag)) {
			if(chessBoard.occupiedByEnemy(leftDiag, this.getPlayer())) {
				tmpList.add(leftDiag);
			}
		}
		if(x == 1) {
			tmpList.add(forwardTwo);
			}
		
		for(CoordinatePair CP: tmpList) {
			availableMoves.add(chessBoard.getCoordinates(CP.getX(), CP.getY()));
			}
		}
		else if(player.getColor() == "White"){
			CoordinatePair forward = new CoordinatePair(x-1, y);
			CoordinatePair rightDiag = new CoordinatePair(x-1, y+1);
			CoordinatePair leftDiag = new CoordinatePair(x-1, y-1);
			CoordinatePair forwardTwo = new CoordinatePair(x-2, y);
			if(!chessBoard.outOfBounds(forward)) {
				if(!chessBoard.occupiedByEnemy(forward, this.getPlayer())) {
					tmpList.add(forward);
				}
			}
			if(!chessBoard.outOfBounds(rightDiag)) {
				if(chessBoard.occupiedByEnemy(rightDiag, this.getPlayer())) {
					tmpList.add(rightDiag);
				}
			}
			if(!chessBoard.outOfBounds(leftDiag)) {
				if(chessBoard.occupiedByEnemy(leftDiag, this.getPlayer())) {
					tmpList.add(leftDiag);
				}
			}
			if(x == 6) {
				tmpList.add(forwardTwo);
				}
			for(CoordinatePair CP: tmpList) {
				availableMoves.add(chessBoard.getCoordinates(CP.getX(), CP.getY()));
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
