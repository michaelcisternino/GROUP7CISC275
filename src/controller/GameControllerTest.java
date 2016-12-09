package controller;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Game;
import model.Block;
import model.Crabby;
import model.InteractiveObject;
import model.Item;
import model.ObjectType;
import model.Platform;
import model.RangeType;

public class GameControllerTest {
	
	static GameController gc;
	Item item = new Item(1300,250, 0, 0, 50,40,ObjectType.Oyster, RangeType.Short, false, false, gc);
	Platform block = new Platform(1000,150,0,0,257,310,ObjectType.Net,RangeType.Mid,true,false, gc);
	Item thrownItem = new Item(1300,250,-1,0,30,30,ObjectType.Hay,RangeType.None,false,false,Game.gameControl);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gc = new GameController();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gc = null;
	}
	
	@Test
	public void addEntityTest(){
		int curr_size = gc.entities.size();
		gc.addEntity(item);
		assertEquals("Length of entites should increase by 1, so there should be 1 item", gc.entities.size(), curr_size + 1);
	}
	
	@Test void removeEntityTest(){
		int curr_size = gc.entities.size();
		gc.removeEntity(item);
		assertEquals("Length of entites should decrease by 1, so there should be 0 items", gc.entities.size(), curr_size - 1);
	}
	
	@Test
	public void addBlockTest(){
		int curr_size = gc.blocks.size();
		gc.addBlock(block);
		assertEquals("Length of blocks should increase by 1, so there should be 1 block", gc.blocks.size(), curr_size + 1);
	}
	
	@Test void removeBlockTest(){
		int curr_size = gc.blocks.size();
		gc.removeBlock(block);
		assertEquals("Length of blocks should decrease by 1, so there should be 0 blocks", gc.blocks.size(), curr_size - 1);
	}
	
	@Test
	public void addItemTest(){
		int curr_size = gc.thrownItems.size();
		thrownItem.setThrown(true);
		gc.addThrownItem(item);
		assertEquals("Length of thrown items should increase by 1, so there should be 1 thrown item", gc.thrownItems.size(), curr_size + 1);
	}
	
	@Test void removeItemTest(){
		int curr_size = gc.thrownItems.size();
		thrownItem.setThrown(true);
		gc.removeThrownItem(item);
		assertEquals("Length of thrown items should decrease by 1, so there should be 0 thrown items", gc.thrownItems.size(), curr_size - 1);
	}
	
	
	

}
