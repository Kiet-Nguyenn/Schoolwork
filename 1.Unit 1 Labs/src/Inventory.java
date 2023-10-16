import java.util.*;

public class Inventory
{
    // instance variables
    private Book[] books;     // declare array variable
    private int numBooks;     // logical size of array

    // constructor
    public Inventory()
    {
        books = new Book[20];  // instantiate array with length 20
        numBooks = 0;          // no books added yet
    }

    /* This method allows a user to input up to 20 books and stores them
       in the array books.
     */
    public void addBooks()
    {
        String ans = "y";
        while(!ans.equalsIgnoreCase("n")){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("************************\n" +
                               "*       addBooks       *\n" +
                               "************************");
            System.out.print("Student Name --> ");
            String name = keyboard.nextLine();
            System.out.print("Book Number --> ");
            String num = keyboard.nextLine();
            books[numBooks] = new Book(name, num);
            numBooks++;

            System.out.print("Enter another book? [y/n] ");
            ans = keyboard.nextLine();
        }
    }

    /* This method displays the student name and book number for each
     * Book in the array.
     */
    public void printBooks()
    {
        System.out.println("************************\n" +
                           "*      printBooks      *\n" +
                           "************************");
        for(int i = 0; i < numBooks; i++){
            System.out.println(books[i]);
        }
    }

    public static void main(String[] args)
    {
        Inventory app = new Inventory();
        app.addBooks();
        app.printBooks();
    }
}