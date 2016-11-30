package dev.darokrithia.packer.entity;

import java.awt.Color;
import java.awt.Graphics;

import dev.darokrithia.packer.graphics.Animation;
import dev.darokrithia.packer.graphics.Assets;
import dev.darokrithia.packer.states.EndState;
import dev.darokrithia.packer.states.HackerState;
import dev.darokrithia.packer.states.State;
import dev.darokrithia.packer.utilities.Handler;

public class Player extends Mob{
	
	private boolean shooting = false;
	private boolean moving = false;
	
	private int reloadTime;
	private int reloadNow;
	
	private int currentEnergy;
	private int maxEnergy;
	private int currentHealth;
	private int maxHealth;
	
	private Animation downAnimation;
	private Animation upAnimation;
	private Animation leftAnimation;
	private Animation rightAnimation;
	
	private Animation downShootAnimation;
	private Animation upShootAnimation;
	private Animation leftShootAnimation;
	private Animation rightShootAnimation;
	
	private Animation projectileDown;
	private Animation projectileUp;
	private Animation projectileLeft;
	private Animation projectileRight;
	
	float centerX;
	float centerY;

	public Player(float x, float y, Handler handler) {
		super(x, y, Mob.DEFAULT_SIZE,Mob.DEFAULT_SIZE, handler);
		this.r = 4;
		collisionBox.x = 18;
		collisionBox.y = 24;
		collisionBox.width = 26;
		collisionBox.height = 40;
		
		this.enemy = false;
		
		reloadTime = 15;
		reloadNow = reloadTime;
		maxEnergy = 200;
		currentEnergy = maxEnergy;
		maxHealth = 2000;
		currentHealth = maxHealth;
		
		downAnimation = new Animation(Assets.packerDownMove, 100);
		upAnimation = new Animation(Assets.packerUpMove, 100);
		rightAnimation = new Animation(Assets.packerRightMove, 100);
		leftAnimation = new Animation(Assets.packerLeftMove, 100);
		
		downShootAnimation = new Animation(Assets.packerDownShoot, 100);
		upShootAnimation = new Animation(Assets.packerUpShoot, 100);
		rightShootAnimation = new Animation(Assets.packerRightShoot, 100);
		leftShootAnimation = new Animation(Assets.packerLeftShoot, 100);
		
		projectileDown = new Animation(Assets.packerBulletDown, 50);
		projectileUp = new Animation(Assets.packerBulletUp, 50);
		projectileLeft = new Animation(Assets.packerBulletLeft, 50);
		projectileRight = new Animation(Assets.packerBulletRight, 50);
	}

	@Override
	public void tick() {
		shooting = (handler.getKeyHandler().upShoot || handler.getKeyHandler().downShoot || handler.getKeyHandler().leftShoot || handler.getKeyHandler().rightShoot);
		moving = (handler.getKeyHandler().upMove || handler.getKeyHandler().downMove || handler.getKeyHandler().leftMove || handler.getKeyHandler().rightMove);
		
		xSpeed = 0;
		ySpeed = 0;
		currentEnergy++;
		if(currentEnergy > maxEnergy){
			currentEnergy = maxEnergy;
		}
		reloadNow++;
		
		if(shooting && (reloadNow >= reloadTime) && (currentEnergy >= 60)){
			reloadNow = 0;
			currentEnergy -= 30;
			if(handler.getKeyHandler().upShoot){
				Projectile p = new Projectile(this.x+16,this.y+16,16,16,60,-7,0, enemy, projectileUp,this.handler);
				handler.getLevel().getEntityHandler().addEntity(p);
			}
			else if (handler.getKeyHandler().downShoot){
				Projectile p = new Projectile(this.x+16,this.y+32,16,16,60,7,0, enemy, projectileDown,this.handler);
				handler.getLevel().getEntityHandler().addEntity(p);
			}
			else if (handler.getKeyHandler().leftShoot){
				Projectile p = new Projectile(this.x+16,this.y+16,16,16,60,0,-7, enemy, projectileLeft,this.handler);
				handler.getLevel().getEntityHandler().addEntity(p);
			}
			else if (handler.getKeyHandler().rightShoot){
				Projectile p = new Projectile(this.x+16,this.y+16,16,16,60,0,7, enemy, projectileRight,this.handler);

				handler.getLevel().getEntityHandler().addEntity(p);
			}
		}
		
		r = (currentEnergy/30);
		
		if(shooting && moving){
			if (handler.getKeyHandler().upShoot){
				upShootAnimation.tick();
			}
			if (handler.getKeyHandler().downShoot){
				downShootAnimation.tick();
			}
			if (handler.getKeyHandler().leftShoot){
				leftShootAnimation.tick();
			}
			if (handler.getKeyHandler().rightShoot){
				rightShootAnimation.tick();
			}
			
			if (handler.getKeyHandler().upMove){
				ySpeed = -r;
			}
			if (handler.getKeyHandler().downMove){
				ySpeed = r;
			}
			if (handler.getKeyHandler().leftMove){
				xSpeed = -r;
			}
			if (handler.getKeyHandler().rightMove){
				xSpeed = r;
			}
		}
		else{
			if (handler.getKeyHandler().upMove){
				upAnimation.tick();
				ySpeed = -r;
			}
			if (handler.getKeyHandler().downMove){
				downAnimation.tick();
				ySpeed = r;
			}
			if (handler.getKeyHandler().leftMove){
				leftAnimation.tick();
				xSpeed = -r;
			}
			if (handler.getKeyHandler().rightMove){
				rightAnimation.tick();
				xSpeed = r;
			}
		}
		
		if(checkCollision(EnemyProjectile.class)){
			currentHealth -= 30;
		}
		
		if(checkClose(DeadAndroid.class) && handler.getKeyHandler().hack){
			DeadAndroid d;
			d = (DeadAndroid)getCloseEntity(DeadAndroid.class);
			((HackerState) handler.getGame().hackerState).setEntityToHack(d);
			State.setState(handler.getGame().hackerState);
		}
		
		if(currentHealth <= 0){
			EndState lose = new EndState(handler, false);
			State.setState(lose);
			handler.getEntityHandler().removeEntity(this);
		}
		
		move();
		centerX = (x - handler.getCamera().getXOffset());
		centerY = (y - handler.getCamera().getYOffset());
		
		handler.getCamera().center(this);
	}

	@Override
	public void render(Graphics g) {
		if (shooting && moving){
			if (handler.getKeyHandler().upShoot){
				g.drawImage(upShootAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else if (handler.getKeyHandler().downShoot){
				 g.drawImage(downShootAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else if (handler.getKeyHandler().leftShoot){
				g.drawImage(leftShootAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else if (handler.getKeyHandler().rightShoot){
				 g.drawImage(rightShootAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else{
				g.drawImage(Assets.packerDownStatic, (int) centerX, (int) centerY, width, height, null);
			}
		}
		else if(shooting){
			if (handler.getKeyHandler().upShoot){
				g.drawImage(Assets.packerUpStaticShoot, (int) centerX, (int) centerY, width, height, null);
			}
			else if (handler.getKeyHandler().downShoot){
				 g.drawImage(Assets.packerDownStaticShoot, (int) centerX, (int) centerY, width, height, null);
			}
			else if (handler.getKeyHandler().leftShoot){
				g.drawImage(Assets.packerLeftStaticShoot, (int) centerX, (int) centerY, width, height, null);
			}
			else if (handler.getKeyHandler().rightShoot){
				 g.drawImage(Assets.packerRightStaticShoot, (int) centerX, (int) centerY, width, height, null);
			}
			else{
				g.drawImage(Assets.packerDownStatic, (int) centerX, (int) centerY, width, height, null);
			}
		}
		else{
			if (handler.getKeyHandler().upMove){
				g.drawImage(upAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else if (handler.getKeyHandler().downMove){
				 g.drawImage(downAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else if (handler.getKeyHandler().leftMove){
				g.drawImage(leftAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else if (handler.getKeyHandler().rightMove){
				 g.drawImage(rightAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else{
				g.drawImage(Assets.packerDownStatic, (int) centerX, (int) centerY, width, height, null);
			}
		}
		Color c = new Color(0.0f, 0.9f, 1.0f);
		g.setColor(c);
		g.fillRect(0, 488, currentEnergy, 12);
		g.setColor(Color.red);
		g.fillRect(0, 500, (currentHealth/10), 12);
		
	}

}
