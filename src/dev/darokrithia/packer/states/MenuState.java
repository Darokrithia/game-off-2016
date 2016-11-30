package dev.darokrithia.packer.states;

import java.awt.Graphics;

import dev.darokrithia.packer.graphics.Assets;
import dev.darokrithia.packer.utilities.Handler;

public class MenuState extends State{
	
	public MenuState(Handler handler){
		super(handler);
	}

	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.packerDownStatic, 0, 0, null );
	}

}
