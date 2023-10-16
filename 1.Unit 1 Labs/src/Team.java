import java.util.*;

public class Team
{
    // instance variables
    private Player[] team;
    private int teamSize;
    // constructor
    public Team() {
        team = new Player[20];
        teamSize = 0;
    }

    /* This method allows a user to input up to 20 basketball players and
     *  stores them in an array.
     */
    public void addPlayers()
    {
        Scanner keyboard = new Scanner(System.in);
        {
            String ans = "y";
            while (!ans.equalsIgnoreCase("n")) {
                System.out.println("************************\n" +
                        "*      addPlayers      *\n" +
                        "************************");
                System.out.print("Enter Player Name --> ");
                String playerName = keyboard.nextLine();
                System.out.print("Enter Free Throws Made --> ");
                int ftm = keyboard.nextInt();
                keyboard.nextLine();
                System.out.print("Enter Free Throws Attempted--> ");
                int fta = keyboard.nextInt();
                keyboard.nextLine();
                System.out.print("Enter 2 Point Field Goals Made --> ");
                int fgm2 = keyboard.nextInt();
                keyboard.nextLine();
                System.out.print("Enter 2 Point Field Goals Attempted --> ");
                int fga2 = keyboard.nextInt();
                keyboard.nextLine();
                System.out.print("Enter 3 Point Field Goals Made --> ");
                int fgm3 = keyboard.nextInt();
                keyboard.nextLine();
                System.out.print("Enter 3 Point Field Goals Attempted --> ");
                int fga3 = keyboard.nextInt();
                keyboard.nextLine();
                team[teamSize] = new Player(playerName, ftm, fta, fgm2, fga2, fgm3, fga3);
                teamSize++;

                System.out.print("Enter another player? [y/n]: ");
                ans = keyboard.nextLine();
            }
        }
    }

    /* This method displays each Player in the array
     */
    public void printPlayers()
    {
        System.out.println("************************\n" +
                           "*      printPlayers     *\n" +
                           "************************");
        for(int i = 0; i < teamSize; i++){
            System.out.println("Player Name = " + team[i].getPlayerName() +
                    "\nFree Throws % = " + team[i].getFTPercentage() +
                    "\n2 Point Field Goal % = " + team[i].getFG2Percentage() +
                    "\n3 Point Field Goal % = " + team[i].getFG3Percentage() +
                    "\nTotal Points Scored = " + team[i].getPointsScored());
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Team app = new Team();
        app.addPlayers();
        app.printPlayers();
    }
}