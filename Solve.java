public class Solve {
	
	public Queue<Solution> generateAndTest() {
		
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