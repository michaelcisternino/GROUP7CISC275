package model;

import java.awt.Color;
import java.awt.Graphics;

import controller.GameController;

public class Platform extends Block{

	public Platform(int x, int y, int width, int height, ObjectType t, GameController oc) {
		super(x, y, width, height, t, oc);
		this.xVel = -1;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(this.xPos,this.yPos,width,height);
	}

	@Override
	public void update() {
		this.xPos += this.xVel;
		if(this.xPos <= (0-this.width)){
			this.setXPos(270*4);
		}
	}
	
	

}
