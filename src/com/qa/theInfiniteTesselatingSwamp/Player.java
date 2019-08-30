package com.qa.theInfiniteTesselatingSwamp;

public class Player {
	int x;
	int y;
	double distance;
	
	
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
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDistance() {
		return distance;
	}
	
	//builder
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
