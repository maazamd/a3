/**
 * The class <b>Solve</b> contains three methods: <b>generateAndTest</b>, <b>breadthFirstSearch</b>,
 * And <b>main</b>. Which solves the instant insanity problem.
 *
 * @author Maaz Ahmad, Richard Guan
 */
public class Solve {
	
	/**
	 * Creates a new cube with a specified color for each side.
	 */
	private Cube c1 = new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED});

	/**
	 * Creates a new cube with a specified color for each side.
	 */
	private Cube c2 = new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED});

	/**
	 * Creates a new cube with a specified color for each side.
	 */
	private Cube c3 = new Cube(new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED});

	/**
	 * Creates a new cube with a specified color for each side.
	 */
	private Cube c4 = new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE});
	
	/**
     * Finds all the solutions to the problem by generating all possible solutions.
	 *
     * @return a queue that contains all the valid solutions to the problem
     */
	public Queue<Solution> generateAndTest() {
		Queue<Solution> sList = new LinkedQueue<Solution>();
		Solution s = new Solution(new Cube[]{c1, c2, c3, c4});
		while (c1.hasNext()) {
			c1.next();
			while (c2.hasNext()) {
				c2.next();
				while (c3.hasNext()) {
					c3.next();
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
		System.out.println(s.getTotalValidSolutions());
		return sList;
	}
	
	/**
     * Finds all the solutions to the problem using the "breadth-first-search" algorithm.
     * 
     * @return a queue that contains all the valid solutions to the problem
     */
	public Queue<Solution> breadthFirstSearch() {
		Queue<Solution> open = new LinkedQueue<Solution>();
		Queue<Solution> solutions = new LinkedQueue<Solution>();
		while (c1.hasNext()) {
			open.enqueue(new Solution(new Cube[]{c1}));
			c1.next();
		}
		while (!open.isEmpty()) {
			Solution current = open.dequeue();
			if (current.isValid(c2)) {
				Solution s = new Solution(current, c2);
				if (s.size() == 4) {
					solutions.enqueue(s);
				}
				else {
					open.enqueue(s);
				}
			}
		}
		return solutions;
	}
	
	/**
     * The main method of the class.
	 *
	 * @param args
	 *			the coomand line arguments
     */
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
		s.breadthFirstSearch();
		stop = System.currentTimeMillis();
		System.out.println("Elapsed time: "+(stop-start)+" milliseconds");
	}
}