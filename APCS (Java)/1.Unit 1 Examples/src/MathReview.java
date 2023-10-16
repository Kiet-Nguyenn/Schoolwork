public class MathReview {
    public static void main(String args[]){
        int num1 =10;
        int num2 = 3;

        int sum = num1 + num2;
        int diff = num1 - num2;
        int product = num1 * num2;
        int quo = num1 / num2; //this is integer division, will not give real result. int div = 3, real div = 3.333
        double quo2 = (double)num1 / num2;
        double quo3 = num1 / 3.0;

        //modulus - % - returns remainder after int division.
        //10 % 3 = 1
        //10 % 4 = 2
        int remainder = num1 % num2;


        //Math.random() - this method will return a double value in the range of [0 - 1)
        //[40 - 90]
        //1. Subtract min from max in range: 90 - 40 -> 50
        //2. Add one: 50 + 1

        int rand = (int)(Math.random() * 51) + 40;
    }
}
