package model;

import java.awt.Color;
import java.awt.Graphics;

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
	/**
	 * Constructor for obstacle. A switch statement based on the type selects the object's picture.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param t
	 * @param gamecontrol
	 */
	public Obstacle(int x, int y, int width, int height, ObjectType t, GameController gamecontrol) {
		super(x, y, width, height, t, gamecontrol);
		switch(t){
		case People:
			this.obsCol = Color.black;
			break;
		case Chemicals: 
			this.obsCol = Color.yellow;
			break;
		case EmptySoil:
			this.obsCol = Color.green;
			break;
		case DeadSoil:
			this.obsCol = Color.red;
			break;
		}
		// TODO Auto-generated constructor stub
	}

	/**
	 * Draws the obstacle based on the parameters.
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
			setXPos(getXPos()-5);
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