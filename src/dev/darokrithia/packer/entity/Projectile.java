package dev.darokrithia.packer.entity;

import java.awt.Graphics;

import dev.darokrithia.packer.graphics.Animation;
import dev.darokrithia.packer.tiles.Tile;
import dev.darokrithia.packer.utilities.Handler;

public class Projectile extends Entity{
	
	private int maxMoves;
	private int moves;
	private int xSpeed;
	private int ySpeed;
	
	private Animation animation;
	private Handler handler;

	public Projectile(float x, float y, int w, int h, int m, int ySpeed, int xSpeed, boolean enemy, Animation ani, Handler handler) {
		super(x, y, w, h, handler);
		this.maxMoves = m;
		this.moves = 0;
		this.ySpeed = ySpeed;
		this.xSpeed = xSpeed;
		
		this.enemy = enemy;
		
		this.handler = handler;
		this.animation = ani;
		handler.getLevel().getEntityHandler().addEntity(this);
		
	}
	private boolean collisionWithTile(int x, int y){
		x = (x/Tile.SIZE);
		y = (y/Tile.SIZE);
		return !(handler.getLevel().getTile(x,y).isPassable());
	}
	
	public void tick(){
		if((moves > maxMoves) || (collisionWithTile((int) x, (int) y))){
			handler.getLevel().getEntityHandler().removeEntity(this);
		}
		else{
			animation.tick();
			moves++;
			y+= ySpeed;
			x+= xSpeed;
		}
	}
	public void render (Graphics g){
		float centerX = (x - handler.getCamera().getXOffset());
		float centerY = (y - handler.getCamera().getYOffset());
		g.drawImage(animation.getFrame(), (int) centerX, (int) centerY, width, height, null);
	}

}
