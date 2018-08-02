package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Game.Chess;
import Game.GameController;

public class GameStatusPanel extends JPanel {
	
	private JPanel infoPanel;
	private JPanel buttonPanel;
	
	private static JLabel currentPlayerLabel;
	private JLabel gamestatusLabel;
	private JLabel latestMoveLabel;
	private JButton restartButton;
	
	public GameStatusPanel() {
		this.setLayout(new GridLayout(1,2));
		GameController controller = GameController.getInstance();
		
		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		
		currentPlayerLabel = new JLabel(controller.getCurrentPlayer().getColor().toString() + " player turn");
		currentPlayerLabel.setFont(new Font("serif", Font.BOLD, 18));
		
		latestMoveLabel = new JLabel("Last move: ");
		latestMoveLabel.setFont(new Font("serif", Font.BOLD, 18));
		
		gamestatusLabel = new JLabel("Game status: ");
		gamestatusLabel.setFont(new Font("serif", Font.BOLD, 18));
		
		infoPanel.add(currentPlayerLabel, BorderLayout.NORTH);
		infoPanel.add(latestMoveLabel, BorderLayout.CENTER);
		infoPanel.add(gamestatusLabel, BorderLayout.SOUTH);
		
		restartButton = new JButton("Restart Game");
		restartButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int input = JOptionPane.showOptionDialog(null, "Do you want to start over?", 
						"Restart", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if(input == JOptionPane.OK_OPTION){
				    Chess chess = Chess.getInstance();
				    chess.restart();
				}	
			}
		});
		buttonPanel.add(restartButton);
		
		this.add(infoPanel);
		this.add(buttonPanel);
	}
	
	public void updateGameState(String status) {
		GameController controller = GameController.getInstance();
		if(status == null) {
			gamestatusLabel.setText("Game status: ");
		}
		else {
			gamestatusLabel.setText("Game status: " +controller.getOpponent().getColor().toString() +" is " + status);
		}
	}
	public void updateLatestMove(String move) {
		
		latestMoveLabel.setText("Last move: " + move);
	}
	public void switchPlayer() {
		GameController controller = GameController.getInstance();
		if(currentPlayerLabel != null) {
			
		}
		currentPlayerLabel.setText(controller.getCurrentPlayer().getColor().toString() + " player turn");
		
	}

	

}
