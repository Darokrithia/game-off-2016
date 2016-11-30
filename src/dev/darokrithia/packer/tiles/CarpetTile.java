package dev.darokrithia.packer.tiles;

import dev.darokrithia.packer.graphics.Assets;

public class CarpetTile extends Tile{

	public CarpetTile(int ID) {
		super(ID, Assets.carpetTile);
		this.walkable = true;
		this.passable = true;
	}

}
