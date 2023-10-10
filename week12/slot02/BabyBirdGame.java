package week12.slot02;

import javax.swing.JFrame;

public class BabyBirdGame {

	public static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame("Baby Bird");
		GamePanel game = new GamePanel();
		frame.getContentPane().add(game);
		frame.pack();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
