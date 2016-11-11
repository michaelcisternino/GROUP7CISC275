package view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

import game.Game;

public class MainView extends JComponent{ //extend canvas and use bufferedimage here?
	//private Game game;
	//private GameController gc = game.gameControl;
	
	public MainView() {
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, getWidth(), getHeight());
		Game.gameControl.draw(g);
	}

	public void update() {
		Game.gameControl.update();
	}
	
	
}
