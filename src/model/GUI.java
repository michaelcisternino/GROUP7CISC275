
package model;

import game.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * The game's user interface and status bar.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 */

public class GUI {
	public int xPos = 15;
	public int yPos = Game.HEIGHT*Game.SCALE - 110;
	public int WIDTH = 300;
	public int HEIGHT = 50;

	/**
	 * Draws the user interface and status bar on the screen. Gets the item and health counts from the character and draws them.
	 * @param g The graphics to be drawn on.
	 */
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(createImage("Final Images/UI Buttons, Icons, Symbols/button2.png"), xPos, yPos, WIDTH, HEIGHT, null, null);
		for (int i = Game.gameControl.crabby.getLives(); i > 0; i--){
			g.drawImage(createImage("Final Images/Objects/fullHeart.png"),xPos*2*i - 10,yPos + 10,25,25, null,null);
		}
		
		switch (Game.getLevel()){
		case 1:
			g.drawImage(createImage("Final Images/Animals/clam_left_2.png"), 185, yPos + 10, 25, 25, null, null);
//			g.drawImage(createImage("Final Images/Objects/soda.png"), 220, yPos + 10, 25, 25, null, null);
//			g.drawImage(createImage("Final Images/Objects/banana.png"), 255, yPos + 10, 25, 25, null, null);
//			g.drawImage(createImage("Final Images/Objects/hay.png"), 290, yPos + 10, 25, 25, null, null);

			Font fnt0 = new Font("arial", Font.BOLD, 24);
			g.setFont(fnt0);
			g.setColor(Color.white);
			g.drawString(String.valueOf(Game.gameControl.crabby.oysterCnt), 175, yPos+35);
//			g.drawString(String.valueOf(Game.gameControl.crabby.recycleCnt), 210, yPos+35);
//			g.drawString(String.valueOf(Game.gameControl.crabby.trashCnt), 245, yPos+35);
//			g.drawString(String.valueOf(Game.gameControl.crabby.hayCnt), 280, yPos+35);
			break;
		case 2:
			g.drawImage(createImage("Final Images/Objects/trashbag.png"), 185, yPos + 10, 25, 25, null, null);
			g.drawImage(createImage("Final Images/Objects/soda.png"), 220, yPos + 10, 25, 25, null, null);
			g.drawImage(createImage("Final Images/Objects/banana.png"), 255, yPos + 10, 25, 25, null, null);
//			g.drawImage(createImage("Final Images/Objects/hay.png"), 290, yPos + 10, 25, 25, null, null);

			Font fnt2 = new Font("arial", Font.BOLD, 24);
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawString(String.valueOf(Game.gameControl.crabby.trashBagCnt), 175, yPos+35);
			g.drawString(String.valueOf(Game.gameControl.crabby.recycleCnt), 210, yPos+35);
			g.drawString(String.valueOf(Game.gameControl.crabby.trashCnt), 245, yPos+35);
//			g.drawString(String.valueOf(Game.gameControl.crabby.hayCnt), 280, yPos+35);
			break;
		case 3:
			g.drawImage(createImage("Final Images/Plants/seed.png"), 185, yPos + 10, 25, 25, null, null);
			g.drawImage(createImage("Final Images/Objects/compost.png"), 220, yPos + 10, 25, 25, null, null);
			g.drawImage(createImage("Final Images/Objects/hay.png"), 255, yPos + 10, 25, 25, null, null);

			Font fnt3 = new Font("arial", Font.BOLD, 24);
			g.setFont(fnt3);
			g.setColor(Color.white);
			g.drawString(String.valueOf(Game.gameControl.crabby.seedCnt), 175, yPos+35);
			g.drawString(String.valueOf(Game.gameControl.crabby.compCnt), 210, yPos+35);
			g.drawString(String.valueOf(Game.gameControl.crabby.hayCnt), 245, yPos+35);
			break;
		}
	
	}
	
	/**
	 * Attempts to load an image given a filename.
	 * @param file The filename to be loaded.
	 * @return img The image loaded from the file.
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
