import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	private static JButton resetButton;
	private static JLabel resultLabel;
	private static GameThread gameThread;
	
	
	public static void main(String[] args) {
		
		
		JFrame mainFrame = new JFrame("GameBoard");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Board gameBoard = new Board(3,3);
		
		mainFrame.getContentPane().add(gameBoard, BorderLayout.NORTH);
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gameBoard.resetBoard();	
				gameThread = new GameThread(gameBoard);
				gameThread.start();
			}
		});
		mainFrame.getContentPane().add(resetButton, BorderLayout.CENTER);
		
		resultLabel = new JLabel();
		resultLabel.setPreferredSize(new Dimension(50,50));
		mainFrame.getContentPane().add(resultLabel, BorderLayout.SOUTH);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
		
		gameThread = new GameThread(gameBoard);
		gameThread.start();
		
		
	}
	
	
	public static void displayWinner(Board GB) {
		String winner = GB.getLastPlayer();
		resultLabel.setText("Winner is: " + winner);
	}

}
