package model;

import game.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import controller.GameController;

/**
 * Game floors. Inherits block.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class Floor extends Block{

	public Floor(int x, int y, int width, int height, ObjectType t, GameController oc) {
		super(x, y, width, height, t, oc);
	}

	/**
	 * Draws a floor based on the obstacle's parameters.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(this.xPos,this.yPos,width,height);
	}

	@Override
	/**
	 * Updates the floor's position based on the direction the game is moving.
	 */
	public void update() {
		//this.xPos-=1;
//		if(this.xPos <= (0-this.width)){
//			this.setXPos(270*4);
//		}
		if (Game.gameControl.goingRight == true){
			this.xPos -= 5;
		}
		else if (Game.gameControl.goingLeft == true){
			this.xPos += 5;
		}
	}

	
}
