package dev.darokrithia.packer.entity;

import dev.darokrithia.packer.tiles.Tile;
import dev.darokrithia.packer.utilities.Handler;

public abstract class Mob extends Entity {
	
	public static final int DEFAULT_HEALTH = 10;
	public static final int DEFAULT_ENERGY = 0;
	public static final float DEFAULT_R = 3; 
	public static final int DEFAULT_SIZE = 64;
	
	protected int maxHealth;
	protected int currentHealth;
	protected int maxEnergy;
	protected int currentEnergy;
	protected float r;
	protected float xSpeed;
	protected float ySpeed;
	
	public Mob(float x, float y, int w, int h, Handler handler) {
		super(x, y, w, h, handler);
		this.maxHealth = DEFAULT_HEALTH;
		this.currentHealth = DEFAULT_HEALTH;
		this.maxEnergy = DEFAULT_ENERGY;
		this.currentEnergy = DEFAULT_ENERGY;
		this.r = DEFAULT_R;
		this.xSpeed = 0;
		this.ySpeed = 0;
	}

	
	public void move(){
		if(xSpeed > 0){
			int desX = ((int) (x + xSpeed + collisionBox.x + collisionBox.width)/Tile.SIZE);
			int desY1 = ((int) (y + collisionBox.y)/Tile.SIZE);
			int desY2 = ((int) (y + collisionBox.y + collisionBox.height)/Tile.SIZE);
			
			if(!collisionWithTile(desX,desY1) && !collisionWithTile(desX,desY2) && !checkCollision(xSpeed, 0)){
				x+=xSpeed;
			}
		}
		else if (xSpeed < 0){
			int desX = ((int) (x + xSpeed + collisionBox.x)/Tile.SIZE);
			int desY1 = ((int) (y + collisionBox.y)/Tile.SIZE);
			int desY2 = ((int) (y + collisionBox.y + collisionBox.height)/Tile.SIZE);
			
			if(!collisionWithTile(desX,desY1) && !collisionWithTile(desX,desY2) && !checkCollision(xSpeed, 0)){
				x+=xSpeed;
			}
		}
		
		
		if(ySpeed > 0){
			int desY = ((int) (y + ySpeed + collisionBox.y + collisionBox.height)/Tile.SIZE);
			int desX1 = ((int) (x + collisionBox.x)/Tile.SIZE);
			int desX2 = ((int) (x + collisionBox.x + collisionBox.width)/Tile.SIZE);
			
			if(!collisionWithTile(desX1,desY) && !collisionWithTile(desX2,desY) && !checkCollision(0, ySpeed)){
				y+=ySpeed;
			}
		}
		else if (ySpeed < 0){
			int desY = ((int) (y + ySpeed + collisionBox.y)/Tile.SIZE);
			int desX1 = ((int) (x + collisionBox.x)/Tile.SIZE);
			int desX2 = ((int) (x + collisionBox.x + collisionBox.width)/Tile.SIZE);
			
			if(!collisionWithTile(desX1,desY) && !collisionWithTile(desX2,desY) && !checkCollision(0, ySpeed)){
				y+=ySpeed;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y){
		return !(handler.getLevel().getTile(x, y).isWalkable());
	}
	
	public void setSpeed(float desiredX, float desiredY){
		float deltaX = this.x-desiredX;
		float deltaY = this.y-desiredY;
		
		if((Math.abs(deltaX) > 2 || Math.abs(deltaY) > 2) && (Math.abs(deltaX) < 200 || Math.abs(deltaY) < 200)){
			float deltaHypotenuse = (float) Math.sqrt(((deltaX*deltaX)+(deltaY*deltaY)));
			float sinØ = (deltaY/deltaHypotenuse);
			float cosØ = (deltaX/deltaHypotenuse);
			
			ySpeed = -r*sinØ;
			xSpeed = -r*cosØ;
		}
		else{
			ySpeed = 0;
			xSpeed = 0;
		}
	}
	public void AI_Move(float desiredX, float desiredY){
		setSpeed(desiredX,desiredY);
		move();
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	public int getMaxEnergy() {
		return maxEnergy;
	}
	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}
	public int getCurrentEnergy() {
		return currentEnergy;
	}
	public void setCurrentEnergy(int currentEnergy) {
		this.currentEnergy = currentEnergy;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}
}
