public class Animal {
    private String name;

    public Animal(){
    }

    public Animal(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eatFood(){
        System.out.println("eating animal food");
    }

    @Override
    public String toString(){
        return "Animal: " + name;
    }
}
