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
		setVisible(true);
		setTitle("Chess");
		
		ChessBoardPanel chessBoardPanel = new ChessBoardPanel(9,9);
		add(chessBoardPanel, BorderLayout.CENTER);
		
		statusPanel = new GameStatusPanel();
		add(statusPanel, BorderLayout.NORTH);
		
		LetterCoordinatePanel letterPanel = new LetterCoordinatePanel();
		add(letterPanel, BorderLayout.EAST);
		
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	public static void main(String[]args) {
		GameController controller = GameController.initInstance();
		controller.initPieces();
		
	}
	
	public static Chess getInstance() {
		if (chess == null) {
			chess = new Chess();
		}
		return chess;
	}
	public void switchPlayer() {
		statusPanel.switchPlayer();
	}
	public void updateGameState(String status) {
		statusPanel.updateGameState(status);
	}

	public void updateLatestMove(String move) {
		statusPanel.updateLatestMove(move);
		
	}

	public static void restart() {
		GameController controller = GameController.initInstance();
		controller.restart();
		
	}
	
}
