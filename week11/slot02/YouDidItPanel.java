package week11.slot02;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YouDidItPanel extends JPanel 
							implements ActionListener {

	JButton yesButton = new JButton("Yes"), 
			noButton = new JButton("No");
	
	public YouDidItPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(new JLabel("YOU DID IT!!"));
		this.add(new JLabel("Play Again?"));
		this.add(yesButton);
		this.add(noButton);
		yesButton.addActionListener(this);
		noButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == yesButton) {
			Container container = 
					MathsQuizApp.mainFrame.getContentPane();
			container.removeAll();
			container.add(new QuizPanel());
			container.revalidate();
			container.repaint();
		}
		if(e.getSource() == noButton) {
			System.exit(0);
		}
	}
	
}
