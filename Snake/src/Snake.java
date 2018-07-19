import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Snake extends JFrame {
	private JPanel buttonPanel;
	private static JButton reStartButton;
	private static GameBoard board;
	static JLabel resultLabel;
	
	public Snake(){
		initUI();		
	}

	private void initUI() {
		board = new GameBoard();
		add(board, BorderLayout.NORTH);
		buttonPanel = new JPanel();
		reStartButton = new JButton("Restart game");
		reStartButton.setEnabled(false);
		reStartButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				board.resetGame();
				reStartButton.setEnabled(false);	
				resultLabel.setText("Score:");
			}
			
		});
		
		buttonPanel.add(reStartButton);
		add(buttonPanel, BorderLayout.CENTER);
        setTitle("Snake");
        
        resultLabel = new JLabel("Score:");
        add(resultLabel, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();	
	}
	
public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            Snake snake = new Snake();
            snake.setVisible(true);
        });
    }

public static void gameEnd() {
	resultLabel.setText("Score: You have eaten " + board.getEatenApples() + " apples");
	reStartButton.setEnabled(true);
	
}
}
