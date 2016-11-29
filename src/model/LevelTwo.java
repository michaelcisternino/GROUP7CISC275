package model;

import game.Game;

import java.util.LinkedList;
/**
 * Level 2 builder
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class LevelTwo {
	private LinkedList<Block> blocks = new LinkedList<Block>();
	private LinkedList<InteractiveObject> levelObjects = new LinkedList<InteractiveObject>();
//	private LinkedList<InteractiveObject> enemies = new LinkedList<InteractiveObject>();

	/**
	 * Creates blocks for the level and adds them to the level's list of blocks. Block positions are predetermined.
	 * The last block in the list is set as the level's final block.
	 * Floors are then created and added to the list.
	 */
	public void fillBlocks(){
		blocks.add(new Platform(1200,600,0,-1,300,30,ObjectType.Wall, RangeType.Short, true, false, Game.gameControl));
		blocks.add(new Platform(1600,400,0,-1,200,30,ObjectType.Wall, RangeType.Mid, true, false, Game.gameControl));
		blocks.add(new Platform(2000,400,0,-1,400,30,ObjectType.Wall, RangeType.Short, true, false, Game.gameControl));
		blocks.add(new Platform(2700,300,0,0,300,30,ObjectType.Wall,RangeType.Mid, true, false, Game.gameControl));
		blocks.add(new Platform(3400,300,-1,0,200,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(3700,500,0,0,300,30,ObjectType.Wall,RangeType.Mid, false, true, Game.gameControl));
		blocks.add(new Platform(4400,400,0,0,200,30,ObjectType.Wall,RangeType.Mid, true, false, Game.gameControl));
		blocks.add(new Platform(4700,400,-1,0,400,30,ObjectType.Wall,RangeType.Short, false, true, Game.gameControl));
		blocks.add(new Platform(5200,200,0,0,300,30,ObjectType.Wall,RangeType.Mid, true, false, Game.gameControl));
		blocks.add(new Platform(5700,300,0,0,200,30,ObjectType.Wall,RangeType.Short, false, true, Game.gameControl));
		blocks.add(new Platform(6200,500,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		
		blocks.getLast().isFinal = true;
		blocks.add(new Floor(300,Game.HEIGHT*Game.SCALE-100,0,0,1000,100,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		//Game.gameControl.blocks = blocks;
	}
	
	/**
	 * Creates items for the level. Level two uses trash bags.
	 * Items are added to the level's list of items.
	 */
	public void fillObjects(){
		// Trash bags
		levelObjects.add(new Item(1700,150,40,30,ObjectType.TrashBag,Game.gameControl));
		levelObjects.add(new Item(2800,250,40,30,ObjectType.TrashBag,Game.gameControl));
		levelObjects.add(new Item(3300,200,40,30,ObjectType.TrashBag,Game.gameControl));
		levelObjects.add(new Item(3800,450,40,30,ObjectType.TrashBag,Game.gameControl));
		levelObjects.add(new Item(4300,350,40,30,ObjectType.TrashBag,Game.gameControl));
		levelObjects.add(new Item(4800,350,40,30,ObjectType.TrashBag,Game.gameControl));
		levelObjects.add(new Item(5800,450,40,30,ObjectType.TrashBag,Game.gameControl));		
	}
	
	/**
	 * Creates obstacles for the level and adds them to the list of obstacles.
	 * Level two uses people as obstacles.
	 */
	public void fillObstacles(){
		levelObjects.add(new Obstacle(2300,150,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(3000,550,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(3300,400,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(3600,550 ,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(4100,250,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(4950,300,70,70,ObjectType.People,Game.gameControl));
//		levelObjects.add(new Obstacle(5800,450,70,70,ObjectType.People,Game.gameControl));	
	}
	
	/**
	 * Gets the list of blocks.
	 * @return this.blocks.
	 */
	public LinkedList<Block> getBlocks(){
		return this.blocks;
	}
	
	/**
	 * Gets the list of objects.
	 * @return this.levelObjects
	 */
	public LinkedList<InteractiveObject> getObjects(){
		return this.levelObjects;
	}
}
