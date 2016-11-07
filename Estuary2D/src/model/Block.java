package model;

import java.awt.Graphics;
import java.awt.Rectangle;

import controller.GameController;

public abstract class Block {

	public double xPos, yPos;
	public double xVel, yVel;

	public int width, height;
	
	public ObjectType type;
	
	public boolean solid;
	
	public GameController gc;
	
	public Block(double x, double y, int width, int height, boolean solid, ObjectType t, GameController oc){
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.solid = solid;
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
	
	public double getXPos(){
		return this.xPos;
	}
	
	public double getYPos(){
		return this.yPos;
	}
	
	public double getxVel() {
		return xVel;
	}

	public double getyVel() {
		return yVel;
	}
	
	public boolean isSolid(){
		return this.solid;
	}
	
	public ObjectType getType(){
		return this.type;
	}
	
	public void setxVel(double xVel){
		this.xVel = xVel;
	}

	public void setyVel(double yVel) {
		this.yVel = yVel;
	}
	
	public void setXPos(double x){
		this.xPos = x;
	}
	
	public void setYPos(double y){
		this.yPos = y;
	}
	
	public void setSolid(boolean s){
		this.solid = s;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)this.getXPos(), (int)this.getYPos(), width, height);
	}
}