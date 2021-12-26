package parts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import main.Frame;
import main.ImageLoader;

public class Brick extends Object {
		
	public int level;
	public int originalLevel;
	private int powerup = 0;
	public boolean dropPowerup = false;
	public boolean hasDied = false;				
		
	private Random rand;
	public Rectangle bounds;
	ImageLoader loader;
		
	public Brick(int x, int y, int width, int height, int level) {
		super(x, y, width, height);
		originalLevel = level;
		this.level = level;
			
		rand = new Random();
		if(level > 0) {
			powerup = rand.nextInt(12);
		}

		bounds = new Rectangle(x, y, width, height);
		loader = new ImageLoader(ImageLoader.brick);
	}
	
	public Image getImage() {
		return loader.getSubImage(level);
	}
		
	public void hasCollided() {
		if(level >= 1) {
			level--;
			if(level == 0) {
				hasDied = true;
				if(hasPowerup() > 0) {
					dropPowerup = true;
				}
			}
		}
	}
		
	public void destroyed(){
		level = 0;
		hasDied = true;
		if(hasPowerup() > 0) {
			dropPowerup = true;
		}
	}
		
	public int hasPowerup() {
		return powerup;
	}
		
	public void render(Graphics g) {
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
