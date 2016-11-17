package model;

import java.awt.Color;
import java.awt.Graphics;

import controller.GameController;
import game.Game;

public class Item extends InteractiveObject{
	public boolean isThrown = false;
	//Color itemCol;
	public Item(int x, int y, int width, int height, ObjectType t, GameController gamecontrol) {
		super(x, y, width, height, t, gamecontrol);
		switch(t){
			case TrashBag:
				file = "Final Images/Objects/trashbag.png";
				item = createImage(file);
				break;
			case Hay:
				file = "Final Images/Objects/hay.png";
				item = createImage(file);
				break;
			case Compost:
				file = "Final Images/Objects/compost.png";
				item = createImage(file);
				break;
			case Seeds:
				file = "Final Images/Plants/seed.png";
				item = createImage(file);
				break;
			case Oyster:
				file = "Final Images/Animals/clam_left_2.png";
				item = createImage(file);
				break;
				
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
//		g.setColor(itemCol);
//		g.fillOval(this.xPos, this.yPos, width, height);
		g.drawImage(item, this.xPos, this.yPos, width, height, null);
	}

	@Override
	public void update() {
		if(!isThrown){
			this.yPos += this.yVel;
			if (Game.gameControl.goingRight == true){
				this.xPos -= 5;
			}
			else if (Game.gameControl.goingLeft == true){
				this.xPos += 5;
			}
		}
		if(isThrown){
			this.xPos += 7;
			for(int i = 0; i < gamecontrol.entities.size(); i++){
				InteractiveObject c = gamecontrol.entities.get(i);
				if(this.getBottomBounds().intersects(c.getBounds()) || this.getLeftBounds().intersects(c.getBounds()) || this.getRightBounds().intersects(c.getBounds())){
					if(c.checkItem(type)){
						gamecontrol.removeObject(c);
					};
					gamecontrol.removeItem(this); 
					isThrown = false;
				}
			}
		}
			//Screen-left bound
	//		if(this.xPos <= 0){
	//			this.xPos = 250*4;
	//		}
			//Screen-right bound
//		if(this.xPos + this.width >= Game.WIDTH*Game.SCALE){
//			this.xPos = Game.WIDTH*Game.SCALE - this.width;
//		}
//		//Screen-bottom bound
//		if(this.yPos + this.height >= 750){
//			this.yPos = 750 - this.height;
//		}
		for(int i = 0; i < gamecontrol.blocks.size(); i++){
			Block b = gamecontrol.blocks.get(i);
//				if(this.getTopBounds().intersects(b.getBounds())){
//					this.setyVel(0);
//					if(isJumping){
//						isJumping = false;
//						gravity=0.8;
//						isFalling = true;
//					}
//				}
				if(this.getBottomBounds().intersects(b.getBounds())){
					this.setyVel(0);
					if(isFalling) {
						isFalling = false;
						}
				}
				else if (!isFalling&&!isJumping){
						isFalling = true;
						gravity = 0.8;
				}
				if(this.getLeftBounds().intersects(b.getBounds())){
					this.setxVel(2);
				}
				if(this.getRightBounds().intersects(b.getBounds())){
					this.setxVel(-6);
					//this.xPos = b.getXPos() - b.width;
				}
		}
//		if(isJumping){
//			gravity-=0.1;
//			this.setyVel((int)-gravity);
//			if(gravity<=0.0){
//				isJumping = false;
//				isFalling = true;
//			}
//		}
//		if(this.xPos <= 0){
//			this.isGone = true;
		//}
		if(isFalling){
			if(this.yPos >= 750){
				this.setyVel(0);
			}
			gravity+=0.1;
			this.setyVel((int)gravity);
		}
//		if(isGone){
//			this.setyVel(0);
//			gamecontrol.removeObject(this);
//			gamecontrol.sendNext = true;
//		}
		//this.yPos+=this.yVel;
		
	}

}
