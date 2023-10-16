import java.util.*;

public class SongApp
{
    public static void main(String[] args)
    {
        SongTester s = new SongTester();
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter number of bottles --> ");
        int b = keyboard.nextInt();
        s.song(b);    // call to void method
        System.out.println();
        System.out.println();
    }
}

class SongTester
{
    public void song(int b)
    {
        if(b < 1)
            return;

        printSong(b);
        System.out.println();
        song(b-1);
    }

    public void printSong(int n){
        System.out.println(n + " bottles of root beer on the wall. \n" + n + " bottles of root beer. \nTake one down, pass it around\n" + (n-1) + " bottles of root beer on the wall.");
    }
}