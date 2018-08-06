package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import GUI.GameBoard;

public class Ball {
	
	private int x,y,dx = 2,dy = 1;
	private GameBoard board;
	
	public Ball(GameBoard board) {
		this.board = board;
		x = board.getWidth()/2;
		y = board.getHeight()/2;
	}

	public void update() {
		x += dx;
		y += dy;
		
		if(x < 0) {
			board.upDateScore(0, 1);
			board.GameOver();
			System.out.println("Player 2 win");
		}
		if(x > board.getWidth()) {
			board.upDateScore(1, 0);
			board.GameOver();
			System.out.println("Player 1 win");
		}
		if(y < 0 || y > board.getHeight()) {
			dy=-dy;
		}
		checkCollision(1);
		checkCollision(2);
	}

	private void checkCollision(int i) {
		if(board.getRacket(i).getBounds().intersects(getBounds())) {
			dx=-dx;
			dy = board.getRacket(i).getSpeed();
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y, 10, 10);
	}
	public void paint(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(x, y, 10, 10);
	}
}
