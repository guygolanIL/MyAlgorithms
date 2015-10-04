package algorithms.demo;

import algorithms.mazeGenerators.Maze3d;

public class Test {

	public static void main(String[] args) {
		byte[] b = {3,3,3,
				0,0,0,
				0,0,0,
				
				1,2,4,
				4,0,6,
				7,8,9,
				
				
				1,2,3,
				4,5,6,
				7,8,9,
				
				
				1,2,3,
				4,5,7,
				8,8,9};
		
		Maze3d maze = new Maze3d(b);
		int[][] plainx = maze.getCrossSectionByX(0);
		int[][] plainy = maze.getCrossSectionByY(1);
		int[][] plainz = maze.getCrossSectionByZ(0);
		
		for (int[] is : plainz) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println("");
		}
			
	}

}
