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
public class LevelOne implements java.io.Serializable{
	private LinkedList<Block> blocks = new LinkedList<Block>();
	private LinkedList<InteractiveObject> levelObjects = new LinkedList<InteractiveObject>();

	
	
	//Need to fix touching gabions removes them
	//if you hit a net after we make goingRight false
	// then it doesnt reset that if you die.
	// thatll be fixed in reset level area
	// oysters fly across the screen prob bc the move func in inter obj
	
	
	/**
	 * Creates blocks for the level and adds them to the level's list of blocks. Block positions are predetermined.
	 * The last block in the list is set as the level's final block.
	 * Floors are then created and added to the list.
	 */
	public void fillBlocks(){
		blocks.add(new Platform(1,1,1,1,1,1,ObjectType.Wall,RangeType.Short,false,false,Game.gameControl));
		blocks.getLast().isLegend = true;
		
		blocks.add(new Platform(1000,150,0,0,257,310,ObjectType.Net,RangeType.Mid,true,false, Game.gameControl));
		blocks.add(new Platform(1600,150,0,0,257,310,ObjectType.Net,RangeType.Short,true,false, Game.gameControl));
		blocks.add(new Platform(2200,75,0,0,257,310,ObjectType.Net,RangeType.Long,true,false, Game.gameControl));
		blocks.add(new Platform(2700,150,0,0,257,310,ObjectType.Net,RangeType.Short,true,false,Game.gameControl));
		blocks.add(new Platform(3200,75,0,0,257,310,ObjectType.Net,RangeType.Long,true,false,Game.gameControl));
		blocks.add(new Platform(3700,175,0,0,257,310,ObjectType.Net,RangeType.Mid,true,false,Game.gameControl));
		blocks.add(new Platform(4200,75,0,0,257,310,ObjectType.Net,RangeType.Long,true,false,Game.gameControl));
		blocks.add(new Platform(4700,100,0,0,257,310,ObjectType.Net,RangeType.Short,true,false,Game.gameControl));
		blocks.add(new Platform(5200,75,0,0,257,310,ObjectType.Net,RangeType.Long,true,false,Game.gameControl));
		blocks.add(new Platform(5700,150,0,0,257,310,ObjectType.Net,RangeType.Mid,true,false,Game.gameControl));
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
		levelObjects.add(new Item(1300,250, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(1500,350, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(2000,300, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(2400,450, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(2800,350, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(3100,350, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(3600,450, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(4000,250, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(4400,300, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(4800,300, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(5300,250, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
	
		// Floor oysters aka floysters 
		levelObjects.add(new Item(1300,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(1700,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(2000,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(2400,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(2800,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(3100,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(3600,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(4000,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(4400,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(4800,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));
		levelObjects.add(new Item(5300,625, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, Game.gameControl));

	}
	
	/**
	 * Creates obstacles for the level and adds them to the list of obstacles.
	 */
	public void fillObstacles(){
		levelObjects.add(new Obstacle(6300,0,0,0,300,400,ObjectType.EmptyGabion,RangeType.None,false,false,Game.gameControl));
		levelObjects.getLast().setFinal(true);
		levelObjects.add(new Obstacle(6300,100,0,0,300,400,ObjectType.EmptyGabion,RangeType.None,false,false,Game.gameControl));
		levelObjects.getLast().setFinal(true);
		levelObjects.add(new Obstacle(6300,200,0,0,300,400,ObjectType.EmptyGabion,RangeType.None,false,false,Game.gameControl));
		levelObjects.getLast().setFinal(true);
		levelObjects.add(new Obstacle(6300,300,0,0,300,400,ObjectType.EmptyGabion,RangeType.None,false,false,Game.gameControl));
		levelObjects.getLast().setFinal(true);
		levelObjects.add(new Obstacle(6300,400,0,0,300,400,ObjectType.EmptyGabion,RangeType.None,false,false,Game.gameControl));
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
