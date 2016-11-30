package dev.darokrithia.packer.utilities;

import dev.darokrithia.packer.Game;
import dev.darokrithia.packer.KeyHandler;
import dev.darokrithia.packer.entity.EntityHandler;
import dev.darokrithia.packer.graphics.Camera;
import dev.darokrithia.packer.levels.Level;

public class Handler {
	
	private Game game;
	private Level level;
	
	public Handler (Game game){
		this.game = game;
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}
	
	public KeyHandler getKeyHandler(){
		return game.getKeyHandler();
	}

	public EntityHandler getEntityHandler(){
		return level.getEntityHandler();
	}
	
	public Camera getCamera(){
		return game.getCamera();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
}
