package model;

import java.awt.Color;
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
public class Item extends InteractiveObject{
	boolean isThrown = false;
	BufferedImage item;
	/**
	 * Constructor for items. A switch statement selects the proper image based on the the type.
	 * @param x The item x position.
	 * @param y The item y position.
	 * @param width The width of the item.
	 * @param height The height of the item.
	 * @param t The type of the item.
	 * @param gamecontrol The game controller.
	 */
	public Item(int x, int y, int width, int height, ObjectType t, GameController gamecontrol) {
		super(x, y, width, height, t, gamecontrol);
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
	 * Throws the item. The thrown item has its x velocity set to 7.
	 */
	public void throwItem(){
		setxVel(7);
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
		if(!isThrown){
			move();
			if (Game.gameControl.goingRight == true){
				setXPos(getXPos()-5);
			}
			else if (Game.gameControl.goingLeft == true){
				setXPos(getXPos()+5);
			}
		}
		if(isThrown){
			throwItem();
			for(int i = 0; i < gamecontrol.entities.size(); i++){
				InteractiveObject c = gamecontrol.entities.get(i);
				if(getBottomBounds().intersects(c.getBounds()) || getLeftBounds().intersects(c.getBounds()) || getRightBounds().intersects(c.getBounds())){
					if(c.checkItem(getType())){
						gamecontrol.removeObject(c);
					};
					gamecontrol.removeItem(this); 
					isThrown = false;
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

}
