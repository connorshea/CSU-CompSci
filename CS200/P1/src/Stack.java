import java.util.ArrayList;

public class Stack implements StackIF{

	private ArrayList<Object> theStack;
	
	public Stack(){
		// initialize theStack
	}
	
	@Override
	/*
	 * push op on Run Time Stack at end of theStack
	 */
	public void push(Object op) {
		// TODO Auto-generated method stub
	}

	@Override
	/*
	 * pop and return top Object from Run Time Stack
	 * If Stack empty, throw StackException("Popping from empty stack!");
	 */
	public Object pop() throws StackException {
		// TODO Auto-generated method stub
		Object popped = null;
		return popped;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// return the String representation of theStack
	public String toString(){
		return "";
	}
	
	public static void main(String[] args) throws StackException{
       Stack st = new Stack();
       st.push(new Frame(1,3,1,3));
       st.push(new Frame(0,2,1,2));
       System.out.println("st: " + st);
       st.pop();
       System.out.println("st: " + st);
       st.pop();
       System.out.println("st: " + st);
	}
       
}
