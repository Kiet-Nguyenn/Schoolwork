public class InheritanceReview {
    public static void main(String[] args) {

        Animal a = new Animal(10);
        System.out.println(a);

        Dog d = new Dog("NABEEL", 16);
        d.getAge();
        d.setAge(12);

        System.out.println(d);

        Cat c = new Cat();
        //c.setName();

        //ref               actual type
        Animal animal = new Animal();
        Dog dog = new Dog();
        Animal dog2 = new Dog();
        //Dog animal2 = new Animal();
        dog2.setAge(10);
        //dog2.setName("ad");

        /*  When calling a method:
            1. The compiler determines if we can call a method if the method is implemented in the reference type.
            2. When the program is running, the actual type of the object is used to call the method.
         */

        dog2.eat();
        dog2.makeNoise();

        //Polymorphic methods are implemented between a sub and superclass. They must be Overridden

        /* Override vs Overload
            Override
                1. Occurs between methods in a sub and superclass.
                2. The methods share the same name and parameters.
            Overload
                1. Occurs between methods in the same class.
                2. Methods have the same name but different params.
         */

        makeEat(dog2);
        makeMakeNoise((Dog) dog2);

        ((Dog) dog2).setName("adsf");
        
    }

    public static void makeEat(Animal a) {
        a.eat();
    }

    public static void makeMakeNoise(Dog d){
        d.makeNoise();
    }
}

class Animal {
    private int age;

    public Animal(){
    }

    public Animal(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(){
        System.out.println("ANIMAL HUNGRY");
    }

    public void makeNoise(){
        System.out.println("*Hungry noises intensify*");
        eat();
    }

    public String toString(){
        return "Animal -> " + age;
    }
}

class Dog extends Animal{
    private String name;

    public Dog(){
    }

    public Dog(String name, int age){
        super(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){
        System.out.println("DOG HUNGRY");
    }

    public void makeNoise(){
        System.out.println("BORK");
        super.makeNoise();
    }

    @Override //when calling super.toString we have a partial override
    public String toString() {
        return super.toString() + " Dog -> " + name;
    }
}

class Cat extends Animal{
}