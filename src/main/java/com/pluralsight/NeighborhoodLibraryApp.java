package com.pluralsight;
import java.util.Scanner;

public class NeighborhoodLibraryApp {
    public static void main(String[] args) {

        // Create a scanner object
        Scanner scanner = new Scanner(System.in);

        // An array to hold an inventory of at least 20 books of your choice
        Book[] books = new Book[20];

        int option;
        do {
            // Prompt user to select a screen using a text block
            System.out.println("""
                    Welcome to the Neighborhood Library!
                    Select which option you would like to view.\s
                    (1) Show Available Books\s
                    (2) Show Checked Out books\s
                    (3) Exit\s
                    Enter an option (1,2, or 3):\s""");
            option = scanner.nextInt();

            // Direct the user to the method that performs the selected option
            switch (option) {
                case 1:
                    showAvailableBooks(books);
                case 2:
                    showCheckedOutBooks(books);
                case 3:
                    return;
            }
        }while(option != 3);


    }

    public static void showAvailableBooks(Book[] books){
        for(Book book : books){
            if(book.isCheckedOut()){
                return;
            }
            else{
                System.out.println(book.getId());
            }
        }

    }

    public static void showCheckedOutBooks(Book[] books){

    }
}
