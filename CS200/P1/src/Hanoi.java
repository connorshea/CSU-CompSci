public class Hanoi {
	private int count = 0;
	private boolean debug;
	private Stack rts;


	// implement
	// constructor sets debug: 
	// if debug is true, iterative Hanoi print rts every time it encounters a frame 
	public Hanoi(boolean debug) {
		this.debug = debug;
	}

	// implement
	private void resetCount() {
		// reset count to 0 to count the moves of a Hanoi implementation
		this.count = 0;
	}

	// implement
	private int getCount() {
		return this.count;
	}

	//Implement Hanoi using an explicit Run Time Stack rts
	//Assume initially there is one Frame [state,n,from,to] on rts
	//Keep popping frames until rts is empty
	//
	// if debug is true, print rts
	//
	// When popping a frame:
	//  if n == 0 do nothing (discard frame)
	//  else if frame in state 0:
	//       Do first call hanoi(n-1,from,via):
	//       by going into state 1 and pushing [1,n,from,to]
	//       and pushing [0,n-1,from,via]
	//      else if in state 1
	//            print disk n move
	//            push [2,n,from,to] , push [0,n-1,via,to]
	//           else (in state 2) do nothing
	private void rtsHanoi() throws StackException {
		while (!rts.isEmpty()) {
			if (debug) {
				System.out.println("RTS: " + rts);
			}
			
			Frame start = (Frame) rts.pop();
			if (start.getN() == 0) {
				// System.out.println("Doing nothing.");
			} else if (start.getState() == 0) {
				start.setState(1);
				rts.push(new Frame(1, start.getN(), start.getFrom(), start.getTo()));
				rts.push(new Frame(0, start.getN() - 1, start.getFrom(), 6 - start.getFrom() - start.getTo()));
			} else if (start.getState() == 1) {
				System.out.println("Move disk " + start.getN() + " from " + start.getFrom() + " to " + start.getTo());
				rts.push(new Frame(2, start.getN(), start.getFrom(), start.getTo()));
				rts.push(new Frame(0, start.getN() - 1, 6 - start.getFrom() - start.getTo(), start.getTo()));
				this.count += 1;
			} else if (start.getState() == 2) {
				// System.out.println("Doing nothing.");
			}
		}
	}

	// provided
	// iterative Hanoi using stack of frames rts
	// number of moves are counted
	public void itHanoi(int n, int from, int to) throws StackException{
		Frame start = new Frame(0, n, from, to);
		rts = new Stack();
		rts.push(start);
		rtsHanoi();
	}

	// provided
	// pegs are numbers, via is computed
	// number of moves are counted
	// empty base case
	public void recHanoi(int n, int from, int to){
		if (n > 0) {
			int via = 6 - from - to;
			recHanoi(n - 1, from, via);
			System.out.println("move disk " + n + 
					" from " + from + " to " + to);
			count++;
			recHanoi(n-1, via, to);
		}
	}

	/**
	 * @param args
	 * @throws StackException 
	 */
	public static void main(String[] args) throws StackException {
		// Implement recursive and iterative Hanoi
		// In both cases count moves
		// In debug mode, print the run time stack in the iterative method
		boolean debug = false;
		int n = Integer.parseInt(args[0]);

		if (args.length > 1) {
			debug = true;
		}

		System.out.println("Recursive and Iterative Hanoi: n = " + n + ", debug = " + debug);
		Hanoi h = new Hanoi(debug);
		
		if (n > 0) {
			h.resetCount();
			System.out.println("\nrecHanoi " + n + " from 1 to 3");
			h.recHanoi(n, 1, 3);
			System.out.println("number of moves: " + h.getCount());


			h.resetCount();
			System.out.println("\nitHanoi " + n + " from 1 to 3");				
			h.itHanoi(n, 1, 3);
			System.out.println("number of moves: " + h.getCount());				
		}

	}
}
