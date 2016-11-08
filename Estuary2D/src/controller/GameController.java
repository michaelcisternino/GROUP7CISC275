package controller;

import java.awt.Graphics;
import java.util.LinkedList;

import game.Game;
import model.Block;
import model.Crabby;
//import model.Blocks;
import model.Character;
import model.ObjectType;
import model.Wall;

public class GameController{

	public LinkedList<Block> blocks = new LinkedList<Block>();
	public LinkedList<Character> objects = new LinkedList<Character>();
	public Crabby crabby = new Crabby(300,512,64,64,true,ObjectType.Crabby,this);
	
	public GameController(){
		
	}
	
	public void draw(Graphics g) {
		if(crabby == null){
			System.out.println("Crabby null");
		}
		crabby.draw(g);
		
		for(Block b: blocks){
			if(b == null){
				System.out.println("ohNO");
			}
			b.draw(g);
		}
	}
	
	public void addObject(Character g){
		objects.add(g);
	}
	
	public void removeObject(Character g){
		objects.remove(g);
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
	}
	
	
	
}