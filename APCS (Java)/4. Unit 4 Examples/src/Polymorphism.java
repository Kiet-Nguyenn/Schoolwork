import java.util.ArrayList;

public class Polymorphism {
    public static void main(String[] args){
        /* Polymorphism is a term that means "having many forms".
           In java both objects and methods can be considered polymorphic.
           A method is considered polymorphic when it has been overidden in a subclass.
         */

        Animal animal = new Dog("Swag", "YEET");
        Animal animal1 = new Cat(false, "Litty");

        //Dog dog = new Animal("sdfa"); Cannot assign superclass to subclass reference

        animal.setName("asdlfs");
        //animal.setBreed("adsfasf");
        animal.eatFood();
        System.out.println(animal);

        //Compiler will check if a method exists in the reference type class
        //When we run the program we use the actual object type to call the method

        //polymorphic methods - methods that change function depending on the calling object

        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Dog("Orange","Sam"));
        list.add(new Cat(true,"Andrew"));
        list.add(new Dog("asdf","adsfsdf"));

        for(int i = 0; i < list.size(); i++){
            list.get(i).eatFood();
            if(list.get(i) instanceof Dog)
            System.out.println((((Dog)list.get(i)).getBreed()));

            if(list.get(i) instanceof Cat)
                ((Cat) list.get(i)).setHatesMondays(false);
        }
    }

    public static void printAnimal(Animal a){
        System.out.println(a);
    }
}
