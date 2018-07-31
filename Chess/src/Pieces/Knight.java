package Pieces;

import java.util.HashSet;

import javax.swing.ImageIcon;

import Game.ChessBoard;
import Game.Player;

public class Knight extends ChessPiece {
	
	private ImageIcon icon;

	public Knight(CoordinatePair CoordPair, Player player) {
		super(CoordPair, player);
		readImage();
		availableMoves = new HashSet<CoordinatePair>();
	}

	@Override
	public HashSet<CoordinatePair> updatePossibleMoves() {
		int x = super.getPosition().getX();
		int y = super.getPosition().getY();
		ChessBoard chessboard = ChessBoard.getInstance();
		HashSet<CoordinatePair> tmpList = new HashSet<CoordinatePair>();
		CoordinatePair upLeft = new CoordinatePair(x-2, y-1);
		CoordinatePair upRight = new CoordinatePair(x-2, y+1);
		CoordinatePair leftUp = new CoordinatePair(x-1, y-2);
		CoordinatePair leftDown = new CoordinatePair(x+1, y-2);
		CoordinatePair rightUp = new CoordinatePair(x-1, y+2);
		CoordinatePair rightDown = new CoordinatePair(x+1, y+2);
		CoordinatePair downLeft = new CoordinatePair(x+2, y-1);
		CoordinatePair downRight = new CoordinatePair(x+2, y+1);
		tmpList.add(upLeft);
		tmpList.add(upRight);
		tmpList.add(leftUp);
		tmpList.add(leftDown);
		tmpList.add(rightUp);
		tmpList.add(rightDown);
		tmpList.add(downLeft);
		tmpList.add(downRight);
		for(CoordinatePair CoordP: tmpList) {
			if(!chessboard.outOfBounds(CoordP)) {
				if(!chessboard.occupiedByFriend(CoordP, this.getPlayer())) {
					availableMoves.add(CoordP);
				}	
			}
		}
		
		return availableMoves;
	}

	@Override
	protected void readImage() {
		if(player.getColor() == "White") {
			ImageIcon icon = new ImageIcon("src/images/White knight.png");
			this.icon = icon;
			}
			else if(player.getColor()  == "Black") {
				ImageIcon icon = new ImageIcon("src/images/Black knight.png");
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
