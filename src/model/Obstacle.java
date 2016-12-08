package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controller.GameController;
import game.Game;
/**
 * Obstacles the player must beat. Subclass of InteractiveObject.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class Obstacle extends InteractiveObject implements java.io.Serializable{
	Color obsCol;
	BufferedImage item;
	/**
	 * Constructor for obstacle. A switch statement based on the type selects the object's picture.
	 * @param x The obstacle's x position.
	 * @param y The obstacle's y position.
	 * @param width The width of the obstacle.
	 * @param height The height of the obstacle.
	 * @param t The type of the obstacle.
	 * @param gamecontrol The game controller.
	 */
	public Obstacle(int x, int y, int initx, int inity, int width, int height, ObjectType t, RangeType r, Boolean isVert, Boolean isHor, GameController gc){
		super(x, y, initx, inity, width, height, t, r, isVert, isHor, gc);
		switch(t){
		case People:
			file = "Final Images/People and Humanoids/volunteer_blueshirt_walk_left_0.png";
			break;
		case Chemicals: 
			file = "Final Images/Objects/StormDrain_01.png";
			break;
		case EmptySoil:
			file = "Final Images/Plants/sadmilkweed.png";
			break;
		case DeadSoil:
			file = "Final Images/Objects/soil.png";
			break;
		case TrashBin:
			file = "Final Images/Objects/trashcan_open.png";
			break;
		case RecycleBin:
			file = "Final Images/Objects/recycling.png";
			break;
		case Erosion:
			file = "Final Images/Environment Misc/no_erosion_icon.png";
			break;
		case Net:
			file = "Final Images/Objects/net.png";
			break;
		case Gabion:
			file = "Final Images/Objects/gabion.png";
			break;
		case EmptyGabion:
			file = "Final Images/Objects/empty_gabion.png";
			break;
		}
		item = createImage(file);
		// TODO Auto-generated constructor stub
		//fall();
	}

	/**
	 * Draws the obstacle based on the parameters.
	 * @param g The graphics to be drawn on.
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(item, getXPos(), getYPos(), getWidth(), getHeight(), null);
	}

	/**
	 * Updates the obstacle based on the controller.
	 * The obstacle's moves based on whether the controller is moving left or right.
	 * If the obstacle is sitting on a block, it is not falling and y velocity is 0.
	 * If the item is falling, its y velocity is updated based on the current gravity.
	 */
	@Override
	public void update() {
		
		move();
		// TODO
		if(Game.getLevel() == 1 || getType() == ObjectType.Gabion){
			setFalling(false);
		}
		else{
			setFalling(true);
		}
		if(Game.getLevel()!=1 && getType() == ObjectType.Gabion){
			if(Game.gameControl.goingRight){
				setxVel(-6);
			}
			else{
				setxVel(0);
			}
		}
		if(isFinal()){
			if(getXPos() == 800 && Game.getLevel() == 1){
				Game.gameControl.crabby.isDone(true);
				Game.gameControl.goingRight = false;
		}
		}
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
		for(int i = 0; i < gamecontrol.blocks.size(); i++){
			Block b = gamecontrol.blocks.get(i);
				if(this.getBottomBounds().intersects(b.getBounds())){
					this.setyVel(0);
					if(isFalling()) {
						setFalling(false);
						}
				}
				else if (!isFalling()){
						setFalling(true);
						setGravity(0.8);
				}
				if(getLeftBounds().intersects(b.getBounds())){
					setxVel(2);
				}
				if(getRightBounds().intersects(b.getBounds())){
					setxVel(-6);
				}
		}
		if(isFalling()){
			if(getYPos() >= 750){
				setyVel(0);
			}
			fall();
		}
	}
}
