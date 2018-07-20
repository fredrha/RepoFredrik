package Game;

import java.util.ArrayList;

import Pieces.ChessPiece;

/**
 * 
 * @author fh922310
 * A player in chess has a list of pieces that is used to keep track of how many pieces are left
 * as well as to use when placing pieces on the board.
 */
public class Player {
	
	private String [][] chessPieces;
	private String color;
	
	public Player(String color) {
		this.color = color;
		chessPieces = new String [8][8];
		for(int i = 0; i < chessPieces.length; i++) {
			chessPieces[0][i] = "Farmer";
		}
		chessPieces[1][0] = "Tower";
		chessPieces[1][7] = "Tower";
		chessPieces[1][1] = "Knight";
		chessPieces[1][6] = "Knight";
		chessPieces[1][2] = "Bishop";
		chessPieces[1][5] = "Bishop";
		chessPieces[1][3] = "Queen";
		chessPieces[1][4] = "King";
	}



	public String [][] getChessPieces(){
		return chessPieces;
	}
	public String getColor() {
		return color;
	}
}
