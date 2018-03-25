public class Solve {
	
	private Cube c1 = new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});
	private Cube c2 = new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED});
	private Cube c3 = new Cube(new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED});
	private Cube c4 = new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE});
	
	public Queue<Solution> generateAndTest() {
		Queue<Solution> sList = new LinkedQueue<Solution>();
		Solution s = new Solution(new Cube[]{c1, c2, c3, c4});
		while (c1.hasNext()) {
			c1.next();
			s = new Solution(new Cube[]{c1, c2, c3, c4});
			if (s.isValid() == true) {
				sList.enqueue(s);
			}
			while (c2.hasNext()) {
				c2.next();
				s = new Solution(new Cube[]{c1, c2, c3, c4});
				if (s.isValid() == true) {
					sList.enqueue(s);
				}
				while (c3.hasNext()) {
					c3.next();
					s = new Solution(new Cube[]{c1, c2, c3, c4});
					if (s.isValid() == true) {
						sList.enqueue(s);
					}
					while (c4.hasNext()) {
						c4.next();
						s = new Solution(new Cube[]{c1, c2, c3, c4});
						if (s.isValid() == true) {
							sList.enqueue(s);
						}
					}
					c4.reset();
				}
				c3.reset();
			}
			c2.reset();
		}
		c1.reset();
		System.out.println(s.getNumberOfCalls());
		return sList;
	}
	
	//public Queue<Solution> breadthFirstSearch() {
		
	//}
	
	public static void main(String[] args) {
		Solve s = new Solve();
		long start, stop;
		System.out.println("generateAndTest: ");
		start = System.currentTimeMillis();
		s.generateAndTest();
		stop = System.currentTimeMillis();
		System.out.println("Elapsed time: "+(stop-start)+" milliseconds");
		System.out.println("breadthFirstSearch: ");
		start = System.currentTimeMillis();
		//s.breadthFirstSearch();
		stop = System.currentTimeMillis();
		System.out.println("Elapsed time: "+(stop-start)+" milliseconds");
	}
}