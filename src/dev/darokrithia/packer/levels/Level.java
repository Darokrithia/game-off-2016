package dev.darokrithia.packer.levels;

import java.awt.Graphics;

import dev.darokrithia.packer.entity.EntityHandler;
import dev.darokrithia.packer.entity.EvilAndroid;
import dev.darokrithia.packer.entity.FinalEnemy;
import dev.darokrithia.packer.entity.Player;
import dev.darokrithia.packer.tiles.Tile;
import dev.darokrithia.packer.utilities.FileHandler;
import dev.darokrithia.packer.utilities.Handler;

public class Level {

	private int width;
	private int height;
	private int playerX;
	private int playerY;
	
	private int[][] layout;
	private Handler handler;
	
	private EntityHandler entityHandler;
	private Player player;
	
	public Level(int[][] layout){
		this.layout = layout;
	}
	public Level(String path, Handler handler){
		this.handler = handler;
		handler.setLevel(this);
		
		entityHandler = new EntityHandler(handler);
		
		loadWorld(path);
		
		player = new Player(playerX, playerY, handler);
		entityHandler.setPlayer(player);
		entityHandler.addEntity(player);
		
	}
	
	public void tick(){
		entityHandler.tick();
	}
	public void render(Graphics g){
		int lowestVisibleX = ((int) Math.max(0, handler.getCamera().getXOffset()/Tile.SIZE));
		int greatestVisibleX = ((int) Math.min(width, (handler.getCamera().getXOffset()+handler.getWidth())/Tile.SIZE + 1));
		int lowestVisibleY = ((int) Math.max(0, handler.getCamera().getYOffset()/Tile.SIZE));
		int greatestVisibleY = ((int) Math.min(height, (handler.getCamera().getYOffset()+handler.getHeight())/Tile.SIZE + 1));
		
		
		for(int i = lowestVisibleX; i < greatestVisibleX; i++){
			for (int j = lowestVisibleY; j<greatestVisibleY; j++){
				getTile(i,j).render(g, (int)((i*Tile.SIZE)-handler.getCamera().getXOffset()), (int)((j*Tile.SIZE)-handler.getCamera().getYOffset()));
			}
		}
		entityHandler.render(g);
	}
	
	public Tile getTile(int x, int y){
		if (x < 0 || x >= width || y < 0 || y >= height){
			return Tile.grassTitle;
		}
		else{
			Tile tile = Tile.tiles[layout[x][y]];
			if(tile == null){
				return Tile.waterTile;
			}
			return tile;
		}
	}
	
	public void loadWorld(String path){
		String file = FileHandler.loadFile(path);
		String[] data = file.split("\\s+");
		String[] temp = file.split("ENT");
		String[] entities = temp[1].split("\\s+");
		width = FileHandler.parseInt(data[0]);
		height = FileHandler.parseInt(data[1]);
		playerX = FileHandler.parseInt(data[2]);
		playerY = FileHandler.parseInt(data[3]);
		
		handler.getGame().setHeight((height*64)-512);
		handler.getGame().setWidth((width*64)-512);
		
		layout = new int[width][height]; 
		for (int i = 0; i < width; i++){
			for (int j = 0; j < height; j++){
				layout[i][j] = FileHandler.parseInt(data[(i+(j*width))+4]);
			}
		}
		for (int i = 0; (i*3 +2) < entities.length; i++){
			int entType = FileHandler.parseInt(entities[i*3]);
			int xSpot = FileHandler.parseInt(entities[i*3 + 1]);
			int ySpot = FileHandler.parseInt(entities[i*3 + 2]);
			
			switch(entType){
				case 1:
					EvilAndroid e = new EvilAndroid(xSpot,ySpot,handler);
					handler.getEntityHandler().addEntity(e);
					break;
				case 2:
					FinalEnemy f = new FinalEnemy(xSpot,ySpot,handler);
					handler.getEntityHandler().addEntity(f);
					break;
				default:
					break;
			}
		}
	}
	public int getPlayerX() {
		return (int) this.player.getX();
	}
	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}
	public int getPlayerY() {
		return (int) this.player.getY();
	}
	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public EntityHandler getEntityHandler() {
		return entityHandler;
	}
	public void setEntityHandler(EntityHandler entityHandler) {
		this.entityHandler = entityHandler;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}	
}