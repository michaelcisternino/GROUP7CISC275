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
	public LinkedList<Item> items = new LinkedList<Item>();
	public Crabby crabby = new Crabby(300,512,64,64,ObjectType.Crabby,this);
	public boolean sendNext = false;
	Random randItem = new Random();
	int itemNum;
	public static int erryXVel;
	public boolean GoingRight = false;
	public boolean GoingLeft = false;
	
	public GameController(){
		
	}
	
	public void draw(Graphics g) {
		
		crabby.draw(g);
		
		for(Block b: blocks){
			b.draw(g);
		}
		this.GoingRight = false;
		this.GoingLeft = false;
		
		for(Item i: items){
			i.draw(g);
		}
		
	}
	
	public void addItem(Item g){
		items.add(g);
	}
	
	public void removeItem(Item g){
		items.remove(g);
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
		for(Item i: items){
			i.update();
		}
		if(sendNext == true){
			itemNum = randItem.nextInt(3);
			System.out.println(itemNum);
			// maybe instead of using item numbers, just use count
			if(itemNum == 0){
				addItem(new Item(500,0,30,30,ObjectType.TrashBag, this));
			}
			else if(itemNum == 1){
				addItem(new Item(500,0,30,30,ObjectType.Hay, this));
			}
			else if(itemNum == 2){
				addItem(new Item(500,0,30,30,ObjectType.Seeds, this));
			}
			else{
				addItem(new Item(500,0,30,30,ObjectType.Compost, this));
			}
			sendNext = false;
		}
	}
	
}