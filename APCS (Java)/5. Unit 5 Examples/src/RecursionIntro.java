public class RecursionIntro {
    public static void main(String[] args) {
        //printThings();
        System.out.println(countEars(5));
        System.out.println(factorial(5));
    }

    public static void printThings(){
        System.out.println("Things");
        printThings();
    }

    public static int countEars(int numRabbits){
        if(numRabbits == 1) return 2;

        return 2 + countEars(--numRabbits);
    }

    public static int factorial(int num){
        if(num == 1) return 1;

        return num * factorial(num - 1);
    }
}
