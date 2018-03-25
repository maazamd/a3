public class Cube {
	
	private String[] faces;
	private String[] original = new String[7];

	private int counter = 1;
	
	public Cube (String[] faces) {

		// Makes an array that stores the original state
		for (int i = 1; i <= 6; i++) {
			original[i] = faces[i];
		}

		this.faces = faces;
	}

	public Cube(Cube other) {
		faces = new String[7];
		int j = 1;
		String c;
		switch (j) {
			case 1:
				c = other.getUp();
				faces[j] = c;
				j++;
			break;
			case 2:
				c = other.getFront();
				faces[j] = c;
				j++;
			break;
			case 3:
				c = other.getRight();
				faces[j] = c;
				j++;
			break;
			case 4:
				c = other.getBack();
				faces[j] = c;
				j++;
			break;
			case 5:
				c = other.getLeft();
				faces[j] = c;
				j++;
			break;
			case 6:
				c = other.getDown();
				faces[j] = c;
			break;
		}

		// Makes an array that stores the original state
		for (int i = 1; i <= 6; i++) {
			original[i] = faces[i];
		}
	}

	public Cube copy() {
		return new Cube(this);
	}
	
	public String getUp() {
		return faces[1];
	}
	
	public String getFront() {
		return faces[2];
	}
	
	public String getRight() {
		return faces[3];
	}
	
	public String getBack() {
		return faces[4];
	}
	
	public String getLeft() {
		return faces[5];
	}
	
	public String getDown() {
		return faces[6];
	}
	
	public String toString() {
		return "[ "+getUp()+", "+getFront()+", "+getRight()+", "+getBack()+", "+getLeft()+", "+getDown()+"]";
	}

	public boolean hasNext() {
		if (counter > 24) {
			return false;
		}
		return true;
	}

	public void next() {
		if (counter == 1) {
			identity();
		}
		else if (counter == 5 || counter == 9 || counter == 21) {
			rightRoll();
		}
		else if (counter == 13 || counter == 17) {
			leftRoll();
		}
		else {
			rotate();
		}

		counter ++;
	}

	public void reset() {
		for (int i = 1; i <= 6; i++) {
			faces[i] = original[i];
		}
		counter = 1;
	}

	private void rotate() {
		int opr = 2;
		int oprNext = opr + 1;
		String temp0 = faces[opr], temp1;

		for (int i = 2; i <= 5; i++) {

			if (opr > 5) {
				opr = 2;
			}
			else if (opr == 5) {
				oprNext = 2;
			}

			temp1 = faces[oprNext];
			faces[oprNext] = temp0;
			temp0 = temp1;

			opr++;
			oprNext++;
		}
	}

	private void rightRoll() {
		int opr = 1;
		int oprNext = 3;
		String temp0 = faces[opr], temp1;

		for (int i = 1; i <= 4; i++) {

			if (i == 2) {
				opr = 3;
				oprNext = 6;
			}
			else if (i == 3) {
				opr = 6;
				oprNext = 5;
			}
			else if (i == 4) {
				opr = 5;
				oprNext = 1;
			}

			temp1 = faces[oprNext];
			faces[oprNext] = temp0;
			temp0 = temp1;
		}
	}

	private void leftRoll() {
		int opr = 1;
		int oprNext = 5;
		String temp0 = faces[opr], temp1;

		for (int i = 1; i <= 4; i++) {

			if (i == 2) {
				opr = 5;
				oprNext = 6;
			}
			else if (i == 3) {
				opr = 6;
				oprNext = 3;
			}
			else if (i == 4) {
				opr = 3;
				oprNext = 1;
			}

			temp1 = faces[oprNext];
			faces[oprNext] = temp0;
			temp0 = temp1;
		}
	}

	private void identity() {
		reset();
	}

	// This is used to test the methods
	public void display() {
		for (int i = 1; i <= 6; i++) {
			System.out.println(this.faces[i]);
		}
		System.out.println("------------");
	}

	// This is used to test the methods
	public static void main(String[] args) {
		Cube c;
		c = new Cube(new String[]{"none","BLUE", "GREEN", "WHITE", "GREEN", "BLUE", "RED"});

		while (c.hasNext() == true) {
			c.next();
			c.display();
		}
		c.reset();
		c.display();
	}
}