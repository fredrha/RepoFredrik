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
		
		if (player.getColor() == "Black") {
		CoordinatePair forward = new CoordinatePair(x+1, y);
		CoordinatePair rightDiag = new CoordinatePair(x+1, y+1);
		CoordinatePair leftDiag = new CoordinatePair(x+1, y-1);
		availableMoves.add(forward);
		availableMoves.add(rightDiag);
		availableMoves.add(leftDiag);
		}
		else if(player.getColor() == "White"){
			CoordinatePair forward = new CoordinatePair(x-1, y);
			CoordinatePair rightDiag = new CoordinatePair(x-1, y+1);
			CoordinatePair leftDiag = new CoordinatePair(x-1, y-1);
			availableMoves.add(forward);
			availableMoves.add(rightDiag);
			availableMoves.add(leftDiag);
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
