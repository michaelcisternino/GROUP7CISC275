package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;

public class PlayerKeyHandler implements KeyListener{
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key){
		case KeyEvent.VK_LEFT:
			Game.gameControl.crabby.setxVel(-5);
			//Game.gameControl.oystery.setxVel(-5);
			break;
		case KeyEvent.VK_RIGHT:
			Game.gameControl.crabby.setxVel(5);
			//Game.gameControl.oystery.setxVel(5);
			break;
//		case KeyEvent.VK_DOWN:
//			Game.gameControl.crabby.setGravity(Game.gameControl.crabby.getGravity()+5);
//			break;
		case KeyEvent.VK_UP:
			if(!Game.gameControl.crabby.isJumping){
				Game.gameControl.crabby.isJumping = true;
				Game.gameControl.crabby.gravity = 9.8;
			}/*
			if(!Game.gameControl.oystery.isJumping){
				Game.gameControl.oystery.isJumping = true;
				Game.gameControl.oystery.gravity = 9.8;
			}*/
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
			//Game.gameControl.oystery.setxVel(0);
			break;
		case KeyEvent.VK_RIGHT:
			Game.gameControl.crabby.setxVel(0);
			//Game.gameControl.oystery.setxVel(0);
			break;
		case KeyEvent.VK_DOWN:
			Game.gameControl.crabby.setyVel(0);
			//Game.gameControl.oystery.setyVel(0);
			break;
		case KeyEvent.VK_UP:
			Game.gameControl.crabby.setyVel(0);
			//Game.gameControl.oystery.setyVel(0);
			break;
		}
		
	}

}
