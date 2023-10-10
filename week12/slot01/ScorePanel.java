package week12.slot01;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {

	JLabel scoreTitleLabel, scoreLabel;
	
	public ScorePanel(String title, int score) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		scoreTitleLabel = new JLabel(title);
		scoreTitleLabel.setFont(
			new Font(Font.SERIF, Font.PLAIN, 14)
				);
		
		scoreLabel = new JLabel("" + score);
		scoreLabel.setFont(
			new Font(Font.SANS_SERIF, Font.BOLD, 24)
				);
		
		this.add(scoreTitleLabel);
		this.add(scoreLabel);
	}
	
}
