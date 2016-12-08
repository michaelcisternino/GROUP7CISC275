package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

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
public class Platform extends Block implements java.io.Serializable{
	
	BufferedImage item;
	
	/**
	 * Construtor for platform. Sends everything to the superclass constructor.
	 * @param x The platform's x position.
	 * @param y The platform's y position.
	 * @param initx The platform's initial x position.
	 * @param inity The platform's initial y position.
	 * @param width The width of the platform.
	 * @param height The height of the platform.
	 * @param t The type of the object.
	 * @param r The distance the platform will move: short, medium, long.
	 * @param isVert If the platform will move vertically when it moves.
	 * @param isHor If the platform will move horizontally when it moves. 
	 * @param gc The game controller.
	 */	
	public Platform(int x, int y, int initx, int inity, int width, int height, ObjectType t, RangeType r, Boolean isVert, Boolean isHor, GameController gc){
		super(x, y, initx, inity, width, height, t, r, isVert, isHor, gc);
		switch(t){
		case Net: file = "Final Images/Objects/net.png";
			break;
		case Wall: file = "Final Images/Backgrounds/sand_tile.jpg";
			break;
	}
		item = createImage(file);
	}

	/**
	 * Draws a rectangle based on the parameters of the platform.
	 * If the platform is the final platform of the level, it is colored a different color.
	 * @param g The graphics to be drawn on.
	 */
	@Override
	public void draw(Graphics g) {
	Random ran = new Random();
	if (isFinal()){
		g.setColor(Color.YELLOW);
		g.fillRect(getXPos(),getYPos(),getWidth(),getHeight());
	}
	g.drawImage(item, getXPos(), getYPos(), getWidth(), getHeight(), null);
	}

	/**
	 * Updates the platform in the controller.
	 * If the platform is the final platform, the next level is called. The final platform rises when the character is on it.
	 * Updates the platform based on the direction the view is moving in the controller.
	 */
	@Override
	public void update() {
		move();
		if(Game.gameControl.crabby.isCaught() && getType() == ObjectType.Net){
			setVert(false);
			setyVel(-5);
		}
		if (isFinal()){
		    if (getYPos() == 200){
		        if (Game.getLevel() == 1){
		            Game.setLevel(6);
		        }
		        if (Game.getLevel() == 2){
		            Game.setLevel(7);
		        }
		        if (Game.getLevel() == 3){
		            Game.setLevel(8);
		        }
		        return;
		    }
			if (getXPos() == 600){
				Game.gameControl.crabby.setRising(true);
				rise();
				return;
			}
		}
		if (Game.gameControl.goingRight == true){
			if(Game.getLevel() == 1){
				setXPos(getXPos() - 2);
			}
			else{
				deltaX = -5;
			}
		}
		else if (Game.gameControl.goingLeft == true){
			deltaX = 5;
		}
		else{
		    deltaX = 0;
		}
		this.setInitX(this.getInitX() + deltaX);
		this.setXPos(this.getXPos() + deltaX);
		if (isHor()){
		    switch (getRange()) {
		    case Short:
		        ticks++;
		        periodPos = (int) (100*Math.sin(ticks * .5 * Math.PI / 60));
		        this.setXPos(this.getInitX() + periodPos);
		        break;
		    case Mid:
		        ticks++;
		        periodPos = (int) (100*Math.sin(ticks * .5 * Math.PI / 60));
		        this.setXPos(this.getInitX() + 2*periodPos);
		        break;
		    case Long:
		        ticks++;
		        periodPos = (int) (100*Math.sin(ticks * .5 * Math.PI / 60));
		        this.setXPos(this.getInitX() + 3*periodPos);
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
				if(getInitY() == -51){
					setInitY(0);
				}
				if(getInitY() == 51){
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
				if(getInitY() == -76){
					setInitY(0);
				}
				if(getInitY() == 76){
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
				if(getInitY() == -101){
					setInitY(0);
				}
				if(getInitY() == 101){
					setInitY(-1);
				}
				break;
			}
		}
	}
}
