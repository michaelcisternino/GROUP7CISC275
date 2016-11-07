package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import game.Game;

public class MainView extends JComponent{ //extend canvas and use bufferedimage here?
	public static Game game;
	
	public MainView() {
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, getWidth(), getHeight());
		game.gameControl.draw(g);
	}

	public void update() {
		game.gameControl.update();
	}
	
	
}
