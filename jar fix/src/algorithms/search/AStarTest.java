package algorithms.search;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;

/**
 * In charge of testing the AStar Class.
 * @author Guy Golan && Amit Sandak
 *
 */
public class AStarTest {

	
	/**
	 *	A test for the shortest path.
	 */
	@Test
	public void shortestPathTest() {
		AStar<Position> searchTest = new AStar<Position>(new MazeAirDistance(new State<Position>(new Position(0,3,1))));
		byte[] maze = {5,5,5,
				0,1,0,
				0,3,1,
				
				1,1,1,1,1,
				0,0,0,0,1,
				1,0,1,0,1,
				1,0,0,0,1,
				1,1,1,1,1,
				
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1};
				
		
		Solution<Position> result = searchTest.search(new MazeDomain(new Maze3d(maze)));
		Solution<Position> s = new Solution<Position>();
		s.add(0, new State<Position>(new Position(0,3,1)));
		s.add(0, new State<Position>(new Position(0,2,1)));
		s.add(0, new State<Position>(new Position(0,1,1)));
		s.add(0, new State<Position>(new Position(0,1,0)));		
		
		System.out.println(s);
		System.out.println(result);
		assertEquals(s , result);
	}
	
	/**
	 * checks if AStar behaves correctly if the goal state and exit state are equal.
	 */
	@Test
	public void entranceEqualsExitTest() {
		AStar<Position> searchTest = new AStar<Position>(new MazeAirDistance(new State<Position>(new Position(0,1,0))));
		byte[] maze = {5,5,5,
				0,1,0,
				0,1,0,
				
				1,1,1,1,1,
				0,0,0,0,1,
				1,0,1,0,1,
				1,0,0,0,1,
				1,1,1,1,1,
				
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1,
				1,1,1,1,1};
				
		
		Solution<Position> result = searchTest.search(new MazeDomain(new Maze3d(maze)));
		Solution<Position> s = new Solution<Position>();
		
		s.add(0, new State<Position>(new Position(0,1,0)));		
		
		System.out.println(s);
		System.out.println(result);
		assertEquals(s , result);
	}
}


