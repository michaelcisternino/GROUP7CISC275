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

	public Platform(int x, int y, int width, int height, ObjectType t, GameController oc) {
		super(x, y, width, height, t, oc);
	}

	/**
	 * Draws a rectangle based on the parameters of the platform.
	 * If the platform is the final platform of the level, it is colored a different color.
	 */
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

	/**
	 * Updates the platform in the controller.
	 * If the platform is the final platform, the next level is called. The final platform rises when the character is on it.
	 * Updates the platform based on the direction the view is moving in the controller.
	 */
	@Override
	public void update() {
		if (isFinal == true){
			if (this.yPos == 200){
				Game.setLevel(Game.getLevel()+1);
				Game.startNextLevel(Game.getLevel());
				return;
			}
			if (this.xPos == 600){
				Game.gameControl.crabby.isRising = true;
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
