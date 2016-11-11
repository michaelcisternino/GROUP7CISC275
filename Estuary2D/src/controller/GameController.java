package controller;

import java.util.Random;
import java.awt.Graphics;
import java.util.LinkedList;

import game.Game;
import model.Block;
import model.Crabby;
//import model.Blocks;
import model.ObjectType;
import model.Obstacle;
import model.Floor;
import model.InteractiveObject;
import model.Item;

public class GameController{
	
	public boolean useTrashb, useHay, useSeeds, useComp;
	public LinkedList<Block> blocks = new LinkedList<Block>();
	public LinkedList<InteractiveObject> entities = new LinkedList<InteractiveObject>();
	public Crabby crabby = new Crabby(300,512,64,64,ObjectType.Crabby,this);
	public boolean sendNext = false;
	Random randItem = new Random();
	int itemNum;
	int blockNum;
	int whatsNext;
	
	public GameController(){
		
	}
	
	public void draw(Graphics g) {
		crabby.draw(g);
		
		for(Block b: blocks){
			b.draw(g);
		}
		
		for(InteractiveObject c: entities){
			c.draw(g);
		}
		
	}
	
	public void addEntity(InteractiveObject g){
		entities.add(g);
	}
	
	public void removeObject(InteractiveObject g){
		entities.remove(g);
	}
	
	public void removeBlock(Block b){
		blocks.remove(b);
	}
	
	public void addBlock(Block b){
		blocks.add(b);
	}
	// when we run into an obstacle, it doesnt actually pause. it just stops movement, but then when it unpases
	// it brings it back to the state it would be in if it kept moving/if the vel didnt go to zero.
	// need to stop the entire map/timer, not just the velocity.
	
	public void update(){
		crabby.update();
		for(Block b: blocks){
			b.update();
		}
		for(InteractiveObject c: entities){
			c.update();
		}
		if(sendNext == true){
			if(!useTrashb || !useHay || !useSeeds || !useComp){
				blockNum = randItem.nextInt(3);
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
				whatsNext = randItem.nextInt(2);
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
					switch(itemNum){
					case 0: addEntity(new Obstacle(Game.WIDTH * Game.SCALE+100,70,100,Game.HEIGHT*Game.SCALE,ObjectType.People, this));
					break;
					case 1: addEntity(new Obstacle(Game.WIDTH * Game.SCALE+100,70,100,Game.HEIGHT*Game.SCALE,ObjectType.Chemicals, this));
					break;
					case 2: addEntity(new Obstacle(Game.WIDTH * Game.SCALE+100,70,100,Game.HEIGHT*Game.SCALE,ObjectType.EmptySoil, this));
					break;
					case 4: addEntity(new Obstacle(Game.WIDTH * Game.SCALE+100,70,100,Game.HEIGHT*Game.SCALE,ObjectType.DeadSoil, this));
					break;
					}
				}
			}
			sendNext = false;
		}
	}
}
	
	
	