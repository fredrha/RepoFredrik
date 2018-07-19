import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements ActionListener{
	
	private Image head;
	private Image tail;
	private Image apple;
    private final int BOARD_WIDTH = 300;
    private final int BOARD_HEIGHT = 300;
    private final int ALL_DOTS = 900;
    private final int DOT_SIZE = 10;
    private final int RAND_POS = 29;
    private final int DELAY = 140;
    
    private final int snakeX[] = new int[ALL_DOTS];
    private final int snakeY[] = new int[ALL_DOTS];
    
    private Timer timer;
    
    private int dots;
    private int apple_x = 100;
    private int apple_y = 100;
    private SnakeAdapter snakeAdapter;
    private boolean hasCollided = false;

	public GameBoard() {
		initBoard();
	}
	
	private void initBoard() {
		snakeAdapter = new SnakeAdapter();
		addKeyListener(snakeAdapter);

		setBackground(Color.black);
        setFocusable(true);
        setDoubleBuffered(true);
        
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        loadImages();
        initGame();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		drawApple(g);
		drawSnake(g);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		move();
		checkCollision();
		checkApple();
		repaint();
		
	}
	
	private void loadImages() {
		ImageIcon head = new ImageIcon("src/images/head.png");
		this.head = head.getImage();
		
		ImageIcon tail = new ImageIcon("src/images/dot.png");
		this.tail = tail.getImage();
		
		ImageIcon apple = new ImageIcon("src/images/apple.png");
		this.apple = apple.getImage();
	}
	
	private void initGame() {
		dots = 3;

	    for (int z = 0; z < dots; z++) {
	        snakeX[z] = 100 - z * 10;
	        snakeY[z] = 100;
	    }      
	    timer = new Timer(DELAY, this);
	    timer.start();
	}
	
	 
	private void drawApple(Graphics g) {
		g.drawImage(apple, apple_x, apple_y, this);
	}
	private void drawSnake(Graphics g) {
		for(int i = 0; i < dots ; i++) {
			if(i == 0) {
				g.drawImage(head, snakeX[i], snakeY[i], this);
			}
			else {
				g.drawImage(tail, snakeX[i], snakeY[i], this);
			}
		}
	}
	
	//TODO replace ifs with switch
	//TODO refactor 10 into a variable that is explained
	 private void move() {
	        for (int i = dots; i > 0; i--) {
	        	snakeX[i] = snakeX[i-1];
	        	snakeY[i] = snakeY[i-1];
	        }
	        if (snakeAdapter.getDirection()==1) {
	        	snakeX[0] -= DOT_SIZE;
	        }
	        if (snakeAdapter.getDirection()==2) {
	        	snakeX[0] += DOT_SIZE;
	        }
	        if (snakeAdapter.getDirection()==3) {
	        	snakeY[0] -= DOT_SIZE;
	        }
	        if (snakeAdapter.getDirection()==4) {
	        	snakeY[0] += DOT_SIZE;
	        }
	    }

	 //TODO fix method so that collision does not occur outside boundaries.
	private void checkCollision() {
		//heck to see if snake has gone off an edge
		if(snakeX[0] >= BOARD_WIDTH || snakeX[0] + 10 <= 0 || 
				snakeY[0] >= BOARD_HEIGHT ||snakeY[0] + 10 <= 0) {
			hasCollided = true;
		}
		
		for(int i = 0; i < dots; i++) {
			if(i>3 && snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i] ) {
				hasCollided = true;
			}
		}
		
	
		if(hasCollided) {
		timer.stop();
		Snake.gameEnd();
		}
	
	}
	
	private void checkApple() {
	        if ((snakeX[0] == apple_x) && (snakeY[0] == apple_y)) {
	            dots++;
	           placeNewApple();
	        }
	    }
	
	private void placeNewApple() {
		int rand_x = (int) (Math.random() * RAND_POS);
		int rand_y = (int) (Math.random() * RAND_POS);
		
		apple_x = rand_x * DOT_SIZE;
		apple_y = rand_y * DOT_SIZE;
	}

	public void resetGame() {
		hasCollided = false;
		snakeAdapter.resetDirection();
		placeNewApple();
		initGame();
		
	}
	public int getEatenApples(){
		return dots-3;
	}
	
}
