package model;

import java.awt.Color;
import java.awt.Graphics;

import controller.GameController;
import game.Game;

public class Platform extends Block{

	public Platform(int x, int y, int width, int height, ObjectType t, GameController oc) {
		super(x, y, width, height, t, oc);
	}

	@Override
	public void draw(Graphics g) {
	if (this.isFinal == true){
	g.setColor(Color.YELLOW);
	}
	else{
	g.setColor(Color.WHITE);
	}
	g.fillRect(this.xPos,this.yPos,width,height);
	}

	@Override
	public void update() {
		if (isFinal == true){
			if (this.yPos == 200){
				Game.startNextLevel(Game.getLevel());
				return;
			}
			if (this.xPos == 500){
				this.yPos -= 5;	
				return;
			}
		}
		if (Game.gameControl.goingRight == true){
			this.xPos -= 5;
		}
		else if (Game.gameControl.goingLeft == true){
			this.xPos += 5;
		}
	}
}
