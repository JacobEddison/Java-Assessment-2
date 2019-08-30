package com.qa.theInfiniteTesselatingSwamp;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		App app = new App();
		Player player = new Player(0,0);
		ArrayList<Tile> board = new ArrayList<Tile>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Select size of game: ");
		float gridSize = sc.nextInt();
		app.initialiseBoard(gridSize, board);
		app.startingTreasure(gridSize, board);
		app.startingPlayer(gridSize, board, player);
		app.playerDistance(player, board);
		System.out.println(player.getDistance());
		System.out.println("You are "+player.getDistance()+"units from the treasure, which direction do you whish to travel?");
		while (player.getDistance() != 0) {
			
			String direction = sc.nextLine();
			
			switch (direction.toLowerCase()) {
				case "north":
					if (player.getY() != (int)gridSize) {
						player.setY(player.getY()+1); 
						System.out.println(player.getY());
					} else {
						player.setY(0);
					}
					break;
				case "south":
					if (player.getY() != 0) {
						player.setY(player.getY()-1); 
					} else {
						player.setY((int)gridSize);
					}
					break;
				case "east":
					if (player.getX() != (int)gridSize) {
						player.setX(player.getX()+1); 
					} else {
						player.setX(0);
					}
					break;
				case "west":
					if (player.getX() != 0) {
						player.setX(player.getX()-1); 
					} else {
						player.setX((int)gridSize);
					}
					break;
			}
			app.playerDistance(player, board);
			System.out.println("You are "+player.getDistance()+"units from the treasure, which direction do you whish to travel?");
		}
		System.out.println("Well done you found it!!!!!");
		
		sc.close();
		board.clear();
	}
	public void initialiseBoard(float gridSize, ArrayList<Tile> board) {
		for (int i=0; i< (int)gridSize; i++) {
			for (int j=0; j<(int)gridSize; j++) {
				board.add(new Tile(i,j));			
			}
		}
		
	}
	
	public void startingTreasure(float gridSize, ArrayList<Tile> board) {
		double random =  Math.random()*Math.random()*gridSize;
		board.get((int)random).setTreasure(true);
		
	}
	
	public Player startingPlayer(float gridSize, ArrayList<Tile> board, Player player) {
		double random =  Math.random()*gridSize;
		System.out.println(random);
		while (board.get((int)random).getTreasure() == false) {
			player.setX((int) (Math.random()*gridSize));
			System.out.println(player.getX());
			player.setY(board.get((int)random).getY());
			System.out.println(player.getY());
			random = Math.random()*gridSize;
			return player;
		}
		return player;
		 
		
	}
	
	public double playerDistance(Player player, ArrayList<Tile> board) {
		int x1 = 0;
		int y1 = 0;
		int x2 = player.getX();
		int y2 = player.getY();
		for (int i=0; i < board.size();i++) {
			if (board.get(i).getTreasure() == true) {
				x1 = board.get(i).getX();
				y1 = board.get(i).getY();
				System.out.println(x1+" "+x2+" "+y1+" "+y2);
		//		System.out.println(x2+" "+y2);
				
			}else {
//				System.out.println(x1+" "+y1);
			}
//			System.out.println(x1+" "+y1);
		}
		int x = x1-x2;
		int y = y1-y2;
		double square = Math.abs(x*x) + Math.abs(y*y);
		double distance = Math.sqrt(square);
		System.out.println(x+" "+y+" "+square);
		//double distance = Math.sqrt((x1-x2)^2+(y1-y2)^2);
		player.setDistance(distance);
		
		return distance;
	}
}

