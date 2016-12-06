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

	private int xPos, yPos;
	private int  xVel, yVel;
	
	private int lives = 5;

	private int width, height;
	
	private ObjectType type;
	
	private double gravity = 0.0;
	
	private boolean isJumping = false;
	private boolean isFalling = true;
	private boolean isGone = false;
	private boolean isRising = false;
	private boolean isSwimUp = false;
	private boolean isSwimDown = false;
	
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
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	public void move(){
		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
	}
	
	public void swim(){
		this.xPos+=1;
		this.yPos+=this.yVel;
	}
	
	public void swimUp(){
		this.gravity -= 0.1;
		this.yVel = -(int)this.gravity;
	}
	
	public void swimDown(){
		this.gravity += 0.1;
		this.yVel = (int)this.gravity;
	}
	
	public void jump(){
		this.gravity -= 0.1;
		this.yVel = -(int)this.gravity;
	}
	
	public void fall(){
		this.gravity += 0.1;
		this.yVel = (int)this.gravity;
	}
	
	public void rise(){
		this.yVel = -5;
	}
	
	/**
	 * If the character dies, it loses a life.
	 */
	public void die(){
		this.lives--;
	}
	
	/**
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
	
	/**
	 * Sets the number of lives the character has.
	 * @param l
	 */
	public void setLives(int l){
		this.lives = l;
	}
	
	/**
	 * Gets the character's jumping status
	 * @return isJumping
	 */
	public boolean isSwimUp() {
		return isSwimUp;
	}
	
	/**
	 * Set's the character's jumping status
	 * @param isJumping
	 */
	public void setSwimUp(boolean isSwimUp) {
		this.isSwimUp = isSwimUp;
	}
	
	/**
	 * Gets the character's jumping status
	 * @return isJumping
	 */
	public boolean isSwimDown() {
		return isSwimDown;
	}
	
	/**
	 * Set's the character's jumping status
	 * @param isJumping
	 */
	public void setSwimDown(boolean isSwimDown) {
		this.isSwimDown = isSwimDown;
	}
	
	/**
	 * Gets the character's jumping status
	 * @return isJumping
	 */
	public boolean isJumping() {
		return isJumping;
	}
	
	/**
	 * Set's the character's jumping status
	 * @param isJumping
	 */
	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	/**
	 * Gets the character's falling status
	 * @return isFalling
	 */
	public boolean isFalling() {
		return isFalling;
	}

	/**
	 * Set's the character's falling status
	 * @param isFalling
	 */
	public void setFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}

	/**
	 * Returns true if character is off screen, false if not
	 * @return isGone
	 */
	public boolean isGone() {
		return isGone;
	}

	/**
	 * Set's the character's gone status
	 * @param isGone
	 */
	public void setGone(boolean isGone) {
		this.isGone = isGone;
	}

	/**
	 * Gets the character's rising status
	 * @return isRising
	 */
	public boolean isRising() {
		return isRising;
	}

	/**
	 * Set's the character's rising status
	 * @param isRising
	 */
	public void setRising(boolean isRising) {
		this.isRising = isRising;
	}
	
	/**
	 * Gets the character's width
	 * @return width
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * Set's the character's width
	 * @param w
	 */
	public void setWidth(int w){
		this.width = w;
	}
	
	/**
	 * Gets the character's rising status
	 * @return height
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * Set's the character's height
	 * @param h
	 */
	public void setHeight(int h){
		this.height = h;
	}

	/**
	 * Gets the character's x position.
	 * @return xPos
	 */
	public int getXPos(){
		return this.xPos;
	}
	
	/**
	 * Set's the character's x position.
	 * @param x
	 */
	public void setXPos(int x){
		this.xPos = x;
	}
	
	/**
	 * Gets the character's y position.
	 * @return yPos
	 */
	public int getYPos(){
		return this.yPos;
	}
	
	/**
	 * Set's the character's y position.
	 * @param y
	 */
	public void setYPos(int y){
		this.yPos = y;
	}
	
	/**
	 * Gets the character's x velocity.
	 * @return xVel
	 */
	public int getxVel() {
		return xVel;
	}
	
	/**
	 * Sets the character's x velocity.
	 * @param xVel
	 */
	public void setxVel(int xVel){
		this.xVel = xVel;
	}

	/**
	 * Gets the character's y velocity.
	 * @return yVel
	 */
	public int getyVel() {
		return yVel;
	}

	/**
	 * Sets the character's y velocity.
	 * @param yVel
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	
	/**
	 * Gets the type of the objects.
	 * @return this.type
	 */
	public ObjectType getType(){
		return this.type;
	}
	
	/**
	 * Gets the current gravity value of the objects.
	 * @return this.gravity
	 */
	public double getGravity() {
		return gravity;
	}

	/**
	 * Sets the character's gravity
	 * @param gravity
	 */
	public void setGravity(double gravity) {
		this.gravity = gravity;
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
