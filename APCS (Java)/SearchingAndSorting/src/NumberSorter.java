import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
    //instance variables and other methods not shown

    private static int getNumDigits(int number)
    {
        int count = 0;
        while (number > 0){
            count++;
            number /= 10;
        }
        return count;
    }

    public static int[] getSortedDigitArray(int number)
    {
        int size = getNumDigits(number);
        int[] sorted = new int[size];
        for(int i = 0; i < size; i ++){
            sorted[i] = number % 10;
            number /= 10;
        }
        for(int i = 1; i < sorted.length; i++){
            int temp = sorted[i];
            int j = i;
            while(j > 0 && sorted[j - 1] > temp){
                sorted[j] = sorted[j - 1];
                j--;
            }
            sorted[j] = temp;
        }
        return sorted;
    }
}

class NumberSorterRunner
{
    public static void main(String args[])
    {
        int[] cases = {567891, 901912468, 864213507, 898777, 234422};
        for( int test : cases )
        {
            int[] one = NumberSorter.getSortedDigitArray( test );
            for(int item : one)
            {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
