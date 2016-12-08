package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameController;
import game.Game;
import model.ObjectType;

public class CrabbyTest {
	
	static GameController gc;
	static Crabby c;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gc = new GameController();
		c = new Crabby(300,512,64,64,ObjectType.Crabby,gc);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gc = null;
		c = null;
	}

	@Test
	public void setCoordinatesTest() {
		c.setXPos(400);
		c.setYPos(500);
		
		assertEquals("XPos should be 400",c.getXPos(), 400);
		assertEquals("YPos should be 500",c.getYPos(), 500);
	}
	
	@Test
	public void setVelocitiesTest() {
		c.setxVel(10);
		c.setyVel(5);
		
		assertEquals("XVel should be 10",c.getxVel(), 10);
		assertEquals("YVel should be 5",c.getyVel(), 5);
	}
	
	@Test
	public void moveTest() {
		c.setXPos(400);
		c.setYPos(500);
		c.setxVel(10);
		c.setyVel(5);
		c.move();
		assertEquals("XPos should increment by xVel (10), so 410",c.getXPos(), 410);
		assertEquals("YPos should increment by yVel (5), so 505", c.getYPos(), 505);
	}
	
	@Test
	public void setGravityTest(){
		c.setGravity(8);
		
		assertEquals(8,c.getGravity(), .001);
	}
	
	@Test
	public void setDimensionsTest(){
		c.setHeight(80);
		c.setWidth(80);
		
		assertEquals("Height should be 80",c.getHeight(), 80);
		assertEquals("Width should be 80",c.getWidth(), 80);
		
		assertEquals("Object type is Crabby",c.getType(), ObjectType.Crabby);
	}
	
	@Test
	public void swimTest(){
		c.setXPos(400);
		c.setYPos(500);
		c.setyVel(0);
		c.swim();
		assertEquals("XPos should increment by 1, so 401",c.getXPos(), 401);
		assertEquals("YPos should increment by yVel (0), so 500", c.getYPos(), 500);
		c.swimUp();
		assertEquals("XPos should increment by gravity (.1), so 401",c.getXPos(), 401);
		assertEquals("YPos should increment by yVel (0), so 500", c.getYPos(), 500);
		c.swimDown();
		assertEquals("XPos should decrement by gravity (.1), so 401",c.getXPos(), 401);
		assertEquals("YPos should increment by yVel (0), so 500", c.getYPos(), 500);
		
		c.setSwimUp(true);
		assertEquals("SwimUp should be true",c.isSwimUp(),true);
		c.setSwimDown(true);
		assertEquals("SwimDown should be true",c.isSwimDown(),true);
		
	}	
	
	@Test
	public void jumpTest(){
		c.setXPos(400);
		c.setYPos(500);
		c.setyVel(0);
		c.jump();
		System.out.println(c.getXPos());
		System.out.println(c.getYPos());
		assertEquals("XVel should increment by gravity (.1), so 400",c.getXPos(), 400);
		assertEquals("YVel should increment by yVel (0), so 500", c.getYPos(), 500);
		c.fall();
		assertEquals("XVel should increment by gravity (.1), so 400",c.getXPos(), 400);
		assertEquals("YVel should increment by yVel (0), so 500", c.getYPos(), 500);
		c.rise();
		assertEquals("YPos should decrement by 5, so -5", c.getyVel(), -5);
		c.setyVel(0);
		c.setJumping(true);
		assertEquals("isJumping should be true",c.isJumping(),true);
		c.setFalling(true);
		assertEquals("isFalling should be true",c.isFalling(),true);
		c.setRising(true);
		assertEquals("isRising should be true",c.isRising(),true);
		c.setGone(true);
		assertEquals("isGone should be true",c.isGone(),true);
	}
	
	@Test
	public void testBounds(){
		c.getBounds();
		c.getBottomBounds();
		c.getTopBounds();
		c.getLeftBounds();
		c.getRightBounds();
	}
	
	@Test
	public void testUpdate(){
		c.setLives(0);
		c.update();
		c.setLives(4);
		//Game.setLevel(1);
		c.setXPos(Game.WIDTH);
		c.update();
		c.setXPos(Game.WIDTH - c.getWidth());
		c.update();
		
	}
	
	@Test
	public void testUpdate2(){
		c.setLives(4);
		Game.setLevel(1);
		assertEquals("Lives should be 4",c.getLives(), 4);
		c.addObject(new Item(1300,150, 0, 0, 40,30,ObjectType.TrashBag, RangeType.Short, false, false, gc));
		c.remove();
		c.setCaught(true);
		assertEquals("Caught should be true",c.isCaught(), true);
		c.setGabionsGone(true);
		assertEquals("GabionsGone should be true",c.getGabionsGone(), true);
		c.isDone(true);
		c.getGabions();
		c.removeGabion();
		//c.die();
	}
	
//	@Test
//	public void jumpTest(){
//		c.setJumping(true);
//		
//	}

}
