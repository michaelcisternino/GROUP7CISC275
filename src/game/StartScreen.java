
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * A start screen for the game.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class StartScreen extends JPanel{

	public Rectangle playButton = new Rectangle(Game.WIDTH *2 - 50, 150, 100, 50);
	public Rectangle helpButton = new Rectangle(Game.WIDTH *2 - 50, 250, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH *2 - 50, 350, 100, 50);
	

	/**
	 * Constructor for the start screen. Not currently used.
	 * @param game The current game.
	 */
	public StartScreen(Game game){
		
	}
	
	/**
	 * Draws the start screen on the screen. Draws the background, buttons, and strings.
	 * @param g The frame to be drawn on.
	 */
	public void paintComponent(Graphics g){
//		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g.drawImage(createImage("Final Images/Backgrounds/Estuary_Background_1.jpg"),0,0,Game.WIDTH*4,Game.HEIGHT*4, Color.BLACK,null);
		g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), playButton.x, playButton.y, 100, 50, Color.BLUE, null);
		g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), helpButton.x, helpButton.y, 100, 50, Color.BLUE, null);
		g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), quitButton.x, quitButton.y, 100, 50, Color.BLUE, null);
	
		
		Font fnt0 = new Font("arial", Font.BOLD, 50);
		g.setFont(fnt0);
		g.setColor(Color.white);
		g.drawString("Super Estuary!", 350, 100);
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setFont(fnt1);
		g.drawString("Play", playButton.x + 19, playButton.y + 35);
		g.drawString("Help", helpButton.x + 19, helpButton.y + 35);
		g.drawString("Quit", quitButton.x + 19, quitButton.y + 35);
	}
	
	/**
	 * Attempts to load an image given the filename.
	 * @param file Filename to be loaded.
	 * @return img The loaded image
	 */
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
	
	class Quit implements ActionListener{

		/**
		 * Exits the system when the quit button is pressed.
		 */
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		
	}
	
	class Starter implements ActionListener{
		
		Game g;
		
		/**
		 * Constructor for the starter actionlistener.
		 * Takes in a game.
		 * @param g
		 */
		Starter(Game g){
			this.g = g;
		}
		
		/**
		 * Action listener calls DoIt().
		 */
		public void actionPerformed(ActionEvent e) {
			DoIt();
		}
		/**
		 * Sets the game playing status to true.
		 */
		public void DoIt(){
			g.setPlaying(true);
		}
		
	}
}
