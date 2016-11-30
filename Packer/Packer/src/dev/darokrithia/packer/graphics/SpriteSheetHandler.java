package dev.darokrithia.packer.graphics;

import java.awt.image.BufferedImage;

public class SpriteSheetHandler {
	
	private BufferedImage sheet;
	
	public SpriteSheetHandler(BufferedImage s){
		this.sheet = s;
	}
	public SpriteSheetHandler(String s){
		this.sheet = ImageHandler.loadImage(s);
	} 
	
	public BufferedImage selectImage(int x, int y, int w, int h){
		return this.sheet.getSubimage(x, y, w, h);
	}
	
}
