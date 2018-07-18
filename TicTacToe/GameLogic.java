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
	public static boolean checkDiags(JButton[][] board) {
		if(board[0][0].getText() != "" && board[0][0].getText() == board[1][1].getText() 
				&& board[0][0].getText()==board[2][2].getText()) {
			board[0][0].setBorder(new LineBorder(Color.RED));
			board[1][1].setBorder(new LineBorder(Color.RED));
			board[2][2].setBorder(new LineBorder(Color.RED));
			return true;
		}
		if(board[2][0].getText() != "" && board[2][0].getText() == board[1][1].getText() 
				&& board[2][0].getText()==board[0][2].getText()) {
			board[2][0].setBorder(new LineBorder(Color.RED));
			board[1][1].setBorder(new LineBorder(Color.RED));
			board[0][2].setBorder(new LineBorder(Color.RED));
			return true;
		}
		
		return false;
	}
	
	
}
