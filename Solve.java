public class Solve {
	
	private Cube c1 = new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});
	private Cube c2 = new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED});
	private Cube c3 = new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE});
	
	public Queue<Solution> generateAndTest() {
		while (c1.hasNext()) {
			c1.next();
			while (c2.hasNext()) {
				c2.next();
				while (c3.hasNext()) {
					c3.next();
					while (c4.hasNext()) {
						c4.next();
					}
					c4.reset();
				}
				c3.reset();
			}
			c2.reset();
		}
		c1.rest();
	}
	
	public Queue<Solution> breadthFirstSearch() {
		
	}
	
	public static void main(String[] args) {
		long start, stop;
		System.out.println("generateAndTest: ");
		start = System.currentTimeMillis();
		generateAndTest();
		stop = System.currentTimeMillis;
		System.out.println("Elapsed time: "+(stop-start)+" milliseconds");
		System.out.println("breadthFirstSearch: ");
		start = System.currentTimeMillis();
		breadthFirstSearch();
		stop = System.currentTimeMillis();
		System.out.println("Elapsed time: "+(stop-start)+" milliseconds");
	}
}