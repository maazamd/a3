public class Cube {
	
	Color[] faces;
	
	public Cube (Color[] faces) {
		this.faces = faces;
	}
	
	public Color getUp() {
		return faces[1];
	}
	
	public Color getFront() {
		return faces[2];
	}
	
	public Color getRight() {
		return faces[3];
	}
	
	public Color getBack() {
		return faces[4];
	}
	
	public Color getLeft() {
		return faces[5];
	}
	
	public Color getDown() {
		return faces[6];
	}
	
	public String toString() {
		return "[ "+getUp()+", "+getFront()+", "+getRight()+", "+getBack()+", "+getLeft()+", "+getDown()+"]";
	}
}