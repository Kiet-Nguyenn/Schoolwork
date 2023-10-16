import java.util.*;      // needed for ArrayList

public class ArrayListPractice
{
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Method 1");
        System.out.println("--------");
        System.out.println();
        Method1();
        System.out.println();
        System.out.println("Method 2");
        System.out.println("--------");
        System.out.println();
        Method2();
    }

    public static void Method1()
    {
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 10; i <= 100; i += 10){
            list1.add(i);
        }
        for(int i = 0; i < list1.size(); i++){
            System.out.println(list1.get(i));
        }
        System.out.println();
        for(Object o : list1){
            System.out.println(o);
        }

    }

    public static void Method2()
    {
        ArrayList<String> list2 = new ArrayList<>();
        String input = "";
        System.out.println("Enter Words - type exit when finished.\n");
        while(!input.equalsIgnoreCase("exit")){
            System.out.print("Enter a word --> ");
            input = keyboard.nextLine();
            if(!input.equalsIgnoreCase("exit")) {
                list2.add(input);
            }
        }
        for(int i = 0; i < list2.size(); i++){
            System.out.println(list2.get(i));
        }
        System.out.println();
        for(Object o : list2){
            System.out.println(o);
        }
    }
}