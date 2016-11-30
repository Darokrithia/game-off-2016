package dev.darokrithia.packer.states;

import java.awt.Graphics;

import dev.darokrithia.packer.graphics.Assets;
import dev.darokrithia.packer.utilities.Handler;

public class EndState extends State{
	
	public boolean win;

	public EndState(Handler handler, boolean win) {
		super(handler);
		this.win = win;
	}

	@Override
	public void tick() {
		if(handler.getKeyHandler().again){
			handler.getGame().shooterState = new ShooterState(handler);
			State.setState(handler.getGame().shooterState);
		}
	}

	@Override
	public void render(Graphics g) {
		if(win){
			g.drawImage(Assets.win, 0, 0, null);
		}
		else{
			g.drawImage(Assets.lose, 0, 0, null);
		}
	}

}
