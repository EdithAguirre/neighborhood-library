package com.pluralsight;
import java.util.Scanner;

public class NeighborhoodLibraryApp {
    public static void main(String[] args) {

        // Create a scanner object
        Scanner scanner = new Scanner(System.in);

        // An array to hold an inventory of at least 20 books of your choice
        Book[] books = new Book[20];

        // Adding books
        books[0] = new Book(1,"qwe", "The Clean Coder: ", false, "(no one)");
        books[1] = new Book(2, "rty", "Code Reading", false, "(no one)");
        books[2] = new Book(3, "uio", "Code Craft", false, "(no one)");
        books[3] = new Book(4,"pas", "The Self-Taught Programmer", false, "(no one)");
        books[4] = new Book(5, "dfg","Coders at Work", false, "(no one)");
        books[5] = new Book(6, "hjk", "Java: The Good Parts", false, "(no one)");
        books[6] = new Book(7, "lzx", "Clojure Programming", false, "(no one)");
        books[7] = new Book(8, "cvb", "Java in a Nutshell", false, "(no one)");
        books[8] = new Book(9, "rgb", "The Way to Go", false, "(no one)");

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

            System.out.println(books.length);
            // Direct the user to the method that performs the selected option
            switch (option) {
                case 1:
                    showAvailableBooks(books, scanner);
                    break;
                case 2:
                    showCheckedOutBooks(books);
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
            if(books[i].isCheckedOut()){
                return;
            }
            else{
                System.out.println("Book ID: " + books[i].getId() + ", ISBN: " + books[i].getIsbn()
                                    + "Book Title: " + books[i].getTitle());
            }
        }

        // Prompt the user to either select a book to check out, or exit to go back to home screen
        System.out.println("\nSelect a book to check out by typing the book ID or type 0 to exit: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice != 0){
            System.out.println("Please enter your name: ");
            String name = scanner.nextLine();
            for(int i = 0; i < books.length - 1 && books[i] != null; i++){
                if(choice == books[i].getId()){
                    books[i].checkOut(name);
                    System.out.println(books[i].getTitle() + " " + books[i].isCheckedOut + " ");
                }
            }
        }


    }

    public static void showCheckedOutBooks(Book[] books){
        // Display a list of all the

    }
}
