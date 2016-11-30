package game;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;

import javax.swing.*;

import controller.GameController;
import controller.PlayerKeyHandler;
import model.Block;
import model.Crabby;
import model.ObjectType;
import model.Platform;
import model.Status;
import model.Floor;
import model.Item;
import model.LevelOne;
import model.LevelThree;
import model.LevelTwo;
import view.MainView;
/**
 * The master game class. Starts and runs the game, contains variables and game parts.
 * @author Alex Addeo
 * @author Zion Aranda
 * @author Katie Black
 * @author Michael Cisternino
 * @author Nick Hoffman
 *
 */
public class Game extends JFrame implements Runnable{

		public static final int WIDTH = 270;
		public static final int HEIGHT = WIDTH/14*10;
		public static final int SCALE = 4;
		public static final String TITLE = "Crabby";
		Random randItem = new Random();
		int itemNum;
		private static Container pane;
		private Thread gameThread;
		
		private boolean run = false;
		public static boolean playing = true;
		
		public MainView view;
		public static GameController gameControl;
		public static Game game;
		private StartScreen starter;
		public static Status status;
		private static int level = 2;
		private static boolean gameOver = false;
		
		/**
		 *  Initializes the game. Creates a game controller and the key listener. Sets focus on the game.
		 */
		private void init(){
			gameControl = new GameController();
			addKeyListener(new PlayerKeyHandler());
			setFocusable(true);
//			gameControl.addBlock(new Platform(0,200,400,30,ObjectType.Wall,gameControl));
			itemNum = randItem.nextInt(4);
			//System.out.println(itemNum);
//			gameControl.addBlock(new Platform(800,500,400,30,ObjectType.Wall,gameControl));
//			gameControl.addBlock(new Floor(300,HEIGHT*SCALE-64,800,64,ObjectType.Wall,gameControl));
//			switch(itemNum){
//			case 0: gameControl.addEntity(new Item(500,0,30,30,ObjectType.TrashBag, gameControl));
//			break;
//			case 1: gameControl.addEntity(new Item(500,0,30,30,ObjectType.Hay, gameControl));
//			break;
//			case 2: gameControl.addEntity(new Item(500,0,30,30,ObjectType.Seeds, gameControl));
//			break;
//			case 3: gameControl.addEntity(new Item(500,0,30,30,ObjectType.Compost, gameControl));
//			break;
//			}
		}
		
		/**
		 * Creates level one. Fills level one with blocks, objects, and obstacles.
		 * The game controller receives the obstacles and blocks, overwriting the previous level.
		 */
		private static void initLevelOne(){
			LevelOne levelOne = new LevelOne();
			// gameControl.blocks.clear();
			levelOne.fillBlocks();
			levelOne.fillObjects();
			levelOne.fillObstacles();
			gameControl.entities = levelOne.getObjects();
			gameControl.blocks = levelOne.getBlocks();
			//System.out.println("this big" +gameControl.blocks.size());
			// for(Block b: levelOne.getBlocks()){
			// gameControl.addBlock(b);
			// }
		}

		/**
		 * Creates level two. Fills level two with blocks, objects, and obstacles.
		 * The game controller receives the obstacles and blocks, overwriting the previous level.
		 * The character's position is reset back to the beginning of the level.
		 */
		public static void initLevelTwo(){
			LevelTwo levelTwo = new LevelTwo();
			//gameControl.blocks.clear();
			levelTwo.fillBlocks();
			levelTwo.fillObjects();
			levelTwo.fillObstacles();
			gameControl.blocks = levelTwo.getBlocks();
			gameControl.entities = levelTwo.getObjects();
			// for(Block b: levelTwo.getBlocks()){
			// gameControl.addBlock(b);
			// }
			gameControl.crabby.setXPos(gameControl.blocks.getFirst().getXPos() + 200);
			gameControl.crabby.setYPos(gameControl.blocks.getFirst().getYPos() - 100);
			gameControl.crabby.setFalling(true);
			System.out.println("HERE");
		}
		
		/**
		 * Creates level three. Fills level three with blocks, objects, and obstacles.
		 * The game controller receives the obstacles and blocks, overwriting the previous level.
		 * The character's position is reset back to the beginning of the level.
		 */
		public static void initLevelThree(){
			LevelThree levelThree = new LevelThree();
			//gameControl.blocks.clear();
			levelThree.fillBlocks();
			levelThree.fillObjects();
			levelThree.fillObstacles();
			gameControl.entities = levelThree.getObjects();
			gameControl.blocks = levelThree.getBlocks();
			// for(Block b: levelTwo.getBlocks()){
			// gameControl.addBlock(b);
			// }
			gameControl.crabby.setXPos(gameControl.blocks.getFirst().getXPos() + 200);
			gameControl.crabby.setYPos(gameControl.blocks.getFirst().getYPos() - 100);
			gameControl.crabby.setFalling(true);
			System.out.println("HERE");
		}

		/**
		 * Sets the game over flag to true.
		 */
		public static void gameOver(){
			gameOver = true;
		}
			
		/**
		 * Starts the game thread. Sets run to true.
		 */
		private synchronized void startGame(){
			init();
			if(run){
				return;
			}
			run = true;
			gameThread = new Thread(this, "Game Thread");
			gameThread.start();
		}
		
		/**
		 * Stops the game thread. If the thread is interrupted, the exception is printed.
		 */
		private synchronized void stopGame(){
			if(!run){
				return;
			}
			try {
				gameThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * Pauses the game thread. Run is set to false.
		 */
		public void pauseThread() throws InterruptedException{
			run = false;
		}

		/**
		 * Resumes the game thread. Run is set to true.
		 */
		public void resumeThread(){
			run = true;
		}
		
		//Implemented method from Runnable
		/**
		 * Controls timing by creating ticks and frames.
		 * Divides system time into ticks and frames. If the timer runs out, the game is stopped.
		 */
		public void run() {
			if(playing){
			requestFocus();
			long last = System.nanoTime();
			long timer = System.currentTimeMillis();
			double delta = 0.0;
			double nanos = 1000000000.0/60.0;
			int frames = 0;
			int ticks = 0;
			while(run){
				long curr = System.nanoTime();
				delta += (curr-last)/nanos;
				last = curr;
				while(delta >= 1){
					view.update();
					ticks++;
					delta--;
				}
				repaint();
				frames++;
				if((System.currentTimeMillis() - timer) > 1000){
					timer += 1000;
					frames = 0;
					ticks = 0;
				}
			}
			stopGame();
			}
		}
		
//		public void render(){
////			BufferStrategy buff = getBufferStrategy();
////			if(buff == null){
////				createBufferStrategy(3);
////				return;
////			}
////			g.setColor(Color.CYAN);
////			g.fillRect(0, 0, getWidth(), getHeight());
////			g.setColor(Color.LIGHT_GRAY);
////			g.fillRect(0, getHeight()-200, getWidth(), getHeight());
////			gameControl.draw(g);
//			//g.dispose();
//			//g.
//		}
		
//		public void update(){
//			
//		}
		
		//Game constructor
		/**
		 * Constructor for the game.
		 * Creates a pane for the game with specified size and creates the view and status bars.
		 * The start screen and the status bar are added to the pane.
		 */
		public Game() {
			System.out.println("in game constructor");
			setPane(getContentPane());
			Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
			setPreferredSize(size);
			setMaximumSize(size);
			setMinimumSize(size);
			view = new MainView();
			status = new Status();
			//view.add(start);
			//start.addActionListener(new StartButton());
			starter = new StartScreen(this);
			getPane().add(starter, BorderLayout.CENTER);
			getPane().add(status, BorderLayout.SOUTH);
		}
		
		/**
		 * Sets the game playing status.
		 * When the start button is clicked, it is removed from the view. The main game is added to the view and the game is started.
		 * A key listener is added to the pane and level is set to one. The level is passed to StartNextLevel.
		 * @param b
		 */
		public void setPlaying(boolean b){
			this.getContentPane().remove(starter);
			view = new MainView();
			pane.add(view, BorderLayout.CENTER);
			pane.validate();
			pane.addKeyListener(new PlayerKeyHandler());
			this.playing = b;
			// if(playing){
			this.startGame();
			// }
			level = 1;
			startNextLevel(level);
			// this.initLevelOne();
		}
		
		/**
		 * Switch statement to select which level to initialize. Calls the chosen level.
		 * @param level
		 */
		public static void startNextLevel(int level){
			switch(level){
			case 1: initLevelOne();
			break;
			case 2: initLevelTwo();
			break;
			case 3: initLevelThree();
			break;
			case 4: System.out.println("Game over!");
			break;
			}
		}

		/**
		 * Gets the current level.
		 * @return level
		 */
		public static int getLevel(){
			return level;
		}
		
		/**
		 * Sets the level to the given int.
		 * @param n
		 */
		public static void setLevel(int n){
			level = n;
		}
		
		class StartButton implements ActionListener{
			/**
			 * Listens for the start button being clicked. When it happens, the game is started.
			 */
			public void actionPerformed(ActionEvent e) {
				Game.game.startGame();
			}
		}
		
		//Main 
		/**
		 * Main function for the game. Links the thread and sets visible.
		 * @param args
		 */
		public static void main(String[] args) {
			game = new Game();
//			JFrame frame = new JFrame(TITLE);;
			game.pack();
			game.setResizable(false);
			game.setLocationRelativeTo(null);
			game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			game.setVisible(true);
			//game.startGame();
		}

		/**
		 * Gets the pane container.
		 * @return pane
		 */
		public static Container getPane() {
			return pane;
		}

		/**
		 * Sets the pane to the given container.
		 * @param pane
		 */
		public void setPane(Container pane) {
			this.pane = pane;
		}

		
}
