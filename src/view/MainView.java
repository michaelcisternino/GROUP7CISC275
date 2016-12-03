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

/**
 * The main view class.
 * 
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 */
public class MainView extends JComponent { // extend canvas and use
											// bufferedimage here?
	// private Game game;
	// private GameController gc = game.gameControl;
	// JFrame frame = new JFrame();
	public Status statusPanel = new Status();
	Image background;

	public MainView() {

	}

	/**
	 * Paints the game on the pane. Gets the level from the game, and based on
	 * the level, sets the background to the appropriate image. Draws the
	 * background on the image, adds the status panel to the game, and draws
	 * everything.
	 * 
	 * @param g
	 *            The graphics to be drawn on.
	 */
	public void paintComponent(Graphics g) {
		int curr_level = Game.getLevel();
		switch (curr_level) {
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
		// Game.setVisible(true);s
		// g.setColor(Color.RED);
		// g.setColor(Color.CYAN);
		// g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		Game.getPane().add(statusPanel, BorderLayout.SOUTH);
		Game.gameControl.draw(g);
	}

	/**
	 * Updates the game controller.
	 */
	public void update() {
		Game.gameControl.update();
	}

	/**
	 * Attempts to load an image given a filename.
	 * @param file The filename to be loaded.
	 * @return img The image loaded from the file.
	 */
	private Image createImage(String file) {
		Image img;
		try {
			img = ImageIO.read(new File(file));
			return img;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}