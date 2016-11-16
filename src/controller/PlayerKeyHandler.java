package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;
import model.Item;
import model.ObjectType;

public class PlayerKeyHandler implements KeyListener{
	
	@Override
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
			if(!Game.gameControl.crabby.isJumping){
				Game.gameControl.crabby.isJumping = true;
				Game.gameControl.crabby.gravity = 9.8;
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
		}
	}
	//want to do a throw method so we can throw objects at the obstacles instead of just pausing it, and if obstacle hits then you lose health or some shit.
		
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
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