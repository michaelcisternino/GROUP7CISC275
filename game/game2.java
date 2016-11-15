package game;
//package game;
//
//public class Game implements Runnable{
//
//	private Thread gameThread;
//	private boolean run = false;
//	private MainController gameControl = new MainController();
//	
//	
//	//Initialize gameThread
//		private synchronized void startGame() {
//			if(run){
//				return;
//			}
//			run = true;
//			gameThread = new Thread(this, "Game Thread");
//			gameThread.start();
//		}
//			
//	//Terminate gameThread
//		private synchronized void stopGame() {
//			if(!run){
//				return;
//			}
//			try {
//				gameThread.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//			
//		//Implemented method from Runnable
//		@Override
//		public void run() {
//			long last = System.nanoTime();
//			System.out.print(last);
//			long timer = System.currentTimeMillis();
//			double delta = 0.0;
//			double nanos = 1000000000.0/60.0;
//			int frames = 0;
//			int ticks = 0;
//			while(run){
//				long curr = System.nanoTime();
//				delta += (curr-last)/nanos;
//				last = curr;
//				while(delta >= 1){
//					update();
//					ticks++;
//					delta--;
//				}
//				render();
//				frames++;
//				if((System.currentTimeMillis() - timer) > 1000){
//					timer += 1000;
//					frames = 0;
//					ticks = 0;
//				}
//			}
//			stopGame();
//		}
//
//}
