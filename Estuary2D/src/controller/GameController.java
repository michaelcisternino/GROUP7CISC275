package controller;

import java.awt.Graphics;
import java.util.LinkedList;

import game.Game;
import model.Block;
import model.Crabby;
//import model.Blocks;
import model.Character;
import model.ObjectType;
import model.Floor;

public class GameController{

	public LinkedList<Block> blocks = new LinkedList<Block>();
	public LinkedList<Character> entities = new LinkedList<Character>();
	public Crabby crabby = new Crabby(300,512,64,64,ObjectType.Crabby,this);
	
	public GameController(){
		
	}
	
	public void draw(Graphics g) {
		crabby.draw(g);
		
		for(Block b: blocks){
			b.draw(g);
		}
		
		for(Character c: entities){
			c.draw(g);
		}
		
	}
	
	public void addObject(Character g){
		entities.add(g);
	}
	
	public void removeObject(Character g){
		entities.remove(g);
	}
	
	public void removeBlock(Block b){
		blocks.remove(b);
	}
	
	public void addBlock(Block b){
		blocks.add(b);
	}
	
	public void update(){
		crabby.update();
		for(Block b: blocks){
			b.update();
		}
		for(Character c: entities){
			c.update();
		}
	}
	
	
	
}