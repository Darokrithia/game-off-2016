package dev.darokrithia.packer.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTitle = new GrassTile(0);
	public static Tile tileTile = new TileTile(1);
	public static Tile carpetTile = new CarpetTile(2);
	public static Tile waterTile = new WaterTile(3);
	public static Tile brickTile = new BrickTile(4);
	
	protected final int ID;
	public static final int SIZE = 64;
	boolean walkable = false;
	boolean passable = false;
	
	protected BufferedImage image;
	
	public Tile(int ID, BufferedImage image){
		this.ID = ID;
		this.image = image;
		tiles[ID] = this;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g, int x, int y){
		g.drawImage(image, x, y, SIZE, SIZE, null);
	}
	
	public int getID(){
		return ID;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}
	
	public boolean isPassable() {
		return passable;
	}

	public void setPassable(boolean walkable) {
		this.passable = walkable;
	}
	
	
}
