package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controller.GameController;
import game.Game;

/**
 * Items are used to overcome obstacles. Subclass of InteractiveObject.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class Item extends InteractiveObject implements java.io.Serializable{
	private boolean isThrown = false;
	BufferedImage item;
	/**
	 * Constructor for items. A switch statement selects the proper image based on the the type.
	 * @param x The item's x position.
	 * @param y The item's y position.
	 * @param initx The item's initial x position.
	 * @param inity The item's initial y position.
	 * @param width The width of the item.
	 * @param height The height of the item.
	 * @param t The type of the item.
	 * @param r The distance the item will move.
	 * @param isVert If the item moves vertically.
	 * @param isHor If the item moves horizontally.
	 * @param gc The game controller.
	 */
	public Item(int x, int y, int initx, int inity, int width, int height, ObjectType t, RangeType r, Boolean isVert, Boolean isHor, GameController gc){
		super(x, y, initx, inity, width, height, t, r, isVert, isHor, gc);
		switch(t){
			case TrashBag:
				file = "Final Images/Objects/trashbag.png";
				item = createImage(file);
				break;
			case Hay:
				file = "Final Images/Objects/hay.png";
				item = createImage(file);
				break;
			case Compost:
				file = "Final Images/Objects/compost.png";
				item = createImage(file);
				break;
			case Seeds:
				file = "Final Images/Plants/seed.png";
				item = createImage(file);
				break;
			case Oyster:
				file = "Final Images/Animals/clam_left_2.png";
				item = createImage(file);
				break;
			case Trash:
 				file = "Final Images/Objects/banana.png";
 				item = createImage(file);
 				break;
 			case Recycling:
 				file = "Final Images/Objects/soda.png";
 				item = createImage(file);
 				break;
		default:
			break;
		}
		// TODO Auto-generated constructor stub
	}

	/**
	 * Draws the item based on the parameters.
	 * @param g The graphics to be drawn on.
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(item, getXPos(), getYPos(), getWidth(), getHeight(), null);
	}

	/**
	 * Updates the item based on the controller.
	 * If the controller is moving left or right, the item's position is updated.
	 * If the object is thrown, its x position is updated. The controller checks if the thrown item is contacting an obstacle.
	 * If the the item does not contact an obstacle, the item is removed.
	 * If the item is contacting a block, it is no longer falling and y velocity is set to 0.
	 * If the item is falling, its y velocity is updated based on the current gravity.
	 */
	@Override
	public void update() {
		if(Game.getLevel() == 1){
			setFalling(false);
		}
		move();
		if(!isThrown()){
			if(Game.gameControl.goingRight == true){
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
			if (isHor()){
				switch (getRange()) {
				case Short:
					if(getInitX() <0){
						setxVel(-4);
						setInitX(getInitX()-1);
					}
					if(getInitX() >=0){
						setxVel(4);
						setInitX(getInitX()+1);
					}
					if(getInitX() == -51){
						setInitX(0);
					}
					if(getInitX() == 51){
						setInitX(-1);
					}
					break;
				case Mid:
					if(this.getInitX() <0){
						setxVel(-3);
						setInitX(getInitX()-1);
					}
					if(this.getInitX() >=0){
						setxVel(3);
						setInitX(getInitX()+1);
					}
					if(this.getInitX() == -76){
						setInitX(0);
					}
					if(this.getInitX() == 76){
						setInitX(-1);
					}
					break;
				case Long:
					if(this.getInitX() <0){
						setxVel(-4);
						setInitX(getInitX()-1);
					}
					if(this.getInitX() >=0){
						setxVel(4);
						setInitX(getInitX()+1);
					}
					if(this.getInitX() == -101){
						setInitX(0);
					}
					if(this.getInitX() == 101){
						setInitX(-1);
					}
					break;
				default:
					break;
				}
			}
			if (isVert()){
				switch (getRange()) {
				case Short:
					if(getInitY() <0){
						setyVel(-4);
						setInitY(getInitY()-1);
					}
					if(getInitY() >=0){
						setyVel(4);
						setInitY(getInitY()+1);
					}
					if(getInitY() == -51){
						setInitY(0);
					}
					if(getInitY() == 51){
						setInitY(-1);
					}
					break;
				case Mid:
					if(getInitY() <0){
						setyVel(-3);
						setInitY(getInitY()-1);
					}
					if(getInitY() >=0){
						setyVel(3);
						setInitY(getInitY()+1);
					}
					if(getInitY() == -76){
						setInitY(0);
					}
					if(getInitY() == 76){
						setInitY(-1);
					}
					break;
				case Long:
					if(getInitY() <0){
						setyVel(-4);
						setInitY(getInitY()-1);
					}
					if(getInitY() >=0){
						setyVel(4);
						setInitY(getInitY()+1);
					}
					if(getInitY() == -101){
						setInitY(0);
					}
					if(getInitY() == 101){
						setInitY(-1);
					}
					break;
				default:
					break;
				}
			}
		}
		if(isThrown()){
			throwItem();
			for(int i = 0; i < gamecontrol.entities.size(); i++){
				InteractiveObject c = gamecontrol.entities.get(i);
				if(getBottomBounds().intersects(c.getBounds()) || getLeftBounds().intersects(c.getBounds()) || getRightBounds().intersects(c.getBounds())){
					if(c.checkItem(getType())){
						gamecontrol.removeEntity(c);
					};
					gamecontrol.removeThrownItem(this); 
					setThrown(false);
				}
			}
		}
		for(int i = 0; i < gamecontrol.blocks.size(); i++){
			Block b = gamecontrol.blocks.get(i);
				if(getBottomBounds().intersects(b.getBounds())){
					setyVel(0);
					if(isFalling()) {
						setFalling(false);
						}
				}
				else if (!isFalling()){
						setFalling(true);
						setGravity(0.8);
				}
				if(this.getLeftBounds().intersects(b.getBounds())){
					setxVel(2);
				}
				if(this.getRightBounds().intersects(b.getBounds())){
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

	/**
	 * @return The item's isThrown status.
	 */
	public boolean isThrown() {
		return isThrown;
	}

	/**
	 * @param isThrown Sets the items isThrown status.
	 */
	public void setThrown(boolean isThrown) {
		this.isThrown = isThrown;
	}

}
