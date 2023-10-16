import java.util.ArrayList;
import java.util.Scanner;

class Student
{
    private String name;
    private double GPA;
    private int gradeLevel;
    public Student(String name,double GPA,int gradeLevel)
    {
        this.name=name;
        this.GPA=GPA;
        this.gradeLevel=gradeLevel;
    }
    public int getGradeLevel()
    {
        return gradeLevel;
    }
    public double getGPA()
    {
        return GPA;
    }
    public String getName()
    {
        return name;
    }
    public void setGradeLevel(int gradeLevel)
    {
        this.gradeLevel=gradeLevel;
    }
    public void setGPA(double GPA)
    {
        this.GPA=GPA;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    @Override
    public String toString()
    {
        String output = "";
        output+=" " +getName()+ " "+getGPA();
        return output;
    }

    @Override
    public boolean equals(Object o){
        Student temp = (Student) o;
        return this.name.equals(temp.name);
    }


}

class StudentArrayList {
    public static void main(String args[]){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Stan",10,5));
        students.add(new Student("Swaggy D",10,5));
        students.add(new Student("Rahik",10,5));

        System.out.println(students); //this calls the 2-string - no cap

        //1. Insert a new student at index 1
        System.out.println("\nInserting at 1: ");
        students.add(1,new Student("Papa John",100,1000));
        System.out.println(students);

        //2. Replace first student with a new student
        System.out.println("\nReplace frist student: ");
        students.set(0,new Student("Cap Lord",1,1));
        System.out.println(students);

        //3. Remove the last student
        System.out.println("\nRemove last student: ");
        System.out.println(students.remove(students.size()-1));
        System.out.println(students);

        //Remove Papa John without using remove(index)
        System.out.println("\nRemove Papa John without remove(index)");
        System.out.println(students.remove(new Student("Papa John", 100, 1000)));
        System.out.println(students);

        students.get(0).setName("sheeshpogbased");
        System.out.println(students);

        //students.get(0) = new Student();

        for(Student s : students){
            System.out.println(s);
            s.setGPA(100);

            //students.remove(1);
            //students.add(new Student("test",1,1));
        }
    }
}