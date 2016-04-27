import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;


public class SortingTests 
{
	public static void writeToFile(String filename, Student[] students) {
		FileWriter fw;
		try {
			fw = new FileWriter(new File(filename));

			for (int i = 0; i < students.length; i++) {
				fw.write(students[i].toString() + "\n");
			}

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void printStudents(Student[] stuArray) {
		for (int i = 0; i < stuArray.length; i++) {
			System.out.println(stuArray[i]);
		}
	}
	
	public static void sortingExperiment(int numStudents) {
		System.out.println("================================================");
		System.out.print("Creating student array of length " + Integer.toString(numStudents) + "...");
		Student[] barray = new Student[numStudents];
		Student[] iarray = new Student[numStudents];
		Student[] marray = new Student[numStudents];

		for (int c = 0; c < barray.length; c++) {
			Student s = new Student();
			barray[c] = s;
			iarray[c] = s;
			marray[c] = s;
		}

		System.out.print("done\n");

		Stopwatch sw = new Stopwatch();
		
		//PART 1 - Bubblesort
		System.out.print("\nPerforming bubble sort...");
		sw.start();
		barray = (Student[])BubbleSort.sort(barray);
		sw.stop();
		System.out.print("done\n");
		System.out.println(sw);
		writeToFile("bubble_sort.txt", barray);
//		printStudents(barray);
		
		//PART 2 - Insertion Sort
		System.out.print("\nPerforming insertion sort...");
		sw.start();
		iarray = (Student[])InsertionSort.sort(iarray);
		sw.stop();
		System.out.print("done\n");
		System.out.println(sw);
		writeToFile("insertion_sort.txt", iarray);
//		printStudents(iarray);
		
		//PART 3 - Merge Sort
		System.out.print("\nPerforming merge sort...");
		sw.start();
		marray = (Student[])MergeSort.sort(marray);
		sw.stop();
		System.out.print("done\n");
		System.out.println(sw);
		writeToFile("merge_sort.txt", marray);
		printStudents(marray);
	}
	
	public static void main(String[] args) {
		// int[] numStudents = {5};

		// int[] numStudents = {1, 3, 10, 30, 100, 300};
		int[] numStudents = {1, 3, 10, 30, 100, 300, 1000, 3000, 10000, 30000};
		for (int i = 0; i < numStudents.length; i++) {
			sortingExperiment(numStudents[i]);
			System.out.println();
		}
	}
}
