package model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import controller.GameController;
/**
 * Abstract class for characters.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public abstract class Character {

	public int xPos, yPos;
	public int  xVel, yVel;
	
	public int lives = 5;

	public int width, height;
	public int colNum; 
	
	public ObjectType type;
	
	public double gravity = 0.0;
	
	//public boolean solid;
	public boolean isJumping = false;
	public boolean isFalling = true;
	public boolean isGone = false;
	public boolean isRising = false;
	
	public GameController gamecontrol;
	
	String file;
	BufferedImage character;
	
	/**
	 * Constructor for character.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param t
	 * @param gamecontrol
	 */
	public Character(int x, int y, int width, int height, ObjectType t, GameController gamecontrol){
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.type = t;
		this.gamecontrol = gamecontrol;
		//this.colNum = color;
	}
	
	/**
	 * If the character dies, it loses a life.
	 */
	public void die(){
		this.lives--;
	}
	
	/*
	 * Removes this character from the game controller's list of entities.
	 */
	public void remove(){
		gamecontrol.entities.remove(this);
	}
	
	/**
	 * Adds a character to the game controller's list of entities.
	 * @param go
	 */
	public void addObject(Item go){
		gamecontrol.entities.add(go);
	}
	
	/**
	 * Gets the number of lives the character has.
	 * @return lives
	 */
	public int getLives(){
		return lives;
	}
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	/**
	 * Gets the character's x position.
	 * @return xPos
	 */
	public int getXPos(){
		return this.xPos;
	}
	
	/**
	 * Gets the character's y position.
	 * @return yPos
	 */
	public int getYPos(){
		return this.yPos;
	}
	
	/**
	 * Gets the character's x velocity.
	 * @return xVel
	 */
	public int getxVel() {
		return xVel;
	}

	/**
	 * Gets the character's y velocity.
	 * @return yVel
	 */
	public int getyVel() {
		return yVel;
	}
	
//	public boolean isSolid(){
//		return this.solid;
//	}
	
	/**
	 * Sets the character's x velocity.
	 * @param xVel
	 */
	public void setxVel(int xVel){
		this.xVel = xVel;
	}

	/**
	 * Sets the character's y velocity.
	 * @param yVel
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	/**
	 * Set's the character's x position.
	 * @param x
	 */
	public void setXPos(int x){
		this.xPos = x;
	}
	
	/**
	 * Set's the character's y position.
	 * @param y
	 */
	public void setYPos(int y){
		this.yPos = y;
	}
	
//	public void setSolid(boolean s){
//		this.solid = s;
//	}
	
	/**
	 * Gets the type of the objects.
	 * @return this.type
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
