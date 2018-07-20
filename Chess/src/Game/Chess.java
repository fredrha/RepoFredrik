package Game;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Chess extends JFrame {

	
	//Constructor that creates the GUI. Has a Chess board
	public Chess(){
		super();
	}
	
	public static void main(String[]args) {
		Chess chessGame = new Chess();
		chessGame.setVisible(true);
		chessGame.setTitle("Chess");
		
		//Add text iplaying which player turn it is
		JLabel currentPlayerlabel = new JLabel( " player turn");
		chessGame.add(currentPlayerlabel, BorderLayout.NORTH);
		
		ChessBoard chessBoard = new ChessBoard();
		chessGame.add(chessBoard, BorderLayout.CENTER);
		
		JLabel resultlabel = new JLabel("Winner is: ");
		chessGame.add(resultlabel, BorderLayout.SOUTH);
		
		chessGame.pack();
		chessGame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		chessGame.setLocationRelativeTo(null);
		
	}
	
}
