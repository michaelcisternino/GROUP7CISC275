package model;

import game.Game;

import java.util.LinkedList;
/**
 * Level 3 builder
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class LevelThree {
	
	private LinkedList<Block> blocks = new LinkedList<Block>();
	private LinkedList<InteractiveObject> levelObjects = new LinkedList<InteractiveObject>();
	
	/**
	 * Creates blocks for the level and adds them to the level's list of blocks. Block positions are predetermined.
	 * The last block in the list is set as the level's final block.
	 * Floors are then created and added to the list.
	 */
	public void fillBlocks(){		
		blocks.add(new Platform(1000,500,-1,0,200,30,ObjectType.Wall,RangeType.Short, false, true, Game.gameControl));
		blocks.add(new Platform(1300,300,0,1,200,30,ObjectType.Wall,RangeType.Short, true, false, Game.gameControl));
		blocks.add(new Platform(1700,650,-1,0,200,30,ObjectType.Wall,RangeType.Short, false, true, Game.gameControl));
		blocks.add(new Platform(2000,500,1,0,200,30,ObjectType.Wall,RangeType.Short, false, true, Game.gameControl));
		blocks.add(new Platform(2750,350,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(3000,275,-1,0,50,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(2800,400,1,0,50,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(3150,500,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(2800,200,0,0,400,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(3800,200,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(3500,200,0,1,200,30,ObjectType.Wall,RangeType.Long, true, false, Game.gameControl));
		blocks.add(new Platform(3800,500,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(4400,200,0,40,200,30,ObjectType.Wall,RangeType.Short, true, false, Game.gameControl));
		blocks.add(new Platform(4700,500,0,-1,100,30,ObjectType.Wall,RangeType.Long, true, false, Game.gameControl));
		blocks.add(new Platform(5000,300,0,1,200,30,ObjectType.Wall,RangeType.Short, true, false, Game.gameControl));
		blocks.add(new Platform(5400,200,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(5800,300,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(6300,500,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		
		blocks.getLast().setFinal(true);
		blocks.add(new Floor(300,Game.HEIGHT*Game.SCALE-100,0,0,1000,100,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Floor(2400,Game.HEIGHT*Game.SCALE-100,0,0,600,100,ObjectType.Wall,RangeType.Short,false, false, Game.gameControl));
	}
	
	/**
	 * Creates items for the level. Level three uses hay, compost, and seeds.
	 * Items are added to the level's list of items.
	 */
	public void fillObjects(){
		// Oysters
		levelObjects.add(new Item(1700,150,40,30,ObjectType.Hay,Game.gameControl));
		levelObjects.add(new Item(2800,250,40,30,ObjectType.Hay,Game.gameControl));
		levelObjects.add(new Item(3300,200,40,30,ObjectType.Compost,Game.gameControl));
		levelObjects.add(new Item(3800,450,40,30,ObjectType.Compost,Game.gameControl));
		levelObjects.add(new Item(4300,350,40,30,ObjectType.Compost,Game.gameControl));
		levelObjects.add(new Item(4800,350,40,30,ObjectType.Seeds,Game.gameControl));
		levelObjects.add(new Item(5800,450,40,30,ObjectType.Seeds,Game.gameControl));		
	}
	
	/**
	 * Creates obstacles for the level and adds them to the list of obstacles.
	 * Level three uses chemicals, dead soil, and empty soil as obstacles.
	 */
	public void fillObstacles(){
		levelObjects.add(new Obstacle(2300,150,70,70,ObjectType.Chemicals,Game.gameControl));
		levelObjects.add(new Obstacle(3000,550,70,70,ObjectType.Chemicals,Game.gameControl));
		levelObjects.add(new Obstacle(3300,400,70,70,ObjectType.DeadSoil,Game.gameControl));
		levelObjects.add(new Obstacle(3600,550 ,70,70,ObjectType.DeadSoil,Game.gameControl));
		levelObjects.add(new Obstacle(4100,250,70,70,ObjectType.EmptySoil,Game.gameControl));
		levelObjects.add(new Obstacle(4950,300,70,70,ObjectType.EmptySoil,Game.gameControl));
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
