package week12.slot02;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class FlightPanel extends JPanel {

	final int WIDTH = 600, HEIGHT = 600;
	BirdPanel bird;
	Timer timer;
	boolean gameStart = false, gameOver = false;
	Random random = new Random();
	LinkedList<JPanel> topWalls = new LinkedList<JPanel>();
	LinkedList<JPanel> bottomWalls = new LinkedList<JPanel>();
	
	public FlightPanel() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.GREEN);
		
		bird = new BirdPanel();
		bird.setBounds(
			10, WIDTH / 2,
				bird.getPreferredSize().width, 
				bird.getPreferredSize().height);
		
		generateWall(250);
		generateWall(500);
		generateWall(750);
		
		timer = new Timer(30, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gameStart == true && gameOver == false) {					
					int birdY = bird.getBounds().y;
					bird.setBounds(
							10, birdY + 5,
							bird.getPreferredSize().width, 
							bird.getPreferredSize().height);
					moveWalls();
					addNewWall();
					birdOutOfBound();
					updateScore();
					if(gameOver == true) {
						restartGame();
					}
				}
			}
		});
		timer.start();
		
		this.add(bird);
	}
	
	public void restartGame() {
		gameOver = false;
		gameStart = false;
		GamePanel.prevScore = GamePanel.score;
		GamePanel.score = 0;
		timer.stop();
		Container container =
				BabyBirdGame.frame.getContentPane();
		container.removeAll();
		container.add(new GamePanel());
		container.revalidate();
		container.repaint();
	}
	
	public void updateScore() {
		GamePanel.score++;
		GamePanel.scorePanel.scoreLabel
			.setText("" + GamePanel.score);
	}
	
	public void birdOutOfBound() {
		if(bird.getBounds().getMinY() < 0 ||
			bird.getBounds().getMaxY() > HEIGHT) {
			gameOver = true;
		}
	}
	
	public void addNewWall() {
		if(topWalls.getFirst().getBounds().getMaxX() < 0) {
			JPanel topWall = topWalls.removeFirst();
			JPanel bottomWall = bottomWalls.removeFirst();
			
			this.remove(topWall);
			this.remove(bottomWall);
			
			int lastTopWallX =
				(int) topWalls.getLast().getBounds().getMinX();
			generateWall(lastTopWallX + 250);
			repaint();
		}
	}
	
	public void moveWalls() {
		for(JPanel topWall : topWalls) {
			int topWallX = topWall.getBounds().x;
			topWall.setBounds(
					topWallX - 5,
					topWall.getBounds().y,
					topWall.getBounds().width,
					topWall.getBounds().height
					);
			if(bird.getBounds()
					.intersects(topWall.getBounds())) {
				gameOver = true;
			}
		}
		for(JPanel bottomWall : bottomWalls) {
			int bottomWallX = bottomWall.getBounds().x;
			bottomWall.setBounds(
					bottomWallX - 5,
					bottomWall.getBounds().y,
					bottomWall.getBounds().width,
					bottomWall.getBounds().height
					);
			if(bird.getBounds()
					.intersects(bottomWall.getBounds())) {
				gameOver = true;
			}
		}
	}
	
	public void generateWall(int x) {
		int topHeight = random.nextInt(250) + 100;
		int bottomHeight = HEIGHT - topHeight - 150;
		
		JPanel topWall = new JPanel();
		topWall.setBounds(x, 0, 50, topHeight);
		topWall.setBackground(Color.BLACK);
		
		JPanel bottomWall = new JPanel();
		bottomWall.setBounds(
				x, topHeight + 150, 50, bottomHeight);
		bottomWall.setBackground(Color.BLACK);
		
		this.add(topWall);
		this.add(bottomWall);
		
		topWalls.add(topWall);
		bottomWalls.add(bottomWall);
	}
	
}
