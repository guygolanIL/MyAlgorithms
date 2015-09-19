package algorithms.search;

import java.util.ArrayList;

/**
 * The Solution type is used to return a sequence of states from a search algorithm.
 * @author Guy Golan
 *
 */

public class Solution<T> {
	
	private ArrayList<State<T>> arr;
	
	/**
	 * A non - default constructor.
	 */
	public Solution(){
		this.arr= new ArrayList<State<T>>();
	}


	public ArrayList<State<T>> getArr() {return arr;}

/**
 * The method prints each State in the solution array. 
 */
	public void print() {
		
		for(State<T> s : this.arr){
			System.out.print(s.getState() + " ");
		}
		System.out.println("");
	}

	@Override
	public String toString() {
		String s="";
		
		for(State<T> state : this.arr){
			s+= state.getState() + " ";
		}
		
		
		
		return s;
	}
	
/**
 *adding a State to the final Solution in a specific index.
 * @param i	- int : an index to for the state to be inserted to.
 * @param s - State.
 */
	public void add(int i, State<T> s) {
		
		this.arr.add(i , s);
	}


	@Override
	public boolean equals(Object obj) {
		Solution s = (Solution)obj;
		if(s.arr.size() != this.arr.size())
			return false;
		
			for (int i = 0; i < s.arr.size(); i++){
				if(!this.arr.get(i).equals(s.arr.get(i)))return false;
			}
		
		
			return true;
		
	}
}
