package week10.slot01;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MovingMessages {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		JPanel rootPanel = new JPanel();
		rootPanel.setLayout(new FlowLayout());
		
		Dimension defaultDimension = new Dimension(200, 50);
		
		JLabel label = new JLabel("Moving Where?");
//		label.setText("Nowhere.");
		JTextField textField = new JTextField();
		textField.setPreferredSize(defaultDimension);
		JButton button = new JButton("Answer");
		button.setPreferredSize(defaultDimension);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userInput = textField.getText();
				label.setText(userInput);
			}
			
		});
		
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String userInput = textField.getText();
				label.setText(userInput);
			}
			
		});
		
		rootPanel.add(label);
		rootPanel.add(textField);
		rootPanel.add(button);
		
		frame.getContentPane().add(rootPanel);
		
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}
