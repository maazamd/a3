/**
 * The class <b>Cube</b> represents a cube (with 6 sides). It has a color
 * on each side, and can be rotated around by calling its methods.
 *
 * @author Maaz Ahmad, Richard Guan
 */
public class Cube {
	
	/**
	 * Stores all the colors of the cube
	 */
	private Color[] faces;

	/**
	 * Creates a copy of the colors of the cube, that stores
	 * The original state of the cube.
	 */
	private Color[] original = new Color[6];

	/**
	 * A counter that counts the current operations for next()
	 */
	private int counter = 1;
	
	/**
     * Constructor used for initializing a Cube with a specific color for each side.
     * 
     * @param faces
     *            the colors for each side of the cube
     */
	public Cube (Color[] faces) {

		// Makes an array that stores the original state
		for (int i = 0; i <= 5; i++) {
			original[i] = faces[i];
		}

		this.faces = faces;
	}

	/**
     * Constructor used for initializing a deep copy of this cube
     * Designated by other.
     * 
     * @param other
     *            the cube to copy
     */
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

	/**
     * Returns a deep copy of this Cube.
     * 
     * @return a deep copy of this Cube
     */
	public Cube copy() {
		return new Cube(this);
	}
	
	/**
     * Getter method for the color of the up side.
     * 
     * @return the color of up side
     */
	public Color getUp() {
		return faces[0];
	}
	
	/**
     * Getter method for the color of the front side.
     * 
     * @return the color of front side
     */
	public Color getFront() {
		return faces[1];
	}
	
	/**
     * Getter method for the color of the right side.
     * 
     * @return the color of right side
     */
	public Color getRight() {
		return faces[2];
	}
	
	/**
     * Getter method for the color of the back side.
     * 
     * @return the color of back side
     */
	public Color getBack() {
		return faces[3];
	}
	
	/**
     * Getter method for the color of the left side.
     * 
     * @return the color of left side
     */
	public Color getLeft() {
		return faces[4];
	}
	
	/**
     * Getter method for the color of the down side.
     * 
     * @return the color of down side
     */
	public Color getDown() {
		return faces[5];
	}
	
	/**
     * A String representation of the Cube.
     * 
     * @return a string representation of the Cube
     */
	public String toString() {
		return "[ "+getUp()+", "+getFront()+", "+getRight()+", "+getBack()+", "+getLeft()+", "+getDown()+"]";
	}

	/**
     * Returns true if and only if a call to the method next() would succeed,
     * False otherwise.
     * 
     * @return if the call to next() would succeed
     */
	public boolean hasNext() {
		if (counter > 24) {
			return false;
		}
		return true;
	}

	/**
     * Changes the orientation of the cube following a specific procedure.
     */
	public void next() {
		if (counter > 24) {
			throw new IllegalStateException("Please reset!");
		}
		else if (counter == 1) {
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

	/**
     * Resets the orientation of the cube back to its original state.
     */
	public void reset() {
		for (int i = 0; i <= 5; i++) {
			faces[i] = original[i];
		}
		counter = 1;
	}

	/**
     * Rotates the cube to the right around the top-bottom axis
     * So that the left side is now facing front.
     */
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

	/**
     * Rolls the cube to the right around the back-front axis
     * So that the left side is now up.
     */
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

	/**
     * Rolls the cube to the left around the back-front axis
     * So that the right side is now up.
     */
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

	/**
     * Resets all the faces to their original state.
     */
	private void identity() {
		reset();
	}
}