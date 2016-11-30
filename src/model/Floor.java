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

	public Floor(int x, int y, int initx, int inity, int width, int height, ObjectType t, RangeType r, Boolean isVert, Boolean isHor, GameController gc) {
		super(x, y, initx, inity, width, height, t, r, isVert, isHor, gc);
	}

	/**
	 * Draws a floor based on the obstacle's parameters.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(getXPos(),getYPos(),getWidth(),getHeight());
	}

	@Override
	/**
	 * Updates the floor's position based on the direction the game is moving.
	 */
	public void update() {
		if (Game.gameControl.goingRight == true){
			setXPos(getXPos()-5);
		}
		else if (Game.gameControl.goingLeft == true){
			setXPos(getXPos()+5);
		}
	}

	
}
