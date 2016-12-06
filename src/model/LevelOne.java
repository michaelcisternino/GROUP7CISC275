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
		blocks.add(new Platform(1000,300,0,0,30,300,ObjectType.Wall,RangeType.Mid,true,false, Game.gameControl));
		blocks.add(new Platform(1600,100,0,0,20,300,ObjectType.Wall,RangeType.Short,true,false, Game.gameControl));
		blocks.add(new Platform(2200,200,0,0,40,300,ObjectType.Wall,RangeType.Long,true,false, Game.gameControl));
		blocks.add(new Platform(2700,50,0,0,30,300,ObjectType.Wall,RangeType.Short,true,false,Game.gameControl));
		blocks.add(new Platform(3200,100,0,0,20,300,ObjectType.Wall,RangeType.Long,true,false,Game.gameControl));
		blocks.add(new Platform(3700,300,0,0,30,300,ObjectType.Wall,RangeType.Mid,true,false,Game.gameControl));
		blocks.add(new Platform(4200,100,0,0,20,300,ObjectType.Wall,RangeType.Long,true,false,Game.gameControl));
		blocks.add(new Platform(4700,200,0,0,40,300,ObjectType.Wall,RangeType.Short,true,false,Game.gameControl));
		blocks.add(new Platform(5200,100,0,0,30,300,ObjectType.Wall,RangeType.Long,true,false,Game.gameControl));
		blocks.add(new Platform(5700,200,0,0,20,300,ObjectType.Wall,RangeType.Mid,true,false,Game.gameControl));
		blocks.add(new Platform(6200,300,0,0,300,30,ObjectType.Wall,RangeType.None,false,false,Game.gameControl));
		
		blocks.getLast().setFinal(true);
		blocks.add(new Floor(300,Game.HEIGHT*Game.SCALE-100,0,0,1000,100,ObjectType.Wall,RangeType.None,false,false,Game.gameControl));
		blocks.add(new Floor(2400,Game.HEIGHT*Game.SCALE-100,0,0,600,100,ObjectType.Wall,RangeType.None,false,false,Game.gameControl));
		blocks.add(new Floor(3000,Game.HEIGHT*Game.SCALE-100,0,0,1000,100,ObjectType.Wall,RangeType.None,false,false,Game.gameControl));
	}
	
	/**
	 * Creates items for the level. Level one only has oysters as objects.
	 * Items are added to the level's list of items.
	 */
	public void fillObjects(){
		// Oysters
		levelObjects.add(new Item(1300,150,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(1500,250,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(2000,200,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(2400,450,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(2800,250,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(3100,350,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(3600,450,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(4000,150,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(4400,200,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(4800,300,40,30,ObjectType.Oyster,Game.gameControl));
		levelObjects.add(new Item(5300,150,400,30,ObjectType.Oyster,Game.gameControl));
	}
	
	/**
	 * Creates obstacles for the level and adds them to the list of obstacles.
	 */
	public void fillObstacles(){
		levelObjects.add(new Obstacle(2300,150,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(3000,550,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(3300,400,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(3600,550 ,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(4100,250,70,70,ObjectType.People,Game.gameControl));
		levelObjects.add(new Obstacle(4950,300,70,70,ObjectType.People,Game.gameControl));
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