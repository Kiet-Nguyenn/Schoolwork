public class Binding {
    public static void main(String[] args){
        /* Objects can have a static and dynamic type
           Static type: the type of the reference variable
           Dynamic type: the actual type of the object
         */

        Animal animal = new Dog("asdfasdf","adfas");
        //Static type: Animal
        //Dynamic type: Dog

        //At time of compilation the compiler only knows the static type.
        animal.getName();
        ((Dog) animal).getBreed();

        animal.eatFood();

        /* When a method is called:
           1. The compiler checks if the method exists in the reference type class
           2. When program is running the JVM will use the actual(dynamic) type of the object
           to call the method
         */

    }
}
