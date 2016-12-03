package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;
import model.Item;
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
	 * X throws oysters to practice throwing.
	 * @param e The keyevent to be acted on.
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT:
			Game.gameControl.crabby.setxVel(-5);
			break;
		case KeyEvent.VK_RIGHT:
			Game.gameControl.crabby.setxVel(5);
			break;
//		case KeyEvent.VK_DOWN:
//			MainController.gameControl.crabby.setyVel(5);
//			break;
		case KeyEvent.VK_UP:
			if(!Game.gameControl.crabby.isJumping()){
				Game.gameControl.crabby.setJumping(true);
				Game.gameControl.crabby.setGravity(7.2);
			}
			break;
		case KeyEvent.VK_T:
			Game.gameControl.thrownType = ObjectType.TrashBag;
			Game.gameControl.itemThrownC = true;
//			thrownT.itemThrown = true;
//			Game.gameControl.addItem(thrownT);
//			Game.gameControl.entities.get(Game.gameControl.entities.size()-1).useCorrect = Game.gameControl.entities.get(Game.gameControl.entities.size()-1).checkItem(thrownT.getType());
			//Game.gameControl.crabby.trashBagCnt -= 1;

			//Game.gameControl.unpause();
			break;
		case KeyEvent.VK_H:
			Game.gameControl.thrownType = ObjectType.Hay;
			Game.gameControl.itemThrownC = true;
//			Item thrownH = new Item(Game.gameControl.crabby.xPos,Game.gameControl.crabby.yPos,30,30,ObjectType.Hay, Game.gameControl);
//			thrownH.itemThrown = true;
//			Game.gameControl.addItem(thrownH);
//			Game.gameControl.entities.get(Game.gameControl.entities.size()-1).useCorrect = Game.gameControl.entities.get(Game.gameControl.entities.size()-1).checkItem(thrownH.getType());
			//Game.gameControl.crabby.hayCnt -= 1;
			
			//Game.gameControl.unpause();
			break;
		case KeyEvent.VK_S:
			Game.gameControl.thrownType = ObjectType.Seeds;
			Game.gameControl.itemThrownC = true;
//			Item thrownS = new Item(Game.gameControl.crabby.xPos,Game.gameControl.crabby.yPos,30,30,ObjectType.Seeds, Game.gameControl);
//			thrownS.itemThrown = true;
//			Game.gameControl.addItem(thrownS);
//			Game.gameControl.entities.get(Game.gameControl.entities.size()-1).useCorrect = Game.gameControl.entities.get(Game.gameControl.entities.size()-1).checkItem(thrownS.getType());
			//Game.gameControl.crabby.seedCnt -= 1;

			//Game.gameControl.unpause();
			break;
		case KeyEvent.VK_C:
			Game.gameControl.thrownType = ObjectType.Compost;
			Game.gameControl.itemThrownC = true;
//			Item thrownC = new Item(Game.gameControl.crabby.xPos,Game.gameControl.crabby.yPos,30,30,ObjectType.Compost, Game.gameControl);
//			thrownC.itemThrown = true;
//			Game.gameControl.addItem(thrownC);
//			Game.gameControl.entities.get(Game.gameControl.entities.size()-1).useCorrect = Game.gameControl.entities.get(Game.gameControl.entities.size()-1).checkItem(thrownC.getType());
			//Game.gameControl.crabby.compCnt -= 1;

			//Game.gameControl.unpause();
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
		}
	}
	//want to do a throw method so we can throw objects at the obstacles instead of just pausing it, and if obstacle hits then you lose health or some shit.
		
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
			Game.gameControl.crabby.setxVel(0);
			break;
		case KeyEvent.VK_RIGHT:
			Game.gameControl.crabby.setxVel(0);
			break;
		case KeyEvent.VK_DOWN:
			Game.gameControl.crabby.setyVel(0);
			break;
		case KeyEvent.VK_UP:
			Game.gameControl.crabby.setyVel(0);
			break;
		}
		
	}

}
