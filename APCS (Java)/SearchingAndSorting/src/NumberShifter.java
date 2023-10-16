import java.util.Arrays;

public class NumberShifter {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 2, 3, 4, 7};
        System.out.println("Before sort: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("After sort: " + Arrays.toString(nums));

        for (int i = 0; i < nums.length; i++)
            nums[i] = (int) (Math.random() * 10);

        System.out.println("Random before sort: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("Random after sort: " + Arrays.toString(nums));

    }

    public static void sort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 7){
                int k = 0;
                while(arr[k] == 7){
                    k++;
                }
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
            }
        }
    }

}