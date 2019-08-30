package com.qa.theInfiniteTesselatingSwamp;

public class Tile {
	int x;
	int y;
	boolean treasure = false;

	
	//getters and setters
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setTreasure(boolean treasure) {
		this.treasure = treasure;
	}
	
	public boolean getTreasure() {
		return treasure;
	}
	
	//builder
	public Tile(int x, int y, boolean treasure) {
		this.x = x;
		this.y = y;
		this.treasure = treasure;
	}
	
	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
