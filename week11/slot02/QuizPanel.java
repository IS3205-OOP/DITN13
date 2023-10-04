package week11.slot02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QuizPanel extends JPanel implements ActionListener {

	JPanel equationPanel = new JPanel();
	JLabel leftValueLabel = new JLabel(),
		rightValueLabel = new JLabel(), counterLabel = new JLabel();
	JTextField answerTextField = new JTextField();
	JButton answerButton = new JButton("Answer");
	Random random = new Random();
	int leftValue, rightValue, counter;
	
	public QuizPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		equationPanel.setLayout(
				new BoxLayout(equationPanel, BoxLayout.X_AXIS));
		initialise();
	}
	
	public void initialise() {
		leftValue = random.nextInt(10);
		rightValue = random.nextInt(10);
		counter = 0;
		leftValueLabel.setText(leftValue + "");
		rightValueLabel.setText(rightValue + "");
		counterLabel.setText(counter + "");
		
		equationPanel.add(leftValueLabel);
		equationPanel.add(new JLabel("+"));
		equationPanel.add(rightValueLabel);
		equationPanel.add(new JLabel("="));
		equationPanel.add(answerTextField);
		this.add(equationPanel);
		this.add(answerButton);
		this.add(new JLabel("Consecutive correct answer:"));
		this.add(counterLabel);
		answerButton.addActionListener(this);
		answerTextField.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String answerString = answerTextField.getText();
		try {
			int answer = Integer.parseInt(answerString);
			if(answer == (leftValue + rightValue)) {
				counter++;
				if(counter >= 5) {
					MathsQuizApp.mainFrame.getContentPane()
						.removeAll();
					MathsQuizApp.mainFrame.getContentPane()
						.add(new YouDidItPanel());
					MathsQuizApp.mainFrame.getContentPane()
						.revalidate();
					MathsQuizApp.mainFrame.getContentPane()
						.repaint();
				}
			} else {
				counter = 0;
			}
		} catch (NumberFormatException exc) {
			counter = 0;
		}
		counterLabel.setText(counter + "");
		leftValue = random.nextInt(10);
		rightValue = random.nextInt(10);
		leftValueLabel.setText(leftValue + "");
		rightValueLabel.setText(rightValue + "");
		answerTextField.setText("");
	}
	
}
