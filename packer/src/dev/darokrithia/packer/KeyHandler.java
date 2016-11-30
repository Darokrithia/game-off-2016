package dev.darokrithia.packer;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	private boolean[] keys;
	public boolean upMove;
	public boolean downMove;
	public boolean leftMove;
	public boolean rightMove;
	public boolean upShoot;
	public boolean downShoot;
	public boolean leftShoot;
	public boolean rightShoot;
	
	public boolean again;
	
	public boolean hack;
	
	public boolean typedSpam;
	
	public KeyHandler(){
		keys = new boolean[256];
	}
	
	public void tick(){
		upMove = keys[KeyEvent.VK_W];
		leftMove = keys[KeyEvent.VK_A];
		downMove = keys[KeyEvent.VK_S];
		rightMove = keys[KeyEvent.VK_D];
		
		upShoot = keys[KeyEvent.VK_UP];
		leftShoot = keys[KeyEvent.VK_LEFT];
		downShoot = keys[KeyEvent.VK_DOWN];
		rightShoot = keys[KeyEvent.VK_RIGHT];
		
		again = keys[KeyEvent.VK_ENTER];
		
		hack = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyTyped(KeyEvent e) {
		typedSpam = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}

}
