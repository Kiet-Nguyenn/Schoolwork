public class Dog
{
    // instance variables
    private String name;
    private String breed;
    // constructors
    public Dog(){
    }

    public Dog(String name, String breed){
        this.name = name;
        this.breed = breed;
    }
    // accessor methods
    public String getName(){
        return name;
    }
    public String getBreed(){
        return breed;
    }
    // mutator methods
    public void setName(String name) {
        this.name = name;
    }
    public void setBreed(String breed){
        this.breed = breed;
    }

}