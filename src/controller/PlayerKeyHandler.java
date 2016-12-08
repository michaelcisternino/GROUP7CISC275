package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;
import model.ObjectType;
/**
 * Takes player input and sends it to the the controller.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 */
public class PlayerKeyHandler implements KeyListener{
	/**
	 * Translates a pressed key into an in-game event.
	 * When a key is pressed, the actionlistener switches it and calls the gamecontrol method related to that action.
	 * Left and right alter the character's x velocity.
	 * Up sets the character's jump status to true and modifies the gravity so it will jump.
	 * T throws a trash bag to collect trash.
	 * H throws hay to soak up chemicals.
	 * S throws seeds to fix bare soil.
	 * C throws compost to fix bad soil.
	 * X throws oysters to fill gabions.
	 * W throws waste (trash) into trash cans.
	 * R throws recyclables into recycling bins.
	 * @param e The keyevent to be acted on.
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT:
			Game.gameControl.crabby.pkh = true;
//			if(Game.getLevel() == 1){
//				break;
//			}
//			else{
			Game.gameControl.crabby.setxVel(-5);
//			}
			break;
		case KeyEvent.VK_RIGHT:
			Game.gameControl.crabby.pkh = true;
//			if(Game.getLevel() == 1){
//				break;
//			}
//			else{
			Game.gameControl.crabby.setxVel(5);
//			}
			break;
//		case KeyEvent.VK_DOWN:
//			if(Game.getLevel() == 1){
//				Game.gameControl.crabby.setSwimDown(true);
//				Game.gameControl.crabby.setGravity(-3.0);
//				Game.gameControl.crabby.setyVel(10);
//			}
//			else{
//				break;
//			}
//			break;
		case KeyEvent.VK_UP:
			if(Game.getLevel() == 1){
				Game.gameControl.crabby.setSwimUp(true);
				Game.gameControl.crabby.setGravity(4.0);
			}
			else{
			if(!Game.gameControl.crabby.isJumping()){
				Game.gameControl.crabby.setJumping(true);
				Game.gameControl.crabby.setGravity(7.2);
			}
			}
			break;
		case KeyEvent.VK_T:
			Game.gameControl.thrownType = ObjectType.TrashBag;
			Game.gameControl.itemThrownC = true;
			break;
		case KeyEvent.VK_H:
			Game.gameControl.thrownType = ObjectType.Hay;
			Game.gameControl.itemThrownC = true;
			break;
		case KeyEvent.VK_S:
			Game.gameControl.thrownType = ObjectType.Seeds;
			Game.gameControl.itemThrownC = true;
			break;
		case KeyEvent.VK_C:
			Game.gameControl.thrownType = ObjectType.Compost;
			Game.gameControl.itemThrownC = true;
			break;
		case KeyEvent.VK_X:
			Game.gameControl.thrownType = ObjectType.Oyster;
			Game.gameControl.itemThrownC = true;
			break;
		case KeyEvent.VK_W:
			Game.gameControl.thrownType = ObjectType.Trash;
			Game.gameControl.itemThrownC = true;
			break;
		case KeyEvent.VK_R:
			Game.gameControl.thrownType = ObjectType.Recycling;
			Game.gameControl.itemThrownC = true;
			break;
		case KeyEvent.VK_E:
			Game.game.writeMyObjectToFile(Game.game, "tempdata.ser");
			break;
		}
	}		
		
	/**
	 * Unused inherited method.
	 */
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * When the key is released, movement is stopped.
	 * @param e The keyevent being acted upon.
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT:
			Game.gameControl.crabby.pkh = false;
			Game.gameControl.crabby.setxVel(0);
			break;
		case KeyEvent.VK_RIGHT:
			Game.gameControl.crabby.pkh = false;
			Game.gameControl.crabby.setxVel(0);
			break;
//		case KeyEvent.VK_DOWN:
//			Game.gameControl.crabby.setyVel(0);
//			break;
		case KeyEvent.VK_UP:
			Game.gameControl.crabby.setyVel(0);
			break;
		}
		
	}

}
