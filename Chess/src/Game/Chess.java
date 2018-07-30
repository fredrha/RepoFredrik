package Game;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.ChessBoardPanel;

public class Chess extends JFrame {
	
	private static Chess chessGameFrame = null;

	
	//Constructor that creates the GUI. Has a Chess board
	public Chess(){
		super();
	}
	private static JLabel currentPlayerlabel;
	public static void main(String[]args) {
		Chess chessGame = new Chess();
		chessGame.setVisible(true);
		chessGame.setTitle("Chess");
		
		GameController controller = GameController.initInstance();
		controller.initPieces();
		
		//Add text displaying which player turn it is
		currentPlayerlabel = new JLabel(controller.getCurrentPlayer().getColor().toString() + " player turn");
		chessGame.add(currentPlayerlabel, BorderLayout.NORTH);
		
		ChessBoardPanel chessBoardPanel = new ChessBoardPanel(8,8);
		chessGame.add(chessBoardPanel, BorderLayout.CENTER);
		
		JLabel resultlabel = new JLabel("Winner is: ");
		chessGame.add(resultlabel, BorderLayout.SOUTH);
		
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
		GameController controller = GameController.getInstance();
		if(currentPlayerlabel != null) {
		}
		currentPlayerlabel.setText(controller.getCurrentPlayer().getColor().toString() + " player turn");
		
	}
	
}
