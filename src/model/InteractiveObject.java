package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.GameController;
import game.Game;

/**
 * Abstract class for interactive objects. Items and obstacles are interactive objects.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public abstract class InteractiveObject implements java.io.Serializable {
	
	private boolean useCorrect = false;

	private int xPos, yPos;
	private int  xVel, yVel;
	
	public boolean vertMover = false;
	public boolean horiMover = false;
	private boolean isFinal = false;
	private boolean gabionsGone = false;
	public int initX = 0;	// The center of horizontal movement
	public int initY = 0;	// The center of vertical movement
	public RangeType range;

	private int width, height;
	
	private ObjectType type;
	
	private double gravity = 0.0;
	
	private boolean isFalling = true;
	
	public GameController gamecontrol;
	
	String file;
	transient BufferedImage object;
	
	/**
	 * Constructor for interactive objects. Contains parameters related to the object.
	 * @param x The object's x position.
	 * @param y The object's y position.
	 * @param initx The object's initial x position.
	 * @param inity The object's initial y position.
	 * @param width The width of the object.
	 * @param height The height of the object.
	 * @param t The type of the object.
	 * @param r The distance the object will move.
	 * @param isVert If the object moves vertically.
	 * @param isHor If the object moves horizontally.
	 * @param gc The game controller.
	 */
	public InteractiveObject(int x, int y, int initx, int inity, int width, int height, ObjectType t, RangeType r, Boolean isVert, Boolean isHor, GameController gc){
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
		//this.colNum = color;
	}
	
	/**
	 * Removes the current object from the game controller's list of entities.
	 */
	public void remove(){
		gamecontrol.entities.remove(this);
	}
	
	/**
	 * @param go The item to be added to the game controller's list of entities.
	 */
	public void addObject(Item go){
		gamecontrol.entities.add(go);
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	/**
	 * Updates the object's position based on the current x and y velocities.
	 */
	public void move(){
		this.yPos+=this.yVel;
		if(Game.getLevel()!=1){
		this.xPos+=this.xVel;
		}
	}
	
	/**
	 * Sets the object's x velocity to 7 and then updates the object's x position based on the new x velocity.
	 */
	public void throwItem(){
		this.xVel = 7;
		this.xPos += this.xVel;
	}
	
	/**
	 * Updates the object's current gravity level and then updates the current y velocity to make the object fall.
	 */
	public void fall(){
		this.gravity += 0.1;
		this.yVel = (int)this.gravity;
	}

	
	/**
	 * @return isFalling The object's falling status.
	 */
	public boolean isFalling() {
		return isFalling;
	}

	/**
	 * @param isFalling Sets the object's falling status.
	 */
	public void setFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}
	/**
	 * @return width The object's width.
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * @param w Sets the object's width.
	 */
	public void setWidth(int w){
		this.width = w;
	}
	
	/**
	 * @return height The object's height.
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * @param h Sets the object's height.
	 */
	public void setHeight(int h){
		this.height = h;
	}

	/**
	 * @return xPos The object's x position.
	 */
	public int getXPos(){
		return this.xPos;
	}
	
	/**
	 * @param x Sets the object's x position.
	 */
	public void setXPos(int x){
		this.xPos = x;
	}
	
	/**
	 * @return yPos The object's y position.
	 */
	public int getYPos(){
		return this.yPos;
	}

	
	/**
	 * @param y Sets the object's y position.
	 */
	public void setYPos(int y){
		this.yPos = y;
	}
	
	/**
	 * @return xVel The object's x velocity.
	 */
	public int getxVel() {
		return xVel;
	}
	
	/**
	 * @param xVel Sets the object's x velocity.
	 */
	public void setxVel(int xVel){
		this.xVel = xVel;
	}

	/**
	 * @return yVel The object's y velocity.
	 */
	public int getyVel() {
		return yVel;
	}
	
	/**
	 * @param yVel Sets the object's y velocity.
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
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
	 * @return isFinal The  object's final status.
	 */
	public boolean isFinal() {
		return isFinal;
	}
	
	/**
	 * @param isFinal Sets the object's final status.
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
	 * @return range The range of the block.
	 */
	public RangeType getRange(){
		return this.range;
	}
	
	
	/**
	 * @return type The type of the object.
	 */
	public ObjectType getType(){
		return this.type;
	}
	
	/**
	 * @return gravity The current gravity value of the objects.
	 */
	public double getGravity() {
		return gravity;
	}

	/**
	 * @param gravity Sets the object's gravity.
	 */
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	/**
	 * @return status of gabions
	 */
	public boolean gabionsGone(){
		return gabionsGone;
	}
	
	/**
	 * @param gone If the gabions are gone.
	 */
	public void setGabionsGone(boolean gone){
		gabionsGone = gone;
	}

	/**
	 * Gets the bounds of the object. Used when determining collisions.
	 * @return Rectangle A rectangle containing the bounds of the object.
	 */
	public Rectangle getBounds() {
		return new Rectangle(this.getXPos(), this.getYPos(), width, height);
	}
	
	/**
	 * Gets the top bounds of the object. Used when determining collisions.
	 * @return Rectangle A rectangle containing the top bounds of the object.
	 */
	public Rectangle getTopBounds(){
		return new Rectangle(this.getXPos()+10,this.getYPos(), width-20, 5);
	}
	
	/**
	 * Gets the bottom bounds of the object. Used when determining collisions.
	 * @return Rectangle A rectangle containing the bottom bounds of the object.
	 */
	public Rectangle getBottomBounds(){
		return new Rectangle(this.getXPos()+10,this.getYPos()+height-5, width-20, 5);
	}
	
	/**
	 * Gets the left bounds of the object. Used when determining collisions.
	 * @return Rectangle A rectangle containing the left bounds of the object.
	 */
	public Rectangle getLeftBounds(){
		return new Rectangle(this.getXPos(),this.getYPos()+10, 5, height-20);
	}
	
	/**
	 * Gets the right bounds of the object. Used when determining collisions.
	 * @return Rectangle A rectangle containing the right bounds of the object.
	 */
	public Rectangle getRightBounds(){
		return new Rectangle(this.getXPos()+width-5,this.getYPos()+10, 5, height-20);
	}

	
	/**
	 * Attempts to load an image given a filename.
	 * @param file The filename to be loaded.
	 * @return img The image loaded from the file.
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
	
	/**
	 * Checks if the correct object was used.
	 * People get trashbags thrown at them to collect garbage.
	 * Chemicals get hay thrown at them to soak it up.
	 * Empty soil gets seeds thrown to grow plants.
	 * Dead soil gets compost thrown to improve it.
	 * Trash bins get trash/waste thrown into them.
	 * Recycle bins get recyclables thrown into them.
	 * Empty gabions get oysters thrown into them to fill them up.
	 * If the correct object is used, the obstacle is removed.
	 * A boolean is returned stating if the player used the correct object.
	 * @param t The type of the object used.
	 * @return useCorrect Whether or not the player used the proper item.
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
		case TrashBin:
 			if(t == ObjectType.Trash){
 				useCorrect = true;
 			}
 			else{
 				useCorrect = false;
 			}
 			break;
 		case RecycleBin:
 			if(t == ObjectType.Recycling){
 				useCorrect = true;
 			}
 			else{
 				useCorrect = false;
 			}
 			break;
 		case EmptyGabion:
 			if(t == ObjectType.Oyster){
 				useCorrect = true;
 				Game.gameControl.crabby.gabionCount--;
 			}
 			else{
 				useCorrect = false;
 			}
 			break;
		}
		return useCorrect;
	}
}
