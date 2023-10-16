import java.util.Scanner;

/**
 * This example is a review of loops and strings from CS1.
 */

public class LoopsAndStrings{

    /** countToTwenty(int startingNum)
     *  precondition: startingNum is a number with a value of 20 or less
     *  postcondition: the method will print a list of nums [startingNum - 20]
     */
    public void countToTwenty(int startingNum){
        for (int i = startingNum; i <= 20; i++){
            //for(loop control variable; boolean condition; increment)
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /** printNumbers(int maxNum)
     *  precondition: maxNum is a positive integer
     *  postcondition: this method will print out [1-maxNum]
     *  while loop
     */
    public void printNumbers(int maxNum){
        int num = 1; //loop control variable
        while(num <= maxNum){ //boolean condition
            System.out.print(num + " ");
            num++; //increment
        }
        System.out.println();
    }


    /** guessMyNumber(int num)
     *  precondition: num is an integer
     *  postcondition: Print "you guessed the number" when the user enters num
     */
    public void guessMyNumber(int num){
        Scanner key = new Scanner(System.in);
        int userGuess = 0;
        while(userGuess != num){ //num is the sentinel value. Will end the loop
            System.out.print("Enter a num: ");
            userGuess = key.nextInt();

        }
        System.out.println("You guessed the number.");
    }

    /** fizzBuzz(int num)
     *  precondition: num is a positive integer
     *  postcondition: 
     *      we will print each value i between 1 and num
     *      if i has a factor of 5, print after i "fizz"
     *      if i has a factor of 3, print after i "buzz"
     *      if i has factors of 3 and 5, print "fizzbuzz"
     *
     *      1
     *      2
     *      3 buzz
     *      4
     *      5 fizz
     *      ...
     *      15 fizzbuzz
     */

    public void fizzBuzz(int num){
        for(int i = 1; i <= num; i++){
            System.out.print(i + " ");
            if (i % 5 == 0) {
                System.out.print("fizz");
            }
            if (i % 3 == 0) {
                System.out.print("buzz");
            }
            System.out.println();
        }
    }

    public void stringStats(String str){
        System.out.println("String Stats:");
        //computer
        //01234567

        //print length of computer
        System.out.println("Length: " + str.length());
        //print the last index of computer
        System.out.println("Last Index: " + (str.length() - 1));
        //print first letter of computer
        System.out.println("First Letter: " + str.substring(0,1));
    }

    public String getString(String str){
        String output = "";
        for(int i = 0;i < str.length();i++){
            output += str.substring(i,i+1);
        }
        return output;
    }

    public static void main(String[] args){
        LoopsAndStrings test = new LoopsAndStrings();
        //test.countToTwenty(5);
        //test.printNumbers(15);
        //test.guessMyNumber(4);
        //test.fizzBuzz(30);
        //test.stringStats("computer");
        System.out.println(test.getString("Hello World"));
    }
}