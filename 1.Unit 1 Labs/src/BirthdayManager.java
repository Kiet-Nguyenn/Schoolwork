import java.util.Scanner;

public class BirthdayManager {
    private Birthday[] birthdays;
    private int numBirthdays;

    public BirthdayManager() {
        birthdays = new Birthday[50];
        numBirthdays = 0;
    }

    public void addBirthdays() {
        String ans = "y";
        System.out.println("************************\n" +
                "*     addBirthdays     *\n" +
                "************************");
        while (!ans.equalsIgnoreCase("n")) {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Enter Name --> ");
            String name = keyboard.nextLine();
            System.out.print("Enter Bday --> ");
            String bday = keyboard.nextLine();
            birthdays[numBirthdays] = new Birthday(name, bday);
            numBirthdays++;

            System.out.print("Enter another? [y/n] ");
            ans = keyboard.nextLine();
        }
    }

    public void printBirthdays(){
        for(int i = 0; i < numBirthdays;i++){
            System.out.println(birthdays[i]);
        }
    }

    public static void main(String args[]){
        BirthdayManager app = new BirthdayManager();
        app.addBirthdays();
        app.printBirthdays();
    }
}
