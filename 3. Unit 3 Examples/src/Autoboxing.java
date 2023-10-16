import java.util.ArrayList;

public class Autoboxing {
    public static void main(String[] args){
        /* Auto/unboxing occurs when the compiler converts between primitives and wrapper class objects

                Autoboxing happens when we convert a primitive to an object.
                Autoboxing occurs when:
                1. Assigning a primitive to a wrapper class variable
                2. Passing a primitive to a method that should receive a wrapper class Object.
         */

        Integer num = new Integer(5);
        Integer num2 = 10; //autoboxing - the compiler is making 10 into an Integer object

        ArrayList<Integer> list = new ArrayList<>();
        list.add(15);

        /* Unboxing happens when we convert a wrapper class Object to a primitive.
           Happens in two cases:
           1. Assigning a wrapper class object to a primitive variable.
           2. When passing a wrapper class object to a method that should receive a primitive.

         */

        Integer num4 = new Integer(20);
        int numz1 = num4; //unboxing - the compiler converts the object to a primitive
        int numz2 = list.get(0); //unboxing
        double result = Math.pow(list.get(0), 2);
        int sum = getSum(list.get(0), list.get(0));

        if(list.get(0) > 10){ //unboxing
            System.out.println("aosdfhasof");
        }

        boolean test = list.get(0) == 0;
    }

    public static int getSum(int num1, int num2){
        return num1 + num2;
    }
}
