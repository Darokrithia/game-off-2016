package dev.darokrithia.packer.graphics;

import dev.darokrithia.packer.entity.Entity;
import dev.darokrithia.packer.utilities.Handler;

public class Camera {
	
	private float xOffset;
	private float yOffset;
	
	private Handler handler;
	
	public Camera (float xOffset, float yOffset, Handler handler){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.handler = handler;
	}
	
	public void move(float xDelta, float yDelta){
		xOffset+=xDelta;
		yOffset+=yDelta;
	}
	
	public void center(Entity e){
		xOffset = (e.getX() - (512/2) + (e.getWidth()/2));
		yOffset = (e.getY() - (512/2) + (e.getHeight()/2));
		edgeCenter();
	}
	
	public void edgeCenter(){
		if(xOffset < 0){
			xOffset = 0;
		}
		else if (xOffset > handler.getWidth()){
			xOffset = handler.getWidth();
		}
		
		if(yOffset < 0){
			yOffset = 0;
		}
		else if (yOffset > handler.getHeight()){
			yOffset = handler.getHeight();
		}
	}

	public float getXOffset() {
		return xOffset;
	}

	public void setXOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getYOffset() {
		return yOffset;
	}

	public void setYOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
	

}
