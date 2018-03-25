public class Cube {
		
	private Color[] faces;
	private Color[] original = new Color[6];

	private int counter = 1;
	
	public Cube (Color[] faces) {

		// Makes an array that stores the original state
		for (int i = 0; i <= 5; i++) {
			original[i] = faces[i];
		}

		this.faces = faces;
	}

	public Cube(Cube other) {
		faces = new Color[6];
		int j = 0;
		Color c;
		switch (j) {
			case 0:
				c = other.getUp();
				faces[j] = c;
				j++;
			break;
			case 1:
				c = other.getFront();
				faces[j] = c;
				j++;
			break;
			case 2:
				c = other.getRight();
				faces[j] = c;
				j++;
			break;
			case 3:
				c = other.getBack();
				faces[j] = c;
				j++;
			break;
			case 4:
				c = other.getLeft();
				faces[j] = c;
				j++;
			break;
			case 5:
				c = other.getDown();
				faces[j] = c;
			break;
		}

		// Makes an array that stores the original state
		for (int i = 0; i <= 5; i++) {
			original[i] = faces[i];
		}
	}

	public Cube copy() {
		return new Cube(this);
	}
	
	public Color getUp() {
		return faces[0];
	}
	
	public Color getFront() {
		return faces[1];
	}
	
	public Color getRight() {
		return faces[2];
	}
	
	public Color getBack() {
		return faces[3];
	}
	
	public Color getLeft() {
		return faces[4];
	}
	
	public Color getDown() {
		return faces[5];
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
		for (int i = 0; i <= 5; i++) {
			faces[i] = original[i];
		}
		counter = 1;
	}

	private void rotate() {
		int opr = 1;
		int oprNext = opr + 1;
		Color temp0 = faces[opr], temp1;

		for (int i = 1; i <= 4; i++) {

			if (opr > 4) {
				opr = 1;
			}
			else if (opr == 4) {
				oprNext = 1;
			}

			temp1 = faces[oprNext];
			faces[oprNext] = temp0;
			temp0 = temp1;

			opr++;
			oprNext++;
		}
	}

	private void rightRoll() {
		int opr = 0;
		int oprNext = 2;
		Color temp0 = faces[opr], temp1;

		for (int i = 0; i <= 3; i++) {

			if (i == 1) {
				opr = 2;
				oprNext = 5;
			}
			else if (i == 2) {
				opr = 5;
				oprNext = 4;
			}
			else if (i == 3) {
				opr = 4;
				oprNext = 0;
			}

			temp1 = faces[oprNext];
			faces[oprNext] = temp0;
			temp0 = temp1;
		}
	}

	private void leftRoll() {
		int opr = 0;
		int oprNext = 4;
		Color temp0 = faces[opr], temp1;

		for (int i = 0; i <= 3; i++) {

			if (i == 1) {
				opr = 4;
				oprNext = 5;
			}
			else if (i == 2) {
				opr = 5;
				oprNext = 2;
			}
			else if (i == 3) {
				opr = 2;
				oprNext = 0;
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
		for (int i = 0; i <= 5; i++) {
			System.out.println(this.faces[i]);
		}
		System.out.println("------------");
	}

	// This is used to test the methods
	public static void main(String[] args) {
		Cube c;
		c = new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});

		while (c.hasNext() == true) {
			c.next();
			c.display();
		}
		c.reset();
		c.display();
	}
}