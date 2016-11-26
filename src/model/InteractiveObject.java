package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.GameController;

/**
 * Abstract class for interactive objects. Items and obstacles are interactive objects.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public abstract class InteractiveObject {
	
	public boolean useCorrect = false;

	public int xPos, yPos;
	public int  xVel, yVel;

	public int width, height;
	public int colNum; 
	
	public ObjectType type;
	
	public double gravity = 0.0;
	
	//public boolean solid;
	public boolean isJumping = false;
	public boolean isFalling = true;
	public boolean isGone = false;
	
	public GameController gamecontrol;
	
	String file;
	BufferedImage item;
	
	/**
	 * Constructor for interactive objects. Contains parameters related to the object.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param t
	 * @param gamecontrol
	 */
	public InteractiveObject(int x, int y, int width, int height, ObjectType t, GameController gamecontrol){
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.type = t;
		this.gamecontrol = gamecontrol;
		//this.colNum = color;
	}
	
	/**
	 * Removes the current object from the game controller's list of entities.
	 */
	public void remove(){
		gamecontrol.entities.remove(this);
	}
	
	/**
	 * Adds an item to the game controller's list of entities.
	 * @param go
	 */
	public void addObject(Item go){
		gamecontrol.entities.add(go);
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	/**
	 * Gets the current object's x position.
	 * @return this.xPos
	 */
	public int getXPos(){
		return this.xPos;
	}
	
	/**
	 * Gets the current object's y position.
	 * @return this.yPos
	 */
	public int getYPos(){
		return this.yPos;
	}
	
	/**
	 * Gets the current object's x velocity.
	 * @return xVel
	 */
	public int getxVel() {
		return xVel;
	}

	/**
	 * Gets the current object's y velocity.
	 * @return yVel
	 */
	public int getyVel() {
		return yVel;
	}
	
//	public boolean isSolid(){
//		return this.solid;
//	}
	
	/**
	 * Sets the current object's x velocity.
	 * @param xVel
	 */
	public void setxVel(int xVel){
		this.xVel = xVel;
	}

	/**
	 * Sets the current object's y velocity.
	 * @param yVel
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	/**
	 * Sets the current object's x position.
	 * @param xPos
	 */
	public void setXPos(int x){
		this.xPos = x;
	}
	
	/**
	 * Sets the current object's y position.
	 * @param yPos
	 */
	public void setYPos(int y){
		this.yPos = y;
	}
	
//	public void setSolid(boolean s){
//		this.solid = s;
//	}
	
	/**
	 * Gets the current object's type.
	 * @return
	 */
	public ObjectType getType(){
		return this.type;
	}
	
	/**
	 * Gets the bounds of the block. Used when determining collisions. Returns a Java Rectangle.
	 * @return Rectangle
	 */
	public Rectangle getBounds() {
		return new Rectangle(this.getXPos(), this.getYPos(), width, height);
	}
	
	/**
	 * Gets the top bounds of the block. Used when determining collisions. Returns a Java Rectangle.
	 * @return Rectangle
	 */
	public Rectangle getTopBounds(){
		return new Rectangle(this.getXPos()+10,this.getYPos(), width-20, 5);
	}
	
	/**
	 * Gets the bottom bounds of the block. Used when determining collisions. Returns a Java Rectangle.
	 * @return Rectangle
	 */
	public Rectangle getBottomBounds(){
		return new Rectangle(this.getXPos()+10,this.getYPos()+height-5, width-20, 5);
	}
	
	/**
	 * Gets the left bounds of the block. Used when determining collisions. Returns a Java Rectangle.
	 * @return Rectangle
	 */
	public Rectangle getLeftBounds(){
		return new Rectangle(this.getXPos(),this.getYPos()+10, 5, height-20);
	}
	
	/**
	 * Gets the right bounds of the block. Used when determining collisions. Returns a Java Rectangle.
	 * @return Rectangle
	 */
	public Rectangle getRightBounds(){
		return new Rectangle(this.getXPos()+width-5,this.getYPos()+10, 5, height-20);
	}
	
	/**
	 * Checks if the correct item was used.
	 * People get trashbags thrown at them to collect garbage.
	 * Chemicals get hay thrown at them to soak it up.
	 * Empty soil gets seeds thrown to grow plants.
	 * Dead soil gets compost thrown to improve it.
	 * If the correct item is used, the obstacle is removed.
	 * A boolean is returned stating if the player used the correct item.
	 * @param t
	 * @return useCorrect
	 */
	public boolean checkItem(ObjectType t){
		switch(this.type){
		case People:
			if(t == ObjectType.TrashBag){
			useCorrect = true;
			}
			else{
			useCorrect = false;
			}
			break;
		case Chemicals:
			if(t == ObjectType.Hay){
			useCorrect = true;
			}
			else{
			useCorrect = false;
			}
			break;
		case EmptySoil:
			if(t == ObjectType.Seeds){
				useCorrect = true;
			}
			else{
				useCorrect = false;
			}
			break;
		case DeadSoil:
			if(t == ObjectType.Compost){
				useCorrect = true;
			}
			else{
				useCorrect = false;
			}
			break;
		}
		System.out.println(useCorrect);
		if(useCorrect == true){
			gamecontrol.removeObject(gamecontrol.entities.getLast());
			gamecontrol.sendNext = true;
		}
		return useCorrect;
	}
	
	/**
	 * Attempts to load an image given a filename.
	 * @param file
	 * @return img
	 */
	public BufferedImage createImage(String file) {
		BufferedImage img;
		try{
			img = ImageIO.read(new File(file));
			return img;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

}