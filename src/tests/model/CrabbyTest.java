package tests.model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameController;
import model.Crabby;
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
	}
	
//	@Test
//	public void jumpTest(){
//		c.setJumping(true);
//		
//	}

}
