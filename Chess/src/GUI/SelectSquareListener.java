package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;

import Game.ChessBoard;
import Game.GameController;
import Pieces.ChessPiece;
import Pieces.CoordinatePair;
import Pieces.Rook;

public class SelectSquareListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
			//Get the controller, chessboard, selected button, coordinates of the button
			//and the piece that is on it if a piece exists
			ChessBoard chessBoard = ChessBoard.getInstance();
			GameController gameController = GameController.getInstance();
			JButton selectedSquare = (JButton) e.getSource();
			CoordinatePair CoordP = (CoordinatePair) selectedSquare.getClientProperty("CoordP");
			ChessPiece piece = ((ChessPiece)chessBoard.getSquare(CoordP));
			
			//Check if the selected square has a piece on it. If not select the piece and color the tile.
			if(piece != null && piece.getPlayer() == gameController.getCurrentPlayer()) {
				
				//TODO implement functionality that colors the selected tile and later uncolors it.
					
				chessBoard.setSelectedPiece(selectedSquare);
				return;
			}
			//If a piece is selected and a button is clicked try to move the piece to the square
			if(chessBoard.getSelectedPiece() != null) {
				moveToSquare(selectedSquare);	
			}
	}

	/**
	 * Moves the selected piece to the selected square
	 * @param selectedSquare the square to move the piece to
	 */
	private void moveToSquare(JButton selectedSquare) {
		ChessBoard chessBoard = ChessBoard.getInstance();
		GameController gameController = GameController.getInstance();
		
		CoordinatePair currentCoordp = (CoordinatePair) chessBoard.getSelectedPiece().getClientProperty("CoordP");
		ChessPiece piece = ((ChessPiece)chessBoard.getSquare(currentCoordp));
		CoordinatePair targetCoordP = (CoordinatePair) selectedSquare.getClientProperty("CoordP");
		
		
		if(piece.move(targetCoordP)) {
			chessBoard.getSelectedPiece().setIcon(null);
			chessBoard.setSelectedPiece(null);
			selectedSquare.setIcon(piece.getIcon());
			
			
			gameController.updateGameState();
			gameController.updateLatestmove(piece, targetCoordP);
			gameController.switchPlayer();
		}	
		//TODO implement functions that check the state of the board and call them here
			
		
	}
	
	

}
