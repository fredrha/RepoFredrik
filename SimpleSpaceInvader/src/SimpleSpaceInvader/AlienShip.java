package SimpleSpaceInvader;

public class AlienShip extends Sprite {

	private final int INITIAL_X = 400;
	public AlienShip(int x, int y) {
		super(x, y);
		initAlien();
	}

	private void initAlien() {
		loadIcon("src/Images/alien.png");
		getImageDimensions();
		
	}
	public void move() {
		if(x<0) {
			x = INITIAL_X;
		}
		 x -= 1;
	}

}
