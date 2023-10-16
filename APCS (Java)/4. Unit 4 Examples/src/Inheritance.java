import java.util.ArrayList;

public class Inheritance {
    public static void main(String[] args){
        /* In java, a class can have a single superclass from which it inherits methods and fields.
           Inheritance allows a way for classes to use the same code - saves the developer time and effort

           A subclass can only inherit public and protected methods and fields

           Override - when two classes implement the same method with same signature
           Overload - when the same class implements two methods with the same name but different params


         */
        Animal animal = new Animal("Duck");
        System.out.println(animal);

        Dog dog = new Dog("Maltese", "Matty");
        System.out.println(dog);

        Cat cat = new Cat(true, "Garfield");
        System.out.println(cat);

        Animal animal1 = new Dog("bluey", "10");
        System.out.println(animal1);

        ArrayList<Animal> list = new ArrayList<>();

    }
}
