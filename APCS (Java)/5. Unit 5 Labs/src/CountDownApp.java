import java.util.*;

public class CountDownApp
{
    public static void main(String[] args)
    {
        CountDownTester cd = new CountDownTester();
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter starting value --> ");
        int s = keyboard.nextInt();

        cd.countDown(s);
    }
}

class CountDownTester
{
    public void countDown(int n)
    {
        if(n < 1)
            return;

        System.out.println(n);
        countDown(n-1);
    }
}