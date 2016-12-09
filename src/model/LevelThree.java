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
public class LevelThree implements java.io.Serializable{
	
	private LinkedList<Block> blocks = new LinkedList<Block>();
	private LinkedList<InteractiveObject> levelObjects = new LinkedList<InteractiveObject>();
	
	/**
	 * Creates platforms for the level and adds them to the level's list of blocks. Block positions are predetermined.
	 * The last platform in the list is set as the level's final platform.
	 */
	public void fillBlocks(){

		
		blocks.add(new Platform(1200,500,1200,0,300,30,ObjectType.Wall,RangeType.Long, false, false, Game.gameControl));
		blocks.add(new Platform(1600,350,1600,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(2000,500,2000,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(2500,350,2500,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(2700,300,2700,0,50,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(2900,250,2900,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(3200,300,3200,0,50,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(3300,350,3300,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(2900,500,2900,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(3800,450,3800,-1,200,30,ObjectType.Wall,RangeType.Long, true, false, Game.gameControl));
		blocks.add(new Platform(4200,200,4200,0,400,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(4200,400,4200,0,400,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(4900,500,4900,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(5800,450,5800,0,400,30,ObjectType.Wall,RangeType.Mid, false, true, Game.gameControl));
		blocks.add(new Platform(5700,150,5700,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(6300,300,6300,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(6800,250,6800,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(7300,200,7300,0,100,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(7500,100,7500,1,300,30,ObjectType.Wall,RangeType.Long, true, false, Game.gameControl));
		blocks.add(new Platform(8000,500,8000,0,400,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(8600,450,8600,0,300,30,ObjectType.Wall,RangeType.Long, false, true, Game.gameControl));
		blocks.add(new Platform(9000,300,9000,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(9200,200,9200,-1,200,30,ObjectType.Wall,RangeType.Short, true, false, Game.gameControl));
		blocks.add(new Platform(9400,250,9400,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(10000,400,10000,0,200,30,ObjectType.Wall,RangeType.Short, false, true, Game.gameControl));
		blocks.add(new Platform(10100,500,10100,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(10700,500,10700,0,400,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(11300,400,11300,0,300,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		blocks.add(new Platform(11700,250,11700,0,200,30,ObjectType.Wall,RangeType.Short, false, false, Game.gameControl));
		
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

		levelObjects.add(new Item(2100,320,1000, 0, 40,30,ObjectType.Hay, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(6300,550,1000, 0, 40,30,ObjectType.Hay, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(11300,550,1000, 0, 40,30,ObjectType.Hay, RangeType.Long, false, false, Game.gameControl));
		
		levelObjects.add(new Item(3000,220,1000, 0, 40,30,ObjectType.Seeds, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(4400,170,1000, 0, 40,30,ObjectType.Seeds, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(7325,170,1000, 0, 40,30,ObjectType.Seeds, RangeType.Long, false, false, Game.gameControl));
		
		levelObjects.add(new Item(3000,470,1000, 0, 40,30,ObjectType.Compost, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(5800,120,1000, 0, 40,30,ObjectType.Compost, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Item(8300,470,1000, 0, 40,30,ObjectType.Compost, RangeType.Long, false, false, Game.gameControl));
		

	}
	
	/**
	 * Creates obstacles for the level and adds them to the list of obstacles.
	 * Level three uses chemicals, dead soil, and empty soil as obstacles.
	 */
	public void fillObstacles(){
		
		levelObjects.add(new Obstacle(5000,440,1000, 0, 80,60,ObjectType.Chemicals, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(10800,440,1000, 0, 80,60,ObjectType.Chemicals, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(11800,190,1000, 0, 80,60,ObjectType.Chemicals, RangeType.Long, false, false, Game.gameControl));
		
		levelObjects.add(new Obstacle(4400,340,1000, 0, 80,60,ObjectType.EmptySoil, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(9100,240,1000, 0, 80,60,ObjectType.EmptySoil, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(9500,190,1000, 0, 80,60,ObjectType.EmptySoil, RangeType.Long, false, false, Game.gameControl));
		 
		levelObjects.add(new Obstacle(6400,240,1000, 0, 80,60,ObjectType.DeadSoil, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(6875,190,1000, 0, 80,60,ObjectType.DeadSoil, RangeType.Long, false, false, Game.gameControl));
		levelObjects.add(new Obstacle(10200,440,1000, 0, 80,60,ObjectType.DeadSoil, RangeType.Long, false, false, Game.gameControl));

		
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
