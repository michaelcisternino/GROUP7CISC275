package model;

import java.awt.Color;
import java.awt.Graphics;

import controller.GameController;

public class Wall extends Block{

	public Wall(double x, double y, int width, int height, boolean solid, ObjectType t, GameController oc) {
		super(x, y, width, height, solid, t, oc);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int)this.xPos,(int)this.yPos,width,height);
	}

	@Override
	public void update() {
		this.xPos-=5;
		if(this.xPos <= (0-this.width)){
			this.setXPos(270*4);
		}
	}

	
}
