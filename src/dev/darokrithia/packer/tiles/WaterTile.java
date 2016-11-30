package dev.darokrithia.packer.tiles;

import dev.darokrithia.packer.graphics.Assets;

public class WaterTile extends Tile{

	public WaterTile(int ID) {
		super(ID, Assets.waterTile);
		this.walkable = false;
		this.passable = true;
	}

}
