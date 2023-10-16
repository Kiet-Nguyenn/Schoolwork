import java.util.ArrayList;

/**An ArrayList is an object similar to an Array.
 * ArrayLists have a dynamic (changing size.)
 * ArrayList can only store objects.
 */

public class ArrayListIntro {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        //1. add(object) - adds object at end of list.
        list.add(10);
        list.add("Kiet");
        list.add(true);

        //[10, "Kiet", true]

        //2. get(index) - returns the element at index.
        System.out.println("Element 0: " + list.get(0));
        System.out.println("Element 1: " + list.get(1));
        System.out.println("Element 2: " + list.get(2));

        //System.out.println(list.get(10)); must be on index of list


        //This calls the toString for the list, prints all values.
        System.out.println(list);


        //3. add(index, object) - insert object at index,moves objects to the right after the insertion point.
        list.add(0, "SWAG");
        list.add(2, "LITTY");
        System.out.println(list);

        //4. set(index, object) - replace the object at index with param object.
        list.set(2, "SWAG");
        System.out.println(list);

        //5. remove(index) - removes the object at index. Other values move to the left.
        //Will return the element removed from the list.
        System.out.println(list.remove(1));
        System.out.println(list);

        //remove(object) - removes an object from the list if it exists.
        //will return true if something was removed. false if not.
        list.remove("SWAG");
        System.out.println(list);

        //6. size() - returns the size of the list.
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        for(Object o : list){
            System.out.println(o);
        }

    }
}
