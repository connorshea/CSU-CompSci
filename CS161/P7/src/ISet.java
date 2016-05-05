/*
 * SetInterface declares the methods that you must implement in P7.
 * You will implement a Set using a LinkedList.
 * You will need to make sure that the Set contains no duplicates.
 */
public interface ISet {

	/*
	 * Adds an item to the set. A duplicate item isn't added.
	 */
	public void add(Object item);
	
	/*
	 * This method returns true if the item is in the set, false otherwise.
	 */
	public boolean in(Object item);
	
	/*
	 * Return a new array that contains all the items in the set.
	 * If the size of the set is 0, return an empty array.
	 * The objects in the set are unique (i.e., no duplicates), so
	 * the returned array cannot contain duplicates. 
	 */
	public Object[] toArray();
	
	/*
	 * Create and return a new set from the items contained in the elements array. 
	 * The array may contain duplicates, but the Set implementation should not 
	 * contain duplicates. If the array is empty or null, return a set of size 0 
	 * with head referring to null. If duplicates of an item are present 
	 * in the array, then ignore all the occurrences of this item after the first one. 
	 */
	public ISet fromArray(Object[] elements);
	
	/*
	 * Return a new set that contains only those items 
	 * that are present in both "this" set and the other set. 
	 * The order of items in the returned set does not matter.
	 * The other set and "this" set remain unchanged.
	 */
	public ISet intersection(ISet other);
	
	/*
	 * Return a new set that contains the union of the items 
	 * that are present in "this" set and the other set. Obviously
	 * common elements will appear only once.
	 * The order of items in the returned set does not matter.
	 * The other set and "this" set remain unchanged.
	 */
	public ISet union(ISet other);
}
