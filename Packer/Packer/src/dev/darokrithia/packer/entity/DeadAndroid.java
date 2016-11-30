package dev.darokrithia.packer.entity;

import java.awt.Graphics;

import dev.darokrithia.packer.graphics.Assets;
import dev.darokrithia.packer.utilities.Handler;

public class DeadAndroid extends Entity{

	private float centerX;
	private float centerY;
	
	private int timer = 0;
	
	public static final int TIME_UNTIL_ALIVE = 900;

	public DeadAndroid(float x, float y, int w, int h, Handler handler) {
		super(x, y, w, h, handler);

		collisionBox.x = 18;
		collisionBox.y = 24;
		collisionBox.width = 26;
		collisionBox.height = 40;
	}

	@Override
	public void tick() {
		if(timer < TIME_UNTIL_ALIVE){
			timer++;
		}
		else{
			handler.getEntityHandler().addEntity(new EvilAndroid(x, y, handler));
			handler.getEntityHandler().removeEntity(this);
		}
		centerX = (x - handler.getCamera().getXOffset());
		centerY = (y - handler.getCamera().getYOffset());
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.deadEnemy, (int)centerX, (int)centerY, width, height, null);
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public int getTimeUntilAlive() {
		return TIME_UNTIL_ALIVE;
	}

}
