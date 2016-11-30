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
	
	private boolean isFinal = false;
	private boolean vertMover = false;
	private boolean horiMover = false;
	
	private int xPos, yPos;
	private int xVel, yVel;
	private int initX = 0;	// The center of horizontal movement
	private int initY = 0;	// The center of vertical movement

	
	private int width, height;
	
	private ObjectType type;
	private RangeType range;
	
	public GameController gamecontrol;
	
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
	
	public void move(){
		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
	}
	
	public void rise(){
		this.yVel = -5;
	}
	
	/**
	 * Gets the block's x position.
	 * @return xPos
	 */
	public int getXPos(){
		return this.xPos;
	}
	
	/**
	 * Sets the block's x position.
	 * @param x
	 */
	public void setXPos(int x){
		this.xPos = x;
	}
	
	/**
	 * Gets the block's y position.
	 * @return ypos
	 */
	public int getYPos(){
		return this.yPos;
	}

	
	/**
	 * Sets the block's y position.
	 * @param y
	 */
	public void setYPos(int y){
		this.yPos = y;
	}
	
	/**
	 * Gets the block's initial x position
	 * @return initX
	 */
	public int getInitX(){
		return this.initX;
	}
	
	/**
	 * Sets the block's initial x position.
	 * @param x
	 */
	public void setInitX(int x){
		this.initX = x;
	}
	
	/**
	 * Gets the block's initial y position
	 * @return initX
	 */
	public int getInitY(){
		return this.initY;
	}
	
	/**
	 * Sets the block's initial y position.
	 * @param y
	 */
	public void setInitY(int y){
		this.initY = y;
	}
	
	/**
	 * Gets the block's width
	 * @return width
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * Set's the block's width
	 * @param w
	 */
	public void setWidth(int w){
		this.width = w;
	}
	
	/**
	 * Gets the block's rising status
	 * @return height
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * Set's the block's height
	 * @param h
	 */
	public void setHeight(int h){
		this.height = h;
	}
	
	/**
	 * Gets the block's x velocity.
	 * @return
	 */
	public int getxVel() {
		return xVel;
	}
	
	/**
	 * Sets the block's x velocity.
	 */
	public void setxVel(int xVel){
		this.xVel = xVel;
	}

	/**
	 * Gets the block's y velocity.
	 * @return
	 */
	public int getyVel() {
		return yVel;
	}
	
	/**
	 * Gets the block's y velocity.
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	/**
	 * Gets the block's final status
	 * @return isFinal
	 */
	public boolean isFinal() {
		return isFinal;
	}
	
	/**
	 * Set's the character's final status
	 * @param isFinal
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
	
	/**
	 * Gets the block's vertical status
	 * @return vertMover
	 */
	public boolean isVert() {
		return vertMover;
	}
	
	/**
	 * Set's the character's vertical status
	 * @param isFinal
	 */
	public void setVert(boolean isVert) {
		this.vertMover = isVert;
	}
	
	/**
	 * Gets the block's horizontal status
	 * @return horiMover
	 */
	public boolean isHor() {
		return horiMover;
	}
	
	/**
	 * Set's the character's horizontal status
	 * @param isHor
	 */
	public void setHor(boolean isHor) {
		this.horiMover = isHor;
	}
	
	/**
	 * Gets the block's type.
	 * @return this.type
	 */
	public ObjectType getType(){
		return this.type;
	}
	
	/**
	 * Gets the range of the block.
	 * @return range
	 */
	public RangeType getRange(){
		return this.range;
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
}
