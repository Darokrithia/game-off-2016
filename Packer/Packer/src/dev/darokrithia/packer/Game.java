package dev.darokrithia.packer;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.darokrithia.packer.graphics.Assets;
import dev.darokrithia.packer.graphics.Camera;
import dev.darokrithia.packer.graphics.Display;
import dev.darokrithia.packer.states.HackerState;
import dev.darokrithia.packer.states.MenuState;
import dev.darokrithia.packer.states.ShooterState;
import dev.darokrithia.packer.states.State;
import dev.darokrithia.packer.utilities.Handler;

public class Game implements Runnable {
	
	//thread control
	private boolean running = false;
	private Thread thread;
	
	//display setup
	private Display display;
	private String title;
	private int width;
	private int height;
	
	//Utilities
	private Handler handler;
	private KeyHandler keyHandler;
	
	//graphics setup
	private Camera camera;
	private BufferStrategy bs;
	private Graphics g;
	
	//states
	public State shooterState;
	public State hackerState;
	public State menuState;
	
	public Game(String t, int w, int h){
		this.title = t;
		this.width = w;
		this.height = h;
		
		keyHandler = new KeyHandler();
		handler = new Handler(this);
		camera = new Camera(0,0,this.handler);
	}
	
	private void init(){
		
		//display
		display = new Display (this.title,this.width,this.height);
		display.createDisplay();
		display.getJFrame().addKeyListener(keyHandler);
		
		//assets
		Assets.init();
		
		//states
		shooterState = new ShooterState(handler);
		hackerState = new HackerState(handler);
		menuState = new MenuState(handler);
		State.setState(shooterState);
	}
	
	private void tick(){
		keyHandler.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
	}
	private void render(){
		//make sure Buffers are set up
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		//Render
		g.fillRect(0, 0, width, height);
		if(State.getState() != null){
			State.getState().render(g);
		}
		
		bs.show();
		g.dispose();
	}
	
	public void run(){
	
		init();
		
		int idealFPS = 60;
		double timePerTick = (1000000000/idealFPS);
		double delta = 0;
		long currentTime;
		long lastTime = System.nanoTime();
		
		long timer = 0;
		int fps = 0;
		
		while(running){
			currentTime = System.nanoTime();
			delta += ((currentTime-lastTime)/timePerTick);
			timer += (currentTime-lastTime);
			lastTime = currentTime;
			
			if(delta >= 1){
				tick();
				render();
				
				delta--;
				fps++;
			}
			if(timer >= 1000000000){
				System.out.println("FPS: " + fps);
				timer = 0;
				fps = 0;
			}
		}
		
		stop();
	}
	
	public synchronized void start(){
		if(running){
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running){
			return;
		}
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public KeyHandler getKeyHandler(){
		return keyHandler;
	}
	
	public Camera getCamera(){
		return camera;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
