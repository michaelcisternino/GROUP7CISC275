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

		
		blocks.add(new Platform(900,500,1,0,300,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(1600,350,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(2000,500,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(2500,350,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(2500,300,1,0,50,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(2900,250,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(3000,300,1,0,50,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(3300,350,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(2900,500,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(3800,450,0,-1,200,30,ObjectType.Wall,RangeType.Long, true, false, Game.gameControl));
		blocks.add(new Platform(4200,200,0,0,400,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(4200,400,0,0,400,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(4900,500,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(5700,450,1,0,400,30,ObjectType.Wall,RangeType.Mid, false, true, Game.gameControl));
		blocks.add(new Platform(5700,150,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(6300,300,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(6800,250,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(7300,200,0,0,100,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(7500,200,0,1,300,30,ObjectType.Wall,RangeType.Long, true, false, Game.gameControl));
		blocks.add(new Platform(8000,500,0,0,400,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(8400,450,1,0,300,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(9000,300,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(9200,300,0,-1,200,30,ObjectType.Wall,RangeType.Short, true, false, Game.gameControl));
		blocks.add(new Platform(9400,250,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(9800,400,1,0,200,30,ObjectType.Wall,RangeType.Short, false, true, Game.gameControl));
		blocks.add(new Platform(10100,500,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(10700,500,0,0,400,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(11300,400,0,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(11700,250,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		
		blocks.add(new Platform(0,Game.HEIGHT*Game.SCALE-100,0,0,1000,100,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(5500,Game.HEIGHT*Game.SCALE-100,0,0,600,100,ObjectType.Wall,RangeType.Short,false, false, Game.gameControl));
		blocks.add(new Platform(10500,Game.HEIGHT*Game.SCALE-100,0,0,600,100,ObjectType.Wall,RangeType.Short,false, false, Game.gameControl));

		blocks.add(new Platform(12000,500,0,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.getLast().setFinal(true);
		
	}
	
	/**
	 * Creates items for the level. Level three uses hay, compost, and seeds.
	 * Items are added to the level's list of items.
	 */
	public void fillObjects(){
		// Oysters
//		levelObjects.add(new Item(1000,150, -1, 0, 40,30,ObjectType.Hay, RangeType.Short, false, true, Game.gameControl));
//		levelObjects.add(new Item(2800,250, 0, 0, 40,30,ObjectType.Hay, RangeType.Long, false, false, Game.gameControl));
//		levelObjects.add(new Item(3300,200, 0, 0, 40,30,ObjectType.Compost, RangeType.Long, false, false, Game.gameControl));
//		levelObjects.add(new Item(3800,450, 0, 0, 40,30,ObjectType.Compost, RangeType.Long, false, false, Game.gameControl));
//		levelObjects.add(new Item(4300,350, 0, 0, 40,30,ObjectType.Compost, RangeType.Long, false, false, Game.gameControl));
//		levelObjects.add(new Item(4800,350, 0, 0, 40,30,ObjectType.Seeds, RangeType.Long, false, false, Game.gameControl));
//		levelObjects.add(new Item(5800,450, 0, 0, 40,30,ObjectType.Seeds, RangeType.Long, false, false, Game.gameControl));		
		
		levelObjects.add(new Item(1000,470, 1, 0, 40,30,ObjectType.Hay, RangeType.Long, false, true, Game.gameControl));
		
	}
	
	/**
	 * Creates obstacles for the level and adds them to the list of obstacles.
	 * Level three uses chemicals, dead soil, and empty soil as obstacles.
	 */
	public void fillObstacles(){
		levelObjects.add(new Obstacle(2300,150, 0, 0, 70,70,ObjectType.Chemicals, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(3000,550, 0, 0, 70,70,ObjectType.Chemicals, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(3300,400, 0, 0, 70,70,ObjectType.DeadSoil, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(3600,550 , 0, 0, 70,70,ObjectType.DeadSoil, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(4100,250, 0, 0, 70,70,ObjectType.EmptySoil, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(4950,300, 0, 0, 70,70,ObjectType.EmptySoil, RangeType.Long, false, false, Game.gameControl));
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
