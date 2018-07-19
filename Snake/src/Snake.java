import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Snake extends JFrame {
	
	public Snake(){
		initUI();		
	}

	private void initUI() {
		
		add(new GameBoard());
		
        setTitle("Snake");
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



}
