package GUI;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import SimpleSpaceInvader.SpaceShip;

public class SpaceShipAdapter extends KeyAdapter {

	@Override
	public void keyPressed(KeyEvent e) {
		SpaceShip ship = SpaceShip.getInstance();
		ship.keyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		SpaceShip ship = SpaceShip.getInstance();
		ship.keyReleased(e);
	}
}
