package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

import SimpleSpaceInvader.AlienShip;
import SimpleSpaceInvader.Missile;
import SimpleSpaceInvader.SpaceShip;

public class GameBoard extends JPanel implements ActionListener{
	
	private Timer timer;
	private SpaceShip ship;
	private List<AlienShip> aliens;
	private final int B_WIDTH = 400;
    private final int B_HEIGHT = 300;
	private final int DELAY = 10;
	private SpaceShipAdapter shipAdapter;
	private boolean inGame;
	
	private final int[][] pos = {
		    {2380, 29}, {2500, 59}, {1380, 89},
		    {780, 109}, {580, 139}, {680, 239},
		    {790, 259}, {760, 50}, {790, 150},
		    {980, 209}, {560, 45}, {510, 70},
		    {930, 159}, {590, 80}, {530, 60},
		    {940, 59}, {990, 30}, {920, 200},
		    {900, 259}, {660, 50}, {540, 90},
		    {810, 220}, {860, 20}, {740, 180},
		    {820, 128}, {490, 170}, {700, 30}
		};
	
	public GameBoard() {
		initBoard();
	}

	private void initBoard() {
		shipAdapter = new SpaceShipAdapter();
		addKeyListener(shipAdapter);
		setFocusable(true);
		setBackground(Color.black);
		setDoubleBuffered(true);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
		inGame = true;
		
		ship = SpaceShip.getInstance();
		
		initAliens();
		timer = new Timer(DELAY, this);
		timer.start();		
	}

	private void initAliens() {
		aliens = new ArrayList<>();
        for (int[] p : pos) {
            aliens.add(new AlienShip(p[0], p[1]));
        }
    }

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(inGame) {
			drawObjects(g);
		}
		else {
			drawGameOver(g);
		}
		Toolkit.getDefaultToolkit().sync();
	}

	private void drawGameOver(Graphics g) {
		String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);		
	}

	private void drawObjects(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		ship = SpaceShip.getInstance();
		
		if(ship.isVisible()) {
			g2d.drawImage(ship.getImage(), ship.getX(), 
            ship.getY(), this);
		} 
        List<Missile> missiles = ship.getMissiles();
        for (Missile missile : missiles) {
        	if(missile.isVisible()) {
        		 g2d.drawImage(missile.getImage(), missile.getX(),
                    missile.getY(), this);
        	}
        }
        for(AlienShip a: aliens) {
        	if(a.isVisible()) {
        		g2d.drawImage(a.getImage(), a.getX(),
                        a.getY(), this);
        	}
        }
		
}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		inGame();
		updateMissiles();
        updateSpaceShip();
        upateAliens();
        
        checkCollision();
        
        repaint();   
	}


	private void checkCollision() {
		Rectangle shipBound = ship.getBounds();
		for(AlienShip a: aliens) {
			Rectangle enemyBound = a.getBounds();
			if(shipBound.intersects(enemyBound)) {
				ship.setVisible(false);
				a.setVisible(false);
				inGame = false;
				System.out.println("Hit ship");
			}
		}
		List<Missile> ms = ship.getMissiles();
		for(Missile m: ms) {
			Rectangle missileBound = m.getBounds();
			for(AlienShip a: aliens) {
				Rectangle enemyBound = a.getBounds();
				if(missileBound.intersects(enemyBound)) {
					m.setVisible(false);
					a.setVisible(false);
				}
			}
		}
		
	}

	private void upateAliens() {
		if(aliens.isEmpty()) {
			inGame = false;
			return;
		}
		for(int i = 0; i < aliens.size(); i++) {

            AlienShip a = aliens.get(i);
            
            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
            }
		}
	}

	//TODO implement game over screen
	private void inGame() {
		if(!inGame) {
			timer.stop();
		}
		
	}

	private void updateSpaceShip() {
		ship.move();	
	}
	private void updateMissiles() {
		List<Missile> missiles = ship.getMissiles();

        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);

            if (missile.isVisible()) {
                missile.move();
            } else {
                missiles.remove(i);
            }
        }
	}
	
	

}
