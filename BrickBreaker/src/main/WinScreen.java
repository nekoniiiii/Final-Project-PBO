package main;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import files.Files;
import files.Level;
import handlers.MouseHandler;

public class WinScreen {

	private Rectangle mainMenu;
	private Image background;
	
	public WinScreen() {
		mainMenu = new Rectangle(220, 380, 150, 55);
		background = new ImageLoader(ImageLoader.titleScreenBackground).getImage();
	}
	
	public void tick() {
		if(mainMenu.contains(Controller.mousePoint) && MouseHandler.MOUSEDOWN) {
			Controller.switchStates(Controller.STATE.MENU);
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(background, 0, 0, Frame.WIDTH, Frame.HEIGHT, null);
		g.setColor(Color.BLACK);
		g.setFont(Controller.bigFont);
		
		g.drawString("You Win!", 240, 150);
		g.drawString("Score: " + Controller.score, 285-g.getFontMetrics().stringWidth("Score" + Controller.score)/2, 225);
		g.drawRect(mainMenu.x, mainMenu.y, mainMenu.width, mainMenu.height);
		
		if(mainMenu.contains(Controller.mousePoint)) {
			g.setColor(new Color(200, 200, 200, 100));
			g.fillRect(mainMenu.x, mainMenu.y, mainMenu.width, mainMenu.height);
			g.setColor(Color.black);
		}
		
		g.drawString("Main Menu", mainMenu.x + 15, mainMenu.y + 30);
	}
}
