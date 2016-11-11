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
import model.Obstacle;
import model.Floor;
import model.InteractiveObject;
import model.Item;

public class GameController{
	
	public boolean useTrashb, useHay, useSeeds, useComp;
	public boolean sendNext = false;
	Random randItem = new Random();
	
	int itemNum;
	int blockNum;
	int whatsNext;
	
	public LinkedList<Block> blocks = new LinkedList<Block>();
	public LinkedList<InteractiveObject> entities = new LinkedList<InteractiveObject>();
	public LinkedList<Obstacle> obstacles = new LinkedList<Obstacle>();
	public Crabby crabby = new Crabby(300,512,64,64,ObjectType.Crabby,this);
	
	public GameController(){
		
	}
	
	public void draw(Graphics g) {
		
		crabby.draw(g);
		
		for(Block b: blocks){
			b.draw(g);
		}
		
		for(InteractiveObject entity: entities){
			entity.draw(g);
		}
		
	}
	
	public void addEntity(InteractiveObject entity){
		entities.add(entity);
	}
	
	public void removeEntity(InteractiveObject entity){
		entities.remove(entity);
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
		for(InteractiveObject entity: entities){
			entity.update();
		}
		if(sendNext == true){
			if(useTrashb == false || useHay == false || useSeeds == false || useComp == false){
			itemNum = randItem.nextInt(4);
			blockNum = randItem.nextInt(3);
			// maybe instead of using item numbers, just use count
			switch(itemNum){
				case 0: addEntity(new Item(500,0,30,30,ObjectType.TrashBag, this));
				break;
				case 1: addEntity(new Item(500,0,30,30,ObjectType.Hay, this));
				break;
				case 2: addEntity(new Item(500,0,30,30,ObjectType.Seeds, this));
				break;
				case 3: addEntity(new Item(500,0,30,30,ObjectType.Compost, this));
				break;
			}
			sendNext = false;
			}
			else{
			whatsNext = randItem.nextInt(2) + 1;
			if(whatsNext == 0){
				blockNum = randItem.nextInt(4);
				itemNum = randItem.nextInt(4);
				switch(itemNum){
				case 0: addEntity(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.TrashBag, this));
				break;
				case 1: addEntity(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.Hay, this));
				break;
				case 2: addEntity(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.Seeds, this));
				break;
				case 3: addEntity(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.Compost, this));
				break;
				}
			}
			else{
				itemNum = randItem.nextInt(4);
				System.out.println("sending");
				switch(itemNum){
				case 0: addEntity(new Obstacle(Game.WIDTH * Game.SCALE,70,400,100,ObjectType.Person, this));
				break;
				case 1: addEntity(new Obstacle(Game.WIDTH * Game.SCALE,70,400,100,ObjectType.Chemicals, this));
				break;
				case 2: addEntity(new Obstacle(Game.WIDTH * Game.SCALE,70,400,100,ObjectType.EmptySoil, this));
				break;
				case 4: addEntity(new Obstacle(Game.WIDTH * Game.SCALE,70,400,100,ObjectType.DeadSoil, this));
				break;
				}
			}
			sendNext = false;
	}
		}
	}
}
	