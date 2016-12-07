package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
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
public class TutorialScreen extends JPanel{
	
	public int screen = 0;
	
	public Rectangle playButton = new Rectangle(Game.WIDTH *2 - 50, 150, 100, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH *2 - 50, 350, 100, 50);
	/**
	 * Constructor for the start screen. Sets the background, draws a nice border, and adds a button with an ActionListener.
	 * @param game
	 */
	public TutorialScreen (int s){
		this.screen = s;
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font fnt1 = new Font("arial", Font.BOLD, 30);
		g.setColor(Color.white);
		g.setFont(fnt1);
		
		switch (this.screen){
		case 1:
				g.drawImage(createImage("Final Images/Backgrounds/Estuary_Background_1.jpg"),0,0,Game.WIDTH*4,Game.HEIGHT*4, Color.BLACK,null);
				g.drawImage(createImage("Final Images/Tutorials/tutorial_1.png"),Game.WIDTH,Game.HEIGHT / 4,400,500, Color.BLACK,null);	// 457x571
				g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), Game.WIDTH * 3 / 2, Game.HEIGHT * 3, 100, 50, Color.BLUE, null);
				g.drawString("Play", Game.WIDTH * 3 / 2 + 19, Game.HEIGHT * 3 + 35);
				break;
		case 2:
				g.drawImage(createImage("Final Images/Backgrounds/Estuary_Background_1.jpg"),0,0,Game.WIDTH*4,Game.HEIGHT*4, Color.BLACK,null);
				g.drawImage(createImage("Final Images/Tutorials/tutorial_2.png"),Game.WIDTH,Game.HEIGHT / 4,400,500, Color.BLACK,null);	// 457x571
				g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), Game.WIDTH * 3 / 2, Game.HEIGHT * 3, 100, 50, Color.BLUE, null);
				g.drawString("Play", Game.WIDTH * 3 / 2 + 19, Game.HEIGHT * 3 + 35);
				break;
		case 3:
			g.drawImage(createImage("Final Images/Backgrounds/Estuary_Background_1.jpg"),0,0,Game.WIDTH*4,Game.HEIGHT*4, Color.BLACK,null);
			g.drawImage(createImage("Final Images/Tutorials/tutorial_3.png"),Game.WIDTH,Game.HEIGHT / 4,400,500, Color.BLACK,null);	// 457x571
			g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), Game.WIDTH * 3 / 2, Game.HEIGHT * 3, 100, 50, Color.BLUE, null);
			g.drawString("Play", Game.WIDTH * 3 / 2 + 19, Game.HEIGHT * 3 + 35);
			break;
		default:
			g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/smallButton.png"), quitButton.x, quitButton.y, 100, 50, Color.BLUE, null);
		}
		
	}
	
	/**
	 * Attempts to load an image given the filename.
	 * @param file
	 * @return img
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
}