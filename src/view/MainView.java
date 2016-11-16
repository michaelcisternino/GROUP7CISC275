package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import game.Game;
import model.Status;

public class MainView extends JComponent{ //extend canvas and use bufferedimage here?
	//private Game game;
	//private GameController gc = game.gameControl;
	//JFrame frame = new JFrame();
	public Status statusPanel = new Status();
	public MainView() {
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//Game.setVisible(true);s
		//g.setColor(Color.RED);
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, getWidth(), getHeight());
		Game.getPane().add(statusPanel, BorderLayout.SOUTH);
		Game.gameControl.draw(g);
	}

	public void update() {
		Game.gameControl.update();
	}
	
	
}
