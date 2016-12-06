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
public class Obstacle extends InteractiveObject{
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
			file = "Final Images/People and Humanoids/mr_evil.png";
			item = createImage(file);
			break;
		case Chemicals: 
			file = "Final Images/Objects/StormDrain_01.png";
			item = createImage(file);
			break;
		case EmptySoil:
			file = "Final Images/Plants/sadmilkweed.png";
			item = createImage(file);
			break;
		case DeadSoil:
			file = "Final Images/Objects/soil.png";
			item = createImage(file);
			break;
		case TrashBin:
			file = "Final Images/Objects/trashcan_open.png";
			item = createImage(file);
			break;
		case RecycleBin:
			file = "Final Images/Objects/recycling.png";
			item = createImage(file);
			break;
		case Erosion:
			file = "Final Images/Environment Misc/no_erosion_icon.png";
			item = createImage(file);
			break;
		}
		// TODO Auto-generated constructor stub
		//fall();
	}

	/**
	 * Draws the obstacle based on the parameters.
	 * @param g The graphics to be drawn on.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(obsCol);
		g.fillRect(getXPos(), getYPos(), getWidth(), getHeight());
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
//		if (Game.gameControl.isXMover == true){
//			if (Game.gameControl.goingRight == true){
//				this.xPos -= 5;
//			}
//			else if (Game.gameControl.goingLeft == true){
//				this.xPos += 5;
//			}
//			if (this.up == true){
//				this.yPos -= 5;
//			}
//			else if (this.up == false){
//				this.yPos += 5;
//			}
//		}
		
		if (Game.gameControl.goingRight == true){
			if(Game.getLevel() == 1){
				setXPos(getXPos() - 1);
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
