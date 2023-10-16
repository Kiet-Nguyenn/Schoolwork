public class Cat extends Animal{
    private boolean hatesMondays;

    public Cat(){
    }

    public Cat(boolean hatesMondays, String name){
        super(name);
        this.hatesMondays = hatesMondays;
    }

    public boolean isHatesMondays() {
        return hatesMondays;
    }

    public void setHatesMondays(boolean hatesMondays) {
        this.hatesMondays = hatesMondays;
    }

    @Override
    public void eatFood(){
        System.out.println("Eating lasagna");
    }

    public String toString(){
        return "Hates Mondays -> " + hatesMondays + ", " + super.getName();
    }
}
