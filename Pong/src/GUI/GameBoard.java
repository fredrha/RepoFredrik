package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import Game.Ball;
import Game.MainFrame;
import Game.Racket;

public class GameBoard extends JPanel implements ActionListener, KeyListener{
	
	private Timer timer;
	private boolean inGame;
	private final int DELAY = 20;
	private Racket player1;
	private Racket player2;
	private Ball ball;
	private MainFrame mainframe;
	private Dimension size = new Dimension(500,300);
	
	public GameBoard(MainFrame mainframe) {
		initBoard();
		this.mainframe = mainframe;
	}

	private void initBoard() {
		setFocusable(true);
		setBackground(Color.black);
		setDoubleBuffered(true);
		setPreferredSize(size);
		inGame = true;	
		player1 = new Racket(new Dimension(30,10), getWidth()-40, getHeight()/2-30, KeyEvent.VK_UP, KeyEvent.VK_DOWN, this);
		player2 = new Racket(new Dimension(30,10), 10,getHeight()/2-30,KeyEvent.VK_W, KeyEvent.VK_S, this);
		ball = new Ball(this);
		
		addKeyListener(this);
		timer = new Timer(DELAY, this);
		timer.start();
	}
	public int getHeight() {
		return (int)size.getHeight();
	}
	public int getWidth() {
		return (int)size.getWidth();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();	
	}
	private void update() {
		if(inGame) {
			ball.update();
			player1.update();
			player2.update();	
		}
		else {
			timer.stop();
		}
	}
	public void GameOver() {
		inGame = false;
	}
	
	
public Racket getRacket(int i) {
	if(i == 1) {
		return player1;
	}
	if(i == 2) {
		return player2;
	}
	else {
		return null;
	}
}

@Override
public void keyPressed(KeyEvent arg0) {
	if(arg0.getKeyCode() == KeyEvent.VK_UP || arg0.getKeyCode() == KeyEvent.VK_DOWN) {
		player1.keyPressed(arg0.getKeyCode());
	}
	else if(arg0.getKeyCode() == KeyEvent.VK_W || arg0.getKeyCode() == KeyEvent.VK_S) {
		player2.keyPressed(arg0.getKeyCode());
	}
	
}

@Override
public void keyReleased(KeyEvent arg0) {
	if(arg0.getKeyCode() == KeyEvent.VK_UP || arg0.getKeyCode() == KeyEvent.VK_DOWN) {
		player1.keyReleased(arg0.getKeyCode());
	}
	else if(arg0.getKeyCode() == KeyEvent.VK_W || arg0.getKeyCode() == KeyEvent.VK_S) {
		player2.keyReleased(arg0.getKeyCode());
	}
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
}

@Override
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	ball.paint(g);
	player1.paint(g);
	player2.paint(g);
}

public void upDateScore(int score1, int score2) {
	mainframe.upDateScore(score1, score2);	
}
public void restart() {
	inGame = true;
	initBoard();
	
}

}
