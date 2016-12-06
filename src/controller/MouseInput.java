package controller;

import game.Game;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

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
//					Game.game.resetPlaying();
					Game.game.setPlaying(true);
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
