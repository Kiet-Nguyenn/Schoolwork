import java.util.*;

public class StudentCouncil
{
    // Instance Variables
    private Dance dance;
    private Scanner scan;

    // Constructor
    public StudentCouncil()
    {
        dance = new Dance();
        scan = new Scanner(System.in);
    }

    // Methods
    public void mainMenu()
    {
        int ans=0;

        do
        {
            System.out.println("======================");
            System.out.println("        Main Menu");
            System.out.println("======================");
            System.out.println("1. Buy a Ticket");
            System.out.println("2. Print Summary Report");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Selection --> ");
            ans = scan.nextInt();
            System.out.println();

            if(ans == 1)
            {
                buyTicket();
            }
            else if (ans == 2)
            {
                printSummary();
            }

        }
        while(ans != 3);

    }

    /** precondition:  none
     *  postcondition: prints a menu of ticket options and allows the
     *     user to select one of the items in the menu. It purchases
     *     a ticket according to ticket type selected.
     */
    public void buyTicket()
    {
        int ticket = 0;
        System.out.println("======================");
        System.out.println("        Buy Ticket");
        System.out.println("======================");
        System.out.println("1. Gold Pass");
        System.out.println("2. Silver Pass");
        System.out.println("3. Bronze Pass");
        System.out.println("4. No Pass");
        System.out.println();
        System.out.print("Selection --> ");
        ticket = scan.nextInt();
        System.out.println();

        if(ticket == 1)
        {
            dance.buyTicket(1);
        }
        else if (ticket == 2)
        {
            dance.buyTicket(2);
        }
        else if (ticket == 3)
        {
            dance.buyTicket(3);
        }
        else if (ticket == 4)
        {
            dance.buyTicket(4);
        }
        System.out.println();
        mainMenu();
    }

    /** precondition:  none
     *  postcondition: prints a summary report that includes the
     *     current number of students attending the dance and the
     *     current amount of money made from ticket sales.
     */
    public void printSummary()
    {
        System.out.println("======================");
        System.out.println("        Summary Report");
        System.out.println("======================");
        System.out.println("Total Attendance = " + dance.getAttendance());
        System.out.println("Ticket Sales = " + dance.getTicketSales());
        System.out.println();
        mainMenu();
    }

    public static void main(String[] args)
    {
        StudentCouncil app = new StudentCouncil();
        app.mainMenu();

    }
}