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
import model.Floor;
import model.Item;
import view.MainView;

public class Game extends JFrame implements Runnable{

		public static final int WIDTH = 270;
		public static final int HEIGHT = WIDTH/14*10;
		public static final int SCALE = 4;
		public static final String TITLE = "Crabby";
		Random randItem = new Random();
		int itemNum;
		private Container pane;
		private Thread gameThread;
		
		private boolean run = false;
		public static boolean playing = true;
		
		public MainView view;
		public static GameController gameControl;
		private JButton start = new JButton("START");
		public static Game game;
		private StartScreen starter;
		
		private void init(){
			gameControl = new GameController();
			addKeyListener(new PlayerKeyHandler());
			gameControl.addBlock(new Platform(0,200,400,30,ObjectType.Wall,gameControl));
			itemNum = randItem.nextInt()%4;
			System.out.println(itemNum);
			gameControl.addBlock(new Platform(800,500,400,30,ObjectType.Wall,gameControl));
			if(itemNum == 0){
				gameControl.addItem(new Item(500,0,30,30,ObjectType.TrashBag, gameControl));
			}
			else if(itemNum == 1){
				gameControl.addItem(new Item(500,0,30,30,ObjectType.Hay, gameControl));
			}
			else if(itemNum == 2){
				gameControl.addItem(new Item(500,0,30,30,ObjectType.Seeds, gameControl));
			}
			else{
				gameControl.addItem(new Item(500,0,30,30,ObjectType.Compost, gameControl));
			}
			gameControl.addBlock(new Floor(300,HEIGHT*SCALE-64,800,64,ObjectType.Wall,gameControl));
		}
		
		//Initialize gameThread
		private synchronized void startGame(){
			init();
			if(run){
				return;
			}
			run = true;
			gameThread = new Thread(this, "Game Thread");
			gameThread.start();
		}
		
		//Terminate gameThread
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
		
		//Implemented method from Runnable
		@Override
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
		public Game() {
			pane = getContentPane();
			Dimension size = new Dimension(WIDTH*SCALE, HEIGHT*SCALE);
			setPreferredSize(size);
			setMaximumSize(size);
			setMinimumSize(size);
			view = new MainView();
			//view.add(start);
			//start.addActionListener(new StartButton());
			starter = new StartScreen(this);
			//pane.add(view, BorderLayout.CENTER);
			pane.add(starter, BorderLayout.CENTER);
		}
		
		public void setPlaying(boolean b){
			this.getContentPane().remove(starter);
			view = new MainView();
			pane.add(view, BorderLayout.CENTER);
			pane.validate();
			this.playing = b;
			if(playing){
				this.startGame();
			}
		}
		
		class StartButton implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Game.game.startGame();
			}
		}
		
		//Main 
//		public static void main(String[] args) {
//			game = new Game();
////			JFrame frame = new JFrame(TITLE);;
//			game.pack();
//			game.setResizable(false);
//			game.setLocationRelativeTo(null);
//			game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			game.setVisible(true);
//			game.startGame();
//		}

}
