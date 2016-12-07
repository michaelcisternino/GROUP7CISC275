package controller;

import game.Game;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Mouse input listener
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 */
public class MouseInput implements MouseListener{

	/**
	 * Inherited mouselistener method. Not currently used.
	 */
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Inherited mouselistener method. Not currently used.
	 */
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Inherited mouselistener method. Not currently used.
	 */
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Listens for mouse clicks. Used when clicking buttons to move between levels.
	 * Checks the mouse coordinates. If they are within the bounds of a button and the mouse is clicked, the appropriate action is taken.
	 */
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		/**
			public Rectangle playButton = new Rectangle(Game.WIDTH *2, 150, 100, 50);
			public Rectangle helpButton = new Rectangle(Game.WIDTH *2, 250, 100, 50);
			public Rectangle quitButton = new Rectangle(Game.WIDTH *2, 350, 100, 50);
		*/
		
		if (Game.game.getLevel() == 0){
			//Play Button
			if(mx >= Game.WIDTH * 2 - 50 && mx <= Game.WIDTH*2 + 50)
			{
				if(my >= 175 && my <= 250)
				{
					//Pressed Play Button
					System.out.println("Pressed play button");
					Game.game.tutorialOne();
				}
			}
			
			//Quit Button
			if(mx >= Game.WIDTH * 2 - 50 && mx <= Game.WIDTH*2 + 50)
			{
				if(my >= 375 && my <= 450)
				{
					//Pressed Quit Button
					System.exit(0);
				}
			}
		}
		if (Game.game.getLevel() == 4){
			//Play Button
			if(mx >= Game.WIDTH * 2 - 50 && mx <= Game.WIDTH*2 + 50)
			{
				if(my >= 250 && my <= 325)
				{
					//Pressed Play Button
					System.out.println("Pressed reset button");
					Game.game.resetPlaying();
				}
			}
			
			//Quit Button
			if(mx >= Game.WIDTH * 2 - 50 && mx <= Game.WIDTH*2 + 50)
			{
				if(my >= 350 && my <= 425)
				{
					//Pressed Quit Button
					System.exit(0);
				}
			}
		}
		if (Game.game.getLevel() == 5){
			//Play Button
			if(mx >= Game.WIDTH * 3 / 2 && mx <= Game.WIDTH * 3 / 2 + 100)
			{
				if(my >= Game.HEIGHT * 3 && my <= Game.HEIGHT * 3 + 75)
				{
					//Pressed Play Button
					System.out.println("Pressed level 5");
					Game.game.setPlaying(true);
				}
			}
		}
		if (Game.game.getLevel() == 6){
			//Play Button
			if(mx >= Game.WIDTH * 3 / 2 && mx <= Game.WIDTH * 3 / 2 + 100)
			{
				if(my >= Game.HEIGHT * 3 && my <= Game.HEIGHT * 3 + 75)
				{
					//Pressed Play Button
					System.out.println("Pressed level 6");
					Game.game.setPlaying(true);
//					Game.startNextLevel(Game.getLevel());
				}
			}
		}
		if (Game.game.getLevel() == 7){
			//Play Button
			if(mx >= Game.WIDTH * 3 / 2 && mx <= Game.WIDTH * 3 / 2 + 100)
			{
				if(my >= Game.HEIGHT * 3 && my <= Game.HEIGHT * 3 + 75)
				{
					//Pressed Play Button
					System.out.println("Pressed level 7");
					Game.game.setPlaying(true);
				}
			}
		}
		if (Game.game.getLevel() == 8){
			//Play Button
			if(mx >= Game.WIDTH * 2 - 50 && mx <= Game.WIDTH*2 + 50)
			{
				if(my >= 350 && my <= 425)
				{
					//Pressed Play Button
					System.out.println("Pressed reset button");
					Game.game.newGame();
				}
			}
			
			//Quit Button
			if(mx >= Game.WIDTH * 2 - 50 && mx <= Game.WIDTH*2 + 50)
			{
				if(my >= 450 && my <= 525)
				{
					//Pressed Quit Button
					System.exit(0);
				}
			}
		}
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
