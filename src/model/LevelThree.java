package model;

import game.Game;

import java.util.LinkedList;

public class LevelThree {
	
	private LinkedList<Block> blocks = new LinkedList<Block>();
	private LinkedList<InteractiveObject> levelObjects = new LinkedList<InteractiveObject>();
//	private LinkedList<InteractiveObject> enemies = new LinkedList<InteractiveObject>();

	public void fillBlocks(){
		blocks.add(new Platform(1000,500,300,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(1600,300,200,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(2200,400,400,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(2700,200,300,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(3200,300,200,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(3700,500,300,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(4200,400,200,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(4700,400,400,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(5200,200,300,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(5700,300,200,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(6200,500,300,30,ObjectType.Wall,Game.gameControl));
	//	blocks.add(new Platform(500,200,400,30,ObjectType.Wall,Game.gameControl));
		
		blocks.getLast().isFinal = true;
		blocks.add(new Floor(300,Game.HEIGHT*Game.SCALE-100,1000,100,ObjectType.Wall,Game.gameControl));
		blocks.add(new Floor(2400,Game.HEIGHT*Game.SCALE-100,600,100,ObjectType.Wall,Game.gameControl));
		blocks.add(new Floor(3000,Game.HEIGHT*Game.SCALE-100,1000,100,ObjectType.Wall,Game.gameControl));
		//Game.gameControl.blocks = blocks;
	}
	
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
	
	public void fillObstacles(){
		levelObjects.add(new Obstacle(2300,150,70,70,ObjectType.Chemicals,Game.gameControl));
		levelObjects.add(new Obstacle(3000,550,70,70,ObjectType.Chemicals,Game.gameControl));
		levelObjects.add(new Obstacle(3300,400,70,70,ObjectType.DeadSoil,Game.gameControl));
		levelObjects.add(new Obstacle(3600,550 ,70,70,ObjectType.DeadSoil,Game.gameControl));
		levelObjects.add(new Obstacle(4100,250,70,70,ObjectType.EmptySoil,Game.gameControl));
		levelObjects.add(new Obstacle(4950,300,70,70,ObjectType.EmptySoil,Game.gameControl));
//		levelObjects.add(new Obstacle(5800,450,70,70,ObjectType.People,Game.gameControl));	
	}
	
	public LinkedList<Block> getBlocks(){
		return this.blocks;
	}
	
	public LinkedList<InteractiveObject> getObjects(){
		return this.levelObjects;
	}
}