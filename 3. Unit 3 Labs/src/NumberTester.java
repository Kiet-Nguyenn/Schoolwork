import static java.lang.System.*;

public class NumberTester
{
    public static void main(String[] args) {
        //add test cases

        Number one = new Number(7);
        out.println(one);
        out.println(one + " isOdd == " + one.isOdd());
        out.println(one + " isPerfect == " + one.isPerfect());
        out.println();
        one.setNumber(496);
        out.println(one);
        out.println(one + " isOdd == " + one.isOdd());
        out.println(one + " isPerfect == " + one.isPerfect());



        //add more test cases






    }
}