package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import controller.GameController;
import game.Game;
/**
 * Our main character, the Crabby. Crabby is a character.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 */
public class Crabby extends Character{
	
    public boolean pkh;    // player key handler check (for movement)
    
    public final int frameCount = 3;
    public int picNum = 0;
    BufferedImage[] pics;
    public int imgWidth = 130;
    public int imgHeight = 64;
	
	public int trashBagCnt, hayCnt, seedCnt, compCnt, oysterCnt, trashCnt, recycleCnt;
	public boolean caught;
	public int gabionCount = 5;
	public LinkedList<InteractiveObject> items = new LinkedList<InteractiveObject>();

	/**
	 * Constructor for crabby. The image file containing the crab is defined in here.
	 * @param x The character's x position.
	 * @param y The character's y position.
	 * @param width The width of the character.
	 * @param height The height of the character.
	 * @param t The type of the character.
	 * @param gamecontrol The game controller.
	 */
	public Crabby(int x, int y, int width, int height, ObjectType t, GameController gamecontrol) {
		super(x, y, width, height, t, gamecontrol);
		file = "Final Images/Animals/bluecrab_0.png";
		character = createImage(file);
		
	    BufferedImage[] img = createImage();
	    pics = new BufferedImage[3];
	    for (int j = 0; j < frameCount; j++){
	        pics[j] = img[0].getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
	    }
	}

	/**
	 * Draws the image of the crab based on the parameters.
	 * @param g The graphics to be drawn on.
	 */
	@Override
	public void draw(Graphics g) {
//		g.drawImage(character, this.getXPos(), this.getYPos(), getWidth(), getHeight(), null);
	    if (getxVel() != 0){
	        picNum = (picNum+1) % frameCount;
	    }
	    g.drawImage(pics[picNum], this.getXPos(), this.getYPos(), null, null);
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
		}
		move();
		if(Game.getLevel() == 1&&!isDone()){
			Game.gameControl.goingRight = true;
			setFalling(false);
		}
		if(gabionCount <= 0){
			Game.setLevel(6);
		}
		if(isCaught()){
			setxVel(0);
			setSwimDown(false);
			setSwimUp(false);
			setyVel(-5);
		}
		if(getYPos() <= -100 && Game.getLevel() == 1){
			die();
		}
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
			Rectangle bbounds;
			if(b.getType() == ObjectType.Net){
				bbounds = b.getNetBounds();
			}
			else{
				bbounds = b.getBounds();
			}
			if(getTopBounds().intersects(bbounds)){
				if(b.getType() == ObjectType.Net){
					break;
				}
				setyVel(0);
				if(isJumping()){
					setJumping(false);
					setGravity(0.8);
					setFalling(true);
				}
			}
			if(getBottomBounds().intersects(bbounds)){
				if(b.getType() == ObjectType.Net){
					break;
				}
				//setyVel(b.getyVel());
				if(b.isHor()){
				setxVel(b.getxVel());
				}
//				setyVel(0);
				setYPos(b.getYPos()-64);
			    if (b.isHor() ==true && pkh == false){
			        this.setxVel((int) (3*Math.cos(Math.PI*(b.ticks)/120)));
			    }
				if(isFalling()) {
					setFalling(false);
					}
			}else if (!isFalling()&&!isJumping()&&Game.getLevel()!=1){
					setFalling(true);
					setGravity(0.8);
			}
			if(getLeftBounds().intersects(bbounds)){
				if(b.getType() == ObjectType.Net){
					break;
				}
				setxVel(0);
				setXPos(b.getXPos() + b.getWidth());
			}
			if(getRightBounds().intersects(bbounds)){
				if(b.getType() == ObjectType.Net){
					setCaught(true);
				}
				setxVel(0);
				setXPos(b.getXPos() - getWidth());
			}
		}
		for(int i = 0; i < gamecontrol.entities.size(); i++){
			InteractiveObject c = gamecontrol.entities.get(i);
			if(getBottomBounds().intersects(c.getBounds()) || getLeftBounds().intersects(c.getBounds()) || getRightBounds().intersects(c.getBounds())){
				switch(c.getType()){
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
				case Trash:
 					trashCnt ++;
 					gamecontrol.useTrash = true;
 					break;
 				case Recycling:
 					recycleCnt ++;
 					gamecontrol.useRecycling = true;
 					break;
				case People:
				case Chemicals:	
				case EmptySoil:
				case DeadSoil:
				case TrashBin:
				case RecycleBin:
					System.out.println(this.getLives());
					this.die();
					break;
				}
				gamecontrol.removeObject(c);
				gamecontrol.sendNext = true;
//				System.out.println("trashbag: " + trashBagCnt + ", hay: " + hayCnt + ", seeds: " + seedCnt + ", compost: " + compCnt);
			}
		}
		if(isJumping()){
			jump();
			if(getGravity()<=0.0){
				setJumping(false);
				setFalling(true);
			}
		}
		if(isSwimUp()){
			swimUp();
			if(getGravity() <= 0.0){
				setSwimDown(true);
				setSwimUp(false);
			}
		}
		if(isSwimDown()){
			swimDown();
			if(getGravity() >= 3){
				setSwimDown(false);
			}
		}
		if(isFalling()){
			if(getYPos() >= 1500){
				setGone(true);
			}
			fall();
		}
		if(isGone()){
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

	private BufferedImage[] createImage(){
	    BufferedImage[] bufferedImage = new BufferedImage[1];
	        try {
	            bufferedImage[0] = ImageIO.read(new File("Final Images/Animals/bluecrab_animated4.png"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return bufferedImage;
	    }

}
