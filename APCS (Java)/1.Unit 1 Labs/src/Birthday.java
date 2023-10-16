public class Birthday {
    private String name;
    private String birthday;

    public Birthday() {
    }
    public Birthday(String name, String birthday){
        this.name = name;
        this.birthday = birthday;
    }

    public String toString(){
        return "Name: " + name +
                "\nBirthday: " + birthday;
    }
}
