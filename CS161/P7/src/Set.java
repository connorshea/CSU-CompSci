/*
 * Author: Connor Shea
 * Date: May 4, 2016
 * Assignment: P7
 */

import java.util.Arrays;

public class Set extends LinkedList implements ISet {

	// This method adds an item to the set. A duplicate item is not added.
	// Hint: Override the add method defined in the LinkedList class but
	// use its functionality using super.
	@Override
	public void add(Object item) {
		if (!in(item)) {
			super.add(item);
		}
	}

	// This method returns true if the item is in the set, false otherwise.
	@Override
	public boolean in(Object item) {
		Node current = head;

		while (current != null) {
			if (current.toString().equals(item.toString())) {
				return true;
			}

			current = current.getNext();
		}

		return false;
	}

	// This method returns a new array that contains all the items in the set.
	// If the size of the set is 0, return an empty array. The objects in the
	// set are unique (i.e., no duplicates), so the returned array cannot
	// contain duplicates.
	@Override
	public Object[] toArray() {

		if (size == 0) {
			return new Object[0];
		}

		Node current = head;
		Object[] array = new Object[size];
		int iterator = 0;

		while (current != null) {
			array[iterator] = current.getItem();
			iterator++;
			current = current.getNext();
		}

		return array;
	}

	// This method creates and returns a new set from the items contained in
	// the elements array. The array may contain duplicates, but the Set
	// implementation should not contain duplicates. If the array is empty
	// or null, return a set of size 0 with head referring to null. If
	// duplicates of an item are present in the array, then ignore all the
	// occurrences of this item after the first one.
	@Override
	public ISet fromArray(Object[] elements) {
		ISet set = new Set();

		for (int i = 0; i < elements.length; i++) {
			set.add(elements[i]);
		}

		return set;
	}

	// This method returns a new set that contains only those items that are
	// present in both "this" set and the other set. The order of items in the
	// returned set does not matter. The other set and "this" set remain
	// unchanged.
	@Override
	public ISet intersection(ISet other) {
		Node current = head;
		ISet set = new Set();

		while (current != null) {
			if (other.in(current) && this.in(current)) {
				set.add(current.getItem());
			}

			current = current.getNext();
		}

		return set;
	}

	// This method returns a new set that contains the union of the items that
	// are present in "this" set and the other set. Obviously common elements
	// should appear only once in the result. The order of items in the returned
	// set does not matter. The other set and "this" set remain unchanged.
	@Override
	public ISet union(ISet other) {
		Node current = head;
		ISet set = other;

		while (current != null) {
			set.add(current.getItem());
			current = current.getNext();
		}

		return set;
	}

	public static void main(String[] args) {
    ISet tester = new Set();
    String[] names = {"Alex", "Hajar", "Asa", "Sudipto", "Koen", "Asa"};
    ISet s1 = tester.fromArray(names);
    System.out.println("After creating set s1 from array:\n" + s1);
    System.out.println("Printing array from s1:\n"+ Arrays.toString(s1.toArray()));

    String[] names2 = {"Chris"};
    s1 = tester.fromArray(names2);
    System.out.println("Printing array from s1:\n"+ Arrays.toString(s1.toArray()));
    String[] otherNames = {"Gareth", "Alex", "Swapnil", "Chris", "Asa"};
    ISet s2 = tester.fromArray(otherNames);
    System.out.println("After creating set s2 from array:\n" + s2);
    ISet s3 = s1.intersection(s2);
    System.out.println("Intersection of s2 and s3:\n" + s3);
    ISet s4 = s1.union(s2);
    System.out.println("Union of s2 and s3:\n" + s4);

	}

}
