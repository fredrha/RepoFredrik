package Game;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.ChessBoardPanel;
import GUI.GameStatusPanel;
import Pieces.ChessPiece;
import Pieces.CoordinatePair;

public class Chess extends JFrame {
	
	private static Chess chessGameFrame = null;

	//Constructor that creates the GUI. Has a Chess board
	public Chess(){
		super();
	}
	private static GameStatusPanel statusPanel;
	
	public static void main(String[]args) {
		Chess chessGame = new Chess();
		chessGame.setVisible(true);
		chessGame.setTitle("Chess");
		
		GameController controller = GameController.initInstance();
		controller.initPieces();
		
		ChessBoardPanel chessBoardPanel = new ChessBoardPanel(8,8);
		chessGame.add(chessBoardPanel, BorderLayout.CENTER);
		
		statusPanel = new GameStatusPanel();
		chessGame.add(statusPanel, BorderLayout.NORTH);
		
		
		chessGame.pack();
		chessGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		chessGame.setLocationRelativeTo(null);
	}
	
	public static Chess getInstance() {
		if (chessGameFrame == null) {
			chessGameFrame = new Chess();
		}
		return chessGameFrame;
	}
	public static void switchPlayer() {
		statusPanel.switchPlayer();
	}
	public static void updateGameState(String status) {
		statusPanel.updateGameState(status);
	}

	public static void updateLatestMove(String move) {
		statusPanel.updateLatestMove(move);
		
	}
	
}
