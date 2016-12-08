package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameController;
import game.Game;

public class ItemTest {

	static Item i;
	static GameController gc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gc = new GameController();
		i = new Item(1300,150, 0, 0, 40,30,ObjectType.Oyster, RangeType.Short, false, false, gc);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gc = null;
		i = null;
	}
	
	@Test
	public void testXY(){
		i.setInitX(1);
		i.setInitY(1);
		i.setXPos(2);
		i.setYPos(2);
		assertEquals("XPos should be 2",i.getXPos(), 2);
		assertEquals("YPos should be 2",i.getYPos(), 2);
		assertEquals("initX should be 1",i.getInitX(), 1);
		assertEquals("initY should be 1",i.getInitY(), 1);
		i.setxVel(3);
		i.setyVel(3);
		assertEquals("XVel should be 3",i.getxVel(), 3);
		assertEquals("YVel should be 3",i.getyVel(), 3);
		i.setWidth(4);
		i.setHeight(4);
		assertEquals("Width should be 4",i.getWidth(), 4);
		assertEquals("Height should be 4",i.getHeight(), 4);
		i.throwItem();
		assertEquals("xVel should be 3",i.getxVel(), 7);
	}
	
	@Test
	public void testBooleans(){
		i.setHor(true);
		assertEquals("isHor should be true",i.isHor(), true);
		i.setVert(true);
		assertEquals("isVert should be true",i.isVert(), true);
		assertEquals("Object type should be Oyster",i.getType(), ObjectType.Oyster);
		assertEquals("Range type should be Short",i.getRange(), RangeType.Short);
		i.setThrown(true);
		assertEquals("isThrown should be true",i.isThrown(), true);
		i.fall();
	}
	
	@Test
	public void testBounds(){
		i.getBounds();
		i.getBottomBounds();
		i.getTopBounds();
		i.getLeftBounds();
		i.getRightBounds();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testOtherStuff(){
		i.addObject(i);
		i.remove();
		i.setGravity(0);
		i.setGabionsGone(true);
		assertEquals("GabionsGone should be true",i.gabionsGone(),true);
		i.isFalling();
		i=new Item(1300,150, 0, 0, 40,30,ObjectType.TrashBag, RangeType.Short, false, false, gc);
		i=new Item(1300,150, 0, 0, 40,30,ObjectType.Hay, RangeType.Short, false, false, gc);
		i=new Item(1300,150, 0, 0, 40,30,ObjectType.Compost, RangeType.Short, false, false, gc);
		i=new Item(1300,150, 0, 0, 40,30,ObjectType.Seeds, RangeType.Short, false, false, gc);
		i=new Item(1300,150, 0, 0, 40,30,ObjectType.Trash, RangeType.Short, false, false, gc);
		i=new Item(1300,150, 0, 0, 40,30,ObjectType.Recycling, RangeType.Short, false, false, gc);
		assertEquals("Gravity should be 0",i.getGravity(),0);
		i.update();
	}

}
