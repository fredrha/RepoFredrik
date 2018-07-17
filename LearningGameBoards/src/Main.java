import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	
	public static void main(String[] args) {
		
		GameBoard GB = new GameBoard(3,3);
		
		while(!GB.isWinner() || !GB.boardFull()) {
			
		}
		System.out.println("Someone won");
		
		
		
	}

}
