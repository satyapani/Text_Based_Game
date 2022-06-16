package com.textbasedcore;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter your name:");
		String name = sc.nextLine();
		System.out.print("Please enter your catchphrase:");
		String catchphrase = sc.nextLine();
		Character player = new Character(name, 10, catchphrase);

		player.getInfo();
		
		System.out.print("Please enter map size X:");
		int maxX = Integer.parseInt(sc.nextLine());
		System.out.print("Please enter map size Y:");
		int maxY = Integer.parseInt(sc.nextLine());
		
		Random r = new Random();
		int currentX = r.nextInt(maxX+1);
		int currentY = r.nextInt(maxY+1);
		
		Map map = new Map(maxX, maxY, currentX, currentY);
		map.getInfo();
		
		int winX = r.nextInt(maxX+1);
		int winY = r.nextInt(maxY+1);
				
		String direction;
		while(map.getCurrentX() != winX || map.getCurrentY() != winY) {
			System.out.print("Please enter a direction N, E, S, or W:");
			direction = sc.nextLine();
			map.move(direction);
			map.getInfo();
			map.compass(winX, winY);
		}
		
		System.out.println("CONGRATULATIONS, YOU HAVE FOUND THE EXIT!");
		
	}

}
