package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import handlers.MouseHandler;

public class PickLevel {
	
	private Image arrow;
	private Image titleScreenBackground;
	private int page = 1;
	
	Rectangle[] levels = {new Rectangle(83, 200, 90, 90), new Rectangle(255, 200, 90, 90),
						  new Rectangle(428, 200, 90, 90), new Rectangle(170, 400, 90, 90),
						  new Rectangle(340, 400, 90, 90)};
	
	Rectangle[] arrows = {new Rectangle(5, 600, 50, 50)};

	public PickLevel() {
		arrow = new ImageLoader(ImageLoader.arrow).getImage();
		titleScreenBackground = new ImageLoader(ImageLoader.titleScreenBackground).getImage();
	}
	
	public void tick(){
		if(MouseHandler.MOUSEDOWN) {
			for(int i = 0; i < levels.length; i++) {
				if(levels[i].contains(Controller.mousePoint)) {
					Controller.switchStates(Controller.STATE.GAME, i*page);
				}
			}
			
			for(int i = 0; i < arrows.length; i++) {
				if(arrows[i].contains(Controller.mousePoint)) {
					if(i == 0) {
						Controller.switchStates(Controller.STATE.MENU);
					}
					
				}
			}
			
			MouseHandler.MOUSEDOWN = false;
		}
	} 

	public void render(Graphics g) {
		g.setFont(Controller.bigFont);
		Graphics2D g2 = (Graphics2D)g;
		Color c = new Color(51, 153, 255); 
	    
	    g2.setPaint(c);
	    g.drawImage(titleScreenBackground, 0, 0, Frame.WIDTH, Frame.HEIGHT, null);
		g.setColor(Color.black);
		g.drawString("Choose Level", Frame.WIDTH/2-g.getFontMetrics().stringWidth("Choose Level")/2, 80);
		
		for(int i = 0; i < levels.length; i++) {
			g.setColor(Color.black);
			g.drawString("" + (i+1), levels[i].x+40, levels[i].y+50);
			
			if(levels[i].contains(Controller.mousePoint)) {
				g.setColor(new Color(255, 255, 255, 150));
				g.fillRect(levels[i].x, levels[i].y, levels[i].width, levels[i].height);
			}
			
			g.drawRect(levels[i].x, levels[i].y, levels[i].width, levels[i].height);
		}

		for(int i = 0; i < arrows.length; i++) {
			if(arrows[i].contains(Controller.mousePoint)) {
				g.setColor(new Color(255, 255, 255, 150));
				g.fillRect(arrows[i].x, arrows[i].y, arrows[i].width, arrows[i].height);
			}
			
			g.setColor(Color.black);
			g.drawRect(arrows[i].x, arrows[i].y, arrows[i].width, arrows[i].height);
			g.drawImage(arrow, arrows[i].x, arrows[i].y, arrows[i].width, arrows[i].height, null);
		}
	}
}
