package model;

import java.awt.Graphics;
import java.awt.Rectangle;

import controller.GameController;

public abstract class Character {

	public double xPos, yPos;
	public double xVel, yVel;

	public int width, height;
	
	public ObjectType type;
	
	public double gravity = 0.0;
	
	public boolean solid;
	public boolean isJumping = false;
	public boolean isFalling = true;
	public boolean isGone = false;
	
	public GameController gamecontrol;
	
	public Character(double x, double y, int width, int height, boolean solid, ObjectType t, GameController gamecontrol){
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.solid = solid;
		this.type = t;
		this.gamecontrol = gamecontrol;
	}
	
	public void remove(){
		gamecontrol.objects.remove(this);
	}
	
	public void addObject(Character go){
		gamecontrol.objects.add(go);
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
	
	public ObjectType getType(){
		return this.type;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)this.getXPos(), (int)this.getYPos(), width, height);
	}
	
	public Rectangle getTopBounds(){
		return new Rectangle((int)this.getXPos()+10,(int)this.getYPos(), width-20, 5);
	}
	
	public Rectangle getBottomBounds(){
		return new Rectangle((int)this.getXPos()+10,(int)this.getYPos()+height-5, width-20, 5);
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle((int)this.getXPos(),(int)this.getYPos()+10, 5, height-20);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle((int)this.getXPos()+width-5,(int)this.getYPos()+10, 5, height-20);
	}

}
