import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SnakeAdapter extends KeyAdapter {
	
    private int direction = 2;

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT && direction !=2) {
			direction = 1;
		}
		if(key == KeyEvent.VK_RIGHT && direction !=1) {
			direction = 2;
		}
		if(key == KeyEvent.VK_UP && direction !=4) {
			direction = 3;
		}
		if(key == KeyEvent.VK_DOWN && direction !=3) {
			direction = 4;
		}
		
	}
	
	public int getDirection() {
		return direction;
	}
	public void resetDirection() {
		direction = 2;
	}
	
}
