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
		boolean duplicate = false;

		if (in(item)) {
			duplicate = true;
		}
		
		if (!duplicate) {
			super.add(item);
		}
	}

	// This method returns true if the item is in the set, false otherwise.
	@Override
	public boolean in(Object item) {
		Node current = head;

		for (int i = 0; i < size; i++) {
			if (current.toString().equals(item.toString())) {
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
		for (int i = 0; i < elements.length; i++) {
			add(elements[i]);
		}

		return this;
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
