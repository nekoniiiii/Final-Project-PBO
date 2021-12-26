package main;

import javax.swing.JFrame;

public class Frame {

	private static JFrame frame;
	
	public static int WIDTH = 600;
	public static int HEIGHT = 800;
	
	public static void main(String[] args) {
		frame = new JFrame("Break Our Brick");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Controller());
		frame.pack();	
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
