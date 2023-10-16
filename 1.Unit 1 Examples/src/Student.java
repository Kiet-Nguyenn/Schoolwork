public class Student {
    //instance variables
    //encapsulation - the idea that methods and variables must be put in a single unit (class)
    //variables must be hidden from other classes in encapsulation
    private String name;
    private double GPA;
    private int gradeLevel;
    private static int numStudents; //this value belongs to the class, will be the same for all Students

    //constructors
    public Student(){
        name = "";
    }
    public Student(String name, double GPA, int gradeLevel){
        this.name = name;
        this.GPA = GPA;
        this.gradeLevel = gradeLevel;
        numStudents++;
    }

    public int getNumStudents(){
        return numStudents;
    }

    //accessors
    public String getName(){
        return name;
    }
    public double getGPA(){
        return GPA;
    }
    public int getGradeLevel(){
        return gradeLevel;
    }

    //mutators
    public String setName(String name){
        this.name = name;
        return name;
    }
    public double setGPA(double GPA){
        this.GPA = GPA;
        return GPA;
    }
    public int setGradeLevel(int gradeLevel){
        this.gradeLevel = gradeLevel;
        return gradeLevel;
    }

    @Override
    public String toString(){
        return "Name: " + name +
                " GPA: " + GPA +
                " Grade: " + gradeLevel;
    }

    @Override
    public boolean equals(Object obj){

        if(obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        System.out.println(".equals called:");
        System.out.println("this class: " + this.getClass());
        System.out.println("obj class: " + obj.getClass());

        Student temp = (Student) obj;
        return this.name.equals(temp.getName()) &&
                this.GPA == temp.getGPA() &&
                this.gradeLevel == temp.getGradeLevel();

    }

}
