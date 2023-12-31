public class Dance
{
    // Constants
    public final int GoldPass = 1;
    public final int SilverPass = 2;
    public final int BronzePass = 3;
    public final int NoPass = 4;

    // Instance Variables
    int attendance;
    double ticketSales;


    // Constructors
    public Dance()
    {
        attendance = 0;
        ticketSales = 0;
    }

    // Methods

    /** precondition:  value of code is in the range (1 to 4) inclusive.
     *  postcondition: updates the ticketSales by the price of the ticket
     *     specified by the parameter code. The attendance variable is
     *     incremented by one.
     *  @param code a value from (1 - 4) indicating the type of ticket
     */
    public void buyTicket(int code)
    {
        if(code == 1){
            attendance++;
        } else if(code == 2){
            ticketSales += 2.00;
            attendance++;
        } else if(code == 3){
            ticketSales += 4.00;
            attendance++;
        } else if(code == 4){
            ticketSales += 6.00;
            attendance++;
        } else{
            System.out.println("Invalid Code");
        }

    }

    /** @return the value of attendance
     */
    public int getAttendance()
    {
        return attendance;
    }

    /** @return the amount of ticketSales
     */
    public double getTicketSales()
    {
        return ticketSales;
    }
}