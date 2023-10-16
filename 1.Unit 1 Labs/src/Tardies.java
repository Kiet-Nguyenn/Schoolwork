import java.util.*;

public class Tardies
{
    // instance variables
    private Student[] students;    // list of students
    private int numStudents;       // logical size of the array

    // constructor
    public Tardies()
    {
        students = new Student[50];   // instantiate array
        numStudents = 0;
    }

    /** precondition: none
     *  postcondition: students array has been populated with
     *     Student objects from keyboard input. numStudents has 
     *     been updated to reflect the logical size of the 
     *     array student.
     */
    public void enterData()
    {
        Scanner key = new Scanner(System.in);
        String ans = "y";
        System.out.println("==================\nEnter Student Data\n==================");
        while(!ans.equalsIgnoreCase("n")) {
            System.out.print("Enter Last Name --> ");
            String lastName = key.nextLine();
            System.out.print("Enter First Name --> ");
            String firstName = key.nextLine();
            System.out.print("Enter Number of Tardies --> ");
            int tardies = key.nextInt();
            key.nextLine();
            students[numStudents] = new Student(lastName,firstName,tardies);
            numStudents++;
            System.out.print("\nEnter another student? [y/n] ");
            ans = key.nextLine();
            System.out.println();
        }

    }

    /* @return the total number of tardies for all students
     *    in the class.
     */
    public int getTotalTardies()
    {
        int tardies = 0;
        for(int i = 0; i < numStudents; i++){
            tardies += students[i].getTardies();
        }
        return tardies;
    }

    /** precondition: none
     *  postcondition: a summary report has been printed which includes
     *     the total number of tardies for the entire class and a
     *     list of names and tardies for every student in the class.
     */
    public void summaryReport()
    {
        System.out.println("==================================\nClass Summary - Tardy Total = " + getTotalTardies() + "\n==================================\n");
        for(int i = 0; i < numStudents; i++){
            System.out.println(students[i]);
        }
    }

    public static void main(String[] args)
    {
        Tardies app = new Tardies();
        app.enterData();
        app.summaryReport();
    }
}