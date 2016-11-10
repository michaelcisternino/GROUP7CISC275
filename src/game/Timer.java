package game;

public class Timer {
	long lastTime = System.nanoTime();
	long timer = System.currentTimeMillis();
	double delta = 0.0;
	double nanos = 1000000000.0/60.0;
	int frames = 0;
	int ticks = 0;
}
