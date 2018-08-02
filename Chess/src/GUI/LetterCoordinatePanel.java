package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LetterCoordinatePanel extends JPanel {

	private Dimension buttonSize = new Dimension(120,50);
	
	public LetterCoordinatePanel(){
		//this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setLayout(new GridLayout(9,1));
		addButtons();
	}
	private void addButtons() {
		for(char c = 'a'; c<'i'; c++) {
			String name = Character.toString(c);
			JButton button = new JButton("		" +name  + "		");
			Color green = new Color(160,220,60);
			button.setBackground(green);
			button.setPreferredSize(buttonSize);
			button.setEnabled(false);
			button.setFont(new Font("serif", Font.BOLD, 18));
			this.add(button);
	
		}
	}
	
}
