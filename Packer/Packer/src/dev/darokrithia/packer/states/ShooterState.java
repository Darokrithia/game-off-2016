package dev.darokrithia.packer.states;

import java.awt.Graphics;

import dev.darokrithia.packer.levels.Level;
import dev.darokrithia.packer.utilities.Handler;

public class ShooterState extends State{
	
	private Level level1;

	public ShooterState(Handler handler){
		super(handler);
		level1 = new Level("res/levels/level1.pck",this.handler);
		handler.setLevel(level1);
	}
	
	@Override
	public void tick() {
		level1.tick();
	}

	@Override
	public void render(Graphics g) {
		level1.render(g);
	}

}
