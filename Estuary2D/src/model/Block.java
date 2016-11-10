package model;

import java.awt.Graphics;
import java.awt.Rectangle;

import controller.GameController;

public abstract class Block {

	public int xPos, yPos;
	public int xVel, yVel;

	public int width, height;
	
	public ObjectType type;
	
	public boolean solid;
	
	public GameController gc;
	
	public Block(int x, int y, int width, int height, ObjectType t, GameController oc){
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.type = t;
		this.gc = oc;
	}
	
	public void remove(){
		gc.blocks.remove(this);
	}
	
	public void addBlock(Block b){
		gc.blocks.add(b);
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
}