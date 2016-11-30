package dev.darokrithia.packer.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageHandler {

	public static BufferedImage loadImage(InputStream s){
		try {
			return ImageIO.read(s);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error, image not found");
			System.exit(0);
		}
		return null;
	}
	
}
