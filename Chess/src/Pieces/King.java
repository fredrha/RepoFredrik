package Pieces;

import java.util.HashSet;

import javax.swing.ImageIcon;

import Game.ChessBoard;
import Game.GameController;
import Game.Player;

public class King extends ChessPiece{
	
	private ImageIcon icon;
	
	public King(CoordinatePair CoordPair, Player player) {
		super(CoordPair, player);
		readImage();
		availableMoves = new HashSet<CoordinatePair>();
	}

	@Override
	public HashSet<CoordinatePair> updatePossibleMoves() {
		int x = super.getPosition().getX();
		int y = super.getPosition().getY();
		ChessBoard chessboard = ChessBoard.getInstance();
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				if(!chessboard.outOfBounds(i,j)) {
					CoordinatePair CoordP = chessboard.getCoordinates(i, j);
					if(!chessboard.occupiedByFriend(CoordP, this.getPlayer())) {
						if(!CoordP.equals(this.getPosition())){
							availableMoves.add(CoordP);
						}
					}	
				}
			}
		}
		
		return availableMoves;
	}

	@Override
	protected void readImage() {
		if(player.getColor() == "White") {
			ImageIcon icon = new ImageIcon("src/images/White king.png");
			this.icon = icon;
			}
			else if(player.getColor()  == "Black") {
				ImageIcon icon = new ImageIcon("src/images/Black king.png");
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
