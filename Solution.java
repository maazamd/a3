public class Solution {
	
	private static int numCalls;
	private Cube[] cubes;
	
	Solution(Cube[] cubes) {
		this.cubes = cubes;
	}
	
	Solution(Solution other, Cube c) {
		
	}
	
	public int size() {
		return cubes.length;
	}
	
	public Cube getCube(int pos) {
		return Cube[pos];
	}
	
	public boolean isValid() {
		for (int i = 0; i < cubes.length; i++) {
			for (int j = 0; j < cubes.length; j++) {
				if (cubes[i].getFront() = cubes[j].getFront() || cubes[i].getBack() = cubes[j].getBack() || cubes[i].getRight() = cubes[j].getRight() || cubes[i].Left() = cubes[j].getLeft()) {
					if (j != i) {
						return false;
					}
				}
			}
		}
		numCalls++;
		return true;
	}
	
	public boolean isValid(Cube next) {
		if (isValid() == true) {
			for (int i = 0; i < cubes.length; i++) {
				if (cubes[i].getFront() = next.getFront() || cubes[i].getBack() = next.getBack() || cubes[i].getRight() = next.getRight() || cubes[i].getLeft() = next.getLeft()) {
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
			return "[ "+cubes[0].toString+", "+cubes[1].toString+", "+cubes[2].toString+", "+cubes[3].toString+" ]";
		}
		else if (cubes.length == 3) {
			return "[ "+cubes[0].toString+", "+cubes[1].toString+", "+cubes[2].toString+" ]";
		}
		else if (cubes.length == 2) {
			return "[ "+cubes[0].toString+", "+cubes[1].toString+" ]";
		}		
		else if (cubes.length == 1) {
			return "[ "+cubes[0].toString+" ]";
		}
		return "There are no cubes given";
	}
	
	public void resetNumberOfCalls() {
		numCalls = 0;
	}
	
	public int getNumberOfCalls() {
		return numCalls;
	}
	
}