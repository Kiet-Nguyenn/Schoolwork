import java.util.Scanner; //java.util is the package name. Scanner is the class name

/** This is a documentaion comment. Used to generate javadocs. 
 *  This program will demonstrate concepts from CS1 about methods, classes, and objects.
 *  All things in this example are included in the AP CS subset.
 */

public class Human {  //This is the class declaration
    //a class is a blueprint for an object, contains methods and data values (fields)

    //1. Instance variables - fields that describe an instance of a class (object)
    //primitve variables - int, double, boolean
    private int age;
    private double height;
    private boolean isGamer;

    //Reference variable types - these store a reference to an object.
    private String name;


    //2. Constructor methods

    //default constructor
    public Human(){

    }

    //assigns all instance vars
    public Human(int age, double height, boolean isGamer, String n){
        this.age = age;
        this.height = height;
        this.isGamer = isGamer;
        name = n;
    }

    //Accessor Methods - getters
    public int getAge(){
        return age;
    }
    public double getHeight(){
        return height;
    }
    public boolean getGamer(){
        return isGamer;
    }
    public String getName(){
        return name;
    }

    //Mutator Methods - setters
    public void setAge(int age){
        this.age = age;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setGamer(boolean isGamer){
        this.isGamer = isGamer;
    }
    public void setName(String name){
        this.name = name;
    }


    public void growOlder(){
        age++; //this is a unary operator will increase age by 1
    }
    public void growYounger(){
        age--;
    }
    public void doubelHeight(){
        height *= 2; //compound operator - height = height * 2
    }


    //toString
    public String toString(){
        return "Name: " + name +
                "\nAge: " + age +
                "\nHeight: " + height +
                "\nGamer? " + isGamer;
    }

    //main method
    public static void main(String args[]){
        Scanner key = new Scanner(System.in);
        Human alan = new Human();
        Human kevin = new Human(17,5.8,true,"kevin");

        System.out.println(kevin);

        System.out.println("\n" + kevin.getName());


        alan.setAge(5);
        alan.setHeight(6.5);
        alan.setGamer(true);

        System.out.print("\nEnter a name: " );
        String name = key.nextLine();

        alan.setName(name);

        System.out.println("\n" + alan);


        if (alan.getName().equalsIgnoreCase(kevin.getName())){
            System.out.println("\nThese are the same name! :)");
        } else {
            System.out.println("\nThese are different names. :(");
        }
    }
}