/**
 * The class <b>Solution</b> represents a stack of cubes with various
 * orientations of their own (which, if all are unique, can be classified as a valid solution).
 *
 * @author Maaz Ahmad, Richard Guan
 */
public class Solution {
	
	/**
	* A counter for the total number of checks towards the validity of a solution.
	*/
	
	private static int numCalls;
	/**
	* A list of cubes representing the stack of cubes used for the puzzle.
	*/
	
	private Cube[] cubes;
	/**
	* A counter for the number of solutions that are actually valid.
	*/
	
	private static int totalValidSolutions;
	
	/**
     * Constructor used to initialize a solution (a state orientations
	 * of given cubes).
     * 
     * @param cubes
     *            the cubes that the solution is to consist of.
     */
	Solution(Cube[] cubes) {
		this.cubes = cubes;
	}
	
	/**
     * Constructor used for merging one stack of cubes with another
	 * cube.
     * 
     * @param other
     *            the other solution (stack of cubes).
     * @param c
     *            the additional cube to be added to the solution.
     */
	Solution(Solution other, Cube c) {
		cubes = new Cube[other.size()+1];
		for (int i = 0; i < other.size(); i++) {
			cubes[i] = other.getCube(i);
		}
		cubes[other.size()] = c;
	}
	
	public int size() {
		return cubes.length;
	}
	
	public Cube getCube(int pos) {
		return cubes[pos];
	}
	
	public boolean isValid() {
		numCalls++;
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes.length; j++) {
				if (cubes[i].getFront() == cubes[j].getFront() || cubes[i].getBack() == cubes[j].getBack() || cubes[i].getRight() == cubes[j].getRight() || cubes[i].getLeft() == cubes[j].getLeft()) {
					if (j != i) {
						return false;
					}
				}
			}
		}
		totalValidSolutions++;
		return true;
	}
	
	public boolean isValid(Cube next) {
		if (isValid() == true) {
			for (int i = 0; i < cubes.length; i++) {
				if (cubes[i].getFront() == next.getFront() || cubes[i].getBack() == next.getBack() || cubes[i].getRight() == next.getRight() || cubes[i].getLeft() == next.getLeft()) {
					return false;
				}
			}
		}
		else if (isValid() == false) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		if (cubes.length == 4) {
			return "[ "+cubes[0].toString()+", "+cubes[1].toString()+", "+cubes[2].toString()+", "+cubes[3].toString()+" ]";
		}
		else if (cubes.length == 3) {
			return "[ "+cubes[0].toString()+", "+cubes[1].toString()+", "+cubes[2].toString()+" ]";
		}
		else if (cubes.length == 2) {
			return "[ "+cubes[0].toString()+", "+cubes[1].toString()+" ]";
		}		
		else if (cubes.length == 1) {
			return "[ "+cubes[0].toString()+" ]";
		}
		return "There are no cubes given";
	}
	
	public void resetNumberOfCalls() {
		numCalls = 0;
	}
	
	public int getNumberOfCalls() {
		return numCalls;
	}
	
	public int getTotalValidSolutions() {
		return totalValidSolutions;
	}
	
}