import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int [] nums = { 4, 6, 7, 3, 8, 9, 2, 1, 7, 4, 5, 8,9};
        System.out.println("Array before sort: " + Arrays.toString(nums));
        sort(nums);
        System.out.println("Array after sort: " + Arrays.toString(nums));

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add((int)(Math.random()*20));
        }
        System.out.println("List before sort : " + list);
        arraySort(list);
        System.out.println("List after sort : " + list);
    }

    public static void sort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int min = i;
            for(int k = i + 1; k < arr.length; k++){
                if(arr[k] < arr[min]){
                    min = k;
                }
            }

            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void arraySort(ArrayList<Integer> list){
        for(int i = 0; i < list.size() - 1; i++){
            int min = i;
            for(int k = i + 1; k < list.size(); k++){
                if(list.get(k) < list.get(min)){
                    min = k;
                }
            }

            if(min != i){
                int temp = list.get(i);
                list.set(i, list.get(min));
                list.set(min, temp);
            }
        }
    }
}
