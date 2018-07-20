package Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import Pieces.ChessPiece;
import Pieces.CoordinatePair;
import Pieces.FarmerPiece;

//A board of buttons
public class ChessBoard extends JPanel {
	
	//Timer for limiting player time
	private Timer timer;
	
	private Dimension buttonSize = new Dimension(200,200);
	
	private boolean playerOneTurn;
	private boolean playerTwoTurn;
	private Player whitePlayer;
	private Player blackPlayer;
	private String white = "White";
	private String black = "Black";
	
	private JButton[][] chessBoard;
	
	public ChessBoard() {
		whitePlayer = new Player(white);
		blackPlayer = new Player(black);
		this.setLayout(new GridLayout(0,8));
		chessBoard  = new JButton[8][8];
		addButtons(chessBoard);
		addListeners(chessBoard);
		
	}
	
	private void addButtons(JButton[][] board) {
		
		//i is y coordinate 
		//J is x coordinate
			//Add the black pieces
			for(int i = 0; i < 2; i++) {
				for(int j = 0; j < board[i].length; j++) {					
					CoordinatePair CoordP = new CoordinatePair(j,i);
					ChessPiece chessPiece = new FarmerPiece(CoordP, black);
					chessPiece.setPreferredSize(buttonSize);
					board[j][i] = chessPiece;	
					add(chessPiece);
					chessPiece.setText(i + " " + j);
				}
		}
			//Add the blank buttons between the players
			for(int i = 2; i < board.length-2; i++) {
				for(int j = 0; j < board[i].length; j++) {					
					JButton button = new JButton();
					button.setPreferredSize(buttonSize);				
					board[j][i] = button;
					add(button);
					button.setText(i + " " + j);
				}
		}			
			//Add the white pieces
			for(int i = board.length-2; i < board.length; i++) {
				for(int j = 0; j < board[i].length; j++) {					
					CoordinatePair CoordP = new CoordinatePair(j,i);
					ChessPiece chessPiece = new FarmerPiece(CoordP, white);
					chessPiece.setPreferredSize(buttonSize);
					board[j][i] = chessPiece;
					add(chessPiece);
					chessPiece.setText(i + " " + j);
				}
		}
	
	}
	
	
	private void addListeners(JButton[][] chessBoard) {	
		for(int i = 0; i < chessBoard.length; i++) {
			for(int j = 0; j < chessBoard[i].length; j++) {
				JButton button = chessBoard[i][j];
				button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				//Check if button is an alive chesspiece
				if(button instanceof ChessPiece && ((ChessPiece) button).getIsAlive()) {
					System.out.println("This is a chesspiece");
					ArrayList<CoordinatePair> possibleMoves = ((ChessPiece) button).getPossibleMoves();
					for(CoordinatePair CoordP: possibleMoves) {
						chessBoard[CoordP.getX()][CoordP.getY()].setBackground(Color.yellow);;
					}
				}
				//If isAlive and unselected set selected.
				//If selected mark possible moves and set displaying moves
				//If same pos selected cancel move. If other pos is selected move
				//If move legal make move if not give error and return to displaying moves.
				
					}	
				});
			}
		}
	}
	
	//Return a specific tile/spot
	public JButton getSpot(CoordinatePair CoordP) {
		return chessBoard[CoordP.getX()][CoordP.getY()];
	}
	


	
	
}
