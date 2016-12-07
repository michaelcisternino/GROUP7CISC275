package model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.GameController;

public class LevelTest {

	static LevelOne l1;
	static LevelTwo l2;
	static LevelThree l3;
	static GameController gc;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gc = new GameController();
		l1 = new LevelOne();
		l2 = new LevelTwo();
		l3 = new LevelThree();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		gc = null;
		l1 = null;
		l2 = null;
		l3 = null;
	}

	@Test
	public void TestL1(){
		l1.fillBlocks();
		l1.fillObjects();
		l1.fillObstacles();
		l1.getBlocks();
		l1.getObjects();
	}
	
	@Test
	public void TestL2(){
		l2.fillBlocks();
		l2.fillObjects();
		l2.fillObstacles();
		l2.getBlocks();
		l2.getObjects();
	}
	
	@Test
	public void TestL3(){
		l3.fillBlocks();
		l3.fillObjects();
		l3.fillObstacles();
		l3.getBlocks();
		l3.getObjects();
	}
}
