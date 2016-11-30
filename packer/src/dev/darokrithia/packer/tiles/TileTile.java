package dev.darokrithia.packer.tiles;

import dev.darokrithia.packer.graphics.Assets;

public class TileTile extends Tile{

	public TileTile(int ID) {
		super(ID, Assets.tileTile);
		this.walkable = true;
		this.passable = true;
	}

}
