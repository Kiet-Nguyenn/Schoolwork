import static java.lang.System.*;

public class DigitCounter
{
    public static void main(String args[])
    {
        System.out.println(countOddDigits(4532));
        System.out.println(countOddDigits(1114532));
        System.out.println(countOddDigits(2245327));
        System.out.println(countOddDigits(2468));
        System.out.println(countOddDigits(13579));

        //add more test cases
    }

    public static int countOddDigits(int num)
    {
        if(num == 0){
            return 0;
        }
        int lastDigit = num % 10;
        if(lastDigit % 2 == 1) {
            return 1 + countOddDigits(num / 10);
        }

        return countOddDigits(num / 10);
    }

}