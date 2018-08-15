package SimpleSpaceInvader;
import java.awt.EventQueue;

import javax.swing.JFrame;

import GUI.GameBoard;

public class SimplepaceInvader extends JFrame {

	public SimplepaceInvader() {
		initUI();
	}

	private void initUI() {
		add(new GameBoard());
		setTitle("SimplepaceInvader");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			SimplepaceInvader spaceinvader = new SimplepaceInvader();
			spaceinvader.setVisible(true);
		});
		

	}
}
