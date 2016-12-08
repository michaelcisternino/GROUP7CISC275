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
 * Abstract class for characters.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public abstract class Character implements java.io.Serializable {

	private int xPos, yPos;
	private int  xVel, yVel;
	
	private int lives = 5;

	private int width, height;
	
	private ObjectType type;
	
	private double gravity = 0.0;
	private int gabionCount = 4;
	
	private boolean isJumping = false;
	private boolean isFalling = true;
	private boolean isGone = false;
	private boolean isRising = false;
	private boolean isSwimUp = false;
	private boolean isSwimDown = false;
	private boolean caught = false;
	private boolean gabionsGone;
	public boolean isdone = false;
	
	public GameController gamecontrol;
	
	String file;
	transient BufferedImage character;
	
	/**
	 * Constructor for character.
	 * @param x The character's x position.
	 * @param y The character's y position.
	 * @param width The width of the character.
	 * @param height The height of the character.
	 * @param t The type of the character.
	 * @param gamecontrol The game controller.
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
	
	/**
	 * Updates the character's position based on the current x and y velocities.
	 */
	public void move(){
		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
	}
	
	/**
	 * Updates the character's position based on yVel and a given xPos offset.
	 */
	public void swim(){
		this.xPos+=1;
		this.yPos+=this.yVel;
	}
	
	/**
	 * Updates the character's y velocity based on gravity.
	 */
	public void swimUp(){
		this.gravity -= 0.1;
		this.yVel = -(int)this.gravity;
	}
	
	/**
	 * Updates the character's y velocity based on gravity.
	 */
	public void swimDown(){
		this.gravity += 0.1;
		this.yVel = (int)this.gravity;
	}
	
	/**
	 * Updates the character's current gravity level and then updates the current y velocity to make the character rise.
	 */
	public void jump(){
		this.gravity -= 0.1;
		this.yVel = -(int)this.gravity;
	}
	
	/**
	 * Updates the character's current gravity level and then updates the current y velocity to make the character fall.
	 */
	public void fall(){
		this.gravity += 0.1;
		this.yVel = (int)this.gravity;
	}
	
	/**
	 * When called, sets the character's y velocity to -5 so it will rise.
	 */
	public void rise(){
		this.yVel = -5;
	}
	
	/**
	 * If the character dies, it loses a life. The correct level will then be reset.
	 */
	public void die(){
		this.lives--;

		switch (Game.getLevel()){
			case 1:
				LevelOne resetOne = new LevelOne();
				resetOne.fillBlocks();
				resetOne.fillObjects();
				resetOne.fillObstacles();
				this.yPos = 512;
				this.xPos = 300;
				Game.gameControl.crabby.oysterCnt = 0;
				Game.gameControl.crabby.gabionCount = 5;
				Game.gameControl.entities = resetOne.getObjects();
				Game.gameControl.blocks = resetOne.getBlocks();
				Game.gameControl.crabby.setCaught(false);
				Game.gameControl.crabby.setSwimDown(true);
				break;
			case 2:
				LevelTwo resetTwo = new LevelTwo();
				resetTwo.fillBlocks();
				resetTwo.fillObjects();
				resetTwo.fillObstacles();
				this.yPos = 512;
				this.xPos = 800;
				Game.gameControl.crabby.trashBagCnt = 0;
				Game.gameControl.crabby.trashCnt = 0;
				Game.gameControl.crabby.recycleCnt = 0;
				Game.gameControl.entities = resetTwo.getObjects();
				Game.gameControl.blocks = resetTwo.getBlocks();
				break;
			case 3:
				LevelThree resetThree = new LevelThree();
				resetThree.fillBlocks();
				resetThree.fillObjects();
				resetThree.fillObstacles();
				Game.gameControl.crabby.hayCnt = 0;
				Game.gameControl.crabby.seedCnt = 0;
				Game.gameControl.crabby.compCnt = 0;
				Game.gameControl.entities = resetThree.getObjects();
				Game.gameControl.blocks = resetThree.getBlocks();
				this.yPos = 512;
				this.xPos = 300;
				break;
		}
	}
	
	/**
	 * Removes this character from the game controller's list of entities.
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
	
	/**
	 * @return lives The number of lives the character has.
	 */
	public int getLives(){
		return lives;
	}
	
	/**
	 * @param l The number of lives the character has.
	 */
	public void setLives(int l){
		this.lives = l;
	}
	
	/**
	 * @return isJumping The character's swimming up status.
	 */
	public boolean isSwimUp() {
		return isSwimUp;
	}
	
	/**
	 * @param isJumping Sets the character's swimming up status.
	 */
	public void setSwimUp(boolean isSwimUp) {
		this.isSwimUp = isSwimUp;
	}
	
	/**
	 * @return isJumping The character's swimming down status.
	 */
	public boolean isSwimDown() {
		return isSwimDown;
	}
	
	/**
	 * @param isJumping Sets the character's swimming up status.
	 */
	public void setSwimDown(boolean isSwimDown) {
		this.isSwimDown = isSwimDown;
	}
	
	/**
	 * @return isJumping The character's jumping status.
	 */
	public boolean isJumping() {
		return isJumping;
	}
	
	/**
	 * @param isJumping Sets the character's jumping status.
	 */
	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	/**
	 * @return isFalling The character's falling status.
	 */
	public boolean isFalling() {
		return isFalling;
	}

	/**
	 * @param isFalling Sets the character's falling status.
	 */
	public void setFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}

	/**
	 * @return isGone If the character is off-screen.
	 */
	public boolean isGone() {
		return isGone;
	}

	/**
	 * @param isGone Sets the character's gone status.
	 */
	public void setGone(boolean isGone) {
		this.isGone = isGone;
	}

	/**
	 * @return isRising The character's rising status.
	 */
	public boolean isRising() {
		return isRising;
	}

	/**
	 * @param isRising Sets the character's rising status.
	 */
	public void setRising(boolean isRising) {
		this.isRising = isRising;
	}
	
	/**
	 * @return width The character's width.
	 */
	public int getWidth(){
		return this.width;
	}
	
	/**
	 * @param w Sets the character's width.
	 */
	public void setWidth(int w){
		this.width = w;
	}
	
	/**
	 * @return height The character's height.
	 */
	public int getHeight(){
		return this.height;
	}
	
	/**
	 * @param h Sets the character's height.
	 */
	public void setHeight(int h){
		this.height = h;
	}

	/**
	 * @return xPos The character's x position.
	 */
	public int getXPos(){
		return this.xPos;
	}
	
	/**
	 * @param x Sets the character's x position.
	 */
	public void setXPos(int x){
		this.xPos = x;
	}
	
	/**
	 * @return yPos The character's y position.
	 */
	public int getYPos(){
		return this.yPos;
	}

	
	/**
	 * @param y Sets the character's y position.
	 */
	public void setYPos(int y){
		this.yPos = y;
	}
	
	/**
	 * @return xVel The character's x velocity.
	 */
	public int getxVel() {
		return xVel;
	}
	
	/**
	 * @param xVel Sets the character's x velocity.
	 */
	public void setxVel(int xVel){
		this.xVel = xVel;
	}

	/**
	 * @return yVel The character's y velocity.
	 */
	public int getyVel() {
		return yVel;
	}
	
	/**
	 * @param yVel Sets the character's y velocity.
	 */
	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	
	/**
	 * @return type The type of the object.
	 */
	public ObjectType getType(){
		return this.type;
	}
	
	/**
	 * @return gravity The current gravity value of the character.
	 */
	public double getGravity() {
		return gravity;
	}

	/**
	 * @param gravity Sets the character's gravity.
	 */
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	/**
	 * @param caught Sets the character's caught status.
	 */
	public void setCaught(boolean caught){
		this.caught = caught;
	}
	
	/**
	 * @return The character's caught status.
	 */
	public boolean isCaught(){
		return this.caught;
	}
	
	/**
	 * @param Sets the gabion gone status.
	 */
	public void setGabionsGone(boolean gone){
		this.gabionsGone = gone;
	}
	
	/**
	 * @return gabionsGone If the gabions are gone. 
	 */
	public boolean getGabionsGone(){
		return this.gabionsGone;
	}
	
	/**
	 * @return gabionCount Number of gabions.
	 */
	public int getGabions(){
		return gabionCount;
	}
	
	/**
	 * Decrements gabion count by 1.
	 */
	public void removeGabion(){
		this.gabionCount--;
	}
	
	/**
	 * @return isdone If the player is done.
	 */
	public boolean isDone(){
		return this.isdone;
	}
	
	/**
	 * @param done Sets the done status.
	 */
	public void isDone(boolean done){
		this.isdone = done;
	}
	
	/**
	 * Gets the bounds of the character. Used when determining collisions.
	 * @return Rectangle A rectangle containing the bounds of the character.
	 */
	public Rectangle getBounds() {
		return new Rectangle(this.getXPos(), this.getYPos(), width, height);
	}
	
	/**
	 * Gets the top bounds of the character. Used when determining collisions.
	 * @return Rectangle A rectangle containing the top bounds of the character.
	 */
	public Rectangle getTopBounds(){
		return new Rectangle(this.getXPos()+10,this.getYPos(), width-20, 5);
	}
	
	/**
	 * Gets the bottom bounds of the character. Used when determining collisions.
	 * @return Rectangle A rectangle containing the bottom bounds of the character.
	 */
	public Rectangle getBottomBounds(){
		return new Rectangle(this.getXPos()+10,this.getYPos()+height-5, width-20, 5);
	}
	
	/**
	 * Gets the left bounds of the character. Used when determining collisions.
	 * @return Rectangle A rectangle containing the left bounds of the character.
	 */
	public Rectangle getLeftBounds(){
		return new Rectangle(this.getXPos(),this.getYPos()+10, 5, height-20);
	}
	
	/**
	 * Gets the right bounds of the character. Used when determining collisions.
	 * @return Rectangle A rectangle containing the right bounds of the character.
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

}
