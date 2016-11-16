package model;

import java.awt.Color;
import java.awt.Graphics;

import controller.GameController;
import game.Game;

public class Obstacle extends InteractiveObject{
	Color obsCol;
	public Obstacle(int x, int y, int width, int height, ObjectType t, GameController gamecontrol) {
		super(x, y, width, height, t, gamecontrol);
		switch(t){
		case People:
			this.obsCol = Color.black;
			break;
		case Chemicals: 
			this.obsCol = Color.yellow;
			break;
		case EmptySoil:
			this.obsCol = Color.green;
			break;
		case DeadSoil:
			this.obsCol = Color.red;
			break;
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(obsCol);
		g.fillRect(this.xPos, this.yPos, width, height);
	}

	@Override
	public void update() {
		this.xPos -= 1;
		//this.yPos+=this.yVel;
		this.yPos=0;
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
		if(isFalling){
			if(this.yPos >= 750){
				this.isGone = true;
			}
			gravity+=0.1;
			this.setyVel((int)gravity);
		}
		if(isGone){
			this.setyVel(0);
			gamecontrol.removeObject(this);
			gamecontrol.sendNext = true;
		}
		
	}
}