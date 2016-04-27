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
			BookNode current = head;

			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(new BookNode(b));
		}
		size++;

		return;
	}
	
	// IMPLEMENT -- adds a book at the specific index, or at the end if index is greater than size
	public void add(Book b, int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException("List index out of bounds");
		} else if (index < size - 1) {

		} else {
			head.setNext(new BookNode(b));
		}

		size++;

		return;
	}
	
	//IMPLEMENT -- removes a book and returns it, or returns null if it is not present
	public Book remove(Book b) {
		BookNode current = head;

		Book book = null;

		if (current.getBook() == b) {
			book = current.getBook();
			head = current.getNext();
			size--;
		} else {
			while (current.getNext() != null) {
				if (current.getNext().getBook() == b) {
					// Current is now the item before the item you want.
					// Current set to point to the item following the item we're removing.
					current.setNext(current.getNext().getNext());
					size--;

					book = current.getNext().getBook();

					break;
				} else {
					current = current.getNext();
				}
			}
		}

		return book;
	}

	//IMPLEMENT -- removes a book at a specific index and returns it, 
	// or returns null if it is not present.
	public Book remove(int index) {
		Book book = null;

		if (index < 0) {
			throw new IndexOutOfBoundsException("List index out of bounds");
		} else {
			BookNode current = head;
			int iteration = 0;

			if (index == 0) {
				head = head.getNext();
				return current.getBook();
			}

			while (current != null && iteration != index - 1) {
				current = current.getNext();
				iteration++;
			}

			if (current == null) {
				return null;
			}

			book = current.getNext().getBook();

			// Current is now the item before the item you want.
			current.setNext(current.getNext().getNext());
		}
		size--;

		return book;
	}
	
	//IMPLEMENT -- returns the total number of pages in the linked list
	public int totalPages() {
		int total = 0;

		BookNode current = head;

		while (current != null) {
			total += current.getNumPages();
			current = current.getNext();
		}

		return total;
	}
	
	public String toString() {
		String res = "";
		BookNode current = head;
		
		while (current != null) {
			res += current.getBook().getTitle();
			res += "\n";
			current = current.getNext();
		}

		return res;
	}
	
}
