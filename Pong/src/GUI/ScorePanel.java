package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
	
	private JLabel player1Score;
	private JLabel player2Score;
	private int score1;
	private int score2;
	
	public ScorePanel() {
		player1Score = new JLabel("Player 1 score: " + 0);
		player2Score = new JLabel("Player 2 score: ");
		add(player1Score);
		add(player2Score);
		
	}
	public void updateScore(int score1, int score2) {
		this.score1 += score1;
		this.score2 += score2;
		player1Score.setText("Player 1 score: " + this.score1);
		player2Score.setText("Player 2 score: " + this.score2);
		
	}
	public void resetScore() {
		
	}

}
