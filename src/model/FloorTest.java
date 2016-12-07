package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameController;
import model.ObjectType;
import model.RangeType;

public class FloorTest {

	static Floor f;
	static GameController gc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gc = new GameController();
		f = new Floor(0, 0, 0, 0, 10, 15, ObjectType.Wall, RangeType.None, false, false, gc);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gc = null;
		f = null;
	}
	
	@Test
	public void testXY(){
		f.setInitX(1);
		f.setInitY(1);
		f.setXPos(2);
		f.setYPos(2);
		assertEquals("XPos should be 2",f.getXPos(), 2);
		assertEquals("YPos should be 2",f.getYPos(), 2);
		assertEquals("initX should be 1",f.getInitX(), 1);
		assertEquals("initY should be 1",f.getInitY(), 1);
		f.setxVel(3);
		f.setyVel(3);
		assertEquals("XVel should be 3",f.getxVel(), 3);
		assertEquals("YVel should be 3",f.getyVel(), 3);
		f.setWidth(4);
		f.setHeight(4);
		assertEquals("Width should be 4",f.getWidth(), 4);
		assertEquals("Height should be 4",f.getHeight(), 4);
		f.move();
		assertEquals("XPos should be 5",f.getXPos(), 5);
		assertEquals("YPos should be 5",f.getYPos(), 5);
		f.rise();
		assertEquals("YVel should be -2",f.getyVel(), -5);
	}
	
	@Test
	public void testBooleans(){
		f.setFinal(true);
		assertEquals("isFinal should be true",f.isFinal(), true);
		f.setHor(true);
		assertEquals("isHor should be true",f.isHor(), true);
		f.setVert(true);
		assertEquals("isVert should be true",f.isVert(), true);
		assertEquals("Object type should be Wall",f.getType(), ObjectType.Wall);
		assertEquals("Range type should be None",f.getRange(), RangeType.None);
	}
	
	@Test
	public void testBounds(){
		f.getBounds();
		f.getBottomBounds();
		f.getTopBounds();
		f.getLeftBounds();
		f.getRightBounds();
	}
	
	@Test
	public void testOtherStuff(){
		f.addBlock((Block) f);
		f.remove();
		f.createImage(null);
	}

}
