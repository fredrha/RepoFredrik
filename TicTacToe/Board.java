import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Board extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[][] board;
	private Dimension buttonSize = new Dimension(50,50);
	private String currentPlayerChar = "X";
	
	Board(int width, int height){
		
		setLayout(new GridLayout(height, width));
		board = new JButton[height][width];
		addButtons(board);
		addListeners(board);
	
	}
	
	private void addButtons(JButton[][] board) {
		this.board = board;
		
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[0].length; j++) {
					JButton button = new JButton("");
					button.setPreferredSize(buttonSize);
					
					board[i][j] = button;
					add(board[i][j]);
				}
		}
	}
	
	private void addListeners(JButton[][] board) {
		this.board = board;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				JButton button = board[i][j];
				button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(button.getText()=="X" || button.getText()== "O") {
					System.out.println("Cant place tile there");
				}
				placeMark(button);
				button.setEnabled(false);
				
				boardFull();
					}	
				});
			}
		}//for
	}
	
	//Call when button is clicked changes currentPlayerChar
		public void placeMark(JButton button) {
			button.setText(currentPlayerChar);
			
			if(currentPlayerChar == "X") {
				currentPlayerChar = "O";
			}
			else if(currentPlayerChar == "O") {
				currentPlayerChar = "X";

				}
		}

		//Checks to see if any button are enabled
		public boolean boardFull() {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if(board[i][j].getText()=="") {
						return true;
					}
					
				}
			
			}
			System.out.println("board full");
			return true;
		}
		
		public void resetBoard() {
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[0].length; j++) {
					board[i][j].setEnabled(true);
					board[i][j].setText("");
					board[i][j].setBorder(new LineBorder(Color.GRAY));
				}
			}
			
		}
		
		public void lockBoard() {
			for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[0].length; j++) {
					board[i][j].setEnabled(false);
				}
			}
			
		}
		
		
		public boolean isWinner() {
			return GameLogic.checkCols(board)||GameLogic.checkRows(board)||GameLogic.checkDiags(board);
		}

		public String getCurrentPlayer() {
			return currentPlayerChar;
		}
		
		public String getLastPlayer() {
			
			if(currentPlayerChar == "X") {
				currentPlayerChar = "O";
			}
			else if(currentPlayerChar == "O") {
				currentPlayerChar = "X";
			}
			
			return currentPlayerChar;
		}
		
		
}
