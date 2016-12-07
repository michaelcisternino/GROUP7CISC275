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

	/**
	 * Creates blocks for the level and adds them to the level's list of blocks. Block positions are predetermined.
	 * The last block in the list is set as the level's final block.
	 * Floors are then created and added to the list.
	 */
	public void fillBlocks(){
		blocks.add(new Platform(1,1,1,1,1,1,ObjectType.Wall,RangeType.Short,false,false,Game.gameControl));
		blocks.getLast().isLegend = true;
		
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
		
		blocks.getLast().setFinal(true);
		blocks.add(new Platform(300,Game.HEIGHT*Game.SCALE-100,0,0,1000,100,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
	}
	
	/**
	 * Creates items for the level. Level two uses trash bags.
	 * Items are added to the level's list of items.
	 */
	public void fillObjects(){
		// Trash bags
		levelObjects.add(new Item(1700,150, 0, 0, 40,30,ObjectType.TrashBag, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(2800,250, 0, 0, 40,30,ObjectType.TrashBag, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(3300,200, 0, 0, 40,30,ObjectType.TrashBag, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(3800,450, 0, 0, 40,30,ObjectType.TrashBag, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(4300,350, 0, 0, 40,30,ObjectType.TrashBag, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(4800,350, 0, 0, 40,30,ObjectType.TrashBag, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(5800,450, 0, 0, 40,30,ObjectType.TrashBag, RangeType.Long, false, false, Game.gameControl));		
	}
	
	/**
	 * Creates obstacles for the level and adds them to the list of obstacles.
	 * Level two uses people as obstacles.
	 */
	public void fillObstacles(){
		levelObjects.add(new Obstacle(2300,150, 0, 0, 70,70,ObjectType.People, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(3000,550, 0, 0, 70,70,ObjectType.People, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(3300,400, 0, 0, 70,70,ObjectType.People, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(3600,550 , 0, 0, 70,70,ObjectType.People, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(4100,250, 0, 0, 70,70,ObjectType.People, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(4950,300, 0, 0, 70,70,ObjectType.People, RangeType.Long, false, false, Game.gameControl));
	}
	
	/**
	 * @return blocks The list of blocks.
	 */
	public LinkedList<Block> getBlocks(){
		return this.blocks;
	}
	
	/**
	 * @return levelObjects the list of objects.
	 */
	public LinkedList<InteractiveObject> getObjects(){
		return this.levelObjects;
	}
}
