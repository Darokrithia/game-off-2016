package dev.darokrithia.packer.states;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import dev.darokrithia.packer.entity.DeadAndroid;
import dev.darokrithia.packer.entity.EvilAndroid;
import dev.darokrithia.packer.entity.GoodAndroid;
import dev.darokrithia.packer.graphics.Assets;
import dev.darokrithia.packer.utilities.Handler;

public class HackerState extends State{
	
	private int lines;
	private int column;
	
	private BufferedImage b1;
	private BufferedImage b2;
	
	private DeadAndroid entityToHack;
	private int hackTimeLeft;
	
	public HackerState(Handler handler){
		super(handler);
		lines = 1;
		column = 1;
	}

	@Override
	public void tick() {
		if(hackTimeLeft > 0){
			if(handler.getKeyHandler().typedSpam){
				column++;
				handler.getKeyHandler().typedSpam = false;
			}
			if (column > 12){
				column = 1;
				lines++;
			}
			if (lines > 23){
				lines = 1;
				GoodAndroid g = new GoodAndroid(entityToHack.getX(), entityToHack.getY(), handler);
				handler.getEntityHandler().removeEntity(entityToHack);
				handler.getEntityHandler().addEntity(g);
				State.setState(handler.getGame().shooterState);
				
			}
			b1 = Assets.hackText.selectImage(0, 0, 512, (lines*20));
			b2 = Assets.hackText.selectImage(0, (lines*20), (column*40), 20);
			hackTimeLeft--;
		}
		else{
			lines = 1;
			column = 1;
			
			EvilAndroid e = new EvilAndroid(entityToHack.getX(), entityToHack.getY(), handler);
			handler.getEntityHandler().removeEntity(entityToHack);
			handler.getEntityHandler().addEntity(e);
			State.setState(handler.getGame().shooterState);
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(b1, 0, 0, null);
		g.drawImage(b2, 0, (lines*20), null);
	}

	public DeadAndroid getEntityToHack() {
		return entityToHack;
	}

	public void setEntityToHack(DeadAndroid d) {
		this.entityToHack = d;
		this.hackTimeLeft = (d.getTimeUntilAlive() - d.getTimer());
	}
}
