package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import controller.GameController;
import game.Game;

public class Crabby extends Character{
	
	private int trashcount = 0;
	public int trashBagCnt, hayCnt, seedCnt, compCnt;
	public LinkedList<Item> items = new LinkedList<Item>();

	public Crabby(int x, int y, int width, int height, ObjectType t, GameController gamecontrol) {
		super(x, y, width, height, t, gamecontrol);
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
					if(isFalling) {
						isFalling = false;
						}
				}else if (!isFalling&&!isJumping){
						isFalling = true;
						gravity = 0.8;
				}
				if(this.getLeftBounds().intersects(b.getBounds())){
					this.setxVel(0);
					this.xPos = b.getXPos() + b.width;
				}
				if(this.getRightBounds().intersects(b.getBounds())){
					this.setxVel(0);
					this.xPos = b.getXPos() - b.width;
				}
			}
		for(int i = 0; i < gamecontrol.items.size(); i++){
			Item c = gamecontrol.items.get(i);
			if(this.getBottomBounds().intersects(c.getBounds()) || this.getLeftBounds().intersects(c.getBounds()) || this.getRightBounds().intersects(c.getBounds())){
				items.add(c);
				if(c.type == ObjectType.TrashBag){
					trashBagCnt ++;
				}
				else if(c.type == ObjectType.Hay){
					hayCnt ++;
				}
				else if(c.type == ObjectType.Seeds){
					seedCnt ++;
				}
				else{
					compCnt ++;
				}
				gamecontrol.removeItem(c);
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
			System.out.println(this.lives);
		}
	}
	
}
