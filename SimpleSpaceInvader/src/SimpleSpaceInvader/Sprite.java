package SimpleSpaceInvader;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {

	protected int x;
	protected int y;
	protected int width;
    protected int height;
	protected boolean visible;
	protected Image image;
	
	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		visible = true;
	}
	protected void loadIcon(String imagelocation) {
		ImageIcon ship = new ImageIcon(imagelocation);
		image = ship.getImage();
	}
	protected void getImageDimensions() {
		width = image.getWidth(null);
        height = image.getHeight(null);
	}
	
	public Image getImage() {
		return image;	
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean b) {
		visible = b;
	}	
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
}
