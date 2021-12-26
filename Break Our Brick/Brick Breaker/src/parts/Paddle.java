package parts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import main.Frame;
import main.ImageLoader;

public class Paddle extends Object{
	
	public int moveSpeed = 10;

	public Rectangle bounds;
	ImageLoader loader;
	
	public Paddle(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		bounds = new Rectangle(x, y, width, height);
		loader = new ImageLoader(ImageLoader.paddle);
	}
	
	public Image getImage() {
		return loader.getImage();
	}
	
	public boolean isColliding(Powerup powerup) {
		if(powerup != null) {
			if(bounds.intersects(powerup.bounds)) {
				return true;
			}
		}
		return false;
	}
	
	public void moveLeft() {
		if(x > 0) {
			x -= moveSpeed;
		}
		bounds = new Rectangle(x, y, width, height);
	}
	
	public void moveRight() {
		if(x + width < Frame.WIDTH) {
			x += moveSpeed;
		}
		bounds = new Rectangle(x, y, width, height);
	}
	
	public void render(Graphics g) {
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
