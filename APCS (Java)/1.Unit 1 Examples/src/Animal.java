public class Animal {
    private String name;
    private int age;
    private boolean isAlive;

    public Animal() {
    }
    public Animal(String name, int age, boolean isAlive){
        this.name = name;
        this.age = age;
        this.isAlive = isAlive;
    }

    @Override
    public String toString(){
        return "name: " + name +
                "\nAge: " + age +
                "\nAlive: " + isAlive;
    }

    @Override
    public boolean equals(Object comp) {
        Animal temp = (Animal) comp;
        return  this.name.equalsIgnoreCase(temp.name) &&
                this.age == temp.age;
        //animal.age == animal2.age
    }
}


class AnimalRunner {
    public static void main(String args[]) {
        Animal animal1 = new Animal("elephant", 217, true); //@01234
        Animal animal2 = new Animal("tiger", 217, true);    //@12345
        Animal animal3 = animal1; //animal3 = @01234


        System.out.println(animal1); //THIS CALLS THE TO STRING

        //== this compares the references of two objects for equality
        System.out.println(animal1 == animal2);
        System.out.println(animal1 == animal3);

        //.equals() - this can be overridden to compare two objects of the same class.
        System.out.println(animal1.equals(animal2));

    }
}