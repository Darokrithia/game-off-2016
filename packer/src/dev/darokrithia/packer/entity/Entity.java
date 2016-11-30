package dev.darokrithia.packer.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.darokrithia.packer.utilities.Handler;

public abstract class Entity {
	
	protected float x;
	protected float y;
	protected int width;
	protected int height;
	protected boolean enemy;
	
	protected Handler handler;
	protected Rectangle collisionBox;
	
	public Entity(float x, float y, int w, int h, Handler handler){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		
		this.handler = handler;
		collisionBox = new Rectangle(0,0,width,height);
	}

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		Rectangle rect = new Rectangle((int)(x + collisionBox.x + xOffset), (int)(y + collisionBox.y + yOffset), collisionBox.width, collisionBox.height);
		return rect;
	}
	
	public boolean checkCollision(){
		for(Entity e: handler.getEntityHandler().getEntities()){
			if(e.equals(this)){
				continue;
			}
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(0f,0f))){
				return true;
			}
		}
		return false;
	}
	public boolean checkCollision(float xOffset, float yOffset){
		for(Entity e: handler.getEntityHandler().getEntities()){
			if(e.equals(this)){
				continue;
			}
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset))){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkCollision(float xOffset, float yOffset, @SuppressWarnings("rawtypes") Class c){
		for(Entity e: handler.getEntityHandler().getEntities()){
			if(e.equals(this)){
				continue;
			}
			if(e.getClass() == c){
				if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset))){
					return true;
				}
			}
		}
		return false;
	}
	public boolean checkCollision(@SuppressWarnings("rawtypes") Class c){
		for(Entity e: handler.getEntityHandler().getEntities()){
			if(e.equals(this)){
				continue;
			}
			if(e.getClass() == c){
				if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(0f,0f))){
					return true;
				}
			}
		}
		return false;
	}
	public boolean checkClose(@SuppressWarnings("rawtypes") Class c){
		for(Entity e: handler.getEntityHandler().getEntities()){
			if(e.equals(this)){
				continue;
			}
			Rectangle rt = e.getCollisionBounds(0f, 0f);
			rt.setBounds((rt.x-100), (rt.y-100), (rt.width+200), (rt.height+200));
			if(e.getClass() == c){
				if(rt.intersects(getCollisionBounds(0f,0f))){
					return true;
				}
			}
		}
		return false;
	}
	public Entity getCloseEntity(@SuppressWarnings("rawtypes") Class c){
		for(Entity e: handler.getEntityHandler().getEntities()){
			if(e.equals(this)){
				continue;
			}
			Rectangle rt = e.getCollisionBounds(0f, 0f);
			rt.setBounds((rt.x-100), (rt.y-100), (rt.width+200), (rt.height+200));
			if(e.getClass() == c){
				if(rt.intersects(getCollisionBounds(0f,0f))){
					return e;
				}
			}
		}
		return null;
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

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public boolean getEnemy() {
		return enemy;
	}

	public void setEnemy(boolean enemy) {
		this.enemy = enemy;
	}
	

}
