package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import controller.GameController;

public abstract class InteractiveObject {
	
	public boolean useCorrect = false;

	public int xPos, yPos;
	public int  xVel, yVel;

	public int width, height;
	public int colNum; 
	
	public ObjectType type;
	
	public double gravity = 0.0;
	
	//public boolean solid;
	public boolean isJumping = false;
	public boolean isFalling = true;
	public boolean isGone = false;
	
	public GameController gamecontrol;
	
	String file;
	BufferedImage item;
	
	public InteractiveObject(int x, int y, int width, int height, ObjectType t, GameController gamecontrol){
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
		this.type = t;
		this.gamecontrol = gamecontrol;
		//this.colNum = color;
	}
	
	public void remove(){
		gamecontrol.entities.remove(this);
	}
	
	public void addObject(Item go){
		gamecontrol.entities.add(go);
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
	
	public ObjectType getType(){
		return this.type;
	}
	
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
	
	public boolean checkItem(ObjectType t){
		switch(this.type){
		case People:
			if(t == ObjectType.TrashBag){
			useCorrect = true;
			}
			else{
			useCorrect = false;
			}
			break;
		case Chemicals:
			if(t == ObjectType.Hay){
			useCorrect = true;
			}
			else{
			useCorrect = false;
			}
			break;
		case EmptySoil:
			if(t == ObjectType.Seeds){
				useCorrect = true;
			}
			else{
				useCorrect = false;
			}
			break;
		case DeadSoil:
			if(t == ObjectType.Compost){
				useCorrect = true;
			}
			else{
				useCorrect = false;
			}
			break;
		}
		System.out.println(useCorrect);
		if(useCorrect == true){
			gamecontrol.removeObject(gamecontrol.entities.getLast());
			gamecontrol.sendNext = true;
		}
		return useCorrect;
	}
	
	public BufferedImage createImage(String file) {
		BufferedImage img;
		try{
			img = ImageIO.read(new File(file));
			return img;
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

}