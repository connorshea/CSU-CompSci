public class LinkedBookList {

	private BookNode head;
	private int size;
	
	public LinkedBookList() {
		head = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	// IMPLEMENT -- adds a book to the end of the linked list
	public void add(Book b) {
		if (size == 0) {
			head = new BookNode(b);
		} else {
			head.setNext(new BookNode(b));
		}
		size++;

		return;
	}
	
	// IMPLEMENT -- adds a book at the specific index, or at the end if index is greater than size
	public void add(Book b, int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("List index out of bounds");
		} else if (index < size) {
			add(b, index);
			size++;
		}

		return;
	}
	
	//IMPLEMENT -- removes a book and returns it, or returns null if it is not present
	public Book remove(Book b) {
		BookNode current = head;

		for (int i = 0; i < size; i++) {
			if (current.getNext() != null) {
				if (current.getNext().getBook() == b) {
					remove(b);
					size--;
					return b;
				} else {
					current = current.getNext();
				}
			} else {
				break;
			}
		}

		return null;
	}

	//IMPLEMENT -- removes a book at a specific index and returns it, 
	//or returns null if it is not present.
	public Book remove(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("List index out of bounds");
		} else if (index == 0) {
			// Removes the head by replacing current head with next element in the list.
			head = head.getNext();
		}
		return null;
	}
	
	//IMPLEMENT -- returns the total number of pages in the linked list
	public int totalPages() {
		int total = 0;

		for (int i = 0; i < size; i++) {
			// total += getNumPages();
		}

		return total;
	}
	
	public String toString() {
		String res = "";

		return res;
	}
	
}
