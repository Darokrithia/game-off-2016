package dev.darokrithia.packer.entity;

import java.awt.Color;
import java.awt.Graphics;

import dev.darokrithia.packer.graphics.Assets;
import dev.darokrithia.packer.states.EndState;
import dev.darokrithia.packer.states.State;
import dev.darokrithia.packer.utilities.Handler;

public class FinalEnemy extends Entity{
	
	private int  maxHealth;
	private int currentHealth;
	private float centerX;
	private float centerY;

	public FinalEnemy(float x, float y, Handler handler) {
		super(x, y, 128, 128, handler);
		maxHealth = 20000;
		currentHealth = maxHealth;
	}

	@Override
	public void tick() {
		if(checkCollision(Projectile.class)){
			currentHealth -= 30;
		}
		
		if(currentHealth <= 0){
			EndState win = new EndState(handler, true);
			State.setState(win);
			handler.getEntityHandler().removeEntity(this);
		}

		centerX = (x - handler.getCamera().getXOffset());
		centerY = (y - handler.getCamera().getYOffset());
	}

	@Override
	public void render(Graphics g) {
		if(currentHealth >= 0){
			g.setColor(Color.red);
			g.fillRect((int) centerX, (int) (centerY -6), (int) (currentHealth/156.25), 3);
		}	
		g.drawImage(Assets.finalEnemy, (int) centerX, (int) centerY, width, height, null);
	}

}
