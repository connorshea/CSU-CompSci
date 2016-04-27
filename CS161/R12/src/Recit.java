import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Recit {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		LinkedBookList lbl = new LinkedBookList();
		
		Scanner scan = new Scanner(new File(args[0]));
		int bookCount = (Integer.parseInt(scan.nextLine()));
		
		//reads in all of the books, and adds them to the linked list
		for (int i = 0; i < bookCount; i++) {
			String line = scan.nextLine();
			String[] parts = line.split("\t");
			String name = parts[0];
			String title = parts[1];
			int numPages = Integer.parseInt(parts[2]);
			Book b = new Book(name, title, numPages);
			lbl.add(b);
		}
		
		//OUTPUTS THE TOTAL NUMBER OF PAGES ADDED TOGETHER
		System.out.println("Expected total pages: 3740");
		System.out.println("Total number of pages: " + lbl.totalPages() + "\n");		
		
		//ADDS NEW BOOK AT INDEX 4
		lbl.add(new Book("Alex Cross, Run", "James Peterson", 432), 4);
		System.out.println(lbl);
		
		//ADDS NEW BOOK AT THE END OF THE LINKED LIST
		lbl.add(new Book("A Dance With Dragons", "George R. R. Martin", 1040));
		System.out.println(lbl);
		
		//REMOVES THE SIXTH BOOK IN THE LINKED LIST -> Gone Girl
		System.out.println("Removed from linked list: " + lbl.remove(6));

		//REMOVES Starting Now FROM THE LIST
		System.out.println("Removed from linked list: " + lbl.remove(new Book("Starting Now", "Debbie Macomber", 352)));
		System.out.println(lbl);

		//REMOVES THE FIRST BOOK IN THE LINKED LIST -> Manuscript Found
		System.out.println("Removed from linked list: " + lbl.remove(0));
		
		//REMOVES GONE GIRL FROM THE LIST -> null
//		System.out.println("Removed from linked list: " + lbl.remove(new Book("Gone Girl", "Gillian Flynn", 432)));


//		System.out.println(lbl);
		
		scan.close();
	}
}

