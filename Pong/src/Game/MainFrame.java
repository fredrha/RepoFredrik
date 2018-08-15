package Game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import GUI.GameBoard;
import GUI.ScorePanel;

public class MainFrame extends JFrame{
	
	private ScorePanel scorePanel;
	private GameBoard board;
	private JButton restartButton;
	
	
	public MainFrame() {
		initUI();
		
	}
	private void initUI() {
		setTitle("Pong");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		restartButton = new JButton("Restart game");
		add(restartButton, BorderLayout.NORTH);
		restartButton.setVisible(false);
		restartButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				board.restart();	
				restartButton.setVisible(false);
				pack();
			}
			
		});
		
		board = new GameBoard(this);
		add(board, BorderLayout.CENTER);
		
		scorePanel = new ScorePanel();
		add(scorePanel, BorderLayout.SOUTH);
		
		pack();
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
		MainFrame mainframe = new MainFrame();
		mainframe.setVisible(true);
		});
	}
	public void upDateScore(int player1, int player2) {
		scorePanel.updateScore(player1, player2);
		restartButton.setVisible(true);
		pack();
	}
}
