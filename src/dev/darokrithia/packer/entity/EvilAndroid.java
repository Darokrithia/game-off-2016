package dev.darokrithia.packer.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import dev.darokrithia.packer.graphics.Animation;
import dev.darokrithia.packer.graphics.Assets;
import dev.darokrithia.packer.utilities.Handler;

public class EvilAndroid extends Mob{

	private boolean closeToPlayer = false;
	
	private int reloadTime;
	private int reloadNow;
	
	private int  currentEnergy;
	private int maxEnergy;
	private int currentHealth;
	private int maxHealth;
	
	private Animation downAnimation;
	private Animation upAnimation;
	private Animation leftAnimation;
	private Animation rightAnimation;
	
	private Animation projectileDown;
	private Animation projectileUp;
	private Animation projectileLeft;
	private Animation projectileRight;
	
	float centerX;
	float centerY;

	public EvilAndroid(float x, float y, Handler handler) {
		super(x, y, Mob.DEFAULT_SIZE,Mob.DEFAULT_SIZE, handler);
		this.r = 4;
		collisionBox.x = 18;
		collisionBox.y = 24;
		collisionBox.width = 26;
		collisionBox.height = 40;
		
		this.enemy = true;
		
		reloadTime = 20;
		reloadNow = reloadTime;
		maxEnergy = 150;
		currentEnergy = maxEnergy;
		maxHealth = 1500;
		currentHealth = maxHealth;
		
		downAnimation = new Animation(Assets.enemyDownMove, 100);
		upAnimation = new Animation(Assets.enemyUpMove, 100);
		rightAnimation = new Animation(Assets.enemyRightMove, 100);
		leftAnimation = new Animation(Assets.enemyLeftMove, 100);
		
		projectileDown = new Animation(Assets.evilBulletDown, 50);
		projectileUp = new Animation(Assets.evilBulletUp, 50);
		projectileLeft = new Animation(Assets.evilBulletLeft, 50);
		projectileRight = new Animation(Assets.evilBulletRight, 50);
	}

	@Override
	public void tick() {
		closeToPlayer = (((Math.abs(getClosest().getX() - this.x))<50) || ((Math.abs(getClosest().getY() - this.y))<50));
		
		xSpeed = 0;
		ySpeed = 0;
		currentEnergy++;
		if(currentEnergy > maxEnergy){
			currentEnergy = maxEnergy;
		}
		reloadNow++;

		if(checkCollision(Projectile.class)){
			currentHealth -= 30;
		}
		
	r = (currentEnergy/30);
		AI_Move(getClosest().getX(), getClosest().getY());
		if(closeToPlayer && (reloadNow >= reloadTime) && (currentEnergy >= 60)){
			reloadNow = 0;
			currentEnergy -= 30;
			if(directionToClosest () == 2){
				Projectile p = new EnemyProjectile(this.x+16,this.y+16,16,16,60,-7,0, enemy, projectileUp,this.handler);
				handler.getLevel().getEntityHandler().addEntity(p);
			}
			else if (directionToClosest () == 3){
				Projectile p = new EnemyProjectile(this.x+16,this.y+32,16,16,60,7,0, enemy, projectileDown,this.handler);
				handler.getLevel().getEntityHandler().addEntity(p);
			}
			else if (directionToClosest () == 0){
				Projectile p = new EnemyProjectile(this.x+16,this.y+16,16,16,60,0,-7, enemy, projectileLeft,this.handler);
				handler.getLevel().getEntityHandler().addEntity(p);
			}
			else if (directionToClosest () == 1){
				Projectile p = new EnemyProjectile(this.x+16,this.y+16,16,16,60,0,7, enemy, projectileRight,this.handler);

				handler.getLevel().getEntityHandler().addEntity(p);
			}
		}
		
		if(directionToClosest () == 2){
			upAnimation.tick();
		}
		else if (directionToClosest () == 3){
			downAnimation.tick();
		}
		else if (directionToClosest () == 0){
			leftAnimation.tick();
		}
		else if (directionToClosest () == 1){
			rightAnimation.tick();
			
		}
		
		if(currentHealth <= 0){
			DeadAndroid deadMe;
			deadMe = new DeadAndroid(x, y, width, height, handler);
			handler.getEntityHandler().addEntity(deadMe);
			handler.getEntityHandler().removeEntity(this);
		}
		
		centerX = (x - handler.getCamera().getXOffset());
		centerY = (y - handler.getCamera().getYOffset());
	}

	private Entity getClosest() {
		ArrayList<Entity> el = new ArrayList<Entity>();
		
		for(int i = 0; i < handler.getEntityHandler().getEntities().size(); i++){
			if (handler.getEntityHandler().getEntities().get(i).getClass() == GoodAndroid.class){
				el.add(handler.getEntityHandler().getEntities().get(i));
			}
		}
		
		Entity e = handler.getLevel().getPlayer();
		double d = (Math.sqrt( ((e.getX() - this.getX())*(e.getX() - this.getX())) + ((e.getY() - this.getY())*(e.getY() - this.getY())) )/4);
		
		for(int i = 0; i < el.size(); i++){
			double temp = (Math.sqrt( ((el.get(i).getX() - this.getX())*(el.get(i).getX() - this.getX())) + ((el.get(i).getY() - this.getY())*(el.get(i).getY() - this.getY())) ));
			if (temp < d){
				e = (GoodAndroid) el.get(i);
				d = temp;
			}
		}
		return e;
	}

	@Override
	public void render(Graphics g) {
		if(currentHealth >= 0){
			if (directionToClosest () == 2){
				g.drawImage(upAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else if (directionToClosest () == 3){
				 g.drawImage(downAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else if (directionToClosest () == 0){
				g.drawImage(leftAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else if (directionToClosest () == 1){
				 g.drawImage(rightAnimation.getFrame(), (int) centerX, (int) centerY, width, height, null);
			}
			else{
				g.drawImage(Assets.enemyStatic, (int) centerX, (int) centerY, width, height, null);
			}
		}

		g.setColor(Color.red);
		g.fillRect((int) centerX, (int) (centerY -6), (int) (currentHealth/23.4375), 3);
	}
	
	public float getXDistancToClosest(){
		return (Math.abs(this.x - getClosest().getX()));
	}
	public float getYDistancToClosest(){
		return (Math.abs(this.y - getClosest().getY()));
	}
	public int directionToClosest (){
		if(Math.sqrt((getXDistancToClosest()*getXDistancToClosest()) + (getYDistancToClosest()*getYDistancToClosest())) <= 500){
			if(getXDistancToClosest() >= getYDistancToClosest()){
				if(this.x >= getClosest().getX()){
					return 0;
				}
				else{
					return 1;
				}
			}
			else{
				if(this.y >= getClosest().getY()){
					return 2;
				}
				else{
					return 3;
				}
			}
		}
		else{
			return 5;
		}
	}

}