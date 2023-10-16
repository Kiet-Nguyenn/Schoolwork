import java.util.Scanner;

public class StudentRunner {
    public static void main(String args[]){
        Scanner key = new Scanner(System.in);

        Student[] students = new Student[100];
        int size = 0; //this keeps track of the number of students in the array (logical size)
        String ans = "";

        /*while(!ans.equalsIgnoreCase("N")){
            System.out.print("Enter student name: ");
            String name = key.nextLine();
            System.out.print("Enter GPA: ");
            double GPA = key.nextDouble();
            System.out.print("Enter grade: ");
            int grade = key.nextInt();
            key.nextLine(); //dummy read

            students[size++] = new Student(name,GPA,grade);

            System.out.print("Enter another student: (y/n) ");
            ans = key.nextLine();

            System.out.println();

        }
        for(int i = 0; i < size; i++){
            System.out.println(students[i] + "\n");
        }*/

        Student bob = new Student("bob", 2.5, 10); //mem ref:123
        Student aryan = new Student("bob", 2.5, 10);
        Student jimbo = bob; //jimbo = 123

        System.out.println("num students: " + bob.getNumStudents());

        if(bob.equals(aryan)){
            System.out.println("Students are equal");
        } else {
            System.out.println("They ain't");
        }

        boolean test1 = bob.equals(students[90]);
        boolean test2 = bob.equals(new Scanner(System.in));
        boolean test3 = bob.equals(bob);
    }
}
