package main;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import handlers.MouseHandler;
import parts.Ball;
import parts.Brick;
import parts.Paddle;

public class MainMenu {
	private Rectangle[] bounds = {new Rectangle(163, 366, 278, 100),
								  new Rectangle(163, 478, 276, 100)};
	
	private Image titleScreenForeground; // images di main
	private Image titleScreenBackground; // kalimat images di main
	
	public MainMenu() {
		titleScreenForeground = new ImageLoader(ImageLoader.titleForeground).getImage();
		titleScreenBackground = new ImageLoader(ImageLoader.titleScreenBackground).getImage();
	}
	
	public void tick() {
		for(int i = 0; i < bounds.length; i++) {
			if(bounds[i].contains(Controller.mousePoint) && MouseHandler.MOUSEDOWN) {
				MouseHandler.MOUSEDOWN = false;
				if(i == 0) {
					Controller.switchStates(Controller.STATE.PICKLEVEL);
				} else {
					visitSite();
				}
			}
		}
	}
	
	public void visitSite() {
		try {
			 Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI("https://github.com/nekoniiiii/Final-Project-PBO");
			  desktop.browse(oURL);
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	
	public void render(Graphics g) {
		g.drawImage(titleScreenBackground, 0, 0, Frame.WIDTH, Frame.HEIGHT, null);
		g.setColor(Color.black);
		g.drawImage(titleScreenForeground, 0, 0, Frame.WIDTH, Frame.HEIGHT, null);
		
		for(int i = 0; i < bounds.length; i++) {
			if(bounds[i].contains(Controller.mousePoint)) {
				g.drawRect(bounds[i].x, bounds[i].y, bounds[i].width, bounds[i].height);
			}
		}
	}
}
