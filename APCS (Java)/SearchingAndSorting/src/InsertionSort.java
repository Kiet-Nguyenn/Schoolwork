import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {
        public static void main(String[] args) {
            int[] nums = {4, 6, 7, 3, 8, 9, 2, 1, 7, 4, 5, 8, 9};
            System.out.println("Array before sort: " + Arrays.toString(nums));
            sort(nums);
            System.out.println("Array after sort: " + Arrays.toString(nums));

            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add((int) (Math.random() * 20));
            }
        }


        public static void sort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] > temp) {
                    arr[j] = arr[j - 1]; //shifts to right
                    j--;
                }
                arr[j] = temp; //insert at correct position
            }
        }

        public static void sort2(ArrayList<Integer> list){
            for(int i = 1; i < list.size(); i++){
                int temp = list.remove(i);
                int j = 1;
                while(j > 0 && list.get(j-1) > temp){
                    j--;
                }
                list.add(j,temp);
            }
        }
}

