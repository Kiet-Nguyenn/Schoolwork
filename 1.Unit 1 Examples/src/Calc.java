/** This example introduces the idea of static vs. non-static (instance) methods and variables
 *  Static: This keyword indicates a method or value belongs to a class rather than an instance (object) of that class.
 *
 *  All objects of a class share the same static methods and values.
 *
 *  Summary
 *  1. Static methods and variables belong to a class rather than an object.
 *  2. Static methods can be called by referencing the class. e.g. Class.method()
 *  3. Static methods can only reference static methods.values
 *  4. Non static (instance) methods can reference both static/instance
 */
public class Calc {
    private static int sum; //static methods can only reference static fields/methods
    private static int diff;

    private Calc(){ //set constructor to private when we don't want to make objects.

    }
    public static void add(int num1, int num2){
        sum = num1 + num2;
        System.out.println("Sum: " + sum);
    }

    public static void subtract(int num1, int num2){
        diff = num1 - num2;
        System.out.println("Difference: " + diff);
    }

    public void printVars(){ //non static contexts can reference static contexts
        System.out.println(sum + "\n" + diff);
    }
}


class CalcRunner{
    public static void main(String args[]){
        int num1 = 10;
        int num2 = 15;

        Calc.add(num1,num2); //this static method can be called by referencing the class.
        Calc.subtract(num1,num2);
    }
}