package dev.darokrithia.packer.tiles;

import dev.darokrithia.packer.graphics.Assets;

public class GrassTile extends Tile{

	public GrassTile(int ID) {
		super(ID, Assets.grassTile);
		this.walkable = true;
		this.passable = true;
	}

}
