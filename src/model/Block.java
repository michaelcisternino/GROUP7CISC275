package model;

import java.awt.Graphics;
import java.awt.Rectangle;

import controller.GameController;
/**
 * Abstract class for block. All platforms and floors are blocks.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public abstract class Block {
	
	public int erryXVel;
	public boolean isFinal = false;
	public boolean vertMover = false;
	public boolean horiMover = false;
	
	public int xPos, yPos;
	public int xVel, yVel;
	public int initX = 0;	// The center of horizontal movement
	public int initY = 0;	// The center of vertical movement

	
	public int width, height;
	
	public ObjectType type;
	public RangeType range;
	
	public double gravity = 0.0;
	
	//public boolean solid;
	public boolean isJumping = false;
	public boolean isFalling = true;
	public boolean isGone = false;
	
	public GameController gamecontrol;
	
	public boolean solid;
	
	/**
	 * Constructor for block.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param t
	 * @param gc
	 */
	public Block(int x, int y, int initx, int inity, int width, int height, ObjectType t, RangeType r, Boolean isVert, Boolean isHor, GameController gc){
		this.xPos = x;
		this.yPos = y;
		this.initX = initx;
		this.initY = inity;
		this.width = width;
		this.height = height;
		this.type = t;
		this.range = r;
		this.vertMover = isVert;
		this.horiMover = isHor;
		this.gamecontrol = gc;
		this.erryXVel = 0;
	}
	
	/**
	 * Removes the current block from the game controller list of blocks.
	 */
	public void remove(){
		gamecontrol.blocks.remove(this);
	}
	
	/**
	 * Adds a block to the game controller list of blocks.
	 * @param b
	 */
	public void addBlock(Block b){
		gamecontrol.blocks.add(b);
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	/**
	 * Gets the block's x position.
	 * @return
	 */
	public int getXPos(){
		return this.xPos;
	}
	
	/**
	 * Gets the block's y position.
	 * @return
	 */
	public int getYPos(){
		return this.yPos;
	}
	
	/**
	 * Gets the block's x velocity.
	 * @return
	 */
	public int getxVel() {
		return xVel;
	}

	/**
	 * Gets the block's y velocity.
	 * @return
	 */
	public int getyVel() {
		return yVel;
	}
	
//	public boolean isSolid(){
//		return this.solid;
//	}
	
	/**
	 * Gets the block's type.
	 * @return this.type
	 */
	public ObjectType getType(){
		return this.type;
	}
	
	/**
	 * Sets the block's x velocity.
	 */
	public void setxVel(int xVel){
		this.xVel = xVel;
	}

	/**
	 * Gets the block's y velocity.
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	/**
	 * Sets the block's x position.
	 */
	public void setXPos(int x){
		this.xPos = x;
	}
	
	/**
	 * Sets the block's y position.
	 */
	public void setYPos(int y){
		this.yPos = y;
	}
	
//	public void setSolid(boolean s){
//		this.solid = s;
//	}
	
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
}
