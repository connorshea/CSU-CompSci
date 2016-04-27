public class BubbleSort {
	
	public static Comparable[] sort(Comparable[] list) {
		// Copy all elements into a new list
		Comparable[] sortedList = new Comparable[list.length];
		for (int i = 0; i < list.length; i++) {
			sortedList = list;
		}

		// Now sort the list
		int i, j;
		for (i = 0; i < sortedList.length; i++) {
			for (j = 1; j < sortedList.length - i; j++) {
				if (list[j-1].compareTo(sortedList[j]) > 0) {
					Comparable sw = sortedList[j-1];
					sortedList[j-1] = sortedList[j];
					sortedList[j] = sw;
				}
			}
		}

		return sortedList;
	}
}
