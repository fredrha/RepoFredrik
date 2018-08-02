package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Game.Chess;
import Game.ChessBoard;
import Game.GameController;
import Pieces.ChessPiece;
import Pieces.CoordinatePair;

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
			System.out.println(gameController.getCurrentPlayer().getColor().toString());
			
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
		Chess chess = Chess.getInstance();
		//TODO implement functions that check the state of the board and call them here
		if (gameController.getStatus() == gameController.CHECKMATE) {
			JOptionPane.showMessageDialog(null, gameController.CHECKMATE);
			
			chess.restart();
			return;
		}
		
	}
	


}
