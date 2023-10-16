import java.util.Arrays;

public class ArraysRecap {
    public static void main(String args[]){

        //Arrays are objects that can store a fixed number of values of the same type.

        String[] names = new String[4]; //this can store 4 strings

        //use a for loop to print all names
        for(int i = 0;i < names.length;i++){
            System.out.print(names[i] + ", ");
        }

        //Change names in the array
        names[0] = "John";
        names[1] = "Jonathan";
        names[2] = "Johnny";
        names[3] = "Johnigula";

        System.out.println();
        for(int i = 0;i < names.length;i++){
            System.out.print(names[i] + ", ");
        }

        //length and last index
        int len = names.length;
        int lastIndex = len - 1;
        System.out.println("\nLast element: " + names[lastIndex]);

        //Making an array of ints using an initializer list
        int[] nums = {11, 22, 33, 44, 55};

        //use an enhanced for loop to print nums
        for(int n: nums){
            System.out.print(n + " ");
        }

        Student[] students = new Student[5];
        students[0] = new Student("bob", 2.5, 10); //anonymous object
        students[1] = new Student("jim", 1.5, 11);
        students[2] = new Student("john", 3, 10);
        students[3] = new Student("chad", 1, 11);
        students[4] = new Student("chadwick", 4, 12);
        for(Student s: students){
            System.out.println(s); //THIS CALLS THE TO STRING
        }

        System.out.println(Arrays.toString(students));

    }
}
