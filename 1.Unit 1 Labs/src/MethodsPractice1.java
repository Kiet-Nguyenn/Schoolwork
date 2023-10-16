import java.util.*;

public class MethodsPractice1
{
    private Scanner keyboard = new Scanner(System.in);

    /** This method returns a string using the following
     *  conditions: if weight is less than 100 it returns
     *  "small", if weight is greater than or equal to 100
     *  and less than or equal to 200 it returns "medium",
     *  if weight is greater than 200 it returns "large".
     *  @return the string "small", "medium", or "large"
     *  @param weight number representing a weight
     */
    public String method1(int weight)
    {
        if(weight < 100) {
            return "small";
        }
        else if(weight >= 100 && weight <= 200){
            return "medium";
        }
        else if(weight > 200){
            return "large";
        } else {
            return "invalid";
        }

    }

    /** This method prints phrase 10 times.
     *  @ param phrase the string to be printed
     */
    public void method2(String phrase)
    {
        for(int i = 1; i <= 10; i++){
            System.out.println(phrase);
        }
    }

    /** This method allows a user to enter an unknown
     *  number of integers from the keyboard. When the
     *  sentinel value -1 is entered the method returns
     *  the count of the number of integers entered.
     *  @return count of the number of integers entered
     */
    public int method3()
    {
        Scanner key = new Scanner(System.in);
        int i = 0;
        int count = 0;
        while(i != -1){
            i = key.nextInt();
            count++;
        }
        return count-1;
    }

    /** This method returns a string containing the
     *  first and last letter of str concatenated
     *  together.
     *  @return a string containing two letters
     *  @param str the string from which to extract
     *     the first and last letters
     */
    public String method4(String str)
    {
        return "" + str.substring(0,1) + str.substring((str.length()-1),str.length());
    }

    /** This method returns a random number.
     *  @return a random number in range of 0 to upper-1
     *  @param upper the upper limit of the random number
     */
    public int method5(int upper)
    {
        return (int)(Math.random()*upper);
    }

    public static void main(String[] args)
    {
        MethodsPractice1 app = new MethodsPractice1();

        System.out.println("******************");
        System.out.println("   Test Method1");
        System.out.println("******************");

        System.out.println("Weight is " + app.method1(150));
        System.out.println("Weight is " + app.method1(99));
        System.out.println("Weight is " + app.method1(200));
        System.out.println("Weight is " + app.method1(300));

        System.out.println("\n\n******************");
        System.out.println("   Test Method2");
        System.out.println("******************");
        app.method2("Computers are fun!");

        System.out.println("\n\n******************");
        System.out.println("   Test Method3");
        System.out.println("******************");
        System.out.println("\nCount = " + app.method3());

        System.out.println("\n\n******************");
        System.out.println("   Test Method4");
        System.out.println("******************");
        System.out.println("String = " + app.method4("red"));
        System.out.println("String = " + app.method4("green"));
        System.out.println("String = " + app.method4("blue"));

        System.out.println("\n\n******************");
        System.out.println("   Test Method5");
        System.out.println("******************");
        System.out.println("Random Number = " + app.method5(5));
        System.out.println("Random Number = " + app.method5(50));
        System.out.println("Random Number = " + app.method5(500));
        System.out.println();
    }
}  