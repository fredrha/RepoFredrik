package Game;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import GUI.ChessBoardPanel;
import GUI.GameStatusPanel;
import GUI.LetterCoordinatePanel;

public class Chess extends JFrame {
	
	private static Chess chess = null;
	private static GameStatusPanel statusPanel;
	protected ChessBoardPanel chessBoardPanel;
	
	//Constructor that creates the GUI. Has a Chess board
	public Chess(){
		super();
	}
	
	//TODO refactor into constructor. Beware of breaking the layout in the other panels.
	public static void main(String[]args) {
		Chess chessGame = new Chess();
		chessGame.setVisible(true);
		chessGame.setTitle("Chess");
		
		GameController controller = GameController.initInstance();
		controller.initPieces();
		
		ChessBoardPanel chessBoardPanel = new ChessBoardPanel(9,9);
		chessGame.add(chessBoardPanel, BorderLayout.CENTER);
		
		statusPanel = new GameStatusPanel();
		chessGame.add(statusPanel, BorderLayout.NORTH);
		
		LetterCoordinatePanel letterPanel = new LetterCoordinatePanel();
		chessGame.add(letterPanel, BorderLayout.EAST);
		
		chessGame.pack();
		chessGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		chessGame.setLocationRelativeTo(null);
	}
	
	public static Chess getInstance() {
		if (chess == null) {
			chess = new Chess();
		}
		return chess;
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

	public static void restart() {
		GameController controller = GameController.initInstance();
		controller.restart();
		
	}
	
}
