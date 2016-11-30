package dev.darokrithia.packer.entity;

import dev.darokrithia.packer.graphics.Animation;
import dev.darokrithia.packer.utilities.Handler;

public class EnemyProjectile extends Projectile{

	public EnemyProjectile(float x, float y, int w, int h, int m, int ySpeed, int xSpeed, boolean enemy, Animation ani,
			Handler handler) {
		super(x, y, w, h, m, ySpeed, xSpeed, enemy, ani, handler);
		// TODO Auto-generated constructor stub
	}

}
