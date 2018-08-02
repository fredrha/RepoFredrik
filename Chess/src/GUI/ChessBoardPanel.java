package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import Game.ChessBoard;
import Pieces.ChessPiece;
import Pieces.CoordinatePair;

//Displays the state of the board. Is updated by the controller and sends information to the controller
public class ChessBoardPanel extends JPanel {
	
	
	private JButton [][]chessSquares;
	private JButton selectedPiece = null;
	
	private Dimension buttonSize = new Dimension(160,160);
	private ChessBoard chessBoard;
	
	public ChessBoardPanel(int height, int width) {
		
		this.setLayout(new GridLayout(height, width));
		chessBoard = ChessBoard.getInstance();
		chessSquares  = new JButton[height][width];
		addSquares(chessSquares);
	}	
	
	//Adds all squares in the game board. Each is represented by a JButton and a CoordinatePair
	private void addSquares(JButton[][] board) {		
		//i is y coordinate 
		//J is x coordinate
			for(int i = 0; i < board.length-1; i++) {
				for(int j = 0; j < board[i].length-1; j++) {	
					//Create a button and a coordinatepair for each square in the game
					CoordinatePair CoordP = new CoordinatePair(i,j);
					JButton chessSquare = new JButton();
					chessSquare.setPreferredSize(buttonSize);				
					board[i][j] = chessSquare;
					
					//Check if the square has a chesspiece on it
					//If so set the proper icon
					ChessPiece piece = chessBoard.getSquare(CoordP);
					if(piece != null) {
						chessSquare.setIcon(piece.getIcon());
					}
					
					//Color the tiles
					if((i+j)%2 == 0) {
						chessSquare.setBackground(new Color(220, 220, 220));
						chessSquare.putClientProperty("Color", new Color(220, 220, 220));
					}
					else{
						chessSquare.setBackground(new Color(80, 80, 80));
						chessSquare.putClientProperty("Color", new Color(80, 80, 80));
					}
					
					//Give the square a coordinate as a client property so that it may be found later
					//Add a SelectSquareListener to each button
					chessSquare.putClientProperty("CoordP", chessBoard.getCoordinates(i, j));
					chessSquare.addActionListener(new SelectSquareListener());
					add(chessSquare);
				}
		}			
			
			//TODO investigate why this does not work for adding coordinatetiles on the right.
			for(int i = 0; i < board.length-1; i++) {
				JButton chessSquare = new JButton(""+ (i+1));
				Color green = new Color(160,220,60);
				chessSquare.setBackground(green);		
				chessSquare.setEnabled(false);
				board[i][board[i].length-1] = chessSquare;
				add(chessSquare);
			}
	}
	
	public JButton getSelectedPiece() {
		return selectedPiece;
	}
	
	//Return a specific tile/spot
		public JButton getSquare(CoordinatePair CoordP) {
			return chessSquares[CoordP.getX()][CoordP.getY()];
		}
		

	
}


	



