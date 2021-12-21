package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	private BufferedImage img;
	public static String titleForeground = "/BrickBreakerForeground.png";
	public static String titleScreenBackground = "/BrickBreakerBackground.png";
	public static String paddle = "/Paddle.png";
	public static String brick = "/Bricks.png";
	public static String ball = "/Ball.png";
	public static String fireBall = "/FireBall.png";
	public static String arrow = "/Arrow.png";
	public static String PUMultiBall = "/PUMulitBall.png";
	public static String PUGrowth = "/PUGrowth.png";
	public static String PUFireball = "/PUFireball.png";
	public static String PUBigball = "/PUBigball.png";
	public static String bigBall = "/Big.png";
	
	public ImageLoader(String path) {
		try {
			img = ImageIO.read(ImageLoader.class.getResourceAsStream(path));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public BufferedImage getImage() {
		return img;
	}
	public BufferedImage getSubImage(int section) {
		return img.getSubimage(0, section*25, 50, 25);
	}
}
