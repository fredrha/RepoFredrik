package GUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LetterCoordinatePanel extends JPanel {

	private Dimension buttonSize = new Dimension(160,50);
	
	public LetterCoordinatePanel(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		addButtons();
	}
	private void addButtons() {
		for(char c = 'a'; c<'i'; c++) {
			String name = Character.toString(c);
			JButton button = new JButton("		" +name  + "		");
			button.setPreferredSize(buttonSize);
			button.setEnabled(false);
			this.add(button);
	
		}
	}
	
}
