import java.util.ArrayList;

public class Fibonacci {

    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) {
        System.out.print("Iterative: ");
        System.out.println(fibDip(43) + " \nIterations: " + counter1);
        System.out.println();
        System.out.print("Recursive: ");
        System.out.println(fib2(43) + " \nCalls: " + counter2);
        //Finds the nth number by adding together the two previous numbers

    }
    //This returns the nth fib number
    //fib(5) = 5
    //fib(6) = 8
    public static int fib(int n){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        for(int i = 2; i <= n; i++){
            list.add((list.get(i-2) + list.get(i-1)));
        }
        return list.get(n);
    }

    public static int fibDip(int n){
        int current = 0;
        int next  = 1;

        for(int i = 0; i < n; i++){
            counter1++;
            int sum = current + next;
            current = next;
            next = sum;
        }
        return current;
    }

    //5 -> 3rd + 4th
    //3 -> 1st + 2nd
    //2nd -> 1st + 0th
    public static int fib2(int n){
        counter2++;
        if(n <= 1) return n;
        return fib2(n - 2) + fib2(n - 1);
    }
}
