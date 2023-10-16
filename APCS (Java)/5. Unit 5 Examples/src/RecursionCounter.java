public class RecursionCounter {
    public static void main(String[] args) {
        count();
        count2(10);
        System.out.println();
        count3(5,10);
    }

    public static void count(){
        for(int i = 0; i < 20; i++){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void count2(int n){
        System.out.print(n + " ");
        if(n > 0)
            count2(n-1);
    }

    public static void count3(int start, int stop){
        if(start >= stop) return; //base case is not explicit
        System.out.println(start);
        count3(start + 1, stop);
    }
}
