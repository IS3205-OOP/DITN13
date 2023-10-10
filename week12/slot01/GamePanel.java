package week12.slot01;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	
	static int score = 0;
	static int prevScore = 0;
	ScorePanel prevScorePanel, scorePanel;
	FlightPanel flightPanel;
	boolean spacePressed = false;

	public GamePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(CENTER_ALIGNMENT);
		
		// Game Title
		JLabel titleLabel = new JLabel("Baby Bird");
		titleLabel.setFont(
				new Font(Font.SANS_SERIF, Font.BOLD, 32));
		titleLabel.setAlignmentX(CENTER_ALIGNMENT);
		this.add(titleLabel);
		
		// Previous Score
		prevScorePanel =
				new ScorePanel("Previous Score: " , prevScore);
		this.add(prevScorePanel);
		
		// Current Score
		scorePanel =
				new ScorePanel("Score: ", score);
		this.add(scorePanel);
		
		// Baby Bird Flight
		flightPanel = new FlightPanel();
		this.add(flightPanel);
		
		// User Manual
		JLabel manualLabel =
				new JLabel("Press Space to Start.");
		manualLabel.setFont(
				new Font(Font.SANS_SERIF, Font.PLAIN, 24));
		manualLabel.setAlignmentX(CENTER_ALIGNMENT);
		this.add(manualLabel);
		
		BabyBirdGame.frame.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			if(spacePressed == false) {	
				flightPanel.gameStart = true;
				flightPanel.bird.wingDown();
				int birdY = flightPanel.bird.getBounds().y;
				flightPanel.bird.setBounds(
						10, birdY - 50,
						flightPanel.bird.getPreferredSize().width, 
						flightPanel.bird.getPreferredSize().height);
				repaint();
			}
			spacePressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			flightPanel.bird.wingUp();
			repaint();
			spacePressed = false;
		}
	}
	
}
