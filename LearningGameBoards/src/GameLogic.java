import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class GameLogic {

	public static boolean checkRows(JButton[][] b) {
		for(int i = 0; i < b.length; i++) {
			if(b[i][0].getText() != "") {
				if(b[i][0].getText() == b[i][1].getText() &&
						b[i][0].getText() == b[i][2].getText()){
					b[i][0].setBorder(new LineBorder(Color.RED));
					b[i][1].setBorder(new LineBorder(Color.RED));
					b[i][2].setBorder(new LineBorder(Color.RED));
					
					System.out.println(b[0].length);
					return true;
					}
			}
		}
		return false;
	}
	
	public static boolean checkCols(JButton[][] b) {
		for(int i = 0; i < b[0].length; i++) {
			if(b[0][i].getText() != "") {
				if(b[0][i].getText() == b[1][i].getText() &&
						b[0][i].getText() == b[2][i].getText()){
					b[0][i].setBorder(new LineBorder(Color.RED));
					b[1][i].setBorder(new LineBorder(Color.RED));
					b[2][i].setBorder(new LineBorder(Color.RED));
					return true;
					}
			}
		}
		
		return false;
	}
	public static boolean checkDiags(JButton[][] b) {
		return false;
	}
	
	//TODO rework method so that it works
	public static boolean boardFull(JButton[][] b) {
		int count = 0;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if(b[i][j].isEnabled() == true) {
					count = count ++;
					
				}
				
			}
		}
		if(count <8) {
			return true;
		}
		return false;
	}
	
}
