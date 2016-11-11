package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;
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
			System.out.println(Game.gameControl.entities.getLast().type);
			Game.gameControl.entities.getLast().setUsedCorrect(Game.gameControl.entities.getLast().checkItem(ObjectType.TrashBag));
			Game.gameControl.crabby.trashBagCnt -= 1;
			System.out.println(e.toString());
			break;
		case KeyEvent.VK_H:
			Game.gameControl.entities.getLast().setUsedCorrect(Game.gameControl.entities.getLast().checkItem(ObjectType.Hay));
			Game.gameControl.crabby.hayCnt -= 1;
			System.out.println(e.toString());
			break;
		case KeyEvent.VK_S:
			Game.gameControl.entities.getLast().setUsedCorrect(Game.gameControl.entities.getLast().checkItem(ObjectType.Seeds));
			Game.gameControl.crabby.seedCnt -= 1;
			System.out.println(e.toString());
			break;
		case KeyEvent.VK_C:
			Game.gameControl.entities.getLast().setUsedCorrect(Game.gameControl.entities.getLast().checkItem(ObjectType.Compost));
			Game.gameControl.crabby.compCnt -= 1;
			System.out.println(e.toString());
			break;
		}
	}
	
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
