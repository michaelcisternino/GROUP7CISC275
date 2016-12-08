package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import game.Game;

/**
 * The main view class.
 * 
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 */

public class MainView extends JComponent {  // extend canvas and use
											// bufferedimage here?
	// private Game game;
	// private GameController gc = game.gameControl;
	// JFrame frame = new JFrame();
	transient Image background;

	/**
	 * Constructor for MainView. Not currently used.
	 */
	public MainView() {

	}

	/**
	 * Paints the game on the pane. Gets the level from the game, and based on
	 * the level, sets the background to the appropriate image. Draws the
	 * background on the image, adds the status panel to the game, and draws
	 * everything.
	 * @param g The graphics to be drawn on.
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
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
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