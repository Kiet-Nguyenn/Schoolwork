import java.util.Arrays;

public class Aliasing {
    public static void main(String[] args){
        Student stu1 = new Student("Ben");
        Student stu2 = stu1;

        //stu2.setName("Benny");
        stu2 = new Student("Not ben");
        System.out.println("stu1: " + stu1);
        System.out.println("stu2: " + stu2);

        //aliasing with an array
        int[] nums = {1,2,3};
        int[] nums2 = nums;

        nums[0] = 100;

        nums2 = new int[100];

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));

        //Aliasing with Strings
        String str = "hello";
        String str2 = str;

        str2 = "world"; //this changes the ref to a new string object

        //Strings are immutable - they cannot change, we always make new String objects.

        String str3 = "hello";

        System.out.println(str);
        System.out.println(str2);

        System.out.println(("Str3 same ref as str: " + (str == str3)));
    }
}
