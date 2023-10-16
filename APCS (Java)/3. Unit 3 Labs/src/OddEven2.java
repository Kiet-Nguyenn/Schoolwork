import java.util.ArrayList;

import static java.lang.System.*;

class OddEven2
{
    public static void main( String args[] )
    {
        NumberAnalyzer test = new NumberAnalyzer("5 12 9 6 1 4 8 6");
        out.println(test);
        out.println("odd count = "+test.countOdds());
        out.println("even count = "+test.countEvens());
        out.println("perfect count = "+test.countPerfects()+"\n\n\n");


        //add more test cases


    }
}