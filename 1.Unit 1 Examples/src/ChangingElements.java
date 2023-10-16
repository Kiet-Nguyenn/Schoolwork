public class ChangingElements {
    public static void main(String args[]){
        Student[] students = new Student[4];
        students[0]= new Student("Ben", 1, 1);
        students[1] = new Student("Ken", 2, 2);
        students[2] = new Student("Slim", 3, 3);
        students[3] = new Student("blem", 4, 4);

        System.out.println("Initial Array:");
        for(Student s : students){
            System.out.println(s);
        }

        //Can we use a for loop to replace elements in an array? YES
        for(int i = 0; i < students.length; i++){
            students[i] = new Student("Test", 1, 1);
        }


        System.out.println("\nArray after replacing elements:");
        for(Student s : students){
            System.out.println(s);
        }

        //Can we change the state of objects using a loop? YES
        for(int i = 0; i < students.length; i++){
            students[i].setName("Kimbo");
        }

        System.out.println("\nArray after changing state:");
        for(Student s : students){
            System.out.println(s);
        }

        //Can we replace elements using an ENHANCED for loop?
        //THAT'S ILLEGAL
        for(Student s : students){
            s = new Student("PRANAVYAN", 1 , 1);
        }

        System.out.println("Array after enhanced loop:");
        for(Student s : students){
            System.out.println(s);
        }

        //Can we change object state using an enhanced for loop?
        //YES
        for(Student s : students){
            s.setGPA(500);
        }

        System.out.println("Array after enhanced loop changing state:");
        for(Student s : students){
            System.out.println(s);
        }

    }
}
