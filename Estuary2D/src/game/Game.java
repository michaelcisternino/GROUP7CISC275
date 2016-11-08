package game;

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
import view.MainView;

public class Game extends JFrame implements Runnable{

		public static final int WIDTH = 270;
		public static final int HEIGHT = WIDTH/14*10;
		public static final int SCALE = 4;
		public static final String TITLE = "Crabby";
		
		private Container pane;
		private Thread gameThread;
		private boolean run = false;
		private MainView view;
		public static GameController gameControl;
		
		private void init(){
			gameControl = new GameController();
			addKeyListener(new PlayerKeyHandler());
			gameControl.addBlock(new Floor(300,HEIGHT*SCALE-64,800,64,true,ObjectType.Wall,gameControl));
			gameControl.addBlock(new Platform(0,200,400,30,true,ObjectType.Wall,gameControl));
			gameControl.addBlock(new Platform(800,500,400,30,true,ObjectType.Wall,gameControl));
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
			pane.add(view, BorderLayout.CENTER);			
		}
		
		//Main 
		public static void main(String[] args) {
			Game game = new Game();
//			JFrame frame = new JFrame(TITLE);;
			game.pack();
			game.setResizable(false);
			game.setLocationRelativeTo(null);
			game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			game.setVisible(true);
			game.startGame();
		}

		
}
