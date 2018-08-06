package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import GUI.GameBoard;

public class Racket {
	
	private Dimension size;
	private int x;
	private int y, dy;
	private int up, down;
	private GameBoard board;
	
	public Racket(Dimension size, int x, int  y, int up, int down, GameBoard board) {
		this.size = size;
		this.x = x;
		this.y = y;
		this.up = up;
		this.down = down;
		this.board = board;
	}

	public void update() {
		if(y > 0 && y < board.getHeight()-size.height) {
			y = y+ dy;
		}
		else if (y == 0) {
			y++;
		}
		else if(y == board.getHeight()) {
			y--;
		}
		
	}
	
	public void keyPressed(int keyCode) {
		if(keyCode == up) {
			dy = -2;
		}
		if(keyCode == down) {
			dy = 2;
		}
	}
	
	public void keyReleased(int keyCode) {
		if(keyCode == up || keyCode == down) {
			dy = 0;
		}
	}
	
	public int getSpeed() {
		return dy;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y, size.height, size.width);
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, size.height, size.width);
		g.setColor(Color.CYAN);
	}

}
