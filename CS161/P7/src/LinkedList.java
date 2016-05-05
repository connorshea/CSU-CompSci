/*
 * Authors: Asa Ben-Hur and Sudipto Ghosh
 * Date: April 18, 2016
 * This class provides a basic implementation of a linked list.
 */
public class LinkedList {

	protected Node head;	// refers to the first node in the linked list.
	protected int size;	// the number of elements in the linked list.

	/*
	 * Constructor: creates an empty linked list
	 */
	public LinkedList() {
		head = null;	
		size = 0;
	}

	/*
	 * Clears the contents of the current linked list
	 */
	public void clear() {
		head = null;
		size = 0;
	}

	/*
	 * Returns the reference of the head node in the current linked list
	 */
	public Node head() {
		return head;
	}


	/*
	 * adds an item as a node at the end of the current list.
	 */
	public void add(Object item) { 
		if(head==null) {
			head = new Node(item);
			size = 1;
		} else {
			Node current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(new Node(item));
			size++;
		}
	}

	/*
	 * removes first node containing the given item
	 */
	public boolean remove(Object item) { 
		if (size == 0)
			return false;
		if (item.equals(head.getItem())) {
			head = head.getNext();
			size--;
			return true;
		} else {
			// locate predecessor of node to be removed
			Node curr = head;
			while (curr.getNext() != null
					&& !item.equals(curr.getNext().getItem())) {
				curr = curr.getNext();
			}
			// if node is not in the list
			if (curr.getNext() == null)
				return false;
			else {
				curr.setNext(curr.getNext().getNext());
				size--;
				return true;
			}
		}
	}

	/*
	 * returns the number of nodes in the linked list
	 */
	public int size() {
		return size;
	}

	/*
	 * returns true if there are no elements in the linked list. false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/*
	 * returns the string representation of the linked list.
	 */
	public String toString() {
		String res = "[" + size + ": ";
		for (Node current = head; current != null; current = current.getNext())
			res += current.getItem().toString() + " ";
		return res + "]";
	}

	/*
	 * Inner class used to represent each node.
	 */
	public class Node {
		private Object item;
		private Node next;

		public Node(Object item) {
			this.item = item;
			this.next = null;
		}
		public Node(Object item, Node next) {
			this.item = item;
			this.next = next;
		}
		public void setNext(Node nextNode) {
			next = nextNode;
		}
		public Node getNext() {
			return next;
		}
		public Object getItem() {
			return item;
		}
		public void setItem(Object item){
			this.item = item;
		}
		public String toString(){
			return item.toString();
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.add("Asa");
		System.out.println("List after adding Asa:\n" + ll);
		ll.add("Sudipto");
		ll.add("Hajar");
		ll.add("Asa");
		System.out.println("List after adding Asa, Sudipto, Hajar, and Asa:\n" + ll);
		ll.remove("Asa");
		System.out.println("List after removing Asa:\n" + ll);
		ll.remove("Hajar");
		ll.remove("Sudipto");
		ll.remove("Asa");
		System.out.println("List after removing all:\n" + ll);
		System.out.println(ll.remove("Chris"));
		
	}
}
