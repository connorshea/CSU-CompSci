public class InsertionSort {
	
	public static Comparable[] sort(Comparable[] list) {
		// Copy all elements into a new list
		Comparable[] sortedList = new Comparable[list.length];

		for (int i = 0; i < list.length; i++) {
			sortedList = list;
		}

		// Now sort the list
		for (int i = 1; i < sortedList.length; i++) {
			int j = i;
			Comparable insert = sortedList[i];

			while (j > 0 && insert.compareTo(sortedList[j-1]) < 0) {
				sortedList[j] = sortedList[j-1];
				j--;
			}
			sortedList[j] = insert;
		}
		
		return sortedList;
	}
}

