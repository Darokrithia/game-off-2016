package dev.darokrithia.packer.tiles;

import dev.darokrithia.packer.graphics.Assets;

public class BrickTile extends Tile{

	public BrickTile(int ID) {
		super(ID, Assets.brickTile);
		this.walkable = false;
		this.passable = false;
	}

}
