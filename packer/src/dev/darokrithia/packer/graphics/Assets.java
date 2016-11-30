package dev.darokrithia.packer.graphics;

import java.awt.image.BufferedImage;

import dev.darokrithia.packer.Main;

public class Assets {
	//Packer's Animations and graphics
	public static SpriteSheetHandler packerSpriteSheet;
	public static BufferedImage packerDownStatic;
	public static BufferedImage packerRightStatic;
	public static BufferedImage packerUpStatic;
	public static BufferedImage packerLeftStatic;
	
	public static BufferedImage packerDownStaticShoot;
	public static BufferedImage packerRightStaticShoot;
	public static BufferedImage packerUpStaticShoot;
	public static BufferedImage packerLeftStaticShoot;

	public static BufferedImage[] packerDownMove = new BufferedImage[4];
	public static BufferedImage[] packerRightMove = new BufferedImage[4];
	public static BufferedImage[] packerUpMove = new BufferedImage[4];
	public static BufferedImage[] packerLeftMove = new BufferedImage[4];
	
	public static BufferedImage[] packerDownShoot = new BufferedImage[4];
	public static BufferedImage[] packerRightShoot = new BufferedImage[4];
	public static BufferedImage[] packerUpShoot = new BufferedImage[4];
	public static BufferedImage[] packerLeftShoot = new BufferedImage[4];
	

	//Enemies' Animations and graphics
	public static SpriteSheetHandler enemySpriteSheet;
	public static BufferedImage enemyStatic;
	
	public static BufferedImage enemyDownStaticShoot;
	public static BufferedImage enemyRightStaticShoot;
	public static BufferedImage enemyUpStaticShoot;
	public static BufferedImage enemyLeftStaticShoot;

	public static BufferedImage[] enemyDownMove = new BufferedImage[4];
	public static BufferedImage[] enemyRightMove = new BufferedImage[4];
	public static BufferedImage[] enemyUpMove = new BufferedImage[4];
	public static BufferedImage[] enemyLeftMove = new BufferedImage[4];
	
	public static BufferedImage[] enemyDownShoot = new BufferedImage[4];
	public static BufferedImage[] enemyRightShoot = new BufferedImage[4];
	public static BufferedImage[] penemyUpShoot = new BufferedImage[4];
	public static BufferedImage[] enemyLeftShoot = new BufferedImage[4];
	
	public static SpriteSheetHandler alliedSpriteSheet;
	public static BufferedImage alliedStatic;
	
	public static BufferedImage alliedDownStaticShoot;
	public static BufferedImage alliedRightStaticShoot;
	public static BufferedImage alliedUpStaticShoot;
	public static BufferedImage alliedLeftStaticShoot;

	public static BufferedImage[] alliedDownMove = new BufferedImage[4];
	public static BufferedImage[] alliedRightMove = new BufferedImage[4];
	public static BufferedImage[] alliedUpMove = new BufferedImage[4];
	public static BufferedImage[] alliedLeftMove = new BufferedImage[4];
	
	public static BufferedImage[] alliedDownShoot = new BufferedImage[4];
	public static BufferedImage[] alliedRightShoot = new BufferedImage[4];
	public static BufferedImage[] alliedUpShoot = new BufferedImage[4];
	public static BufferedImage[] alliedLeftShoot = new BufferedImage[4];
	

	public static SpriteSheetHandler deadEnemySpriteSheet;
	public static BufferedImage deadEnemy;
	
	public static SpriteSheetHandler finalEnemySpriteSheet;
	public static BufferedImage finalEnemy;
	
	//Projectile graphics
	public static SpriteSheetHandler bulletSpriteSheet;
	public static BufferedImage[] packerBulletRight = new BufferedImage[2];
	public static BufferedImage[] packerBulletLeft = new BufferedImage[2];
	public static BufferedImage[] packerBulletUp = new BufferedImage[2];
	public static BufferedImage[] packerBulletDown = new BufferedImage[2];
	
	public static BufferedImage[] evilBulletRight = new BufferedImage[2];
	public static BufferedImage[] evilBulletLeft = new BufferedImage[2];
	public static BufferedImage[] evilBulletUp = new BufferedImage[2];
	public static BufferedImage[] evilBulletDown = new BufferedImage[2];
	
	//Tile Animations and graphics
	public static SpriteSheetHandler tileSpriteSheet;
	public static BufferedImage grassTile;
	public static BufferedImage tileTile;
	public static BufferedImage carpetTile;
	public static BufferedImage waterTile;
	public static BufferedImage brickTile;
	
	//Hack mode
	public static SpriteSheetHandler hackText;
	
	public static SpriteSheetHandler winText;
	public static SpriteSheetHandler loseText;
	
	public static BufferedImage win;
	public static BufferedImage lose;
	
	public static void init(){
		packerSpriteSheet = new SpriteSheetHandler(Main.packer);
		packerDownStatic = packerSpriteSheet.selectImage(0, 0, 32, 32);
		packerRightStatic = packerSpriteSheet.selectImage(32, 0, 32, 32);
		packerUpStatic = packerSpriteSheet.selectImage(64, 0, 32, 32);
		packerLeftStatic = packerSpriteSheet.selectImage(96, 0, 32, 32);
		
		packerDownStaticShoot = packerSpriteSheet.selectImage(128, 0, 32, 32);
		packerRightStaticShoot = packerSpriteSheet.selectImage(160, 0, 32, 32);
		packerUpStaticShoot = packerSpriteSheet.selectImage(192, 0, 32, 32);
		packerLeftStaticShoot = packerSpriteSheet.selectImage(224, 0, 32, 32);
		
		packerDownMove[0] = packerSpriteSheet.selectImage(0, 32, 32, 32);
		packerRightMove[0] = packerSpriteSheet.selectImage(32, 32, 32, 32);
		packerUpMove[0] = packerSpriteSheet.selectImage(64, 32, 32, 32);
		packerLeftMove[0] = packerSpriteSheet.selectImage(96, 32, 32, 32);
		packerDownMove[1] = packerSpriteSheet.selectImage(0, 0, 32, 32);
		packerRightMove[1] = packerSpriteSheet.selectImage(32, 0, 32, 32);
		packerUpMove[1] = packerSpriteSheet.selectImage(64, 0, 32, 32);
		packerLeftMove[1] = packerSpriteSheet.selectImage(96, 0, 32, 32);
		packerDownMove[2] = packerSpriteSheet.selectImage(0, 64, 32, 32);
		packerRightMove[2] = packerSpriteSheet.selectImage(32, 64, 32, 32);
		packerUpMove[2] = packerSpriteSheet.selectImage(64, 64, 32, 32);
		packerLeftMove[2] = packerSpriteSheet.selectImage(96, 64, 32, 32);
		packerDownMove[3] = packerSpriteSheet.selectImage(0, 96, 32, 32);
		packerRightMove[3] = packerSpriteSheet.selectImage(32, 96, 32, 32);
		packerUpMove[3] = packerSpriteSheet.selectImage(64, 96, 32, 32);
		packerLeftMove[3] = packerSpriteSheet.selectImage(96, 96, 32, 32);
		
		packerDownShoot[0] = packerSpriteSheet.selectImage(128, 32, 32, 32);
		packerRightShoot[0] = packerSpriteSheet.selectImage(160, 32, 32, 32);
		packerUpShoot[0] = packerSpriteSheet.selectImage(192, 32, 32, 32);
		packerLeftShoot[0] = packerSpriteSheet.selectImage(224, 32, 32, 32);
		packerDownShoot[1] = packerSpriteSheet.selectImage(128, 0, 32, 32);
		packerRightShoot[1] = packerSpriteSheet.selectImage(160, 0, 32, 32);
		packerUpShoot[1] = packerSpriteSheet.selectImage(192, 0, 32, 32);
		packerLeftShoot[1] = packerSpriteSheet.selectImage(224, 0, 32, 32);
		packerDownShoot[2] = packerSpriteSheet.selectImage(128, 64, 32, 32);
		packerRightShoot[2] = packerSpriteSheet.selectImage(160, 64, 32, 32);
		packerUpShoot[2] = packerSpriteSheet.selectImage(192, 64, 32, 32);
		packerLeftShoot[2] = packerSpriteSheet.selectImage(224, 64, 32, 32);
		packerDownShoot[3] = packerSpriteSheet.selectImage(128, 96, 32, 32);
		packerRightShoot[3] = packerSpriteSheet.selectImage(160, 96, 32, 32);
		packerUpShoot[3] = packerSpriteSheet.selectImage(192, 96, 32, 32);
		packerLeftShoot[3] = packerSpriteSheet.selectImage(224, 96, 32, 32);
		

		enemySpriteSheet = new SpriteSheetHandler(Main.enemy);
		enemyStatic = enemySpriteSheet.selectImage(0, 0, 32, 32);
		
		enemyDownStaticShoot = enemySpriteSheet.selectImage(0, 0, 32, 32);
		
		enemyDownMove[0] = enemySpriteSheet.selectImage(0, 32, 32, 32);
		enemyRightMove[0] = enemySpriteSheet.selectImage(32, 32, 32, 32);
		enemyUpMove[0] = enemySpriteSheet.selectImage(64, 32, 32, 32);
		enemyLeftMove[0] = enemySpriteSheet.selectImage(96, 32, 32, 32);
		enemyDownMove[1] = enemySpriteSheet.selectImage(0, 0, 32, 32);
		enemyRightMove[1] = enemySpriteSheet.selectImage(32, 0, 32, 32);
		enemyUpMove[1] = enemySpriteSheet.selectImage(64, 0, 32, 32);
		enemyLeftMove[1] = enemySpriteSheet.selectImage(96, 0, 32, 32);
		enemyDownMove[2] = enemySpriteSheet.selectImage(0, 64, 32, 32);
		enemyRightMove[2] = enemySpriteSheet.selectImage(32, 64, 32, 32);
		enemyUpMove[2] = enemySpriteSheet.selectImage(64, 64, 32, 32);
		enemyLeftMove[2] = enemySpriteSheet.selectImage(96, 64, 32, 32);
		enemyDownMove[3] = enemySpriteSheet.selectImage(0, 96, 32, 32);
		enemyRightMove[3] = enemySpriteSheet.selectImage(32, 96, 32, 32);
		enemyUpMove[3] = enemySpriteSheet.selectImage(64, 96, 32, 32);
		enemyLeftMove[3] = enemySpriteSheet.selectImage(96, 96, 32, 32);
		
		alliedSpriteSheet = new SpriteSheetHandler(Main.ally);
		alliedStatic = alliedSpriteSheet.selectImage(0, 0, 32, 32);
		
		alliedDownStaticShoot = alliedSpriteSheet.selectImage(0, 0, 32, 32);
		
		alliedDownMove[0] = alliedSpriteSheet.selectImage(0, 32, 32, 32);
		alliedRightMove[0] = alliedSpriteSheet.selectImage(32, 32, 32, 32);
		alliedUpMove[0] = alliedSpriteSheet.selectImage(64, 32, 32, 32);
		alliedLeftMove[0] = alliedSpriteSheet.selectImage(96, 32, 32, 32);
		alliedDownMove[1] = alliedSpriteSheet.selectImage(0, 0, 32, 32);
		alliedRightMove[1] = alliedSpriteSheet.selectImage(32, 0, 32, 32);
		alliedUpMove[1] = alliedSpriteSheet.selectImage(64, 0, 32, 32);
		alliedLeftMove[1] = alliedSpriteSheet.selectImage(96, 0, 32, 32);
		alliedDownMove[2] = alliedSpriteSheet.selectImage(0, 64, 32, 32);
		alliedRightMove[2] = alliedSpriteSheet.selectImage(32, 64, 32, 32);
		alliedUpMove[2] = alliedSpriteSheet.selectImage(64, 64, 32, 32);
		alliedLeftMove[2] = alliedSpriteSheet.selectImage(96, 64, 32, 32);
		alliedDownMove[3] = alliedSpriteSheet.selectImage(0, 96, 32, 32);
		alliedRightMove[3] = alliedSpriteSheet.selectImage(32, 96, 32, 32);
		alliedUpMove[3] = alliedSpriteSheet.selectImage(64, 96, 32, 32);
		alliedLeftMove[3] = alliedSpriteSheet.selectImage(96, 96, 32, 32);
		
		deadEnemySpriteSheet = new SpriteSheetHandler(Main.dead);
		deadEnemy = deadEnemySpriteSheet.selectImage(0, 0, 32, 32);
		finalEnemySpriteSheet = new SpriteSheetHandler(Main.bigBad);
		finalEnemy = finalEnemySpriteSheet.selectImage(0, 0, 128, 128);
		
		bulletSpriteSheet = new SpriteSheetHandler(Main.projectiles);
		packerBulletRight[0] = bulletSpriteSheet.selectImage(0, 0, 16, 16);
		packerBulletRight[1] = bulletSpriteSheet.selectImage(16, 0, 16, 16);
		packerBulletLeft[0] = bulletSpriteSheet.selectImage(0, 16, 16, 16);
		packerBulletLeft[1] = bulletSpriteSheet.selectImage(16, 16, 16, 16);
		packerBulletUp[0] = bulletSpriteSheet.selectImage(0, 32, 16, 16);
		packerBulletUp[1] = bulletSpriteSheet.selectImage(16, 32, 16, 16);
		packerBulletDown[0] = bulletSpriteSheet.selectImage(0, 48, 16, 16);
		packerBulletDown[1] = bulletSpriteSheet.selectImage(16, 48, 16, 16);
		
		evilBulletRight[0] = bulletSpriteSheet.selectImage(32, 0, 16, 16);
		evilBulletRight[1] = bulletSpriteSheet.selectImage(48, 0, 16, 16);
		evilBulletLeft[0] = bulletSpriteSheet.selectImage(32, 16, 16, 16);
		evilBulletLeft[1] = bulletSpriteSheet.selectImage(48, 16, 16, 16);
		evilBulletUp[0] = bulletSpriteSheet.selectImage(32, 32, 16, 16);
		evilBulletUp[1] = bulletSpriteSheet.selectImage(48, 32, 16, 16);
		evilBulletDown[0] = bulletSpriteSheet.selectImage(32, 48, 16, 16);
		evilBulletDown[1] = bulletSpriteSheet.selectImage(48, 48, 16, 16);
		
		tileSpriteSheet = new SpriteSheetHandler(Main.tiles);
		grassTile = tileSpriteSheet.selectImage(0, 0, 32, 32);
		tileTile = tileSpriteSheet.selectImage(32, 0, 32, 32);
		carpetTile = tileSpriteSheet.selectImage(64, 0, 32, 32);
		waterTile = tileSpriteSheet.selectImage(96, 0, 32, 32);
		brickTile = tileSpriteSheet.selectImage(0, 32, 32, 32);
		
		hackText = new SpriteSheetHandler(Main.hack);
		
		winText = new SpriteSheetHandler(Main.win);
		win = winText.selectImage(0, 0, 512, 512);
		loseText = new SpriteSheetHandler(Main.lose);
		lose = loseText.selectImage(0, 0, 512, 512);
	}

}
