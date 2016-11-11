package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JLabel;

import game.Game;

public class MainView extends JComponent{ //extend canvas and use bufferedimage here?
	//private Game game;
	//private GameController gc = game.gameControl;
	private JLabel start = new JLabel("START!!");
	
	public MainView() {
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, getWidth(), getHeight());
//		start.setOpaque(true);
//		add(start);
//		start.setOpaque(true);
		Game.gameControl.draw(g);
		//add(new label());
	}

	public void update() {
		Game.gameControl.update();
		start.repaint();
	}
	
	class label extends JLabel{
		public label(){
		setPreferredSize(new Dimension(40,50));
		setOpaque(true);
		repaint();
		}
		@Override 
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 40, 50);
		}
	}
	
}
