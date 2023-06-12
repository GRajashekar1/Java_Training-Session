package assignment;
public class LibraryManagementSystem {
			
		    private static final int MAX_BOOKS = 2; // Maximum number of books in the library
		    private static final int MAX_PATRONS = 1; // Maximum number of patrons in the library

		    private String[] books; // Array to store book titles
		    private String[] author; // Array to store book authors		    
		    private boolean[] borrowed; // Array to track book availability
		    private String[] patrons; // Array to store patron names
		    private int[][] borrowedBooks; // 2D array to track borrowed books by patrons
		    
		    private int authorCount; // Current number of authors for the books in the library
		    private int bookCount; // Current number of books in the library
		    private int patronCount; // Current number of patrons in the library

		    public LibraryManagementSystem() {
		        books = new String[MAX_BOOKS];
		        author=new String[MAX_BOOKS];
		        borrowed = new boolean[MAX_BOOKS];
		        patrons = new String[MAX_PATRONS];
		        borrowedBooks = new int[MAX_PATRONS][MAX_BOOKS];
		        bookCount = 0;
		        authorCount = 0;
		        patronCount = 0;
		    }

		    public void addBook(String bookTitle, String authorName) {
		        if (bookCount < MAX_BOOKS) {
		            books[bookCount] = bookTitle;
		           	author[authorCount]=authorName;		           
		            bookCount++;
		            System.out.println("Book added successfully.");
		        } else {
		            System.out.println("Maximum book limit reached.");
		        }
		    }

		    public void addPatron(String patronName) {
		        if (patronCount < MAX_PATRONS) {
		            patrons[patronCount] = patronName;
		            patronCount++;
		            System.out.println("Patron added successfully.");
		        } else {
		            System.out.println("Maximum patron limit reached.");
		        }
		    }

		    public void borrowBook(int patronIndex, int bookIndex) {
		        if (patronIndex >= 0 && patronIndex < patronCount && bookIndex >= 0 && bookIndex < bookCount) {
		            if (!borrowed[bookIndex]) {
		                borrowed[bookIndex] = true;
		                borrowedBooks[patronIndex][bookIndex] = 1;
		                System.out.println("Book borrowed successfully.");
		            } else {
		                System.out.println("Book already borrowed.");
		            }
		        } else {
		            System.out.println("Invalid patron or book index.");
		        }
		    }

		    public void returnBook(int patronIndex, int bookIndex) {
		        if (patronIndex >= 0 && patronIndex < patronCount && bookIndex >= 0 && bookIndex < bookCount) {
		            if (borrowed[bookIndex]) {
		                borrowed[bookIndex] = false;
		                borrowedBooks[patronIndex][bookIndex] = 0;
		                System.out.println("Book returned successfully.");
		            } else {
		                System.out.println("Book is not currently borrowed.");
		            }
		        } else {
		            System.out.println("Invalid patron or book index.");
		        }
		    }

		    public void displayBookAvailability() {
		        System.out.println("Book Availability:");
		        for (int i = 0; i < bookCount; i++) {
		            String status = borrowed[i] ? "Borrowed" : "Available";
		            System.out.println((i + 1) + ". " + books[i] + " - " + status);
		        }
		    }

		    public void displayBorrowedBooksByPatron(int patronIndex) {
		        if (patronIndex >= 0 && patronIndex < patronCount) {
		            System.out.println("Books borrowed by " + patrons[patronIndex] + ":");
		            for (int i = 0; i < bookCount;i++) {
		                if (borrowedBooks[patronIndex][i] == 1) {
		                    System.out.println("- " + books[i]);
		                }
		            }
		        } else {
		            System.out.println("Invalid patron index.");
		        }
		    }

		
}
