package controller;

import java.util.Random;
import java.awt.Graphics;
import java.util.LinkedList;

import game.Game;
import model.Block;
import model.Crabby;
//import model.Blocks;
import model.MovingObj;
import model.ObjectType;
import model.Obstacle;
import model.Floor;
import model.Item;

public class GameController{
	
	public boolean useTrashb, useHay, useSeeds, useComp;
	public LinkedList<Block> blocks = new LinkedList<Block>();
	public LinkedList<MovingObj> entities = new LinkedList<MovingObj>();
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
		
		for(MovingObj c: entities){
			c.draw(g);
		}
		
	}
	
	public void addObject(MovingObj g){
		entities.add(g);
	}
	
	public void removeObject(MovingObj g){
		entities.remove(g);
	}
	
	public void removeBlock(Block b){
		blocks.remove(b);
	}
	
	public void addBlock(Block b){
		blocks.add(b);
	}
	
	public void pause(){
		crabby.xVel = 0;
		crabby.yVel = 0;
		for(MovingObj c: entities){
			c.xVel = 0;
			c.yVel = 0;
		}
		for(Block b: blocks){
			b.xVel = 0;
			b.yVel = 0;
		}
	}
	
	public void unpause(){
		crabby.xVel = crabby.prevXVel;
		crabby.yVel = crabby.prevYVel;
		for(MovingObj c: entities){
			c.xVel = c.prevXVel;
			c.yVel = c.prevYVel;
		}
		for(Block b: blocks){
			b.xVel = b.prevXVel;
			b.yVel = b.prevYVel;
		}
	}
	public void update(){
		crabby.update();
		for(Block b: blocks){
			b.update();
		}
		for(MovingObj c: entities){
			c.update();
		}
		if(sendNext == true){
			if(useTrashb == false || useHay == false || useSeeds == false || useComp == false){
				blockNum = randItem.nextInt(3);
				itemNum = randItem.nextInt(4);
//				System.out.println(itemNum);
//				System.out.println("Initial block number" + blockNum);
				// maybe instead of using item numbers, just use count
	//			if(blocks.get(blockNum).getXPos()+50 < crabby.getXPos()){
	//
	//				System.out.println("Updated block number" + blockNum);
	//			}
				//check to see if the object xpos is off the screen, if true then go back into the if statements.
				//if(item.getX < leftbound) -> then redraw
				if(itemNum == 0){
					addObject(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.TrashBag, this));
				}
				else if(itemNum == 1){
					addObject(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.Hay, this));
				}
				else if(itemNum == 2){
					addObject(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.Seeds, this));
				}
				else{
					addObject(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.Compost, this));
				}
				sendNext = false;
			}
			else{
				whatsNext = randItem.nextInt(2);
				if(whatsNext == 0){
					blockNum = randItem.nextInt(3);
					itemNum = randItem.nextInt(4);
					if(itemNum == 0){
						addObject(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.TrashBag, this));
					}
					else if(itemNum == 1){
						addObject(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.Hay, this));
					}
					else if(itemNum == 2){
						addObject(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.Seeds, this));
					}
					else{
						addObject(new Item(blocks.get(blockNum).getXPos()+50,blocks.get(blockNum).getYPos()-30,30,30,ObjectType.Compost, this));
					}
				}
				else{
					itemNum = randItem.nextInt(4);
					if(itemNum == 0){
						addObject(new Obstacle(0,70,400,100,ObjectType.People, this));
					}
					else if(itemNum == 1){
						addObject(new Obstacle(0,70,400,100,ObjectType.Chemicals, this));
					}
					else if(itemNum == 2){
						addObject(new Obstacle(0,70,400,100,ObjectType.EmptySoil, this));
					}
					else{
						addObject(new Obstacle(0,70,400,100,ObjectType.DeadSoil, this));
					}
				}
				sendNext = false;
			}
		}
	}
	
	
	
}