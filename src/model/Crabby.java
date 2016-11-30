package model;

import java.awt.Graphics;
import java.util.LinkedList;

import controller.GameController;
import game.Game;
/**
 * Our main character, the Crabby. Crabby is a character.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class Crabby extends Character{
	
	public int trashBagCnt, hayCnt, seedCnt, compCnt, oysterCnt;
	public LinkedList<InteractiveObject> items = new LinkedList<InteractiveObject>();

	/**
	 * Constructor for crabby. The image file containing the crab is defined in here.
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param t
	 * @param gamecontrol
	 */
	public Crabby(int x, int y, int width, int height, ObjectType t, GameController gamecontrol) {
		super(x, y, width, height, t, gamecontrol);
		file = "Final Images/Animals/bluecrab_0.png";
		character = createImage(file);
	}

	/**
	 * Draws the image of the crab based on the parameters.
	 */
	@Override
	public void draw(Graphics g) {
		g.drawImage(character, this.getXPos(), this.getYPos(), getWidth(), getHeight(), null);
	}

	/**
	 * Updates the character based on the controller.
	 * If the character has 0 lives, it is dead and the game exits.
	 * If the character reaches the bounds of the panel, the controller is set so the view appears to be moving.
	 * If the character lands on a block, it is no longer falling and y velocity is set to 0.
	 * If the character is not on a platform and not jumping, it is falling.
	 * If the character intersects a block, the character's position is updated based on the block's position.
	 * If the character contacts an item, the item is collected and the counter is incremented.
	 * If the character contacts an obstacle, the lives counter is decremented and it is checked if the character is dead.
	 * If the character is jumping, the current gravity is subtracted from the current y velocity.
	 * If the character is falling, the current gravity is added to the current y velocity.
	 * If the character falls off the screen, the lives counter is decremented and the character respawns at the top.
	 * If the character is on the final platform, it will rise with the platform up to a certain height.
	 */
	@Override
	public void update() {
		if(getLives() == 0){
			System.out.println("dead");
			//game stop
			System.exit(0);
		}
		move();
		//Screen-left bound
		if(getXPos() <= Game.WIDTH){
			setXPos(Game.WIDTH + 1);
			Game.gameControl.goingLeft = true;
		}
		//Screen-right bound
		if(getXPos() + getWidth() >= Game.WIDTH*3){
			setXPos(Game.WIDTH*3 - getWidth() - 1);
			Game.gameControl.goingRight = true;
		}
		for(int i = 0; i < gamecontrol.blocks.size(); i++){
			Block b = gamecontrol.blocks.get(i);
			if(getTopBounds().intersects(b.getBounds())){
				setyVel(0);
				if(isJumping()){
					setJumping(false);
					setGravity(0.8);
					setFalling(true);
				}
			}
			if(getBottomBounds().intersects(b.getBounds())){
				setyVel(0);
				setYPos(b.getYPos()-64);
				if(isFalling()) {
					setFalling(false);
					}
			}else if (!isFalling()&&!isJumping()){
					setFalling(true);
					setGravity(0.8);
			}
			if(getLeftBounds().intersects(b.getBounds())){
				setxVel(0);
				setXPos(b.getXPos() + getWidth());
			}
			if(getRightBounds().intersects(b.getBounds())){
				setxVel(0);
				setXPos(b.getXPos() - getWidth());
			}
		}
		for(int i = 0; i < gamecontrol.entities.size(); i++){
			InteractiveObject c = gamecontrol.entities.get(i);
			if(getBottomBounds().intersects(c.getBounds()) || getLeftBounds().intersects(c.getBounds()) || getRightBounds().intersects(c.getBounds())){
				switch(c.type){
				case TrashBag:
					trashBagCnt ++;
					gamecontrol.useTrashb = true;
					break;
				case Hay:
					hayCnt ++;
					gamecontrol.useHay = true;
					break;
				case Seeds:
					seedCnt ++;
					gamecontrol.useSeeds = true;
					break;
				case Compost:
					compCnt ++;
					gamecontrol.useComp = true;
					break;
				case Oyster:
					oysterCnt ++;
					gamecontrol.useOyster = true;
					break;
				case People:
				case Chemicals:	
				case EmptySoil:
				case DeadSoil:
					System.out.println(this.getLives());
					this.die();
					break;
				}
				gamecontrol.removeObject(c);
				gamecontrol.sendNext = true;
				System.out.println("trashbag: " + trashBagCnt + ", hay: " + hayCnt + ", seeds: " + seedCnt + ", compost: " + compCnt);
			}
		}
		if(isJumping()){
			jump();
			if(getGravity()<=0.0){
				setJumping(false);
				setFalling(true);
			}
		}
		if(isFalling()){
			if(getYPos() >= 750){
				setGone(true);
			}
			fall();
		}
		if(isGone()){
			setYPos(0);
			setFalling(true);
			die();
			setGone(false);
		}
		if(isRising()){
			rise();
			if(getYPos() <= 200){
				setRising(false);
			}
	}
	}
}