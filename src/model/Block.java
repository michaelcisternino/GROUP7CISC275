package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import controller.GameController;

public abstract class Block {

	public int xPos, yPos;
	public int xVel, yVel;

	public int width, height;
	
	public ObjectType type;
	
	public double gravity = 0.0;
	
	//public boolean solid;
	public boolean isJumping = false;
	public boolean isFalling = true;
	public boolean isGone = false;
	
	public GameController gamecontrol;
	
	public boolean solid;
	
	
	public Block(int x, int y, int width, int height, ObjectType t, GameController gc){
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.type = t;
		this.gamecontrol = gc;
	}
	
	public void remove(){
		gamecontrol.blocks.remove(this);
	}
	
	public void addBlock(Block b){
		gamecontrol.blocks.add(b);
	}
	
	public abstract void draw(Graphics g);
	
	public abstract void update();
	
	public int getXPos(){
		return this.xPos;
	}
	
	public int getYPos(){
		return this.yPos;
	}
	
	public int getxVel() {
		return xVel;
	}

	public int getyVel() {
		return yVel;
	}
	
//	public boolean isSolid(){
//		return this.solid;
//	}
	
	public ObjectType getType(){
		return this.type;
	}
	
	public void setxVel(int xVel){
		this.xVel = xVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
	
	public void setXPos(int x){
		this.xPos = x;
	}
	
	public void setYPos(int y){
		this.yPos = y;
	}
	
//	public void setSolid(boolean s){
//		this.solid = s;
//	}
	
	public Rectangle getBounds() {
		return new Rectangle(this.getXPos(), this.getYPos(), width, height);
	}
	
	public Rectangle getTopBounds(){
		return new Rectangle(this.getXPos()+10,this.getYPos(), width-20, 5);
	}
	
	public Rectangle getBottomBounds(){
		return new Rectangle(this.getXPos()+10,this.getYPos()+height-5, width-20, 5);
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle(this.getXPos(),this.getYPos()+10, 5, height-20);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle(this.getXPos()+width-5,this.getYPos()+10, 5, height-20);
	}
}