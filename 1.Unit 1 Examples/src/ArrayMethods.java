public class ArrayMethods {
    public int sumArray(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public double getAvgGPA(Student[] students){
        double sum = 0;
        double count = 0;
        for(int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                sum += students[i].getGPA();
                count++;
            }
        }
        return sum / count;
    }

    /** precondition: there is at least one non null Student element.
     * post condition: returns the student with the best GPA
     * getBestStudent()
     */

    public Object getBestStudent(Student[] students) {
        Student best = students[0];
        for(int i = 1; i < students.length; i++){
            if(students[i] != null && students[i].getGPA() > best.getGPA()){
                best = students[i];
            }
        }
    return best;
    }
}

class ArrayTester {
    public static void main(String args[]) {

        //physical vs. logical size
        //physical - the actual size of the array including null elements.
        //logical - the number of elements we are using in the array (non-null)
        Student[] students = new Student[30]; //physical size == 30
        students[0] = new Student("jen", 10, 10);
        students[1] = new Student("ken", 5, 10);
        students[2] = new Student("min", 14, 10); //logical  - 3

        Student test = new Student("test",1,1);
        System.out.println(test); //printing the object will call toString

        System.out.println(students[0]);


        int[] nums = {1, 2, 3, 4 ,5, 6, 7 , 8, 9};
        ArrayMethods am = new ArrayMethods();
        System.out.println("\nSum of nums: " + am.sumArray(nums));

        System.out.println("\nAvg GPA: " + am.getAvgGPA(students));

        System.out.println("\nBest student: \n" + am.getBestStudent(students));
    }
}