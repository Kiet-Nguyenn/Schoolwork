public class Student
{
    // instance variables
    private String name;
    private String id;
    private boolean distractor;

    // default constructor
    public Student()
    {
        name = "vacant";
        id = "";
    }

    // another constructor
    public Student(String n, String i)
    {
        name = n;
        id = i;
    }

    // mutator methods
    public void setName(String n)
    {
        name = n;
    }

    public void setID(String i)
    {
        id = i;
    }

    public void setDistractor(boolean d){
        distractor = d;
    }

    // accessor methods
    public String getName()
    {
        return name;
    }

    public String getID()
    {
        return id;
    }

    public boolean getDistractor(){
        return distractor;
    }

    // toString method
    public String toString()
    {
        return String.format("%-10s", name + " " + (distractor ? "x": "" )) ;
    }
}