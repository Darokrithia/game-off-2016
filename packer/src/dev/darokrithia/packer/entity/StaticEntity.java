package dev.darokrithia.packer.entity;

import dev.darokrithia.packer.utilities.Handler;

public abstract class StaticEntity extends Entity{

	public StaticEntity(float x, float y, int w, int h, Handler handler) {
		super(x, y, w, h, handler);
	}

}
