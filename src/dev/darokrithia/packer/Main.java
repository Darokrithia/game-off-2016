package dev.darokrithia.packer;

import java.io.InputStream;

public class Main {
	
	// Class.getResourceAsStream
	
	public static InputStream packer = Main.class.getResourceAsStream("nested");
    public static InputStream tiles = Main.class.getResourceAsStream("nested");
    public static InputStream enemy = Main.class.getResourceAsStream("nested");
    public static InputStream ally = Main.class.getResourceAsStream("nested");
    public static InputStream dead = Main.class.getResourceAsStream("nested");
    public static InputStream bigBad = Main.class.getResourceAsStream("nested");
    public static InputStream projectiles = Main.class.getResourceAsStream("nested");
    public static InputStream hack = Main.class.getResourceAsStream("nested");
    public static InputStream win = Main.class.getResourceAsStream("nested");
    public static InputStream lose = Main.class.getResourceAsStream("nested");
	
	public static void main (String args[]){
	    
	    packer = Main.class.getResourceAsStream("/images/packerSpriteSheet.png");
	    tiles = Main.class.getResourceAsStream("/images/tileSpriteSheet.png");
	    enemy = Main.class.getResourceAsStream("/images/enemySpriteSheet.png");
	    ally = Main.class.getResourceAsStream("/images/hackedSpriteSheet.png");
	    dead = Main.class.getResourceAsStream("/images/deadEnemySpriteSheet.png");
	    bigBad = Main.class.getResourceAsStream("/images/evilComputer.png");
	    projectiles = Main.class.getResourceAsStream("/images/projectileSpriteSheet.png");
	    hack = Main.class.getResourceAsStream("/images/hackText.png");
	    win = Main.class.getResourceAsStream("/images/winScreen.png");
	    lose = Main.class.getResourceAsStream("/images/loseScreen.png");
		
		Game game = new Game("Packer",512,512);
		game.start();
	}

}
