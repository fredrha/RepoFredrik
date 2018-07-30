package Pieces;

import java.util.HashSet;

import javax.swing.ImageIcon;

import Game.ChessBoard;
import Game.Player;

public class Bishop extends ChessPiece {
	
	private HashSet<CoordinatePair> availableMoves;
	private ImageIcon icon;

	public Bishop(CoordinatePair CoordPair, Player player) {
		super(CoordPair, player);
		readImage();
	}

	@Override
	public HashSet<CoordinatePair> updatePossibleMoves() {
		ChessBoard chessBoard = ChessBoard.getInstance();
		availableMoves = chessBoard.getDiagPaths(this.getPosition(), this.getPlayer());
		return availableMoves;
	}

	@Override
	protected void readImage() {
		if(player.getColor() == "White") {
			ImageIcon icon = new ImageIcon("src/images/White bishop.png");
			this.icon = icon;
			}
			else if(player.getColor()  == "Black") {
				ImageIcon icon = new ImageIcon("src/images/Black bishop.png");
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
