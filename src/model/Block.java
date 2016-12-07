package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.GameController;
/**
 * Abstract class for block. All platforms and floors are blocks.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 */
public abstract class Block {
	
	private boolean isFinal = false;
	public boolean isLegend = false;
	private boolean vertMover = false;
	private boolean horiMover = false;
	private boolean caughtCrabby = false;
	
	private int xPos, yPos;
	private int xVel, yVel;
	private int initX = 0;	// The center of horizontal movement
	private int initY = 0;	// The center of vertical movement

	
	private int width, height;
	
	private ObjectType type;
	private RangeType range;
	
	public GameController gamecontrol;
	
	String file;
	
	/**
	 * Constructor for block.
	 * @param x The block's x position.
	 * @param y The block's y position.
	 * @param initx The block's initial x position.
	 * @param inity The block's initial y position.
	 * @param width The width of the block.
	 * @param height The height of the block.
	 * @param t The type of the object.
	 * @param r The distance the block will move: none, short, medium, long.
	 * @param isVert If the block will move vertically when it moves.
	 * @param isHor If the block will move horizontally when it moves. 
	 * @param gc The game controller.
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
	 * @param b The block to be added to the list of blocks.
	 */
	public void addBlock(Block b){
		gamecontrol.blocks.add(b);
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	/**
	 * Updates the block's position based on the current x and y velocities.
	 */
	public void move(){
		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
	}
	
	/**
	 * When called, sets the block's y velocity to -5 so it will rise.
	 */
	public void rise(){
		this.yVel = -5;
	}
	
	/**
	 * @return xPos The block's x position.
	 */
	public int getXPos(){
		return this.xPos;
	}
	
	/**
	 * @param x Sets the block's x position.
	 */
	public void setXPos(int x){
		this.xPos = x;
	}
	
	/**
	 * @return yPos The block's y position.
	 */
	public int getYPos(){
		return this.yPos;
	}

	
	/**
	 * @param y Sets the block's y position.
	 */
	public void setYPos(int y){
		this.yPos = y;
	}
	
	/**
	 * @return initX The block's initial x position.
	 */
	public int getInitX(){
		return this.initX;
	}
	
	/**
	 * @param x The block's initial x position.
	 */
	public void setInitX(int x){
		this.initX = x;
	}
	
	/**
	 * @return inity The block's initial y position.
	 */
	public int getInitY(){
		return this.initY;
	}
	
	/**
	 * @param y Sets the block's initial y position.
	 */
	public void setInitY(int y){
		this.initY = y;
	}
	
	/**
	 * @return width The block's width.
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * @param w Sets the block's width.
	 */
	public void setWidth(int w){
		this.width = w;
	}
	
	/**
	 * @return height The block's height.
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * @param h Sets the block's height.
	 */
	public void setHeight(int h){
		this.height = h;
	}
	
	/**
	 * @return xVel The block's x velocity.
	 */
	public int getxVel() {
		return xVel;
	}
	
	/**
	 * @param xVel Sets the block's x velocity.
	 */
	public void setxVel(int xVel){
		this.xVel = xVel;
	}

	/**
	 * @return yVel The block's y velocity.
	 */
	public int getyVel() {
		return yVel;
	}
	
	/**
	 * @param yVel Sets the block's y velocity.
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	/**
	 * @return isFinal The block's final status.
	 */
	public boolean isFinal() {
		return isFinal;
	}
	
	/**
	 * @param isFinal Sets the block's final status.
	 */
	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
	
	/**
	 * @return vertMover The block's vertical movement status.
	 */
	public boolean isVert() {
		return vertMover;
	}
	
	/**
	 * @param isVert Sets the block's vertical movement status.
	 */
	public void setVert(boolean isVert) {
		this.vertMover = isVert;
	}
	
	/**
	 * @return horiMover The block's horizontal movement status.
	 */
	public boolean isHor() {
		return horiMover;
	}
	
	/**
	 * @param isHor Sets the character's horizontal status.
	 */
	public void setHor(boolean isHor) {
		this.horiMover = isHor;
	}
	
	/**
	 * 
	 */
	public void setCaughtCrabby(boolean caughtCrabby){
		this.caughtCrabby = caughtCrabby;
	}
	
	/**
	 * 
	 */
	public boolean getCaughtCrabby(){
		return caughtCrabby;
 	}
	
	/**
	 * @return type The block's type.
	 */
	public ObjectType getType(){
		return this.type;
	}
	
	/**
	 * @return range The range of the block.
	 */
	public RangeType getRange(){
		return this.range;
	}
	

	/**
	 * Gets the bounds of the block. Used when determining collisions.
	 * @return Rectangle A rectangle containing the bounds of the block.
	 */
	public Rectangle getBounds() {
		return new Rectangle(this.getXPos(), this.getYPos(), width, height);
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	public Rectangle getNetBounds(){
		return new Rectangle(this.getXPos()+50, this.getYPos() + 190, width-170, height - 225);
	}
	
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
