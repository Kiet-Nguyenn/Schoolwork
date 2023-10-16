public class Dog extends Animal{
    private String breed;

    public Dog(){
    }

    public Dog(String breed, String name) {
        super(name); //this calls the super class constructor.
        this.breed = breed;
    }

    //public String getBreed(){
    //}
    //You cannot override in the same class

    public String getBreed(){
        return breed;
    }
    //getBreed is now overloaded
    public String getBreed(String subBreed) {
        return breed + subBreed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void eatFood(){
        System.out.println("Eating dog food.");
    }

    @Override
    public String toString(){
        return "Dog -> " + breed + ", " + getName(); //super.toString();
        //When calling a super class method that is overridden
        //It is called a partial override
    }


}
