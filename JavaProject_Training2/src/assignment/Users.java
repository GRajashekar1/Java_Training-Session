package assignment;

import java.util.Scanner;

public class Users {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();

        boolean exit = false;

        while (!exit) {
            System.out.println("Library Management System");
            System.out.println(" 1. Add Book \n 2. Add Patron \n 3. Borrow Book \n 4. Return Book \n 5. Book Availability \n 6. Borrowed Books by Patron \n 7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String bookTitle = sc.nextLine();
                    System.out.println("Enter book author: ");
                    String authorName = sc.nextLine();
                    library.addBook(bookTitle,authorName);
                    break;
                case 2:
                    System.out.print("Enter patron name: ");
                    String patronName = sc.nextLine();
                    library.addPatron(patronName);
                    break;
                case 3:
                    System.out.print("Enter patron index: ");
                    int patronIndex = sc.nextInt();
                    System.out.print("Enter book index: ");
                    int bookIndex = sc.nextInt();
                    library.borrowBook(patronIndex, bookIndex);
                    break;
                case 4:
                    System.out.print("Enter patron index: ");
                    patronIndex = sc.nextInt();
                    System.out.print("Enter book index: ");
                    bookIndex = sc.nextInt();
                    library.returnBook(patronIndex, bookIndex);
                    break;
                case 5:
                    library.displayBookAvailability();
                    break;
                case 6:
                    System.out.print("Enter patron index: ");
                    patronIndex = sc.nextInt();
                    library.displayBorrowedBooksByPatron(patronIndex);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("Thank you for using the Library Management System!");
        
    }
	
}
