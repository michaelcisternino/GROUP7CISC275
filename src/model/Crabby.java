package model;

import java.awt.Color;
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
//		g.setColor(Color.RED);	
//		g.fillOval((int)this.getXPos(), (int)this.getYPos(), width, height);
		g.drawImage(character, (int)this.getXPos(), (int)this.getYPos(), width, height, null);
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
		if(this.getLives() == 0){
			System.out.println("dead");
			//game stop
			System.exit(0);
		}
		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
		//Screen-left bound
		if(this.xPos <= Game.WIDTH){
			this.xPos = Game.WIDTH + 1;
			Game.gameControl.goingLeft = true;
		}
		//Screen-right bound
		if(this.xPos + this.width >= Game.WIDTH*3){
			this.xPos = Game.WIDTH*3 - this.width - 1;
			Game.gameControl.goingRight = true;
		}
//		//Screen-bottom bound
//		if(this.yPos + this.height >= 750){
//			this.yPos = 750 - this.height;
//		}
		for(int i = 0; i < gamecontrol.blocks.size(); i++){
			Block b = gamecontrol.blocks.get(i);
			if(this.getTopBounds().intersects(b.getBounds())){
				this.setyVel(0);
				if(isJumping){
					isJumping = false;
					gravity=0.8;
					isFalling = true;
				}
			}
			if(this.getBottomBounds().intersects(b.getBounds())){
				this.setyVel(0);
				this.setYPos(b.getYPos()-64);
				if(isFalling) {
					isFalling = false;
					}
			}else if (!isFalling&&!isJumping){
					isFalling = true;
					gravity = 0.8;
			}
			if(this.getLeftBounds().intersects(b.getBounds())){
				this.setxVel(0);
				this.xPos = b.getXPos() + this.width;
			}
			if(this.getRightBounds().intersects(b.getBounds())){
				this.setxVel(0);
				this.xPos = b.getXPos() - this.width;
			}
		}
		for(int i = 0; i < gamecontrol.entities.size(); i++){
			InteractiveObject c = gamecontrol.entities.get(i);
			if(this.getBottomBounds().intersects(c.getBounds()) || this.getLeftBounds().intersects(c.getBounds()) || this.getRightBounds().intersects(c.getBounds())){
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
		if(isJumping){
			gravity-=0.1;
			this.setyVel((int)-gravity);
			if(gravity<=0.0){
				isJumping = false;
				isFalling = true;
			}
		}
		if(isFalling){
			if(this.yPos >= 750){
				this.isGone = true;
			}
			gravity+=0.1;
			this.setyVel((int)gravity);
		}
		if(isGone){
			this.yPos = 0;
			this.isFalling = true;
			this.die();
			this.isGone = false;
		}
		if(isRising){
			this.setyVel(-5);
			if(this.yPos <= 200){
				this.isRising = false;
			}
	}
	}
}