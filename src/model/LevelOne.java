package model;

import game.Game;

import java.util.LinkedList;

public class LevelOne {
	private LinkedList<Block> blocks = new LinkedList<Block>();

	public void fillBlocks(){
		blocks.add(new Platform(0,200,400,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(800,500,400,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(1200,300,400,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(1600,600,400,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(2000,300,400,30,ObjectType.Wall,Game.gameControl));
		blocks.add(new Platform(2500,600,400,30,ObjectType.Wall,Game.gameControl));
		blocks.getLast().isFinal = true;
		blocks.add(new Floor(300,Game.HEIGHT*Game.SCALE-64,800,64,ObjectType.Wall,Game.gameControl));
		//Game.gameControl.blocks = blocks;
	}
	
	public LinkedList<Block> getBlocks(){
		return this.blocks;
	}
}