package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameController;
import game.Game;

public class ObstacleTest {

	static Obstacle o;
	static GameController gc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gc = new GameController();
		o = new Obstacle(2300,150, 0, 0, 70,70,ObjectType.People, RangeType.Short, false, false, Game.gameControl);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gc = null;
		o = null;
	}
	
	@Test
	public void testXY(){
		o.setInitX(1);
		o.setInitY(1);
		o.setXPos(2);
		o.setYPos(2);
		assertEquals("XPos should be 2",o.getXPos(), 2);
		assertEquals("YPos should be 2",o.getYPos(), 2);
		assertEquals("initX should be 1",o.getInitX(), 1);
		assertEquals("initY should be 1",o.getInitY(), 1);
		o.setxVel(3);
		o.setyVel(3);
		assertEquals("XVel should be 3",o.getxVel(), 3);
		assertEquals("YVel should be 3",o.getyVel(), 3);
		o.setWidth(4);
		o.setHeight(4);
		assertEquals("Width should be 4",o.getWidth(), 4);
		assertEquals("Height should be 4",o.getHeight(), 4);
		o.throwItem();
		assertEquals("xVel should be 3",o.getxVel(), 7);
	}
	
	@Test
	public void testBooleans(){
		o.setHor(true);
		assertEquals("isHor should be true",o.isHor(), true);
		o.setVert(true);
		assertEquals("isVert should be true",o.isVert(), true);
		assertEquals("Object type should be People",o.getType(), ObjectType.People);
		assertEquals("Range type should be Short",o.getRange(), RangeType.Short);
	}
	
	@Test
	public void testBounds(){
		o.getBounds();
		o.getBottomBounds();
		o.getTopBounds();
		o.getLeftBounds();
		o.getRightBounds();
	}
	
	@Test
	public void testOtherStuff(){
		o=new Obstacle(2300,150, 0, 0, 70,70,ObjectType.Chemicals, RangeType.Short, false, false, Game.gameControl);
		o=new Obstacle(2300,150, 0, 0, 70,70,ObjectType.DeadSoil, RangeType.Short, false, false, Game.gameControl);
		o=new Obstacle(2300,150, 0, 0, 70,70,ObjectType.EmptySoil, RangeType.Short, false, false, Game.gameControl);
		o=new Obstacle(2300,150, 0, 0, 70,70,ObjectType.Erosion, RangeType.Short, false, false, Game.gameControl);
		o=new Obstacle(2300,150, 0, 0, 70,70,ObjectType.Trash, RangeType.Short, false, false, Game.gameControl);
		o.update();
	}

}
