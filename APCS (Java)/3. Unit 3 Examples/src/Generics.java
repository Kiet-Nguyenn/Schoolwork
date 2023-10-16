import java.util.ArrayList;
/* Generics are a way to use a type as a parameter.
   all you need to know: the arraylist will only store values of the generic type.
 */

public class Generics {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        //list.add(5);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).substring(0,1));
        }

        ArrayList<Double> list2 = new ArrayList<>();
        list2.add(5.5); //autoboxing - when the compiler takes a primitive and wraps it in the appropriate wrapper class.
        list2.add(new Double(1.1));

        double dub = list2.get(0); //unboxing - the compiler takes a wrapper class object and unboxes to the primitive
        System.out.println(dub);

        //int sum = (Integer)list2.get(0) + list2.get(1);
        double dub2 = list2.get(0);
        double dub3 = list2.get(1);
        int sum = (int)dub2 + (int)dub3;

    }
}
