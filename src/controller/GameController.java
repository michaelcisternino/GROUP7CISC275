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
import model.Oystery;
import model.Floor;
import model.Item;

public class GameController{
	
	public LinkedList<Block> blocks = new LinkedList<Block>();
	public LinkedList<Item> items = new LinkedList<Item>();
	public Crabby crabby = new Crabby(300,512,64,64,ObjectType.Crabby,this);
	//public Oystery oystery = new Oystery(300,512,64,64,ObjectType.Oystery,this);
	public boolean sendNext = false;
	int itemNum;
	
	public GameController(){
		
	}
	
	public void draw(Graphics g) {
		
		crabby.draw(g);
		//oystery.draw(g);
		
		for(Block b: blocks){
			b.draw(g);
		}
		
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
		//oystery.update();
		for(Block b: blocks){
			b.update();
		}
		for(Item i: items){
			i.update();
		}
		if(sendNext == true){
			Random randItem = new Random();
			itemNum = randItem.nextInt(4);
			System.out.println(itemNum);
			switch (itemNum){
			case 0:
				addItem(new Item(500,0,30,30,ObjectType.TrashBag, this));
				break;
			case 1:
				addItem(new Item(500,0,30,30,ObjectType.Hay, this));
				break;
			case 2:
				addItem(new Item(500,0,30,30,ObjectType.Compost, this));
				break;
			default:
				addItem(new Item(500,0,30,30,ObjectType.Seeds, this));
				break;
			}
			sendNext = false;
		}
	}
	
}