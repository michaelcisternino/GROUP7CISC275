package controller;

import java.util.Random;
import java.awt.Graphics;
import java.util.LinkedList;

import game.Game;
import model.Block;
import model.Crabby;
//import model.Blocks;
import model.Character;
import model.ObjectType;
import model.Floor;
import model.Item;

public class GameController{
	
	public LinkedList<Block> blocks = new LinkedList<Block>();
	public LinkedList<Item> entities = new LinkedList<Item>();
	public Crabby crabby = new Crabby(300,512,64,64,ObjectType.Crabby,this);
	public boolean sendNext = false;
	Random randItem = new Random();
	int itemNum;
	
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
	
	public void addObject(Item g){
		entities.add(g);
	}
	
	public void removeObject(Item g){
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
		if(sendNext == true){
			itemNum = randItem.nextInt(3);
			System.out.println(itemNum);
			// maybe instead of using item numbers, just use count
			if(itemNum == 0){
				addObject(new Item(500,0,30,30,ObjectType.TrashBag, this));
			}
			else if(itemNum == 1){
				addObject(new Item(500,0,30,30,ObjectType.Hay, this));
			}
			else if(itemNum == 2){
				addObject(new Item(500,0,30,30,ObjectType.Seeds, this));
			}
			else{
				addObject(new Item(500,0,30,30,ObjectType.Compost, this));
			}
			sendNext = false;
		}
	}
	
	
	
}