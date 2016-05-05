/*
 * Author: Connor Shea
 * Date: May 4, 2016
 * Assignment: P7
 */

public class Set extends LinkedList implements ISet {

	// This method adds an item to the set. A duplicate item is not added.
	// Hint: Override the add method defined in the LinkedList class but
	// use its functionality using super.
	@Override
	public void add(Object item) {
		Node current = head;

		for (int i = 0; i < size; i++) {
			if (current == item) {
				return;
			}

			if (i + 1 != size) {
				current = current.getNext();
			}
		}

		super.add(item);
	}

	// This method returns true if the item is in the set, false otherwise.
	@Override
	public boolean in(Object item) {
		Node current = head;

		for (int i = 0; i < size; i++) {
			if (current == item) {
				return true;
			}

			if (i + 1 != size) {
				current = current.getNext();
			}
		}

		return false;
	}

	// This method returns a new array that contains all the items in the set.
	// If the size of the set is 0, return an empty array. The objects in the
	// set are unique (i.e., no duplicates), so the returned array cannot
	// contain duplicates.
	@Override
	public Object[] toArray() {
		return null;
	}

	// This method creates and returns a new set from the items contained in
	// the elements array. The array may contain duplicates, but the Set
	// implementation should not contain duplicates. If the array is empty
	// or null, return a set of size 0 with head referring to null. If
	// duplicates of an item are present in the array, then ignore all the
	// occurrences of this item after the first one.
	@Override
	public ISet fromArray(Object[] elements) {
		Object[] tempArray = new Object[size];

		Node current = head;

		for (int i = 0; i < size; i++) {
			tempArray[i] = current;

			if (i + 1 != size) {
				current = current.getNext();
			}
		}

		int numUnique = size;

		// Iterates through the array.
		for (int i = 0; i < size; i++) {
			// Checks for duplicates starting from the element the parent loop is
			// currently at. This prevents the numUnique from becoming too low due
			// to duplicates.
			// 
			// With an array [A, B, A, C], the first iterator goes to A, checks
			// all four elements, subtracts one from numUnique for the third element
			// which is equal to the element currently being checked. B detects no
			// duplicates and nothing happens. The second A (at array[2]) doesn't check
			// previous elements and therefore doesn't detect a duplicate.
			for (int j = i; j < size; j++) {
				if (tempArray[i] == tempArray[j] && i != j) {
					numUnique--;
				}
			}
		}

		Object[] array = new Object[numUnique];
		int iterator = 0;

		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (tempArray[i] == tempArray[j] && i != j) {
					continue;
				} else {
					array[iterator] = tempArray[j];
					iterator++;
				}
			}
		}



		if (array.length == 0) {
			ISet set = null;
		} else {
			ISet set = array[0];
			for (int i = 0; i < array.length; i++) {
				set.add(array[i]);
			}
		}

		return set;
	}

	// This method returns a new set that contains only those items that are
	// present in both "this" set and the other set. The order of items in the
	// returned set does not matter. The other set and "this" set remain
	// unchanged.
	@Override
	public ISet intersection(ISet other) {
		// TODO Auto-generated method stub
		return null;
	}

	// This method returns a new set that contains the union of the items that
	// are present in "this" set and the other set. Obviously common elements
	// should appear only once in the result. The order of items in the returned
	// set does not matter. The other set and "this" set remain unchanged.
	@Override
	public ISet union(ISet other) {
		// TODO Auto-generated method stub
		return null;
	}

}
