import java.util.*;

public class Kennel
{
    // instance variable
    private Dog[] dogs;     // declare array variable

    // constructor
    public Kennel()
    {
        dogs = new Dog[5];  // instantiate array with length 5
    }

    /* This method allows a user input information about 5 dogs and
     * stores this information in the array dogs.
     */
    public void addDogs()
    {
        Scanner keyboard = new Scanner(System.in);
        for(int i = 0; i <= 4; i++){
            System.out.print("Enter Dog Name: ");
            String name = keyboard.nextLine();
            System.out.print("Enter Dog Breed: ");
            String breed = keyboard.nextLine();
            dogs[i] = new Dog(name,breed);
            System.out.println();
    }

    }

    /* This method displays the name and breed for each Dog in the array.
     */
    public void printDogs()
    {
        for(int i = 0; i <= 4; i++){
            System.out.println("Name: " + dogs[i].getName());
            System.out.println("Breed: " + dogs[i].getBreed());
            System.out.println();

        }
    }

    public static void main(String[] args)
    {
        Kennel app = new Kennel();
        app.addDogs();
        app.printDogs();
    }
}