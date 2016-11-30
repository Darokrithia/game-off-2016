package dev.darokrithia.packer.graphics;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int millisecondsPerFrame;
	private int index;
	private BufferedImage[] frames;
	
	long lastTime;
	long timer;
	
	public Animation (BufferedImage[] frames, int mspf){
		this.millisecondsPerFrame = mspf;
		this.frames = frames;
		index = 0;
		lastTime = System.currentTimeMillis();
		timer = 0;
	}
	
	public void tick(){
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if (timer > millisecondsPerFrame){
			index++;
			if(index >= frames.length){
				index = 0;
			}
			timer = 0;
		}
	}
	
	public BufferedImage getFrame(){
		return frames[index];
	}
	
	public BufferedImage getFrame(int i){
		return frames[i];
	}

}
