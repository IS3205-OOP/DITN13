package week11.slot02;

import javax.swing.JFrame;

public class MathsQuizApp {

	public static JFrame mainFrame;
	
	public static void main(String[] args) {
		mainFrame = new JFrame("Maths Quiz");
		QuizPanel quiz = new QuizPanel();
		mainFrame.getContentPane().add(quiz);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
}
