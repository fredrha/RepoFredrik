package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.GameController;

public class GameStatusPanel extends JPanel {
	
	private static JLabel currentPlayerLabel;
	private JLabel gamestatusLabel;
	private JLabel latestMoveLabel;
	public GameStatusPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		GameController controller = GameController.getInstance();
		
		currentPlayerLabel = new JLabel(controller.getCurrentPlayer().getColor().toString() + " player turn");
		currentPlayerLabel.setFont(new Font("serif", Font.BOLD, 18));
		
		latestMoveLabel = new JLabel("Last move: ");
		latestMoveLabel.setFont(new Font("serif", Font.BOLD, 18));
		
		gamestatusLabel = new JLabel("Game status: ");
		gamestatusLabel.setFont(new Font("serif", Font.BOLD, 18));
		
		add(currentPlayerLabel, BorderLayout.NORTH);
		add(latestMoveLabel, BorderLayout.CENTER);
		add(gamestatusLabel, BorderLayout.SOUTH);
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
