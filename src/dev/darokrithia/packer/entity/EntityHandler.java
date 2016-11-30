package dev.darokrithia.packer.entity;

import java.awt.Graphics;
import java.util.ArrayList;

import dev.darokrithia.packer.utilities.Handler;

public class EntityHandler {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	public EntityHandler(Handler handler){
		this.handler = handler;
		entities = new ArrayList<Entity>();
	}
	
	public void tick(){
		for (int i = 0; i < entities.size(); i++){
			entities.get(i).tick();
		}
	}
	
	public void render(Graphics g){
		for (int i = 0; i < entities.size(); i++){
			entities.get(i).render(g);
		}
	}
	
	public void removeEntity(Entity e){
		entities.remove(e);
		e = null;
	}
	
	public void addEntity(Entity e){
		entities.add(e);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public Object hasProjectile() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean containsEntityType(ArrayList<Entity> eList, Entity e){
		ArrayList<Object> cList = new ArrayList<Object>();
		for (int i = 0; i < eList.size(); i++){
			cList.add(eList.get(i).getClass());
		}
		if(cList.contains(e.getClass())){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean containsEntityType(ArrayList<Entity> eList, @SuppressWarnings("rawtypes") Class cl) {
		ArrayList<Object> cList = new ArrayList<Object>();
		for (int i = 0; i < eList.size(); i++){
			cList.add(eList.get(i).getClass());
		}
		if(cList.contains(cl)){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean hasProjectile(ArrayList<Entity> e) {
		for (int i = 0; i < e.size(); i++){
			Entity ent = entities.get(i);
			if(ent.getClass().equals(Projectile.class)){
			}
		}
		return false;
	}
	
}
