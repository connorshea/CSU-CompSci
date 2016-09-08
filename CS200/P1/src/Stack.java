import java.util.ArrayList;

public class Stack implements StackIF {

  private ArrayList<Object> theStack;
  
  public Stack() {
    this.theStack = new ArrayList<Object>();
  }
  
  @Override
  /*
   * push op on Run Time Stack at end of theStack
   */
  public void push(Object op) {
    this.theStack.add(op);
  }

  @Override
  /*
   * pop and return top Object from Run Time Stack
   * If Stack empty, throw StackException("Popping from empty stack!");
   */
  public Object pop() throws StackException {
    if (this.isEmpty()) {
      throw new StackException("Popping from empty stack!");
    }

    Object popped = this.theStack.get(this.theStack.size() - 1);
    this.theStack.remove(this.theStack.size() - 1);
    return popped;
  }

  @Override
  public boolean isEmpty() {
    return this.theStack.isEmpty();
  }
  
  // return the String representation of theStack
  public String toString() {
    return theStack.toString();
  }
  
  public static void main(String[] args) throws StackException {
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
