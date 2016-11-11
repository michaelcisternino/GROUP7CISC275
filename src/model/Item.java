package model;

import java.awt.Color;
import java.awt.Graphics;

import controller.GameController;
import game.Game;

public class Item extends InteractiveObject{
	public Color itemCol;
	public Item(int x, int y, int width, int height, ObjectType t, GameController gamecontrol) {
		super(x, y, width, height, t, gamecontrol);
		switch(t){
		case TrashBag:
			this.itemCol = Color.black;
			break;
		case Hay:
			this.itemCol = Color.yellow;
			break;
		case Compost:
			this.itemCol = Color.red;
			break;
		case Seeds:
			this.itemCol = Color.green;
			break;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(this.itemCol);
		g.fillOval(this.xPos, this.yPos, width, height);
	}

	@Override
	public void update() {
		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
		//Screen-left bound
//		if(this.xPos <= 0){
//			this.xPos = 250*4;
//		}
		//Screen-right bound
		if(this.xPos + this.width >= Game.WIDTH*Game.SCALE){
			this.xPos = Game.WIDTH*Game.SCALE - this.width;
		}
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
					this.setxVel(b.getxVel());
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
					this.setxVel(-2);
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
		if(isFalling){
			if(this.yPos >= 750){
				this.isGone = true;
			}
			gravity+=0.1;
			this.setyVel((int)gravity);
		}
		if(isGone){
			this.setyVel(0);
			gamecontrol.removeEntity(this);
			gamecontrol.sendNext = true;
		}
		
	}

}
