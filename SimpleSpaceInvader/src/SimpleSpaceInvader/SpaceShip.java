package SimpleSpaceInvader;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite{

	private int dx;
	private int dy;
	private static SpaceShip ship = null;
	private List<Missile> missiles;
	
	public SpaceShip(int x, int y) {
		super(x,y);
		initSpacehip();
	}
	
	private void initSpacehip() {
		missiles = new ArrayList<>();
		loadIcon("src/Images/craft.png");
		getImageDimensions();
	}

	public static SpaceShip getInstance() {
		if(ship == null) {
			ship = new SpaceShip(40, 20);
		}
		return ship;
	}
	
	public void move() {
		x = x + dx;
		y = y + dy;
		if(x < 1) {
			x = 1;
		}
		if(y < 1) {
			y = 1;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_SPACE) {
			fire();
		}
		if(key == KeyEvent.VK_LEFT) {
			dx = -2;
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = 2;		
				}
		if(key == KeyEvent.VK_UP) {
			dy = -2;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy = 2;
		}
	}
	private void fire() {
		missiles.add(new Missile(x+width, y + height / 2));
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if(key == KeyEvent.VK_RIGHT) {
			dx = 0;		
				}
		if(key == KeyEvent.VK_UP) {
			dy = 0;
		}
		if(key == KeyEvent.VK_DOWN) {
			dy =0;
		}
	}

	public List<Missile> getMissiles() {
		return missiles;
	}

}
