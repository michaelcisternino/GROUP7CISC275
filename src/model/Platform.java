package model;

import java.awt.Color;
import java.awt.Graphics;

import controller.GameController;
import game.Game;
/**
 * Platforms for the character to move on. Inherits block.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class Platform extends Block{

	public Platform(int x, int y, int initx, int inity, int width, int height, ObjectType t, RangeType r, Boolean isVert, Boolean isHor, GameController gc){
		super(x, y, initx, inity, width, height, t, r, isVert, isHor, gc);
	}

	/**
	 * Draws a rectangle based on the parameters of the platform.
	 * If the platform is the final platform of the level, it is colored a different color.
	 */
	@Override
	public void draw(Graphics g) {
	if (isFinal()){
	g.setColor(Color.YELLOW);
	}
	else{
	g.setColor(Color.WHITE);
	}
	g.fillRect(getXPos(),getYPos(),getWidth(),getHeight());
	}

	/**
	 * Updates the platform in the controller.
	 * If the platform is the final platform, the next level is called. The final platform rises when the character is on it.
	 * Updates the platform based on the direction the view is moving in the controller.
	 */
	@Override
	public void update() {
		move();
		if (isFinal()){
			if (getYPos() == 200){
				Game.setLevel(Game.getLevel()+1);
				Game.startNextLevel(Game.getLevel());
				return;
			}
			if (getXPos() == 600){
				Game.gameControl.crabby.setRising(true);
				rise();
				return;
			}
		}
		if (Game.gameControl.goingRight == true){
			setXPos(getXPos() - 5);
		}
		else if (Game.gameControl.goingLeft == true){
			setXPos(getXPos() + 5);
		}
		if (isHor()){
			switch (getRange()) {
			case Short:
				if(getInitX() <0){
					setxVel(-4);
					setInitX(getInitX()-1);
				}
				if(getInitX() >=0){
					setxVel(4);
					setInitX(getInitX()+1);
				}
				if(getInitX() == -50){
					setInitX(0);
				}
				if(getInitX() == 50){
					setInitX(-1);
				}
				break;
			case Mid:
				if(this.getInitX() <0){
					setxVel(-3);
					setInitX(getInitX()-1);
				}
				if(this.getInitX() >=0){
					setxVel(3);
					setInitX(getInitX()+1);
				}
				if(this.getInitX() == -75){
					setInitX(0);
				}
				if(this.getInitX() == 75){
					setInitX(-1);
				}
				break;
			case Long:
				if(this.getInitX() <0){
					setxVel(-4);
					setInitX(getInitX()-1);
				}
				if(this.getInitX() >=0){
					setxVel(4);
					setInitX(getInitX()+1);
				}
				if(this.getInitX() == -100){
					setInitX(0);
				}
				if(this.getInitX() == 100){
					setInitX(-1);
				}
				break;
			}
		}
		if (isVert()){
			switch (getRange()) {
			case Short:
				if(getInitY() <0){
					setyVel(-4);
					setInitY(getInitY()-1);
				}
				if(getInitY() >=0){
					setyVel(4);
					setInitY(getInitY()+1);
				}
				if(getInitY() == -50){
					setInitY(0);
				}
				if(getInitY() == 50){
					setInitY(-1);
				}
				break;
			case Mid:
				if(getInitY() <0){
					setyVel(-3);
					setInitY(getInitY()-1);
				}
				if(getInitY() >=0){
					setyVel(3);
					setInitY(getInitY()+1);
				}
				if(getInitY() == -75){
					setInitY(0);
				}
				if(getInitY() == 75){
					setInitY(-1);
				}
				break;
			case Long:
				if(getInitY() <0){
					setyVel(-4);
					setInitY(getInitY()-1);
				}
				if(getInitY() >=0){
					setyVel(4);
					setInitY(getInitY()+1);
				}
				if(getInitY() == -100){
					setInitY(0);
				}
				if(getInitY() == 100){
					setInitY(-1);
				}
				break;
			}
		}
	}
}
