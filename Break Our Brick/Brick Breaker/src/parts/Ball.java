package parts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import main.Frame;
import main.ImageLoader;

public class Ball extends Object {
	
	private double dx = 0.25;
	private double dy = -6;
	private int speed = 5;
	public boolean onFire = false;
	private int fireSec = 0;
	private boolean big = false;
	private int bigSec = 0;
		
	public Rectangle bounds;
	private Random rand;
	private Timer timer;
	ImageLoader loader;
		
	public Ball(int x, int y, int width, int height, boolean onFire, boolean big) {
		super(x, y, width, height);
		
		this.onFire = onFire;
		this.big = big;
		this.speed = speed;
			
		rand = new Random();
		dx = 0;
			
		bounds = new Rectangle(x, y, width, height);
		loader = new ImageLoader(ImageLoader.ball);
		timer = new Timer();
	}
	
	public Image getImage() {
		return loader.getImage();
	}
		
	public void setOnFire(int seconds) {
		if(!onFire) {
			fireSec = seconds;
			onFire = true;
		    timer.schedule(new RemindTask(), seconds*1000);
		    loader = new ImageLoader(ImageLoader.fireBall);
		}
	}
	
	public void setBigger(int seconds) {
		if(!big) {
			bigSec = seconds;
			big = true;
			bounds = new Rectangle(x, y, 37, 37);
		    timer.schedule(new RemindTask(), seconds*1000);
		    loader = new ImageLoader(ImageLoader.bigBall);
		}
	}
	
	class RemindTask extends TimerTask {
		public void run() {
			if(onFire) {
				onFire = false;
				loader = new ImageLoader(ImageLoader.ball);
			}
			else if(big) {
				big = false;
				bounds = new Rectangle(x, y, 23, 23);
				loader = new ImageLoader(ImageLoader.ball);
			}
		}
	}
	
	public void tick() {
		if (x + dx < 0 || x + width + dx > Frame.WIDTH) {
			dx *= -1;
	    }
		
	    if (y + dy < 0 || y + height + dy > Frame.HEIGHT) {
	        dy *= -1;
	        
	        if(dx == 0) {
	        	dx = 1.5;
	        }
	    }
	    
	    x += dx;
	    y += dy;
	    bounds = new Rectangle(x, y, width, height);
	            
	}
		
	public void checkBrickCollision(Brick[] bricks) {
			for(int i = 0; i < bricks.length; i++) {
				if(bricks[i].level > 0) {
					if(bounds.intersects(bricks[i].bounds)) {
						if(!onFire) {
						switchDirections(bricks[i]);
						bricks[i].hasCollided();
						} else {
							bricks[i].destroyed();
						}
					}
				}
			}
	}
		
	public void checkPaddleCollision(Paddle paddle) {
		if(bounds.intersects(paddle.bounds)) {
			hitPaddle(paddle);
		}
	}
		
	public void switchDirections(Brick brick) {
		int random = rand.nextInt(6);
		double randomSpeed = rand.nextInt(6);
		
		if(random == 1) {
			if(dx < 10) {
				dx += randomSpeed;
			} else {
				dx -= randomSpeed;
			}
		}
		
		if(random == 2) {
			if(dx > -10) {
				dx += randomSpeed;
			} else {
				dx -= randomSpeed;
			}
		}
				
		if (x + dx < brick.getX() || x + width + dx > brick.getX()+brick.getWidth()) {
			dx *= -1;
	    }
		
	    if (y + dy < brick.getY() || y + height + dy > brick.getY()+brick.getHeight()) {
	        dy *= -1;
	    }
	    
	    x += dx;
	    y += dy;
	    bounds = new Rectangle(x, y, width, height);
	}
		
	public void hitPaddle(Paddle paddle) {
		if(y+height-5 < paddle.getY()) {
			
			if (x + dx < paddle.getX() || x + width + dx > paddle.getX()+paddle.getWidth()) {
				dx *= -1;
	        }
			
	        if (y + dy < paddle.getY() || y + height + dy > paddle.getY()+ paddle.getHeight()) {
	            dy *= -1;
	        }
		}
		
        x += dx;
        y += dy;
	}
		
	public void render(Graphics g) {
		g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}
