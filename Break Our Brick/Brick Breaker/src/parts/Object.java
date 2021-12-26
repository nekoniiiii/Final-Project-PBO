package parts;

import java.awt.Graphics;
import java.awt.Image;

import main.Frame;

public abstract class Object {
	
	protected int x, y;
	public int height, width;
	
	public Object(int x, int y, int width, int height) {
		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
	}
	
	public abstract Image getImage();
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setX(int pos) {
		if(pos > 0 && pos < Frame.WIDTH) {
			this.x = pos;
		} 
	}
	
	public void setY(int pos) {
		if(pos > 0 && pos < Frame.WIDTH) {
			this.y = pos;
		}
	}
	
	public int setWidth(int width) {
		return this.width = width;
	}
	
	public int setHeight(int height) {
		return this.height = height;
	} 
}
