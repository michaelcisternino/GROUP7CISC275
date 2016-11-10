package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import controller.GameController;

public class Floor extends Block{

	public Floor(int x, int y, int width, int height, ObjectType t, GameController oc) {
		super(x, y, width, height, t, oc);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.darkGray);
		g.fillRect(this.xPos,this.yPos,width,height);
	}

	@Override
	public void update() {
		this.xPos-=1;
		if(this.xPos <= (0-this.width)){
			this.setXPos(270*4);
		}
	}

	
}
