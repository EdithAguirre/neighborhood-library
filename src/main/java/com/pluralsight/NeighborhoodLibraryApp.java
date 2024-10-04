package com.pluralsight;
import java.util.Scanner;

public class NeighborhoodLibraryApp {
    public static void main(String[] args) {

        // Create a scanner object
        Scanner scanner = new Scanner(System.in);

        // An array to hold an inventory of at least 20 books of your choice
        Book[] books = new Book[20];

        // Adding books
        books[0] = new Book(1,"978-1-98765-432-1", "The Clean Coder", true, "Sandra");
        books[1] = new Book(2, "978-1-98765-433-8", "Code Reading", false, "(no one)");
        books[2] = new Book(3, "978-1-98765-434-5", "Code Craft", false, "(no one)");
        books[3] = new Book(4,"978-1-98765-435-2", "The Self-Taught Programmer", false, "(no one)");
        books[4] = new Book(5, "978-1-98765-436-9","Coders at Work", false, "(no one)");
        books[5] = new Book(6, "978-1-98765-437-6", "Java: The Good Parts", false, "(no one)");
        books[6] = new Book(7, "978-1-98765-438-3", "Clojure Programming", true, "Anthony");
        books[7] = new Book(8, "978-1-98765-439-0", "Java in a Nutshell", false, "(no one)");
        books[8] = new Book(9, "978-1-98765-440-6", "The Way to Go", false, "(no one)");

        int option;
        do {
            // Prompt user to select a screen using a text block
            System.out.print("""
                    Welcome to the Neighborhood Library!
                    Select which option you would like to view.\s
                    (1) Show Available Books\s
                    (2) Show Checked Out books\s
                    (3) Exit\s
                    Enter an option (1,2, or 3): """);
            option = scanner.nextInt();

            // Direct the user to the method that performs the selected option
            switch (option) {
                case 1:
                    showAvailableBooks(books, scanner);
                    break;
                case 2:
                    showCheckedOutBooks(books, scanner);
                    break;
                case 3:
                    return;
            }
        }while(option != 3);


    }

    public static void showAvailableBooks(Book[] books, Scanner scanner){
        // Displays a list of all books that are not currently checked out
        System.out.println("Available Books: ");
        for(int i = 0; i < books.length - 1 && books[i] != null; i++){
            if(!books[i].isCheckedOut()) {
                System.out.println("Book ID: " + books[i].getId() + ", ISBN: " + books[i].getIsbn()
                        + " Book Title: " + books[i].getTitle());
            }
        }

        // Prompt the user to either select a book to check out, or exit to go back to home screen
        System.out.print("\nSelect a book to check out by typing the book ID or type 0 to exit: ");
        int choice = scanner.nextInt();

        if(choice != 0){
            for(int i = 0; i < books.length - 1 && books[i] != null; i++){
                if(choice == books[i].getId() && !books[i].isCheckedOut){
                    System.out.print("Please enter your name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    books[i].checkOut(name);
                    System.out.println("The book: \"" + books[i].getTitle() + "\" has been checked out.\n");
                }
            }
        }


    }

    public static void showCheckedOutBooks(Book[] books, Scanner scanner){
        // Display a list of all the books that are currently checked out
        System.out.println("Checked Out Books: ");
        for(int i = 0; i < books.length - 1 && books[i] != null; i++){
            if(books[i].isCheckedOut()) {
                System.out.println("Book ID: " + books[i].getId() + ", ISBN: " + books[i].getIsbn()
                        + ", Book Title: " + books[i].getTitle() + ", Checked Out to: " + books[i].checkedOutTo);
            }
        }

        // Prompt user to check in a book or go back to home screen
        System.out.print("Done! What would you like to do next? \n" +
                "(C) - to Check In a book \n" +
                "(X) - to go back to the home screen\n" +
                "Select and option (C or X): ");

        String option = scanner.nextLine();

        if(option.equalsIgnoreCase("C")){

        }
        else if(option.equalsIgnoreCase("X")){

        }
    }

}
