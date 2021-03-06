package game;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;

import controller.GameController;
import controller.MouseInput;
import controller.PlayerKeyHandler;
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
 */
public class Game extends JFrame implements Runnable, Serializable{

		public static final int WIDTH = 270;
		public static final int HEIGHT = WIDTH/14*10;
		public static final int SCALE = 4;
		private static Container pane;
		
		private transient Thread gameThread;
		private boolean run = false;
		public static boolean playing = true;
		
		public transient MainView view;
		public static transient GameController gameControl;
		public static Game game;
		private transient StartScreen starter;
		private transient GameOver endGame;
		private transient WinScreen winScreen;
		
		private transient TutorialScreen tut1 = new TutorialScreen(1);
		private transient TutorialScreen tut2 = new TutorialScreen(2);
		private transient TutorialScreen tut3 = new TutorialScreen(3);
		
		private transient MouseListener mi;
		
		private static int level = 0;
		
		/**
		 *  Initializes the game. Creates a game controller and the key listener. Sets focus on the game.
		 */
		private void init(){
			gameControl = new GameController();
			addKeyListener(new PlayerKeyHandler());
			setFocusable(true);
		}
		
		/**
		 * Creates level one. Fills level one with blocks, objects, and obstacles.
		 * The game controller receives the obstacles and blocks, overwriting the previous level.
		 */
		private static void initLevelOne(){
			LevelOne levelOne = new LevelOne();
			levelOne.fillBlocks();
			levelOne.fillObjects();
			levelOne.fillObstacles();
			gameControl.entities = levelOne.getObjects();
			gameControl.blocks = levelOne.getBlocks();
			gameControl.crabby.setSwimDown(true);
			gameControl.goingRight = true;
		}

		/**
		 * Creates level two. Fills level two with blocks, objects, and obstacles.
		 * The game controller receives the obstacles and blocks, overwriting the previous level.
		 * The character's position is reset back to the beginning of the level.
		 */
		public static void initLevelTwo(){
			LevelTwo levelTwo = new LevelTwo();
			levelTwo.fillBlocks();
			levelTwo.fillObjects();
			levelTwo.fillObstacles();
			gameControl.blocks = levelTwo.getBlocks();
			gameControl.entities = levelTwo.getObjects();
			gameControl.crabby.setXPos(gameControl.blocks.getFirst().getXPos() + 700);
			gameControl.crabby.setYPos(gameControl.blocks.getFirst().getYPos() - 100);
			gameControl.crabby.setFalling(true);
		}
		
		/**
		 * Creates level three. Fills level three with blocks, objects, and obstacles.
		 * The game controller receives the obstacles and blocks, overwriting the previous level.
		 * The character's position is reset back to the beginning of the level.
		 */
		public static void initLevelThree(){
			LevelThree levelThree = new LevelThree();
			levelThree.fillBlocks();
			levelThree.fillObjects();
			levelThree.fillObstacles();
			gameControl.entities = levelThree.getObjects();
			gameControl.blocks = levelThree.getBlocks();
			gameControl.crabby.setXPos(gameControl.blocks.getFirst().getXPos() + 200);
			gameControl.crabby.setYPos(gameControl.blocks.getFirst().getYPos() - 100);
			gameControl.crabby.setFalling(true);
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
		 * @throws InterruptedException Exception if the thread can't be paused.
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
		
		/**
		 * Constructor for the game.
		 * Creates a pane for the game with specified size and creates the view and status bars.
		 * The start screen and the status bar are added to the pane.
		 */
		public Game(){
			setPane(getContentPane());
			Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
			setPreferredSize(size);
			setMaximumSize(size);
			setMinimumSize(size);
			view = new MainView();
			starter = new StartScreen(this);
			this.addMouseListener(mi = new MouseInput());
			getPane().add(starter, BorderLayout.CENTER);
		}
		
		/**
		 * Sets the game playing status.
		 * When the start button is clicked, it is removed from the view. The main game is added to the view and the game is started.
		 * A key listener is added to the pane and level is set to one. The level is passed to StartNextLevel.
		 * @param b Sets the boolean playing to the boolean b.
		 */
		public void setPlaying(boolean b){
			this.getContentPane().remove(starter);
			view = new MainView();
			pane.add(view, BorderLayout.CENTER);
			pane.validate();
			pane.addKeyListener(new PlayerKeyHandler());
			this.playing = b;
			this.startGame();
            if (level == 5){
		        this.getContentPane().remove(tut1);
		        level = 1;
		    }
		    else if (level == 6){
		        this.getContentPane().remove(tut2);
		        level = 2;
		    }
		    else if (level == 7){
		        this.getContentPane().remove(tut3);
		        level = 3;
		    }
            //uncomment to start at chosen level
            level = 2;
			startNextLevel(level);
		}
	
		/**
		 * called when player loses and presses 'play' - starts level 1
		 */
		public void resetPlaying(){
			this.getContentPane().remove(endGame);
			view = new MainView();
			pane.add(view);
			pane.validate();
			this.playing = true;
			this.startGame();
			level = 1;
			startNextLevel(level);
		}
		
		/**
		 * called when player wins game and presses 'play' - starts level 1
		 */
		public void newGame(){
			this.getContentPane().remove(winScreen);
			view = new MainView();
			pane.add(view);
			pane.validate();
			this.playing = true;
			this.startGame();
			level = 1;
			startNextLevel(level);
		}
		
		/**
		 * called when all lives are lost, displays GameOver screen
		 */
		public void gameOver(){
			this.getContentPane().remove(view);
			endGame = new GameOver(this);
			pane.add(endGame, BorderLayout.CENTER);
			pane.validate();
			this.getContentPane().setFocusable(true);
		}
		
		/**
		 * called when player wins game, displays new WinScreen
		 */
		public void winScreen(){
			this.getContentPane().remove(view);
			winScreen = new WinScreen(this);
			pane.add(winScreen, BorderLayout.CENTER);
			pane.validate();
			this.getContentPane().setFocusable(true);
		}
		
		/**
		 * called when player starts game initially, displays level one tutorial
		 */
        public void tutorialOne(){
            this.getContentPane().remove(view);
            pane.add(tut1, BorderLayout.CENTER);
            pane.validate();
            this.getContentPane().setFocusable(true);
            level = 5;
        }
        
        /**
		 * called when player completes level one, displays level two tutorial
		 */
        public void tutorialTwo(){
            this.getContentPane().remove(view);
            pane.add(tut2, BorderLayout.CENTER);
            pane.validate();
            this.getContentPane().setFocusable(true);
            level = 6;
        }
        
        /**
		 * called when player completes level two, displays level three tutorial
		 */
        public void tutorialThree(){
            this.getContentPane().remove(view);
            pane.add(tut3, BorderLayout.CENTER);
            pane.validate();
            this.getContentPane().setFocusable(true);
            level = 7;
        }
		
		/**
		 * Switch statement to select which level to initialize. Calls the chosen level.
		 * @param level Integer to initialize the corresponding level.
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
		 * @return level The current level.
		 */
		public static int getLevel(){
			return level;
		}
		
		/**
		 * Sets the level to the given int.
		 * @param n Integer corresponding to the level to be set to.
		 */
		public static void setLevel(int n){
			level = n;
		}
		
		//Main 
		/**
		 * Main function for the game. Links the thread and sets visible.
		 * @param args Arguements we don't use.
		 */
		public static void main(String[] args) {
			game = new Game();
			//game = readMyObjectFromFile("tempdata.ser");
			game.pack();
			game.setResizable(false);
			game.setLocationRelativeTo(null);
			game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			game.setVisible(true);
		}

		/**
		 * Gets the pane container.
		 * @return pane The container pane for the game.
		 */
		public static Container getPane() {
			return pane;
		}

		/**
		 * Sets the pane to the given container.
		 * @param pane A container to set the game pane to.
		 */
		public void setPane(Container pane) {
			this.pane = pane;
		}
		
		/**
		 * writes serialized data to file at given file name
		 * @param runner
		 * @param fileName
		 */
		public void writeMyObjectToFile(Game runner, String fileName){
	        FileOutputStream fos = null;
	        ObjectOutputStream oos = null;
	        try{
	            fos = new FileOutputStream(fileName);
	            oos = new ObjectOutputStream(fos);
	            oos.writeObject(runner);
	            oos.close();
	        }catch(IOException e){
	            e.printStackTrace();
	        }
	    }
		
		/**
		 * reads serialized data in file at given file name
		 * @param fileName
		 */
	    public static Game readMyObjectFromFile(String fileName){
	        FileInputStream fis = null;
	        ObjectInputStream ois = null;
	        Game runner = null;
	        try{
	            fis = new FileInputStream(fileName);
	            ois = new ObjectInputStream(fis);
	            runner = (Game)ois.readObject();
	            ois.close();
	        }catch(IOException e){
	            e.printStackTrace();
	        }catch(ClassNotFoundException ex){
	            ex.printStackTrace();
	        }
	        return runner;
	    }		
		
}
