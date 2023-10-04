package week11.slot01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import week06.slot01.assets.Map;
import week06.slot01.assets.Pirate;
import week06.slot01.assets.Potion;
import week06.slot01.assets.interfaces.Placeable;
import week06.slot01.assets.weapons.Sword;

public class MainGamePanel extends JPanel {
	
	private final static int MAX_WIDTH = 6, MAX_HEIGHT = 6;
	private Map map = new Map(MAX_WIDTH, MAX_HEIGHT);
	private JPanel mapPanel, buttonsPanel;
	private AssetTextArea prevSelectedAsset = null;
	private int selectedX = -1, selectedY = -1;

	public MainGamePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		mapPanel = new JPanel();
		mapPanel.setLayout(new GridLayout(MAX_WIDTH, MAX_HEIGHT));
		mapPanel.setPreferredSize(new Dimension(800, 500));
		
		map.addAsset(0, 1, new Sword(4));
		map.addAsset(1, 1, new Potion(2));
		map.addPirate(4, 3, new Pirate());
		map.addPirate(3, 3, new Pirate());
		
		generateMap();
		
		buttonsPanel = new JPanel();
		
		generateMovePirateButtons();
		
		this.add(mapPanel);
		this.add(buttonsPanel);
	}
	
	public void refreshMap() {
		mapPanel.removeAll();
		generateMap();
		mapPanel.revalidate();
		mapPanel.repaint();
	}
	
	public void generateMovePirateButtons() {
		JButton leftButton = new JButton("Left");
		JButton upButton = new JButton("Up");
		JButton downButton = new JButton("Down");
		JButton rightButton = new JButton("Right");
		
		leftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				map.movePirateLeft(selectedX, selectedY);
				if(map.selectPirate(selectedX, selectedY) == null) {
					selectedX = selectedX - 1;
				}
				refreshMap();
			}
		});
		
		rightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				map.movePirateRight(selectedX, selectedY);
				if(map.selectPirate(selectedX, selectedY) == null) {
					selectedX = selectedX + 1;
				}
				refreshMap();
			}
		});
		
		upButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				map.movePirateUp(selectedX, selectedY);
				if(map.selectPirate(selectedX, selectedY) == null) {
					selectedY = selectedY - 1;
				}
				refreshMap();
			}
		});
		
		downButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				map.movePirateDown(selectedX, selectedY);
				if(map.selectPirate(selectedX, selectedY) == null) {
					selectedY = selectedY + 1;
				}
				refreshMap();
			}
		});
		
		buttonsPanel.add(leftButton);
		buttonsPanel.add(upButton);
		buttonsPanel.add(downButton);
		buttonsPanel.add(rightButton);
	}
	
	public void generateMap() {
		for(int y = 0; y < map.getHeight(); y++) {
			for(int x = 0; x < map.getWidth(); x++) {
				AssetTextArea assetTextArea = new AssetTextArea(x, y);
				assetTextArea.setLineWrap(true);
				assetTextArea.setBorder(
						BorderFactory.createLineBorder(Color.BLACK)
						);
				assetTextArea.setEditable(false);
				
				Placeable asset = map.selectAsset(x, y);
				if(asset != null) {
					assetTextArea.setText(asset.toString());
				}
				
				if(x == selectedX && y == selectedY) {
					prevSelectedAsset = assetTextArea;
					assetTextArea.setBackground(Color.LIGHT_GRAY);
				}
				
				assetTextArea.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {}

					@Override
					public void mousePressed(MouseEvent e) {
						if(prevSelectedAsset != null) {							
							prevSelectedAsset.setBackground(Color.WHITE);
						}
						prevSelectedAsset = assetTextArea;
						selectedX = assetTextArea.getArenaXLoc();
						selectedY = assetTextArea.getArenaYLoc();
						assetTextArea.setBackground(Color.LIGHT_GRAY);
					}

					@Override
					public void mouseReleased(MouseEvent e) {}

					@Override
					public void mouseEntered(MouseEvent e) {}

					@Override
					public void mouseExited(MouseEvent e) {}
				});
				
				mapPanel.add(assetTextArea);
			}
		}
	}
	
}
