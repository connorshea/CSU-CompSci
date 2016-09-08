

public class Frame {

	// A frame has four int instance variables: [state, n, from, to]
	// see toString()
	
	// state: the state a Hanoi frame is in:
	// 0: initial state: no action performed
	// 1: "called" (pushed Frame really) hanoi(n-1, from, via)
	// 2: done, both "calls" performed
	private int state;
	
	// n: the size of the problem
	private int n;
	
	// from: source peg
	private int from;
	
	// to: destination peg
	private int to;

	public Frame(int state, int n, int from, int to) {
		this.state = state;
		this.n = n;
		this.from = from;
		this.to = to;
	}
	
	public int getN() {
		return this.n;
	}
	
	public int getFrom() {
		return this.from;
	}
	
	public int getTo() {
		return this.to;
	}
	
	public int getState() {
		return this.state;
	}
	
	public void setState(int s) {
		this.state = s;
	}
	
	public String toString() {
		return "[s:" + state + ", n:" + n + ", f:" + from + ", t:" + to + "]";
	}
		
	public static void main(String[] args) {
		Frame f = new Frame(0, 3, 1, 3);
		System.out.println(f);
		f.setState(1);
		System.out.println("[" + f.getState() + ", " + f.getN() + ", " + f.getFrom()  + ", " + f.getTo()+"]");
		
	}
}
