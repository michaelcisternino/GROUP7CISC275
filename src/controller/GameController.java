package controller;

import java.util.Random;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import game.Game;
import model.Block;
import model.Crabby;
//import model.Blocks;
import model.ObjectType;
import model.Obstacle;
import model.Status;
import model.Floor;
import model.InteractiveObject;
import model.Item;
/**
 * Controller for the game.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 */
public class GameController{
	
	public boolean useTrashb, useHay, useSeeds, useComp, useOyster;
	public ObjectType thrownType;
	public boolean itemThrownC = false;
	public LinkedList<Block> blocks = new LinkedList<Block>();
	public LinkedList<InteractiveObject> entities = new LinkedList<InteractiveObject>();
	public LinkedList<Item> thrownItems = new LinkedList<Item>();
	public LinkedList<Item> items = new LinkedList<Item>();
	public Crabby crabby = new Crabby(300,512,64,64,ObjectType.Crabby,this);
	public boolean sendNext = false;
	Random randItem = new Random();
	int itemNum;
	public int blockNum;
	int whatsNext;
	int spawnXpos;
	int spawnYpos;
	public static int erryXVel;
	public boolean goingRight = false;
	public boolean goingLeft = false;
	//Status statusPanel = new Status();
	
	public GameController(){
		
	}
	/**
	 * Draws objects on the screen. Draws blocks, the entities, and the thrown items.	
	 * @param g Graphics passed in to be drawn.
	 */
	public void draw(Graphics g) {
		crabby.draw(g);
		for(Block b: blocks){
			b.draw(g);
		}
		this.goingRight = false;
		this.goingLeft = false;
		
		for(InteractiveObject c: entities){
			c.draw(g);
		}
		
		for(InteractiveObject i: thrownItems){
			i.draw(g);
		}
//		for(Item item: items){
//			item.draw(g);
//		}
	}
	/**
	 * Adds an interactive object to the list of entities.
	 * @param g The object to be added to the list of entities.
	 */
	public void addEntity(InteractiveObject g){
		entities.add(g);
	}
	
	/**
	 * Removes the given interactive object from the list of entities.
	 * @param g The object to be removed from the list of entities.
	 */
	public void removeObject(InteractiveObject g){
		entities.remove(g);
	}
	
	/**
	 * Removes the given block from the list of blocks.
	 * @param b The block to be removed from the list of blocks.
	 */
	public void removeBlock(Block b){
		blocks.remove(b);
	}
	
	/**
	 * Adds a block to the list of blocks.
	 * @param b The block to be added to the list of blocks.
	 */
	public void addBlock(Block b){
		blocks.add(b);
	}
	
	/**
	 * Adds an item to the list of items.
	 * @param i The item to be added to the list of items.
	 */
	public void addItem(Item i){
		thrownItems.add(i);
	}
	
	/**
	 * Removes the given item from the list of items.
	 * @param i The item to be removed from the list of items.
	 */
	public void removeItem(Item i){
		thrownItems.remove(i);
	}
	// when we run into an obstacle, it doesnt actually pause. it just stops movement, but then when it unpases
	// it brings it back to the state it would be in if it kept moving/if the vel didnt go to zero.
	// need to stop the entire map/timer, not just the velocity.
	
	/**
	 * Updates the game. Updates the character.
	 * Updates each block, interactive object, thrown item, and item. Updates the status bar.
	 * If an item is thrown, the corresponding counter is decremented. An item is created with the thrown velocity.
	 * If the player attempts to throw and item they don't have, a message is printed.
	 */
	public void update(){
		crabby.update();
		for(Block b: blocks){
			b.update();
		}
		for(InteractiveObject c: entities){
			c.update();
		}
		for(Item i: thrownItems){
			i.update();
		}
		for(Item item: items){
			item.update();
		}
		Game.status.update();
//		if(sendNext == true){
//			sendNext = false;
//			if(!useTrashb || !useHay || !useSeeds || !useComp){
//				blockNum = randItem.nextInt(3);
//				itemNum = randItem.nextInt(4);
//				spawnXpos = ThreadLocalRandom.current().nextInt(blocks.get(blockNum).getXPos(), blocks.get(blockNum).getXPos()+blocks.get(blockNum).width);
//				spawnYpos = blocks.get(blockNum).getYPos()-30;
//				switch(itemNum){
//				case 0: addEntity(new Item(spawnXpos,spawnYpos,30,30,ObjectType.TrashBag, this));
//				break;
//				case 1: addEntity(new Item(spawnXpos,spawnYpos,30,30,ObjectType.Hay, this));
//				break;
//				case 2: addEntity(new Item(spawnXpos,spawnYpos,30,30,ObjectType.Seeds, this));
//				break;
//				case 3: addEntity(new Item(spawnXpos,spawnYpos,30,30,ObjectType.Compost, this));
//				break;
//				}
//			}
//			else{
//				whatsNext = randItem.nextInt(2);
//				if(whatsNext == 0){
//					blockNum = randItem.nextInt(3);
//					itemNum = randItem.nextInt(4);
//					switch(itemNum){
//					case 0: addEntity(new Item(spawnXpos,spawnYpos,30,30,ObjectType.TrashBag, this));
//					break;
//					case 1: addEntity(new Item(spawnXpos,spawnYpos,30,30,ObjectType.Hay, this));
//					break;
//					case 2: addEntity(new Item(spawnXpos,spawnYpos,30,30,ObjectType.Seeds, this));
//					break;
//					case 3: addEntity(new Item(spawnXpos,spawnYpos,30,30,ObjectType.Compost, this));
//					break;
//					}
//				}
//				else{
//					itemNum = randItem.nextInt(4);
//					switch(itemNum){
//					case 0: addEntity(new Obstacle(Game.WIDTH * Game.SCALE+100,70,100,Game.HEIGHT*Game.SCALE,ObjectType.People, this));
//					break;
//					case 1: addEntity(new Obstacle(Game.WIDTH * Game.SCALE+100,70,100,Game.HEIGHT*Game.SCALE,ObjectType.Chemicals, this));
//					break;
//					case 2: addEntity(new Obstacle(Game.WIDTH * Game.SCALE+100,70,100,Game.HEIGHT*Game.SCALE,ObjectType.EmptySoil, this));
//					break;
//					case 3: addEntity(new Obstacle(Game.WIDTH * Game.SCALE+100,70,100,Game.HEIGHT*Game.SCALE,ObjectType.DeadSoil, this));
//					break;
//					}
//				}
//			}
//		}
		if(itemThrownC){
			boolean haveItem = false;
			itemThrownC = false;
			switch(thrownType){
			case TrashBag:
				if(useTrashb){
					haveItem = true;
					crabby.trashBagCnt -= 1;
					if(crabby.trashBagCnt == 0){
						useTrashb = false;
					}
				}
				break;
			case Hay:
				if(useHay){
					haveItem = true;
					crabby.hayCnt -= 1;
					if(crabby.hayCnt == 0){
						useHay = false;
					}
				}
				break;
			case Seeds:
				if(useSeeds){
					haveItem = true;
					crabby.seedCnt-= 1;
					if(crabby.seedCnt == 0){
						useSeeds = false;
					}
				}
				break;
			case Compost: 
				if(useComp){
					haveItem = true;
					crabby.compCnt -= 1;
					if(crabby.compCnt == 0){
						useComp = false;
					}
				}
				break;
			case Oyster: 
				if(useOyster){
					haveItem = true;
					crabby.oysterCnt -= 1;
					if(crabby.oysterCnt == 0){
						useComp = false;
					}
				}
				break;
			case Trash: 
				if(useTrash){
					haveItem = true;
					crabby.trashCnt -= 1;
					if(crabby.trashCnt == 0){
						useComp = false;
					}
				}
				break;
			case Recycling: 
				if(useRecycling){
					haveItem = true;
					crabby.recycleCnt -= 1;
					if(crabby.recycleCnt == 0){
						useComp = false;
					}
				}
				break;
			}
			if(haveItem){
				Item thrownItem = new Item(crabby.getXPos(),crabby.getYPos(),30,30,thrownType,this);
				thrownItem.isThrown = true;
				addItem(thrownItem);
			}
			else{
				System.out.println("Can't use that item!");
			}
		}
	}
}

	
	
	
