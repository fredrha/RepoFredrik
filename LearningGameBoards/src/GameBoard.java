import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoard {
	
	private JButton[][] board;
	private Dimension buttonSize = new Dimension(50,50);
	private String currentPlayerChar = "X";
	
	GameBoard(int height, int width){
		
		JFrame mainFrame = new JFrame("GameBoard");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(height, width));
		board = new JButton[height][width];
		
		addButtonsToPane(mainPanel, board);
		addListeners(board);
		
		mainFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		mainFrame.pack();
		mainFrame.setVisible(true);		
	}
	
	//Call when button is clicked changes currentPlayerChar
	public void placeMark(JButton button) {
		button.setText(currentPlayerChar);
		
		if(currentPlayerChar == "X") {
			currentPlayerChar = "O";
		}
		else if(currentPlayerChar == "O") {
			currentPlayerChar = "X";
			isWinner();
			boardFull();
			}
	}
	
	public boolean isWinner(){
		return GameLogic.checkRows(board)|| GameLogic.checkCols(board);
	}
	public boolean boardFull() {
		return GameLogic.boardFull(board);
	}
	
	private void addListeners(JButton[][] b) {
		
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				JButton button = b[i][j];
				button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(button.getText()=="X" || button.getText()== "O") {
					System.out.println("Cant place tile there");
				}
				placeMark(button);
				button.setEnabled(false);
					}	
				});
			}
		}//for
		
	}
	private void addButtonsToPane(JPanel p, JButton[][] b) {
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < 3; j++) {
				JButton button = new JButton();
				button.setPreferredSize(buttonSize);
				
				
				board[i][j] = button;
				p.add(board[i][j]);
			}
	
		}
		
	}
}
