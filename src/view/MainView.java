package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	Image background;
	public MainView() {

	}

	public void paintComponent(Graphics g){
		int curr_level = Game.getLevel();
		switch(curr_level){
				case 1:
				background = createImage("Final Images/Backgrounds/underwater2.png");
				break;
				case 2:
				background = createImage("Final Images/Backgrounds/lvltwobg.png");
				break;
				case 3:
				background = createImage("Final Images/Backgrounds/2D_estuary.jpg");
				break;
		}
	super.paintComponent(g);
	//Game.setVisible(true);s
	//g.setColor(Color.RED);
	// g.setColor(Color.CYAN);
	// g.fillRect(0, 0, getWidth(), getHeight());
	g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
	Game.getPane().add(statusPanel, BorderLayout.SOUTH);
	Game.gameControl.draw(g);
	}
	public void update() {
	Game.gameControl.update();
	}

	private Image createImage(String file) {
		Image img;
		try{
			img = ImageIO.read(new File(file));
			return img;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}
}