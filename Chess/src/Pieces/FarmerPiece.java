package Pieces;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class FarmerPiece extends ChessPiece{

	private ArrayList<CoordinatePair> availableMoves;
	private ImageIcon icon;
	
	
	public FarmerPiece(CoordinatePair CoordPair, String color) {
		super(CoordPair, color);
		readImage();
		setIcon(icon);
		availableMoves = new ArrayList<CoordinatePair>();
		
	}
	
	@Override
	public ArrayList<CoordinatePair> getPossibleMoves() {
		int x = super.getPosition().getX();
		int y = super.getPosition().getY();
		
		CoordinatePair forward = new CoordinatePair(x, y+1);
		CoordinatePair rightDiag = new CoordinatePair(x+1, y+1);
		CoordinatePair leftDiag = new CoordinatePair(x-1, y+1);
		availableMoves.add(forward);
		availableMoves.add(rightDiag);
		availableMoves.add(leftDiag);
		
		return availableMoves;
	}
	
	private void readImage() {
		if(color == "White") {
		ImageIcon icon = new ImageIcon("src/GUI/White pawn.png");
		this.icon = icon;
		}
		else if(color == "Black") {
			ImageIcon icon = new ImageIcon("src/GUI/Black pawn.png");
			this.icon = icon;
		}
		else {
			System.out.println("Color not set properly");
		}
	}
	

}
