import java.util.Arrays;

public class FindNextLargest {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println("Next Largest to 5: " + nextLargest(nums, 5));

        System.out.println();
        int[] nums2 = {10, 30, 20, 40, 50, 15};
        sort(nums2);
        System.out.println(Arrays.toString(nums2));
        System.out.println("Next Largest to 12: " + nextLargest(nums2, 12));


        System.out.println();
        int[] nums3 = {3, 4, 5, 6, 8, 9, 10, 11, 2, 3, 4, 65};
        sort(nums3);
        System.out.println(Arrays.toString(nums3));
        System.out.println("Next Largest to 25: " + nextLargest(nums3, 25));

        System.out.println();
        int[] nums4 = {100, 110, 1000, 25000, 65535};
        sort(nums4);
        System.out.println(Arrays.toString(nums4));
        System.out.println("Next Largest to 32767: " + nextLargest(nums4, 32767));

    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int k = i + 1; k < arr.length; k++) {
                if (arr[k] < arr[i]) {
                    min = k;
                }
            }

            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static int nextLargest(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > key) {
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }
}