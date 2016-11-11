package model;

import java.awt.Color;
import java.awt.Graphics;

import controller.GameController;
import game.Game;

public class Obstacle extends InteractiveObject{
	Color obsCol;
	public Obstacle(int x, int y, int width, int height, ObjectType t, GameController gc) {
		super(x, y, width, height, t, gc);
		this.xVel = -1;
		switch(t){
			case Person:
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
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(obsCol);
		g.fillRect(this.xPos, this.yPos, 80, 80);
	}

	@Override
	public void update() {
		this.xPos += this.xVel;
		this.yPos += this.yVel;
	
		//Screen-left bound
			if(this.xPos <= -60){
				this.isGone = true;
			}

		if(this.xPos + this.width >= Game.WIDTH*Game.SCALE){
			this.xPos = Game.WIDTH*Game.SCALE - this.width;
		}
		//	Screen-bottom bound
		//	if(this.yPos + this.height >= 750){
		//		this.yPos = 750 - this.height;
		//	}
		for(int i = 0; i < gamecontrol.blocks.size(); i++){
			Block b = gamecontrol.blocks.get(i);
			//			if(this.getTopBounds().intersects(b.getBounds())){
			//				this.setyVel(0);
			//				if(isJumping){
			//					isJumping = false;
			//					gravity=0.8;
			//					isFalling = true;
			//				}
			//			}
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
					this.setxVel(-2);
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
			this.setyVel(0);
			gamecontrol.removeEntity(this);
			gamecontrol.sendNext = true;
		}
	
	}

}
