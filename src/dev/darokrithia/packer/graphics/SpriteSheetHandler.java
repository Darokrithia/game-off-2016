package dev.darokrithia.packer.graphics;

import java.awt.image.BufferedImage;
import java.io.InputStream;

public class SpriteSheetHandler {
	
	private BufferedImage sheet;
	
	public SpriteSheetHandler(BufferedImage s){
		this.sheet = s;
	}
	public SpriteSheetHandler(InputStream s){
		this.sheet = ImageHandler.loadImage(s);
	}
	
	public BufferedImage selectImage(int x, int y, int w, int h){
		return this.sheet.getSubimage(x, y, w, h);
	}
	
}
