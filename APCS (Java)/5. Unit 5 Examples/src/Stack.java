public class Stack {
    public static void main(String[] args) {
        count(5);
    }

    public static void count(int n){
        if (n > 0){
            System.out.println("Pushing " + n + " on the stack");
            //^ before but on stack
            count(n-1);
            //v after popped off stack
            System.out.println("Popping " + n + " off the stack");

            //Tail Recursion - the recursive method call is the last line that executes
            //Head Recursion - the recursive method call is not lass, must keep pop order in mind

        }
    }
}
