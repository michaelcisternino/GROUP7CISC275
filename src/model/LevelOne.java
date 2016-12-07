package model;

import game.Game;

import java.util.LinkedList;

/**
 * Level 1 builder
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class LevelOne {
	private LinkedList<Block> blocks = new LinkedList<Block>();
	private LinkedList<InteractiveObject> levelObjects = new LinkedList<InteractiveObject>();
//	private LinkedList<InteractiveObject> enemies = new LinkedList<InteractiveObject>();

	/**
	 * Creates blocks for the level and adds them to the level's list of blocks. Block positions are predetermined.
	 * The last block in the list is set as the level's final block.
	 * Floors are then created and added to the list.
	 */
	public void fillBlocks(){
		blocks.add(new Platform(1,1,1,1,1,1,ObjectType.Wall,RangeType.Short,false,false,Game.gameControl));
		blocks.getLast().isLegend = true;
		
		blocks.add(new Platform(1000,200,0,0,257,310,ObjectType.Net,RangeType.Mid,true,false, Game.gameControl));
		blocks.add(new Platform(1600,100,0,0,257,310,ObjectType.Net,RangeType.Short,true,false, Game.gameControl));
		blocks.add(new Platform(2200,100,0,0,257,310,ObjectType.Net,RangeType.Long,true,false, Game.gameControl));
		blocks.add(new Platform(2700,50,0,0,257,310,ObjectType.Net,RangeType.Short,true,false,Game.gameControl));
		blocks.add(new Platform(3200,100,0,0,257,310,ObjectType.Net,RangeType.Long,true,false,Game.gameControl));
		blocks.add(new Platform(3700,300,0,0,257,310,ObjectType.Net,RangeType.Mid,true,false,Game.gameControl));
		blocks.add(new Platform(4200,100,0,0,257,310,ObjectType.Net,RangeType.Long,true,false,Game.gameControl));
		blocks.add(new Platform(4700,200,0,0,257,310,ObjectType.Net,RangeType.Short,true,false,Game.gameControl));
		blocks.add(new Platform(5200,100,0,0,257,310,ObjectType.Net,RangeType.Long,true,false,Game.gameControl));
		blocks.add(new Platform(5700,200,0,0,257,310,ObjectType.Net,RangeType.Mid,true,false,Game.gameControl));
		//blocks.add(new Platform(6200,300,0,0,257,310,ObjectType.Wall,RangeType.None,false,false,Game.gameControl));
		
		//blocks.getLast().setFinal(true);
		blocks.add(new Platform(0,Game.HEIGHT*Game.SCALE-100,0,0,7000,100,ObjectType.Wall,RangeType.None,false,false,Game.gameControl));
	}
	
	/**
	 * Creates items for the level. Level one only has oysters as objects.
	 * Items are added to the level's list of items.
	 */
	public void fillObjects(){
		// Oysters
		levelObjects.add(new Item(1300,150, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(1500,250, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(2000,200, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(2400,450, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(2800,250, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(3100,350, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(3600,450, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(4000,150, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(4400,200, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(4800,300, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(5300,150, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
	}
	
	/**
	 * Creates obstacles for the level and adds them to the list of obstacles.
	 */
	public void fillObstacles(){
		levelObjects.add(new Obstacle(6300,0,0,0,250,250,ObjectType.Gabion,RangeType.None,false,false,Game.gameControl));
		levelObjects.getLast().setFinal(true);
		levelObjects.add(new Obstacle(6300,100,0,0,250,250,ObjectType.Gabion,RangeType.None,false,false,Game.gameControl));
		levelObjects.getLast().setFinal(true);
		levelObjects.add(new Obstacle(6300,200,0,0,250,250,ObjectType.Gabion,RangeType.None,false,false,Game.gameControl));
		levelObjects.getLast().setFinal(true);
		levelObjects.add(new Obstacle(6300,300,0,0,250,250,ObjectType.Gabion,RangeType.None,false,false,Game.gameControl));
		levelObjects.getLast().setFinal(true);
		levelObjects.add(new Obstacle(6300,400,0,0,250,250,ObjectType.Gabion,RangeType.None,false,false,Game.gameControl));
		levelObjects.getLast().setFinal(true);
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
