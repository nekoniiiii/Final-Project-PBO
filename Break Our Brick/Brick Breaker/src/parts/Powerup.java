package parts;

import java.awt.Image;
import java.awt.Rectangle;

import main.Frame;
import main.ImageLoader;

public class Powerup extends Object {

	public int powerup;
	public boolean remove = false;
	private int speed = 2;
	
	public Rectangle bounds;
	private Image image;
	
	public Powerup(int x, int y, int width, int height, int type) {
		super(x, y, width, height);
		
		powerup = type;
		bounds = new Rectangle(x, y, width, height);
		
		// multi ball
		if(powerup == 1) {
			image = new ImageLoader(ImageLoader.PUMultiBall).getImage();
		}
		
		// longer paddle
		if(powerup == 2) {
			image = new ImageLoader(ImageLoader.PUGrowth).getImage();
		}
		
		// fireball
		if(powerup == 3) {
			image = new ImageLoader(ImageLoader.PUFireball).getImage();
		}
		
		// bigger ball
		if(powerup == 4) {
			image = new ImageLoader(ImageLoader.PUBigball).getImage();
		}
		
	}
	
	public Image getImage() {
		return image;
	}
	
	public void tick() {
		if(y < Frame.HEIGHT) {
			y += speed;
			bounds = new Rectangle(x, y, width, height);
		} else {
			remove = true;
		}
	}
	
}
