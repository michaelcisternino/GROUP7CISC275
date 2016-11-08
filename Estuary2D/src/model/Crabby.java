package model;

import java.awt.Color;
import java.awt.Graphics;

import controller.GameController;
import game.Game;

public class Crabby extends Character{

	public Crabby(double x, double y, int width, int height, boolean solid, ObjectType t, GameController gamecontrol) {
		super(x, y, width, height, solid, t, gamecontrol);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);	
		g.fillOval((int)this.getXPos(), (int)this.getYPos(), width, height);
	}

	@Override
	public void update() {
		this.xPos+=this.xVel;
		this.yPos+=this.yVel;
		//Screen-left bound
		if(this.xPos <= 0){
			this.xPos = 0;
		}
		//Screen-right bound
		if(this.xPos + this.width >= Game.WIDTH*Game.SCALE){
			this.xPos = Game.WIDTH*Game.SCALE - this.width;
		}
//		//Screen-bottom bound
//		if(this.yPos + this.height >= 750){
//			this.yPos = 750 - this.height;
//		}
		for(Block b: gamecontrol.blocks){
			if(!b.isSolid()){
				break;
			}
			switch(b.getType()){
			case Wall:
				if(this.getTopBounds().intersects(b.getBounds())){
					this.setyVel(0);
					if(isJumping){
						isJumping = false;
						gravity=0.0;
						isFalling = true;
					}
				}
				if(this.getBottomBounds().intersects(b.getBounds())){
					this.setyVel(0);
					if(isFalling){
						isFalling = false;
					}
				}
				if(!this.getBottomBounds().intersects(b.getBounds()) && !isFalling && !isJumping){
					gravity = 0.0;
					isFalling = true;
				}
				if(this.getLeftBounds().intersects(b.getBounds())){
					this.setxVel(0);
					this.xPos = b.getXPos() + b.width;
				}
				if(this.getRightBounds().intersects(b.getBounds())){
					this.setxVel(0);
					this.xPos = b.getXPos() - b.width;
				}
				break;
			}
		}
		if(isJumping){
			gravity-=0.1;
			this.setyVel(-gravity);
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
			this.setyVel(gravity);
		}
		if(isGone){
			this.setyVel(0);
		}
	}
	
}
