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
 */
public class Floor extends Block{

	/**
	 * Construtor for floor. Sends everything to the superclass constructor.
	 * @param x The floor's x position.
	 * @param y The floor's y position.
	 * @param initx The floor's initial x position.
	 * @param inity The floor's initial y position.
	 * @param width The width of the floor.
	 * @param height The height of the floor.
	 * @param t The type of the object.
	 * @param r The distance the floor will move: short, medium, long.
	 * @param isVert If the floor will move vertically when it moves.
	 * @param isHor If the floor will move horizontally when it moves. 
	 * @param gc The game controller.
	 */	
	public Floor(int x, int y, int initx, int inity, int width, int height, ObjectType t, RangeType r, Boolean isVert, Boolean isHor, GameController gc) {
		super(x, y, initx, inity, width, height, t, r, isVert, isHor, gc);
	}

	/**
	 * Draws a floor based on the obstacle's parameters.
	 * @param g The graphics to be drawn on.
	 */
	@Override
	public void draw(Graphics g) {
//		if(Game.getLevel() == 1){
//			g.drawImage(createImage("Final Images/Backgrounds/sand_tile.jpg"), getXPos(), getYPos(), null);
//		}
//		else{
		g.setColor(Color.darkGray);
		g.fillRect(getXPos(),getYPos(),getWidth(),getHeight());
//		}
		if (this.isLegend == true){
			switch(Game.getLevel()){
			case 1:
				g.drawImage(createImage("Final Images/Tutorials/tutorial_1.png"),this.xPos,this.yPos,400,500, Color.BLACK,null);	// 457x571
				break;
			case 2:
				g.drawImage(createImage("Final Images/Tutorials/tutorial_2.png"),this.xPos,this.yPos,400,500, Color.BLACK,null);
				break;
			case 3:
				g.drawImage(createImage("Final Images/Tutorials/tutorial_3.png"),this.xPos,this.yPos,400,500, Color.BLACK,null);
				break;
			}
		}
	}

	@Override
	/**
	 * Updates the floor's position based on the direction the game is moving.
	 */
	public void update() {
		if (Game.gameControl.goingRight == true){
			if(Game.getLevel() == 1){
				setXPos(getXPos() - 2);
			}
			else{
			setXPos(getXPos()-5);
			}
		}
		else if (Game.gameControl.goingLeft == true){
			setXPos(getXPos()+5);
		}
	}

	
}
