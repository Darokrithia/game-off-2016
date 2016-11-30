package dev.darokrithia.packer;

public class Main {
	
	public static void main(String args[]){
		// Class.getResourceAsStream
        Object resource1 = Main.class.getResourceAsStream("nested");
        Object resource2 = Main.class.getResourceAsStream("nested");
        
        resource1 = Main.class.getResourceAsStream("/images/packerSpriteSheet.png");
        resource2 = Main.class.getResourceAsStream("/images/tileSpriteSheet.png");

		Game game = new Game("Packer",512,512);
		game.start();
	}

}
